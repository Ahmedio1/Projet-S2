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
	
	// A Faire (29/04/2021 CD Finalise)
	
	//remplissage du tableau
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
	
	//4 rotations
	for (int nbRota=0;nbRota<4;nbRota++) {
		for (int i=0;i<piece.length;i++) {
			piece[i].rotation();
			}
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,piece[7*i+j].getModelePiece(),piece[7*i+j].getOrientationPiece());						
				}
			}
		IG.changerPieceHorsPlateau(piece[49].getModelePiece(),piece[49].getOrientationPiece());
		IG.miseAJourAffichage();
		System.out.println("[m:"+piece[49].getModelePiece()+"|o:"+piece[49].getOrientationPiece()+"|pe:"+piece[49].getPointEntree(0)+" "+piece[49].getPointEntree(1)+" "+piece[49].getPointEntree(2)+" "+piece[49].getPointEntree(3)+"]");
		IG.attendreClic();
		}
	
	IG.fermerFenetreJeu();
	System.exit(0);
	}
	
	public static void main(String[] args) {
		
		Testpieces demo = new Testpieces();
		
		demo.TestPieces();
	}

}
		
