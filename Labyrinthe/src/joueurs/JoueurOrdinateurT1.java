package joueurs;

import composants.Objet;
import composants.Piece;
import composants.PieceM0;
import composants.PieceM1;
import composants.PieceM2;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import partie.ElementsPartie;

/**
 * 
 * Cette classe permet de représenter un joueur ordinateur de type T1.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public class JoueurOrdinateurT1 extends JoueurOrdinateur {

	/**
	 * 
	 * Constructeur permettant de créer un joueur.
	 * 
	 * @param numJoueur Le numéro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.

	 */
	public JoueurOrdinateurT1(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}

	@Override
	public String getCategorie() {
		return "OrdiType1";
	}

	
	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT1(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}
	
	
	
	@Override
	public int[] choisirCaseArrivee(ElementsPartie elementsPartie) {
		ElementsPartie plat=elementsPartie.copy();
		boolean possible=false;
		while (possible==false) { //boucle permettant d'obliger le joueur a cliquer sur une case ou il  peut se deplacer
			//deplacement des persos
			for(int ligne=0;ligne<7;ligne++) {
				for (int colonne=0;colonne<7;colonne++) {
					int[] caseTarget=new int[2];
					caseTarget[0]=ligne;
					caseTarget[1]=colonne;
					int[][] chemin=plat.getPlateau().calculeChemin(super.getPosLigne(), super.getPosColonne(), caseTarget[0],caseTarget[1]);
					
					if (chemin!=null ||
							caseTarget[0]==super.getPosLigne()&&
							caseTarget[1]==super.getPosColonne()) {
						possible=true;
						if (super.getNumJoueur()==0)IG.placerJoueurPrecis(super.getNumJoueur(), caseTarget[0], caseTarget[1], 0, 2);
						else if (super.getNumJoueur()==1)IG.placerJoueurPrecis(super.getNumJoueur(), caseTarget[0], caseTarget[1], 2, 2);
						else if (super.getNumJoueur()==2)IG.placerJoueurPrecis(super.getNumJoueur(), caseTarget[0], caseTarget[1], 2, 0);
						super.setPosition(caseTarget[0], caseTarget[1]);
						
					}
					//test de possibilite de recuperer l'objet
					Objet objTest=super.getProchainObjet();
					if (objTest.getPosLignePlateau()==super.getPosLigne()
						&& objTest.getPosColonnePlateau()==super.getPosColonne()) {
						int[] retour=new int[2];
						retour[0]=ligne;
						retour[1]=colonne;
						return retour;
					}
				}
			}
			
		}
		return super.choisirCaseArrivee(elementsPartie);
	}
}
