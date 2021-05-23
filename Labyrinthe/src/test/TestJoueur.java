package test;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
	
	public void testJoueur() {
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		//plateau
		Plateau plateau=new Plateau();
		Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
		//NouveauJoueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",joueurs);
		IG.rendreVisibleFenetreJeu();
		IG.jouerUnSon(2);
		IG.pause(300);
		IG.jouerUnSon(2);
		IG.attendreClic();
		String message[]={
				"",
				"Cliquer pour continuer ...",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(),pieceHorsPlateau.getOrientationPiece());
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		

}
	
	public static void main(String[] args) {
		TestJoueur obj = new TestJoueur();
		
		obj.testJoueur();
	}
}
