package composants;



/**
 * Cette classe permet de gerer un plateau de jeu constitue d'une grille de pieces (grille de 7 lignes sur 7 colonnes).
 *
 */
public class Plateau {

	private Piece plateau[][]; // La grille des pieces.

	/**
	 * A Faire (AD 14/05/2021 Finis)
	 * 
	 * Constructeur permettant de construire un plateau vide (sans pieces) et d'une taille de 7 lignes sur 7 colonnes.
	 */
	public Plateau() {
		plateau = new Piece[7][7];
	}

	/**
	 * A Faire (AD 14/05/2021 Finis)
	 * 
	 * Methode permettant de placer une piece sur le plateau.
	 * 
	 * @param piece La piece  placer.
	 * @param lignePlateau La ligne du plateau sur laquelle sera placee la piece (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau sur laquelle sera placee la piece (une entier entre 0 et 6).
	 */
	public void positionnePiece(Piece piece,int lignePlateau,int colonnePlateau){
		plateau[lignePlateau][colonnePlateau]=piece;
	}

	/**
	 * A Faire (AD 14/05/2021 Finis)
	 * 
	 * Methode retournant une piece se trouvant sur le plateau e un emplacement specifique.
	 * 
	 * @param lignePlateau La ligne du plateau  (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau (un entier entre 0 et 6).
	 * @return La piece se trouvant sur la ligne lignePlateau et la colonne colonnePlateau. Si il n'y a pas de piece, null est retourne.
	 */
	public Piece getPiece(int lignePlateau,int colonnePlateau){
		if (plateau[lignePlateau][colonnePlateau] instanceof Piece) {
			return plateau[lignePlateau][colonnePlateau];
		}
		else{return null;} 
	}

	/**
	 * 
	 * A Faire (AD 14/05/2021 Finis)
	 *  
	 * Methode permettant de placer aleatoirment 49 pieces du jeu sur le plateau.
	 * L'orientation des pieces est aleatoire. Les pieces utilisees doivent etre des nouvelles pieces generees a partir de la methode Piece.nouvellesPieces.
	 * Parmi les 50 pieces du jeu, la piece qui n'a pas ete placee sur le plateau est retournee par la methode.
	 * 
	 * @return La seule piece qui n'a pas ete placee sur le plateau
	 */
	public Piece placerPiecesAleatoierment(){
		Piece[] piece;
		piece=Piece.nouvellesPieces();	
		int[] utils;
		utils=Utils.genereTabIntAleatoirement(50);
		for (int i=0;i<49;i++) {
			plateau[i/7][i%7]=piece[utils[i]];
		}
		
		return piece[utils[49]];
	}

	/**
	 * 
	 * Methode utilitaire permettant de tester si les positions passees en parametre sont les positions de deux cases differentes et adjacentes d'une grille de 7 lignes sur 7 colonnes.
	 *  
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les les positions passees en parametre sont les positions de deux cases differentes et adjacentes d'une grille de 7 lignes sur 7 colonnes, false sinon.
	 */
	private static boolean casesAdjacentes(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if ((posLigCase1<0)||(posLigCase2<0)||(posLigCase1>6)||(posLigCase2>6)) return false;
		if ((posColCase1<0)||(posColCase2<0)||(posColCase1>6)||(posColCase2>6)) return false;
		int distLigne=posLigCase1-posLigCase2;
		if (distLigne<0) distLigne=-distLigne;
		int distColonne=posColCase1-posColCase2;
		if (distColonne<0) distColonne=-distColonne;
		if ((distLigne>1)||(distColonne>1)||((distColonne+distLigne)!=1))
			return false;
		return true;
	}

	/**
	 * 
	 * A Faire (AD 14/05/2021 en cours)
	 * 
	 * Methode permettant de tester si les positions passees en parametre sont les positions de deux cases differentes et adjacentes 
	 * de la grille de jeu et qu'il est possible de passer d'une cas e  l'autre compte tenu des deux pieces posees sur les deux cases du plateau.
	 * 
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les positions passees en parametre sont les positions de deux cases differentes et adjacentes de la grille de jeu et qu'il est possible de passer d'une cas a l'autre compte tenu des deux pieces posees sur les deux cases du plateau, false sinon.
	 */
	private boolean passageEntreCases(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if (casesAdjacentes(posLigCase1,posColCase1,posLigCase2, posColCase2)==true) {
				if (((posLigCase1-posLigCase2==1)&&(plateau[posLigCase1][posColCase1].getPointEntree(0)==true && plateau[posLigCase2][posColCase2].getPointEntree(2)==true)) || ((posColCase1-posColCase2==-1)&&(plateau[posLigCase1][posColCase1].getPointEntree(1)==true && plateau[posLigCase2][posColCase2].getPointEntree(3)==true)) || ((posLigCase1-posLigCase2==-1)&&(plateau[posLigCase1][posColCase1].getPointEntree(2)==true && plateau[posLigCase2][posColCase2].getPointEntree(0)==true))|| ((posColCase1-posColCase2==1)&&(plateau[posLigCase1][posColCase1].getPointEntree(3)==true && plateau[posLigCase2][posColCase2].getPointEntree(1)==true)) ){
					return true;	
				}
				else {
					return false;
				}
		}
		
		else{return false;} 
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Methode permettant de retourner un eventuel chemin entre deux cases du plateau compte tenu des pieces posees sur le plateau.
	 * Dans le cas ou il n'y a pas de chemin entre les deux cases, la valeur null est retournee.
	 * Dans le cas ou il existe un chemin, un chemin possible est retourne sous forme d'un tableau d'entiers a  deux dimensions.
	 * La premiere dimension correspond aux cases du plateau a emprunter pour aller de la case de depart a  la case d'arrivee.
	 * Dans ce tableau, chaque case est un tableau de deux entiers avec le premier entier qui correspond a la ligne de la case et
	 * le second entier qui correspond a  la colonne de la case. La premiere case d'un chemin retourne correspond toujours 
	 * a la case (posLigCaseDep,posColCaseDep) et la derniere case correspond toujours a  la case (posLigCaseArr,posColCaseArr).
	 *
	 * @param posLigCaseDep La ligne de la case de depart (un entier compris entre 0 et 6).
	 * @param posColCaseDep La colonne de la case de depart (un entier compris entre 0 et 6).
	 * @param posLigCaseArr La ligne de la case d'arrivee (un entier compris entre 0 et 6).
	 * @param posColCaseArr La colonne de la case d'arrivee (un entier compris entre 0 et 6).
	 * @return null si il n'existe pas de chemin entre les deux case, un chemin sinon.
	 */
	public int[][] calculeChemin(int posLigCaseDep,int posColCaseDep,int posLigCaseArr,int posColCaseArr){
		//test que l'on ne se dirige pas vers la case de départ
		if (posLigCaseDep==posLigCaseArr && posColCaseDep==posColCaseArr)return null;
		
		
		int resultat[][]=new int[49][];
		resultat[0]=new int[] {posLigCaseDep,posColCaseDep};
		int der=0;
		int LigneActuel=posLigCaseDep;
		int ColActuel=posColCaseDep;
		int[][] tab = new int[7][7];
		boolean trouve=false;
		boolean finChemin=false;
		int lPre, cPre;
		while (trouve==false) {
			lPre=LigneActuel;
			cPre=ColActuel;
			
			if (finChemin==false){
				if (passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==true&&tab[LigneActuel-1][ColActuel]!=1&&tab[LigneActuel-1][ColActuel]!=2) {
					tab[LigneActuel][ColActuel]=1;

					resultat[der]=new int[] {LigneActuel,ColActuel};
					der++;
					LigneActuel--;

					
				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==true&&tab[LigneActuel][ColActuel+1]!=1&&tab[LigneActuel][ColActuel+1]!=2) {
					tab[LigneActuel][ColActuel]=1;

					resultat[der]=new int[] {LigneActuel,ColActuel};
					der++;
					ColActuel++;

				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==true&&tab[LigneActuel+1][ColActuel]!=1&&tab[LigneActuel+1][ColActuel]!=2){
					tab[LigneActuel][ColActuel]=1;

					resultat[der]=new int[] {LigneActuel,ColActuel};
					der++;
					LigneActuel++;

					
				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==true&&tab[LigneActuel][ColActuel-1]!=1 && tab[LigneActuel][ColActuel-1]!=2) {
					tab[LigneActuel][ColActuel]=1;

					resultat[der]=new int[] {LigneActuel,ColActuel};
					der++;
					ColActuel--;

				}
			}
				
			else {
				if (passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==true&&tab[LigneActuel-1][ColActuel]!=2) {
					tab[LigneActuel][ColActuel]=2;

					resultat=delElement(resultat,new int[] {LigneActuel,ColActuel});
					if (der!=0)der--;
					LigneActuel--;

				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==true&&tab[LigneActuel][ColActuel+1]!=2) {
					tab[LigneActuel][ColActuel]=2;

					resultat=delElement(resultat,new int[] {LigneActuel,ColActuel});
					if (der!=0)der--;
					ColActuel++;

				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==true&&tab[LigneActuel+1][ColActuel]!=2) {
					tab[LigneActuel][ColActuel]=2;

					resultat=delElement(resultat,new int[] {LigneActuel,ColActuel});
					if (der!=0)der--;
					LigneActuel++;

				}
				else if (passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==true&&tab[LigneActuel][ColActuel-1]!=2) {
					tab[LigneActuel][ColActuel]=2;

					resultat=delElement(resultat,new int[] {LigneActuel,ColActuel});
					if (der!=0)der--;
					ColActuel--;

				}
			}
			
			//Check si on vient d'arriver a la fin d'un chemin
			if(passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==false && passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==false
					&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==false && tab[LigneActuel-1][ColActuel]==1&&tab[LigneActuel][ColActuel]!=1)finChemin=true;
			if(passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==false && passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==false
					&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==false && tab[LigneActuel+1][ColActuel]==1&&tab[LigneActuel][ColActuel]!=1)finChemin=true;
			if(passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==false && passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==false
					&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==false && tab[LigneActuel][ColActuel-1]==1&&tab[LigneActuel][ColActuel]!=1)finChemin=true;
			if(passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==false && passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==false
					&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==false && tab[LigneActuel][ColActuel+1]==1&&tab[LigneActuel][ColActuel]!=1)finChemin=true;
			
			//rencontre d'une intersection
			if (LigneActuel!=0&&ColActuel!=0||LigneActuel!=7&&ColActuel!=7||LigneActuel!=0&&ColActuel!=7||LigneActuel!=7&&ColActuel!=0) {
				
				if (ColActuel!=6&&LigneActuel!=0) {
					if(passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==true && passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==true
							&&(tab[LigneActuel][ColActuel+1]!=2||tab[LigneActuel-1][ColActuel]!=2)&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==true)finChemin=false;
				}
				if(LigneActuel!=6&&LigneActuel!=0) {
					if(passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==true && passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==true
							&&(tab[LigneActuel-1][ColActuel]!=2||tab[LigneActuel+1][ColActuel]!=2)&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==true)finChemin=false;
				}
				if (LigneActuel!=0&&ColActuel!=0) {
					if(passageEntreCases(LigneActuel,ColActuel,LigneActuel-1,ColActuel)==true && passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==true
							&&(tab[LigneActuel][ColActuel-1]!=2||tab[LigneActuel-1][ColActuel]!=2)&& passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==true)finChemin=false;
				}
				if (ColActuel!=6&&LigneActuel!=6) {
					if(passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel+1)==true && passageEntreCases(LigneActuel,ColActuel,LigneActuel+1,ColActuel)==true
							&&(tab[LigneActuel][ColActuel+1]!=2||tab[LigneActuel+1][ColActuel]!=2)&& passageEntreCases(LigneActuel,ColActuel,LigneActuel,ColActuel-1)==true)finChemin=false;
				}
			}
			
			
			if (LigneActuel==posLigCaseDep&&ColActuel==posColCaseDep)finChemin=false;
			/*
			int millis = 1000;

			try {
			    Thread.sleep(millis);
			} catch (InterruptedException ie) {
			    // ...
			}
			
			System.out.println("-------------------------");
			*/
			
			
			if(LigneActuel==lPre && ColActuel==cPre)return null;
			if (posLigCaseArr==LigneActuel && posColCaseArr==ColActuel) {
				trouve=true;//Un chemin a ete trouve
				resultat[der]=new int[] {LigneActuel,ColActuel};
				return resultat;
			}

		}
		
		
		
		return resultat;
	}

	//méthode permettant de supprimer un element d'un tableau egale au parametre donne
	private static int[][] delElement(int[][] tab,int[] element){
		for (int i=0;i<tab.length;i++) {
			if (tab[i]!=null) {
				if (tab[i][0]==element[0]&&tab[i][1]==element[1]) {
					for (int j=i;j<tab.length-1;j++) {
						tab[j]=tab[j+1];
					}
					int ind=i;
					for (int k=i;k<tab.length;k++) {
						if (tab[k]!=null)ind=k;
					tab[ind]=null;
					}
				}
		}
		}
		return tab;
	}
	
	//methode permettant de retourner en String les element contenu dans le tableau
	public String toString(int[][] tab) {
		if (tab==null)return("null");
		else {
			String a="";
			for (int i=0;tab[i]!=null;i++) {
				a+=("("+tab[i][0]+","+tab[i][1]+")");
			}
			return a;
		}
	}

	/**
	 * 
	 * Methode permettant de calculer un chemin detaille (chemin entre sous-cases) a  partir d'un chemin entre cases.
	 *  
	 * @param chemin Un tableau representant un chemin de cases.
	 * @param numJoueur Le numero du joueur pour lequel nous souaitons construire un chemin detaille.
	 * 
	 * @return Le chemin detaille correspondant au chemin de positions de pieces donnees en parametre et pour le numero de joueur donne.
	 */
	public int[][] calculeCheminDetaille(int[][] chemin,int numJoueur){
		if (chemin.length==1)
			return new int[0][0];
		int[][] cheminDetaille=new int[chemin.length*5][4];
		int pos=0;
		int col,lig,colS,ligS;
		for (int i=0;i<chemin.length-1;i++){
			lig=chemin[i][0];
			col=chemin[i][1];
			ligS=chemin[i+1][0];
			colS=chemin[i+1][1];
			if (ligS<lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
			}
			else if (ligS>lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
			} else if (colS<col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
			} else if (colS>col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
			}
		}
		cheminDetaille[pos][0]=chemin[chemin.length-1][0];
		cheminDetaille[pos][1]=chemin[chemin.length-1][1];
		cheminDetaille[pos][2]=1;
		cheminDetaille[pos++][3]=1;

		int debut=0;
		if ((numJoueur==0)&&((cheminDetaille[pos-2][2]==0)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==1)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==2)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==0))) pos--;
		if ((numJoueur==0)&&((cheminDetaille[1][2]==0)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==1)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==2)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==0))) debut++;

		int[][] resultat=new int[pos-debut][4];
		for (int i=debut;i<pos;i++)
			for (int j=0;j<4;j++)
				resultat[i-debut][j]=cheminDetaille[i][j];
		return resultat;	
	}

	/**
	 * 
	 * Methode retournant une copie du plateau avec des copies de ses pieces.
	 * 
	 * @return Une copie du plateau avec une copie de toutes ses pieces.
	 */
	public Plateau copy(){
		Plateau plateau=new Plateau();
		for (int ligne=0;ligne<7;ligne++)
			for (int colonne=0;colonne<7;colonne++)
				plateau.positionnePiece((this.plateau[ligne][colonne]).copy(), ligne, colonne);
		return plateau;
	}

}
