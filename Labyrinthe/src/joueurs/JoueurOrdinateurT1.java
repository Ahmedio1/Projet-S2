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
 * Cette classe permet de représenter un joueur ordinateur de type T1.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public class JoueurOrdinateurT1 extends JoueurOrdinateur {

	/**
	 * 
	 * Constructeur permettant de créer un joueur.
	 * 
	 * @param numJoueur Le numéro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.

	 */
	public JoueurOrdinateurT1(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}

	@Override
	public String getCategorie() {
		return "OrdiType1";
	}

	
	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT1(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}
	
	@Override
	public int[] choisirEntreePiece(ElementsPartie plat) {
		for (int posPiece=0;posPiece<4;posPiece++) { //test pour chaque orientation
			for (int arrow=0;arrow<28;arrow++) { //test pour chaque fleche
				
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
				
				//changer la piece hors plateau
				IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
				
				//d�placement du joueur
				for (int j=0;j<plat.getNombreJoueurs();j++) {
					IG.placerJoueurSurPlateau(j,plat.getJoueurs()[j].getPosLigne(),plat.getJoueurs()[j].getPosColonne());
				}
				//suppression de tout les objets
				for (int j=0;j<49;j++) {
					IG.enleverObjetPlateau(j/7,j%7 );
				}
				
				//replacer les objets
				for (int j=0;j<plat.getNombreJoueurs();j++) {
					for (int k=plat.getJoueurs()[j].getNombreObjetsRecuperes();k<18/plat.getNombreJoueurs();k++) {
						if (plat.getJoueurs()[j].getObjetsJoueur()[k].surPlateau()) {
							IG.placerObjetPlateau(plat.getJoueurs()[j].getObjetsJoueur()[k].getNumeroObjet(), plat.getJoueurs()[j].getObjetsJoueur()[k].getPosLignePlateau(),
									plat.getJoueurs()[j].getObjetsJoueur()[k].getPosColonnePlateau());
						}
					}
				}
				//test de possibilite de recuperer l'objet
				Objet objTest=super.getProchainObjet();
				if (objTest.getPosLignePlateau()==plat.getJoueurs()[j].getPosLigne()
					&& objTest.getPosColonnePlateau()==plat.getJoueurs()[j].getPosColonne()) {
					int[] retour=new int[2];
					retour[0]=arrow;
					retour[1]=posPiece;
					return retour;
				}
			}
		}
	}
}
