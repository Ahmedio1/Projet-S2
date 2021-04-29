package composants;

/**
 * 
 * Cette classe permet de représenter les pièces du jeu de modèle 0.
 *
 */
public class PieceM0 extends Piece {
	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e)
	 * 
	 * Constructeur permettant de construire une pièce de modèle 0 et d'orientation 0.
	 */
	public PieceM0() {
		super(0,false,true,true,false); 
	}
	/**
	 * A Faire (27/04/2021 CD/PP Finalis�e(peut-�tre))
	 * 
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public Piece copy(){
		Piece piece=this.copy();
		return piece;

	}
	
	
	
}