package composants;

/**
 * 
 * Cette classe permet de représenter les pièces du jeu de modèle 1.
 * 
 */
public class PieceM1 extends Piece {

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Constructeur permettant de construire une pièce de modèle 1 et d'orientation 0.
	 */
	public PieceM1() {
		// A Modifier !!!
		super(1,true,false,true,false); 
	}
	/**
<<<<<<< HEAD
	 * A Faire (29/04/2021 CD/PP Finalis�e)
=======
	 * A Faire (27/04/2021 CD/PP Finalis�e(peut-etre))
>>>>>>> branch 'master' of https://gitlab.univ-artois.fr/ahmed_daoud/projets2.git
	 * 
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public Piece copy(){
		PieceM1 piece=this;
		return piece;
	}
}