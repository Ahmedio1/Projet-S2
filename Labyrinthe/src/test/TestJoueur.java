package test;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
	
	public void testJoueur() {
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nbJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",nbJoueurs);
		IG.rendreVisibleFenetreJeu();
		IG.jouerUnSon(2);
		IG.pause(300);
		IG.jouerUnSon(2);
		String message[]={
				"",
				"Cliquer pour continuer ...",
				""
		};
		IG.afficherMessage(message);
		
		//g�n�ration du plateau
		Plateau plateau=new Plateau();
		Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
		
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(),pieceHorsPlateau.getOrientationPiece());
		
		//gereration des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		for (int i=0;i<nbJoueurs;i++) {
			IG.placerJoueurSurPlateau(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne());
			IG.changerImageJoueur(i, joueurs[i].getNumeroImagePersonnage());
			IG.changerNomJoueur(i, joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
		}
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		for (int i=0;i<nbJoueurs;i++) {
			boolean possible=false;
			while (possible==false) {
				String[] mess={
						"Au tour de "+joueurs[i].getNomJoueur(),
						"Sélectionner une case ..."
				};
				IG.afficherMessage(mess);
				IG.miseAJourAffichage();
				int[] caseTarget=joueurs[i].choisirCaseArrivee(null);
				int[][] chemin=plateau.calculeChemin(joueurs[i].getPosLigne(), joueurs[i].getPosColonne(), caseTarget[0],caseTarget[1]);
				
				//deplacement des persos
				if (chemin!=null ||
						caseTarget[0]==joueurs[i].getPosLigne()&&
						caseTarget[1]==joueurs[i].getPosColonne()) {
					possible=true;
					if (i==0)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 0, 2);
					else if (i==1)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 2);
					else if (i==2)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 0);
					
					//affichage du chemin a l'aide des billes
					int j=0;
					if (chemin!=null) {
						while (chemin[j]!=null) {
							IG.placerBilleSurPlateau(chemin[j][0], chemin[j][1], 1, 1, i);
							j++;
						}
					}else {
						IG.placerBilleSurPlateau(joueurs[i].getPosLigne(), joueurs[i].getPosColonne(), 1, 1, i);
					}
					
					IG.miseAJourAffichage();
					System.out.println("OK");
				}
			}
		}
		
		String[] mess= {
				"C'est terminé !",
				"Cliquer pour quitter ..."
		};
		IG.afficherMessage(mess);
		IG.miseAJourAffichage();
		IG.attendreClic();
		IG.fermerFenetreJeu();
		System.exit(0);
		

}
	
	public static void main(String[] args) {
		TestJoueur obj = new TestJoueur();
		
		obj.testJoueur();
	}
}
