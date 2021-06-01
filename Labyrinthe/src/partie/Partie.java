package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		//le plateau
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,elementsPartie.getPlateau().getPiece(i,j).getModelePiece(),elementsPartie.getPlateau().getPiece(i, j).getOrientationPiece());
				}
			}
		IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(),elementsPartie.getPieceLibre().getOrientationPiece());
		IG.miseAJourAffichage();
		
		//les objets
		for (int i=0;i<elementsPartie.getObjets().length;i++) {
			IG.placerObjetPlateau(elementsPartie.getObjets()[i].getNumeroObjet(), elementsPartie.getObjets()[i].getPosLignePlateau(), elementsPartie.getObjets()[i].getPosColonnePlateau());
		}
		
		//les joueurs
		for (int i=0;i<elementsPartie.getNombreJoueurs();i++) {
			IG.placerJoueurSurPlateau(i,elementsPartie.getJoueurs()[i].getPosLigne(),elementsPartie.getJoueurs()[i].getPosColonne());
			IG.changerImageJoueur(i, elementsPartie.getJoueurs()[i].getNumeroImagePersonnage());
			IG.changerNomJoueur(i, elementsPartie.getJoueurs()[i].getNomJoueur()+" ("+elementsPartie.getJoueurs()[i].getCategorie()+")");
		}
		
		//les objets des joueurs
		int nbObjParJoueur=elementsPartie.getObjets().length/elementsPartie.getNombreJoueurs();
		for(int i=0;i<nbObjParJoueur;i++) {
			IG.changerObjetJoueur(0,elementsPartie.getObjets()[i].getNumeroObjet(),i);
			IG.changerObjetJoueur(1,elementsPartie.getObjets()[i+nbObjParJoueur].getNumeroObjet(),i);
			if (elementsPartie.getNombreJoueurs()==3) {
				IG.changerObjetJoueur(2,elementsPartie.getObjets()[i+nbObjParJoueur*2].getNumeroObjet(),i);
				}
			}
		
		
		//demande de clic pour commencer la partie
		String message[]={
				"",
				"Cliquer pour continuer ...",
				""
		};
		IG.afficherMessage(message);

		IG.rendreVisibleFenetreJeu();
		IG.attendreClic();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		// A Compléter
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}
