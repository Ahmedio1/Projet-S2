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
	public int choisirEntreePiece(ElementsPartie plat) {
		for (int i=0;i<4;i++) {
			for (int j=0;j<28;j++) {
				
				Piece pieceHp=null;
				if (IG.recupererModelePieceHorsPlateau()==0) {
					pieceHp = new PieceM0();
				}else if(IG.recupererModelePieceHorsPlateau()==1) {
					pieceHp = new PieceM1();
				}else if(IG.recupererModelePieceHorsPlateau()==2) {
					pieceHp = new PieceM2();
				}
				ElementsPartie obj1 = new ElementsPartie(plat.getJoueurs(),plat.getObjets(),plat.getPlateau(),pieceHp);
				obj1.insertionPieceLibre(plat.getJoueurs()[i].choisirEntreePiece(plat));
				pieceHp.setOrientation(IG.recupererOrientationPieceHorsPlateau());
				for (int k=0;k<7;k++) {
					for (int j=0;j<7;j++) {
						IG.changerPiecePlateau(k,j,elementsPartie.getPlateau().getPiece(k,j).getModelePiece(),elementsPartie.getPlateau().getPiece(k, j).getOrientationPiece());
						}
					}
				
				//changer la piece hors plateau
				IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
				
				//d�placement du joueur
				for (int j=0;j<elementsPartie.getNombreJoueurs();j++) {
					IG.placerJoueurSurPlateau(j,elementsPartie.getJoueurs()[j].getPosLigne(),elementsPartie.getJoueurs()[j].getPosColonne());
				}
				//suppression de tout les objets
				for (int j=0;j<49;j++) {
					IG.enleverObjetPlateau(j/7,j%7 );
				}
				
				//replacer les objets
				for (int j=0;j<elementsPartie.getNombreJoueurs();j++) {
					for (int k=elementsPartie.getJoueurs()[j].getNombreObjetsRecuperes();k<18/elementsPartie.getNombreJoueurs();k++) {
						if (elementsPartie.getJoueurs()[j].getObjetsJoueur()[k].surPlateau()) {
							IG.placerObjetPlateau(elementsPartie.getJoueurs()[j].getObjetsJoueur()[k].getNumeroObjet(), elementsPartie.getJoueurs()[j].getObjetsJoueur()[k].getPosLignePlateau(),
									elementsPartie.getJoueurs()[j].getObjetsJoueur()[k].getPosColonnePlateau());
						}
					}
				}
			}
		}
	}
}
