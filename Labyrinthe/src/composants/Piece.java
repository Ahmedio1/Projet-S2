package composants;
import java.util.Random;
/**
 * 
 * Cette classe permet de représenter les différentes pièces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le modèle de la pièce
	private int orientationPiece; 	// L'orientation de la pièce
	private boolean[] pointsEntree; // Les points d'entrée indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Constructeur permettant de créer une pièce d'un modèle avec l'orientation 0.
	 * @param modelePiece Le modèle de la pièce.
	 * @param pointEntreeHaut Un booléen indiquant si la pièce a un point d'entrée en haut.
	 * @param pointEntreeDroite Un booléen indiquant si la pièce a un point d'entrée �  droite.
	 * @param pointEntreeBas Un booléen indiquant si la pièce a un point d'entrée en bas.
	 * @param pointEntreeGauche Un booléen indiquant si la pièce a un point d'entrée �  gauche.
	 */
	public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
		this.modelePiece=modelePiece;
		orientationPiece=0;
		this.pointsEntree[0]=pointEntreeHaut;
		this.pointsEntree[1]=pointEntreeDroite;
		this.pointsEntree[2]=pointEntreeBas;
		this.pointsEntree[3]=pointEntreeGauche;
	}
	
	/**
	 * Méthoide retournant un String représentant la pièce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Méthode permettant de rotationner une pièce dans le sens d'une horloge.
	 */
	public void rotation(){
		orientationPiece+=1%4;
	}
	
	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Méthode permettant d'orienter une pièce vers une orientation spécifique.
	 * @param orientationPiece Un entier correspondant �  la nouvelle orientation de la pièce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece=orientationPiece;
	}

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Méthode retournant le modèle de la pièce.
	 * @return Un entier corrspondant au modèle de la pièce.
	 */
	public int getModelePiece() {
		return(modelePiece);
	}

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Méthode retournant l'orientation de la pièce.
	 * @return un entier retournant l'orientation de la pièce.
	 */
	public int getOrientationPiece() {
		return(orientationPiece);
	}

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Méthode indiquant si il existe un point d'entrée �  une certaine position (0: en haut, 1: �  droite, 2: en bas, 3: �  gauche).
	 * @param pointEntree L'indice/la position du point d'entrée.
	 * @return true si il y a un point d'entrée, sinon false.
	 */
	public boolean getPointEntree(int pointEntree){
		return(this.pointsEntree[pointEntree]);
	}
	
	/**
	 * A Faire (27/04/2021 CD/PP/AD Finalis�e)
	 * 
	 * Méthode permettant de créer un tableau contenant toutes les pièces du jeu (les 50 pièces).
	 * Le tableau contiendra 20 pièces du modèle 0, 12 pièces du modèle 1 et 18 pièces du modèle 2.
	 * L'orientation de chaque pièce sera aléatoire.
	 * @return Un tableau contenant toutes les pièces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		Piece pieces[]=new Piece[50];
		for (int i=0;i<20;i++) {
			PieceM0 p=new PieceM0();
			//cr�ation d'un nb random entre 0 et 3
			Random r=new Random();
			int nb=0+r.nextInt(3-0);
			//orientation en fonction du nb random
			p.setOrientation(nb);
			//attribution du de la piece avec l'orientation random
			pieces[i]=p;
		}
		for (int i=20;i<32;i++) {
			PieceM1 p=new PieceM1();
			//cr�ation d'un nb random entre 0 et 3
			Random r=new Random();
			int nb=0+r.nextInt(3-0);
			//orientation en fonction du nb random
			p.setOrientation(nb);
			//attribution du de la piece avec l'orientation random
			pieces[i]=p;
		}
		for (int i=32;i<50;i++) {
			PieceM2 p=new PieceM2();
			//cr�ation d'un nb random entre 0 et 3
			Random r=new Random();
			int nb=0+r.nextInt(3-0);
			//orientation en fonction du nb random
			p.setOrientation(nb);
			//attribution du de la piece avec l'orientation random
			pieces[i]=p;
		}
		return pieces;
	}
	
	/**
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public abstract Piece copy();
	
}