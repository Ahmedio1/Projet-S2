package test;
import composants.Piece;
import grafix.interfaceGraphique.IG;
public class Testpieces {
	public void Testpieces() {
		
		/*Object parametres[];
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
	IG.attendreClic();*/
	
	Piece[] piece;
	piece=Piece.nouvellesPieces();
	System.out.println(piece);	
	/*for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				for (int l=0;l<piece.length;l++) {
				IG.changerPiecePlateau(i,j,piece[l].getModelePiece(),piece[l].getOrientationPiece());				
					}		
				}
			}*/
	IG.miseAJourAffichage();
	IG.attendreClic();
	}
	
	/*public static void main(String[] args) {
		
		Testpieces demo = new Testpieces();
		
		demo.Testpieces();
	}*/

}
		
