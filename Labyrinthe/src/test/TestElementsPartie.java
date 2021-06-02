package test;

import joueurs.Joueur;
import partie.ElementsPartie;
import composants.Objet;
import composants.Piece;
import composants.PieceM0;
import composants.PieceM1;
import composants.PieceM2;
import composants.Plateau;
import grafix.interfaceGraphique.IG;

public class TestElementsPartie {
	
	public void TestElementsPartie() {
	
	Object parametresJeu[];
	parametresJeu=IG.saisirParametres();
	int  nbJoueurs=((Integer)parametresJeu[0]).intValue();
	IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
	Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
	ElementsPartie elementsPartie=new ElementsPartie(joueurs);
	IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",nbJoueurs);
	IG.rendreVisibleFenetreJeu();
	String message[]={
			"",
			"Cliquer pour continuer ...",
			""
	};
	IG.afficherMessage(message);

	//génération du plateau
	Plateau plateau=new Plateau();
	Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
	
	for (int i=0;i<7;i++) {
		for (int j=0;j<7;j++) {
			IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
			}
		}
	IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(),pieceHorsPlateau.getOrientationPiece());
	
	//gereration des joueurs
	for (int i=0;i<nbJoueurs;i++) {
		IG.placerJoueurSurPlateau(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne());
		IG.changerImageJoueur(i, joueurs[i].getNumeroImagePersonnage());
		IG.changerNomJoueur(i, joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
		
	}
	
	Objet[] obj=Objet.nouveauxObjets();
	for (int i=0;i<obj.length;i++) {
		IG.placerObjetPlateau(obj[i].getNumeroObjet(), obj[i].getPosLignePlateau(), obj[i].getPosColonnePlateau());
		
	}
	
	int nbObj=18/nbJoueurs;
	for(int i=0;i<nbObj;i++) {
		IG.changerObjetJoueur(0,obj[i].getNumeroObjet(),i);
		IG.changerObjetJoueur(1,obj[i+nbObj].getNumeroObjet(),i);
	if (nbJoueurs==3)IG.changerObjetJoueur(2,obj[i+nbObj*2].getNumeroObjet(),i);
	}
	IG.miseAJourAffichage();
	IG.attendreClic();

	IG.miseAJourAffichage();

	//4 entrées 
	//message fleche
	String messagefleche[]={
			"",
			"Choissiez une entrée...",
			""
};
	IG.afficherMessage(messagefleche); 
	IG.miseAJourAffichage();
	for (int l=0;l<4;l++) {
		Piece pieceHp=null;
		if (IG.recupererModelePieceHorsPlateau()==0) {
			pieceHp = new PieceM0();
		}else if(IG.recupererModelePieceHorsPlateau()==1) {
			pieceHp = new PieceM1();
		}else if(IG.recupererModelePieceHorsPlateau()==2) {
			pieceHp = new PieceM2();
		}
		ElementsPartie obj1 = new ElementsPartie(joueurs,obj,plateau,pieceHp);
		obj1.insertionPieceLibre(IG.attendreChoixEntree());
		pieceHp.setOrientation(IG.recupererOrientationPieceHorsPlateau());
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
		for (int i=0;i<nbJoueurs;i++) {
			IG.placerJoueurSurPlateau(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne());
		}
		
		//retirer objet 
		for (int i=0;i<49;i++) {
			IG.enleverObjetPlateau(i/7,i%7 );
		}
		
		//mettre objet
		for (int i=0;i<18;i++) {
			IG.placerObjetPlateau(obj[i].getNumeroObjet(), obj[i].getPosLignePlateau(), obj[i].getPosColonnePlateau());
		}
		IG.miseAJourAffichage();
		
	/*else if(IG.recupererModelePieceHorsPlateau()==1) {
		Piece pieceHp = new PieceM1();
		pieceHp.setOrientation(IG.recupererOrientationPieceHorsPlateau());
		ElementsPartie obj1 = new ElementsPartie(joueurs,obj,plateau,pieceHp);
		obj1.insertionPieceLibre(IG.attendreChoixEntree());
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
		
		IG.miseAJourAffichage();
	}
	else if(IG.recupererModelePieceHorsPlateau()==2) {
		Piece pieceHp = new PieceM2();
		pieceHp.setOrientation(IG.recupererOrientationPieceHorsPlateau());
		ElementsPartie obj1 = new ElementsPartie(joueurs,obj,plateau,pieceHp);
		obj1.insertionPieceLibre(IG.attendreChoixEntree());
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
		
		IG.miseAJourAffichage();
	}*/
	

	}
	String messageTerminer[]={
			"",
			"C'est terminer",
			"Cliquer pour fermer",
			""
};
	IG.miseAJourAffichage();
	IG.attendreClic();
	IG.fermerFenetreJeu();
	
}
	
	public static void main(String[] args) {
		TestElementsPartie obj = new TestElementsPartie();
		obj.TestElementsPartie();
	}
	}
