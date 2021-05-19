package test;
import composants.Plateau;
import composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestPlateau {
	
	public void testPlateau() {
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
		
		System.out.println("La liste des chemins trouvés à partir de la case (3,3) :"+"\n");
		int Max=0;
		int[] indexTab=new int[2];
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				int[][] a=plateau.calculeChemin(3, 3, i, j);
				if (a!=null) {
					System.out.println("Chemin entre les cases (3,3) et ("+i+","+j+") : "+ plateau.toString(a));
					int taille=0;
					for (int k=0;k<a.length;k++) {
						if (a[k]!=null)taille=k;
					}
					if (taille>Max) {
						Max=taille;
						indexTab[0]=i;
						indexTab[1]=j;
					}
				}
			}
		}
		
		int[][] tabBille=plateau.calculeChemin(3, 3, indexTab[0], indexTab[1]);
		if (Max>0) {
			for (int i=0;i<Max+1;i++) {
				IG.placerBilleSurPlateau(tabBille[i][0], tabBille[i][1], 1, 1, 2);
			}
		}else IG.placerBilleSurPlateau(3, 3, 1, 1, 2);
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		IG.fermerFenetreJeu();
		System.exit(0);
		
		
	}
	
	public static void main(String[] args) {
		
		TestPlateau demo = new TestPlateau();
		
		demo.testPlateau();
	}
}