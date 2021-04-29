package composants;

import java.util.Date;
import java.util.Random;

/**
 * 
 * Classe contenant quelques fonctions utilitaires.
 * 
 */
public class Utils {
	
	private static Random generateur=new Random((new Date().getTime()));

	/**
	 * le 27 avril 2021, A.D,Finalisé
	 * 
	 * Methode permettant de generer aleatoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant etre retourne.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	public static int genererEntier(int max){
		int nb;
		nb =0+generateur.nextInt(max-0);		
		return nb;
	}
	/**
	 *le 27 avril 2021, A.D,Finaliser
	 * 
	 * Methode permettant de generer un tableau d'entiers dont la longueur longTab est donnee en parametre.
	 * Le tableau genere doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit etre aleatoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 places aleatoirement dans le tableau.
	 */
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[];
		int nb;
		int tmp;
		tab = new int[longTab];
		for (int i=0;i<longTab;i++) {
			tab[i]=i;}
		for (int i=0;i<longTab;i++){
			nb=genererEntier(longTab-1);
			tmp=tab[nb];
			tab[nb]=tab[i];
			tab[i]=tmp;			
		}		
		return tab;
	}
	/**
	 * Programme testant la methode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");


	}

}