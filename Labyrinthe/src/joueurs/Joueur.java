package joueurs;

import composants.Objet;
import partie.ElementsPartie;

/**
 * 
 * Cette classe abstraite represente un joueur du jeu. Ce joueur peut etre un joueur humain ou un joueur ordinateur.
 * 
 *
 */
public abstract class Joueur {
	
	private int numJoueur; // le numero du jouer
	private String nomJoueur; // Le nom du joueur
	private int numeroImagePersonnage; // Le numero de l'image representant le joueur
	private Objet objetsJoueur[]; // Les objets qui sont attribues au joueur et qui devront etre recuperes dans l'ordre
	private int nombreObjetsRecuperes; // le nombre d'objets recuperes
	private int posLigne; // La ligne correspondant √  la position du joueur sur le plateau
	private int posColonne; // La colonne correspondant √  la position du joueur sur le plateau
	/**
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Constructeur permettant de creer un joueur ‡  partir de son nom, son type et 
	 * le numero de l'image le representant. La position du joueur sur le plateau doit etre
	 * egalement indiquee. Aucun objet n'est attribue au joueur (l'attribut objetsJoueur vaudra null apres la construction du joueur).
	 * 
	 * @param numJoueur Le numero du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numero de l'image representant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnee le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnes le joueur.
	 */
	public Joueur(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
		this.numJoueur=numJoueur;
		this.nomJoueur=nomJoueur;
		this.numeroImagePersonnage=numeroImagePersonnage;
		this.posLigne=posLignePlateau;
		this.posColonne=posColonnePlateau;
		this.objetsJoueur=null;
	}

	/**
	 * 
	 * Methode permettant de creer des joueurs ‡  partir de parametres obtenus ‡  partir des fenetres de parametrages.
	 * Les joueurs sont positionnes dans les differents coins du plateau en fonction de leur rang 
	 * (le premier au coin en haut √  gauche, le deuxieme au coin en haut √  droite, le troisieme en bas ‡  droite).
	 * Le joueur de numero 0 est le premier element du tableau retourn√©, le joueur de numero 1 est le deuxieme element du tableau retourne et
	 * l'eventuel joueur de numero 2 est l'eventuel troisieme element du tableau retourne. 
	 * 
	 * @param parametresJeu Les parametres du jeu.
	 * @return Un tableau de joueurs initialises.
	 */
	public static Joueur[] nouveauxJoueurs(Object parametresJeu[]){
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		Joueur joueurs[]=null;
		String nomJoueur,typeJoueur;
		int posJoueurs[][]={{0,0},{0,6},{6,6}};
		int numImageJoueur;
		joueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++){
			nomJoueur=(String)parametresJeu[1+(3*i)];
			typeJoueur=(String)parametresJeu[2+(3*i)];
			numImageJoueur=((Integer)parametresJeu[3+(3*i)]).intValue();
			if (typeJoueur.equals("Humain")) 
				joueurs[i]=new JoueurHumain(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			else if (typeJoueur.equals("OrdiType0")) 
				joueurs[i]=new JoueurOrdinateurT0(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			else if (typeJoueur.equals("OrdiType1")) 
				joueurs[i]=new JoueurOrdinateurT1(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			else if (typeJoueur.equals("OrdiType2")) 
				joueurs[i]=new JoueurOrdinateurT2(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			else if (typeJoueur.equals("OrdiType3")) 
				joueurs[i]=new JoueurOrdinateurT3(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			else {
				System.err.println("Type de joueur non g√©r√© : "+typeJoueur+" cr√©ation d'un joueur du type par d√©faut (Humain) ...");
				joueurs[i]=new JoueurHumain(i,nomJoueur,numImageJoueur,posJoueurs[i][0],posJoueurs[i][1]);
			}
		}
		return joueurs;
	}

	/**
	 * 
	 * A Faire (AD le 20/05/2021 Finis)
	 *  
	 * Methode retournant le nombre d'objets recuperes par le joueur.
	 * 
	 * @return Le nombre d'objets recuperes par le joueur.
	 */
	public int getNombreObjetsRecuperes() {
		return this.nombreObjetsRecuperes; 
	}


	/**
	 * A Faire (AD le 20/05/2021 Finis)
	 *  
	 * Methode retournant la ligne du plateau sur laquelle se trouve le joueur.
	 * @return  La ligne du plateau sur laquelle se trouve le joueur.
	 */
	public int getPosLigne() {
		return this.posLigne; // A Modifier
	}


	/**
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode retournant la colonne du plateau sur laquelle se trouve le joueur.
	 * @return La colonne du plateau sur laquelle se trouve le joueur.
	 */
	public int getPosColonne() {
		return this.posColonne; // A Modifier
	}


	/**
	 *  A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode retournant le nom du joueur.
	 * @return Le nom du joueur.
	 */
	public String getNomJoueur() {
		return this.nomJoueur; // A Modifier
	}

	/**
	 *  A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode retournant le numero de l'image representant le joueur.
	 * @return Le numero de l'image representant le joueur.
	 */
	public int getNumeroImagePersonnage() {
		return this.numeroImagePersonnage; // A Modifier
	}

	/**
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode permettant d'affecter au joueur les objets qu'il devra recuperer durant le jeu.
	 * Attention : cette methode devra creer un nouveau tableau pour l'attribut this.objetsARecuperer.
	 * 
	 * @param objetsARecuperer Un tableau contenant les objets ‡  recuperer dans l'ordre.
	 */
	public static void setObjetsJoueur(Objet objetsARecuperer[]){
		Objet tabRecup[];
		tabRecup = new Objet[6];
		for(int i=0;i<6;i++) {
			tabRecup[i]=objetsARecuperer[i];	
		}
		
	}
	
	/**
	 *
	 * 
	 * Methode retournant un nouveau tableau contenant les objets attribues au joueur. Des objets ‡  recuperer devront etre
	 * affectes au joueur avant tout appel de cette methode (on suppose donc que l'attribut objetsJoueur est non null).
	 * 
	 * @return Un tableau d'Objet correspondant aux objets ‡ recuperer du joueur.
	 */
	public Objet[] getObjetsJoueur(){
		Objet resultat[];
		resultat = new Objet[6];
		for(int i=0;i<6;i++) {
			resultat[i]=this.objetsJoueur[i];	
		}
	
		return resultat;
	}
	
	
	/**
	 *  A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode retournant le prochain objet ‡  recuperer par le joueur.
	 * Avant d'appeler cette methode il est necessaire de s'assurer qu'il existe encore des objets ‡  recuperer.
	 * 
	 * @return Le prochain objet ‡  recuperer par le joueur.
	 */
	public Objet getProchainObjet(){
		return this.objetsJoueur[nombreObjetsRecuperes];
	}
	
	/**
	 * 
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode permettant de recuperer un nouvel objet. Cette methode incremente simplement de 1 le nombre d'objets qui ont ete recuperes.
	 */
	public void recupererObjet(){
		this.nombreObjetsRecuperes++;
	}
	

	/**
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode retournant le numero du joueur.
	 * 
	 * @return Le numero du joueur.
	 */
	public int getNumJoueur(){
		return this.numJoueur; // A Modifier
	}
	
	/**
	 * 
	 * A Faire (AD le 20/05/2021 Finis)
	 * 
	 * Methode permettant le changement de position du joueur.
	 * @param posLigne La ligne de la nouvelle position.
	 * @param posColonne La colonne de la nouvelle position.
	 */
	public void setPosition(int posLigne,int posColonne) {
		this.posLigne=posLigne;
		this.posColonne=posColonne;
	}
	
	/**
	 * 
	 * Methode retournant un String representant la categorie du joueur. Par defaut retourne
	 * le nom de la classe du joueur.
	 * @return Un String representant la categorie du joueur.
	 */
	public String getCategorie() {
		return this.getClass().getName();
	}
	
	/**
	 * 
	 * Cette methode est appelee lorsque le joueur doit jouer en debut de son tour. Il doit choisir une orientation de la piece qui est hors plateau
	 * et une entree (une fleche) dans le plateau. Ce choix se fera ‡  travers l'interface graphique pour un joueur humain et par calcul pour un joueur
	 * ordinateur. Les elements de la partie sont passes en parametre pour qu'on joueur ordinateur puisse faire ses calculs. Dans le cas d'un joueur humain,
	 * ce parametre n'est pas utile.
	 * @param elementsPartie Les elements de la partie.
	 * @return Un tableau contenant deux entiers, le premier correspond ‡ l'orientation choisie de la piece hors plateau (un nombre entre 0 et 3) et le second ‡ l'entree du plateau (un nombre entre 0 et 27).
	 */
	
	abstract public int[] choisirOrientationEntree(ElementsPartie elementsPartie);
	
	
	/**
	 * 
	 * Cette methode est appelee lorsque le joueur doit se deplacer et donc choisir une case sur le plateau. Pour un joueur humain ce choix se fera ‡  l'aide
	 * de l'interface graphique tandis que pour un ordinateur elle se fera totalement par calcul. Il n'existe pas forcement un chemin entre la case du joueur et la case choisie.
	 * 
	 * @param elementsPartie Les elements de la partie.
	 * @return Un tableau contenant deux entiers, le premier correspond ‡  la ligne de la case choisie, le second ‡  la colonne de la case choisie. 
	 */
	abstract public int[] choisirCaseArrivee(ElementsPartie elementsPartie);

	
	/**
	 * 
	 * Methode retournant un nouveau tableau contenant les elements du tableau objets donne en parametre qui ont meme numero qu'un objet appartenant ‡  l'attribut
	 * objetsJoueur. L'ordre des elements du tableau retourne doit suivre l'ordre des objets se trouvant dans objetsJoueur.
	 * 
	 * @param objets L'ensemble de tous les objets du jeu dans un ordre indefini.
	 * @return Un nouveau tableau contenant les elements du tableau objets donne en parametre qui ont meme numero qu'un objet appartenant ‡ l'attribut
	 * objetsARecuperer (ordonne de la meme maniere que les objets attribues au joueur).
	 */
	public Objet[] getObjetsJoueurGeneral(Objet objets[]){
		Objet resultat[]=new Objet[objetsJoueur.length];
		for (int i=0;i<objetsJoueur.length;i++)
			for (int j=0;j<objets.length;j++)
				if (objets[j].getNumeroObjet()==objetsJoueur[i].getNumeroObjet())
					resultat[i]=objets[j];
		return resultat;
	}
	
	/**
	 * Methode retournant une copie du joueur.
	 * @param objets Les objets du jeu.
	 * @return Une copie du joueur.
	 */
	public abstract Joueur copy(Objet objets[]);
	
	
}