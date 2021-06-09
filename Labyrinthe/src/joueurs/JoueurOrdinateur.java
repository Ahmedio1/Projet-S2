package joueurs;

import composants.Utils;
import grafix.interfaceGraphique.IG;
import partie.ElementsPartie;


/**
 * 
 * Cette classe permet de représenter un joueur ordinateur générique et basique.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public abstract class JoueurOrdinateur extends Joueur {

	/**
	 * Constructeur permettant de créer un joueur.
	 * 
	 * @param numJoueur Le numéro du joueur (un entier compris entre 0 et 2).
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.
	 */
	public JoueurOrdinateur(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}

	@Override
	public String getCategorie() {
		return "Ordinateur";
	}

	/**
	 * Saisies de l'orientation de la pièce hors plateau et de l'entrée dans le plateau : on retourne toujours 3 pour l'entrée du plateau (la flêche du haut)
	 * et l'orientation courante de la pièce hors plateau de l'interface graphique.
	 */
	@Override
	public int[] choisirOrientationEntree(ElementsPartie elementsPartie) {
		int resultat[]=new int[2];
		resultat[1]=3;
		resultat[0]=IG.recupererOrientationPieceHorsPlateau();
		return resultat;
	}

	
	/**
	 * Saisie de la case d'arrivée réalisée : retourne toujours la position du joueur.
	 */
	@Override
	public int[] choisirCaseArrivee(ElementsPartie elementsPartie) {
		int[] i=new int[2];
		i[0]=Utils.genererEntier(7);
		i[1]=Utils.genererEntier(7);
		return i;
	}

	
	@Override
	public int[] choisirEntreePiece(ElementsPartie plat) {
		int[] i=new int[2];
		i[0]=Utils.genererEntier(28);
		return i;
	}
	
	
	

}
