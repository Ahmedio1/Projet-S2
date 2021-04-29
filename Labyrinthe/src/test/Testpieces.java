package test;
import composants.Piece;
import grafix.interfaceGraphique.IG;
public class Testpieces {
	
	public void TestPieces() {
		
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
	
	Piece[] piece;
	piece=Piece.nouvellesPieces();	
	for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,piece[7*i+j].getModelePiece(),piece[7*i+j].getOrientationPiece());						
				}
			}
	IG.changerPieceHorsPlateau(piece[49].getModelePiece(),piece[49].getOrientationPiece());
	IG.miseAJourAffichage();
	IG.attendreClic();
	for (int i=0;i<7;i++) {
		for (int j=0;j<7;j++) {
			
			}
		}
	}
	public static void main(String[] args) {
		
		Testpieces demo = new Testpieces();
		
		demo.TestPieces();
	}

}
		
