package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 *  
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 oièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée à la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribuées aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		
		// A Compléter
		
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	private void attribuerObjetsAuxJoueurs(){
	
		// A Compléter
		
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return null; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return null; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return null; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return null; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return -1; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite à l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
		// A Compléter
	}


	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}
