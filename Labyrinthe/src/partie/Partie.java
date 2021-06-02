package partie;

import composants.Objet;
import composants.Piece;
import composants.PieceM0;
import composants.PieceM1;
import composants.PieceM2;
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
		//initialisation des variables permettant de savoir si un joueur a win
		boolean j1Win=false, j2Win=false, j3Win=false;
		while (!j1Win && !j2Win && !j3Win) { //on boucle tant que personne n'a gagne
			for (int i=0;i<elementsPartie.getNombreJoueurs();i++) {
				boolean possible=false;
				
					String[] mess={
							"Au tour de "+elementsPartie.getJoueurs()[i].getNomJoueur(),
							"S�lectionner une case ..."
					};
					IG.afficherMessage(mess);
					IG.miseAJourAffichage();
					
					//introduction de la piece hors plateau
					Piece pieceHp=null;
					if (IG.recupererModelePieceHorsPlateau()==0) {
						pieceHp = new PieceM0();
					}else if(IG.recupererModelePieceHorsPlateau()==1) {
						pieceHp = new PieceM1();
					}else if(IG.recupererModelePieceHorsPlateau()==2) {
						pieceHp = new PieceM2();
					}
					ElementsPartie obj1 = new ElementsPartie(elementsPartie.getJoueurs(),elementsPartie.getObjets(),elementsPartie.getPlateau(),pieceHp);
					obj1.insertionPieceLibre(IG.attendreChoixEntree());
					pieceHp.setOrientation(IG.recupererOrientationPieceHorsPlateau());
					for (int k=0;k<7;k++) {
						for (int j=0;j<7;j++) {
							IG.changerPiecePlateau(k,j,elementsPartie.getPlateau().getPiece(k,j).getModelePiece(),elementsPartie.getPlateau().getPiece(k, j).getOrientationPiece());
							}
						}
					IG.changerPieceHorsPlateau(obj1.getPieceLibre().getModelePiece(),obj1.getPieceLibre().getOrientationPiece());
					
					IG.miseAJourAffichage();
					
					
					
					
					
					
					
					
					
					
					
					while (possible==false) { //boucle permettant d'obliger le joueur a cliquer sur une case ou il  peut se deplacer
					//deplacement des persos
					int[] caseTarget=elementsPartie.getJoueurs()[i].choisirCaseArrivee(null);
					int[][] chemin=elementsPartie.getPlateau().calculeChemin(elementsPartie.getJoueurs()[i].getPosLigne(), elementsPartie.getJoueurs()[i].getPosColonne(), caseTarget[0],caseTarget[1]);
					
					if (chemin!=null ||
							caseTarget[0]==elementsPartie.getJoueurs()[i].getPosLigne()&&
							caseTarget[1]==elementsPartie.getJoueurs()[i].getPosColonne()) {
						possible=true;
						if (i==0)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 0, 2);
						else if (i==1)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 2);
						else if (i==2)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 0);
						
						//affichage du chemin a l'aide des billes
						int j=0;
						if (chemin!=null) {
							while (chemin[j]!=null) {
								IG.placerBilleSurPlateau(chemin[j][0], chemin[j][1], 1, 1, i);
								j++;
							}
						}else {
							IG.placerBilleSurPlateau(elementsPartie.getJoueurs()[i].getPosLigne(), elementsPartie.getJoueurs()[i].getPosColonne(), 1, 1, i);
						}
						
						IG.miseAJourAffichage();
					}
				}
				Objet objTest=elementsPartie.getJoueurs()[i].getProchainObjet();
				if (objTest.getPosLignePlateau()==elementsPartie.getJoueurs()[i].getPosLigne()
					&& objTest.getPosLignePlateau()==elementsPartie.getJoueurs()[i].getPosLigne()) {
					
					int objRecup=elementsPartie.getJoueurs()[i].getNombreObjetsRecuperes();
					IG.changerObjetJoueurAvecTransparence(i, elementsPartie.getJoueurs()[i].getObjetsJoueur()[objRecup].getNumeroObjet(), objRecup);
					elementsPartie.getJoueurs()[i].recupererObjet();
				}
			}
		}
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
