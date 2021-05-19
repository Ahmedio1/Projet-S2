package test;
import composants.Plateau;
import composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestPlateau {
	
	public void TestPlateau() {
		Object parametres[];
		parametres=IG.saisirParametres();
		int nbJoueurs=((Integer)parametres[0]).intValue();
		IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",nbJoueurs);
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
		
		
		Plateau plateau=new Plateau();
		Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,plateau.getPiece(i,j).getModelePiece(),plateau.getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(),pieceHorsPlateau.getOrientationPiece());
		IG.miseAJourAffichage();
		
		IG.attendreClic();
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				int[][] a=plateau.calculeChemin(3, 3, i, j);
				System.out.println("Chemin entre les cases (3,3) et ("+i+","+j+") : "+ plateau.toString(a));
			}
		}
	}
	
	public static void main(String[] args) {
		
		TestPlateau demo = new TestPlateau();
		
		demo.TestPlateau();
	}
}