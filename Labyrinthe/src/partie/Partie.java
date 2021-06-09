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
				int millis = 500;

				try {
				    Thread.sleep(millis);
				} catch (InterruptedException ie) {
				    // ...
				}
				
				//selection de la fleche
				String[] mess={
						"",
						"Au tour de "+elementsPartie.getJoueurs()[i].getNomJoueur(),
						"S�lectionner une fl�che ..."
				};
				IG.afficherMessage(mess);
				IG.miseAJourAffichage();
				//suppression des billes lors du tour du joueur suivant
				for (int l=0;l<49;l++) IG.supprimerBilleSurPlateau(l/7, l%7, 1, 1);
				
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
				int[] choixEntres=new int[2];
				choixEntres=elementsPartie.getJoueurs()[i].choisirEntreePiece(elementsPartie);
				obj1.insertionPieceLibre(choixEntres[0]);
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
				
				IG.miseAJourAffichage();
				
				
				
				
				
				
				
				
				String[] message={
						"",
						"Au tour de "+elementsPartie.getJoueurs()[i].getNomJoueur(),
						"S�lectionner une case ..."
				};
				IG.afficherMessage(message);
				IG.miseAJourAffichage();
				
				boolean possible=false;
				while (possible==false) { //boucle permettant d'obliger le joueur a cliquer sur une case ou il  peut se deplacer
					//deplacement des persos
					int[] caseTarget=elementsPartie.getJoueurs()[i].choisirCaseArrivee(elementsPartie);
					int[][] chemin=elementsPartie.getPlateau().calculeChemin(elementsPartie.getJoueurs()[i].getPosLigne(), elementsPartie.getJoueurs()[i].getPosColonne(), caseTarget[0],caseTarget[1]);
					
					if (chemin!=null ||
							caseTarget[0]==elementsPartie.getJoueurs()[i].getPosLigne()&&
							caseTarget[1]==elementsPartie.getJoueurs()[i].getPosColonne()) {
						possible=true;
						if (i==0)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 0, 2);
						else if (i==1)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 2);
						else if (i==2)IG.placerJoueurPrecis(i, caseTarget[0], caseTarget[1], 2, 0);
						elementsPartie.getJoueurs()[i].setPosition(caseTarget[0], caseTarget[1]);
						
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
				//permettre aux joueur de recuperer l'objet si il est sur la case de celui-ci et qu'il s'agit du bonne objet
				Objet objTest=elementsPartie.getJoueurs()[i].getProchainObjet();
				if (objTest.getPosLignePlateau()==elementsPartie.getJoueurs()[i].getPosLigne()
					&& objTest.getPosColonnePlateau()==elementsPartie.getJoueurs()[i].getPosColonne()) {
					
					int objRecup=elementsPartie.getJoueurs()[i].getNombreObjetsRecuperes();//nombre d'objet recup
					IG.changerObjetJoueurAvecTransparence(i, elementsPartie.getJoueurs()[i].getObjetsJoueur()[objRecup].getNumeroObjet(), objRecup);
					
					IG.enleverObjetPlateau(objTest.getPosLignePlateau(),objTest.getPosColonnePlateau());//enlever graphiquement l'objet du plateau
					
					//set les coo a -1 -1 et la variable surPlateau a false
					elementsPartie.getJoueurs()[i].getObjetsJoueur()[elementsPartie.getJoueurs()[i].getNombreObjetsRecuperes()].enleveDuPlateau();
					elementsPartie.getJoueurs()[i].recupererObjet();//passage � l'objet suivant du joueur i
					IG.miseAJourAffichage();
				}
				
				//test de win
				if (elementsPartie.getJoueurs()[i].getNombreObjetsRecuperes()==elementsPartie.getJoueurs()[i].getObjetsJoueur().length) {
					if (i==0)j1Win=true;
					else if (i==1)j2Win=true;
					else j3Win=true;
					break; //permet de sortir prematurement de la boucle for
				}
			}
			/*
			String[] message={
					"",
					"Cliquez pour passer",
					"au tour suivant..."
			};
			IG.afficherMessage(message);
			IG.miseAJourAffichage();
			IG.attendreClic();
			*/
			
		}
		
		if (j1Win)IG.afficherGagnant(0);
		else if (j2Win) IG.afficherGagnant(1);
		else IG.afficherGagnant(2);
		IG.miseAJourAffichage();
		IG.attendreClic();
		IG.enleverGagnant();
		IG.fermerFenetreJeu();
		System.exit(0);
		
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
