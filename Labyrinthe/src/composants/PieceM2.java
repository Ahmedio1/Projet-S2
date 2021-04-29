package composants;

/**
 * 
 * Cette classe permet de représenter les pièces du jeu de modèle 2.
 *
 */
public class PieceM2 extends Piece {

	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Constructeur permettant de construire une pièce de modèle 2 et d'orientation 0.
	 */
	public PieceM2() {
		// A Modifier !!!
		super(2,true,true,false,true); 
	}
	/**
	 * A Faire (29/04/2021 CD/PP Finalisee)
	 * 
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public Piece copy(){
		PieceM2 piece=this;
		return piece;
	}
}