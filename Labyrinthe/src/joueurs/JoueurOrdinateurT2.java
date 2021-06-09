package joueurs;

import composants.Objet;
import composants.Piece;
import composants.PieceM0;
import composants.PieceM1;
import composants.PieceM2;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import partie.ElementsPartie;

/**
 * 
 * Cette classe permet de représenter un joueur ordinateur de type T2.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public class JoueurOrdinateurT2 extends JoueurOrdinateur {

	/**
	 * Constructeur permettant de créer un joueur.
	 * 
	 * @param numJoueur Le numéro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.

	 */
	public JoueurOrdinateurT2(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}

	@Override
	public String getCategorie() {
		return "OrdiType2";
	}


	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT2(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}
	
	
	@Override
	public int[] choisirEntreePiece(ElementsPartie plateau) {
		for (int posPiece=0;posPiece<4;posPiece++) { //test pour chaque orientation
			for (int arrow=0;arrow<28;arrow++) { //test pour chaque fleche
				ElementsPartie plat=plateau.copy();
				Piece pieceHp=null;
				if (IG.recupererModelePieceHorsPlateau()==0) {
					pieceHp = new PieceM0();
				}else if(IG.recupererModelePieceHorsPlateau()==1) {
					pieceHp = new PieceM1();
				}else if(IG.recupererModelePieceHorsPlateau()==2) {
					pieceHp = new PieceM2();
				}
				
				ElementsPartie obj1 = new ElementsPartie(plat.getJoueurs(),plat.getObjets(),plat.getPlateau(),pieceHp);
				obj1.insertionPieceLibre(arrow);
				pieceHp.setOrientation((IG.recupererOrientationPieceHorsPlateau()+posPiece)%4);
				for (int k=0;k<7;k++) {
					for (int j=0;j<7;j++) {
						IG.changerPiecePlateau(k,j,plat.getPlateau().getPiece(k,j).getModelePiece(),plat.getPlateau().getPiece(k, j).getOrientationPiece());
					}
				}
				

				int[][] chemin=plat.getPlateau().calculeChemin(plat.getJoueurs()[super.getNumJoueur()].getPosLigne(), plat.getJoueurs()[super.getNumJoueur()].getPosColonne(), plat.getJoueurs()[super.getNumJoueur()].getProchainObjet().getPosLignePlateau(),plat.getJoueurs()[super.getNumJoueur()].getProchainObjet().getPosColonnePlateau());
				
				//test de possibilite de recuperer l'objet
				if (chemin!=null) {
					int[] retour=new int[2];
					retour[0]=arrow;
					retour[1]=posPiece;
					return retour;
					
				}
			}
		}
		return super.choisirEntreePiece(plateau);
	}
	
	
	@Override
	public int[] choisirCaseArrivee(ElementsPartie elementsPartie) {
		ElementsPartie plat=elementsPartie.copy();
		boolean possible=false;
		while (possible==false) { //boucle permettant d'obliger le joueur a cliquer sur une case ou il  peut se deplacer
			//deplacement des persos
			for(int ligne=0;ligne<7;ligne++) {
				for (int colonne=0;colonne<7;colonne++) {
					int[] caseTarget=new int[2];
					caseTarget[0]=ligne;
					caseTarget[1]=colonne;
					int[][] chemin=plat.getPlateau().calculeChemin(plat.getJoueurs()[super.getNumJoueur()].getPosLigne(), plat.getJoueurs()[super.getNumJoueur()].getPosColonne(), caseTarget[0],caseTarget[1]);
					
					if (chemin!=null ||
							caseTarget[0]==super.getPosLigne()&&
							caseTarget[1]==super.getPosColonne()) {
						possible=true;

						plat.getJoueurs()[super.getNumJoueur()].setPosition(caseTarget[0], caseTarget[1]);
						
					}
					//test de possibilite de recuperer l'objet
					Objet objTest=super.getProchainObjet();
					if (objTest.getPosLignePlateau()==plat.getJoueurs()[super.getNumJoueur()].getPosLigne()
						&& objTest.getPosColonnePlateau()==plat.getJoueurs()[super.getNumJoueur()].getPosColonne()) {
						int[] retour=new int[2];
						retour[0]=plat.getJoueurs()[super.getNumJoueur()].getPosLigne();
						retour[1]=plat.getJoueurs()[super.getNumJoueur()].getPosColonne();
						return retour; //retourne la case et la colonne
					}
				}
			}
			
		}
		return super.choisirCaseArrivee(elementsPartie);
	}

}
