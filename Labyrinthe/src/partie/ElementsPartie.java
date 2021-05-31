package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 *
 * Cette classe permet de reprÃ©senter un ensemble d'Ã©lements composant une partie de jeu.
 *
 */
public class ElementsPartie {

    private Joueur[] joueurs; 	// Les joueurs de la partie.
    private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numÃ©ros.
    private Plateau plateau; 	// Le plateau des piÃ¨ces.
    private Piece pieceLibre; 	// La piÃ¨ce libre.
    private int nombreJoueurs; 	// Le nombre de joueurs.

    /**
     *
     * A Faire (SS 30/05/2021  fini)
     *
     * Constructeur permettant de gÃ©nÃ©rer et d'initialiser l'ensemble des Ã©lÃ©ments d'une partie (sauf les joueurs qui sont donnÃ©s en paramÃ¨tres).
     *
     * Un plateau est crÃ©Ã© en placant 49 oiÃ¨ces de maniÃ¨re alÃ©atoire (utilisation de la mÃ©thode placerPiecesAleatoierment de la classe Plateau).
     * La piÃ¨ce restante (celle non prÃ©sente sur le plateau) est affectÃ©e Ã  la piÃ¨ce libre.
     * Les 18 objets sont crÃ©Ã©s avec des positions alÃ©atoires sur le plateau (utilisation de la mÃ©thode Objet.nouveauxObjets)
     * et distribuÃ©es aux diffÃ©rents joueurs (utilisation de la mÃ©thode attribuerObjetsAuxJoueurs).
     *
     * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribuÃ©s (c'est au constructeur de le faire).
     */
    public ElementsPartie(Joueur[] joueurs) {
        this.joueurs = joueurs;
        objets = Objet.nouveauxObjets();
        Plateau plateau=new Plateau();
        pieceLibre=plateau.placerPiecesAleatoierment();
        nombreJoueurs = joueurs.length;

    }

    /**
     * Un simple constructeur.
     *
     * @param joueurs Les joueurs de la partie.
     * @param objets Les 18 objets de la partie.
     * @param plateau Le plateau de jeu.
     * @param pieceLibre La piÃ¨ce libre (la piÃ¨ce hors plateau).
     */
    public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
        this.joueurs=joueurs;
        nombreJoueurs=joueurs.length;
        this.objets=objets;
        this.plateau=plateau;
        this.pieceLibre=pieceLibre;
    }

    /**
     * A Faire (ss 30/05/2021 fini)
     *
     * MÃ©thode permettant d'attribuer les objets aux diffÃ©rents joueurs de maniÃ¨re alÃ©atoire.
     */
    private void attribuerObjetsAuxJoueurs(){
        int [] tabInt = Utils.genereTabIntAleatoirement(18);
        Objet[] tabObjet = objets;
        int nombreObjetParJoueur =18/ nombreJoueurs;
        for (int i = 0;i<tabObjet.length;i++){
            objets[i] = tabObjet[tabInt[i]];
        }
        if (nombreJoueurs >= 2){
            Objet[] tabJ1 = new Objet[nombreObjetParJoueur];
            Objet[] tabJ2 = new Objet[nombreObjetParJoueur];
            for (int i = 0; i<nombreObjetParJoueur;i++){
                tabJ1[i] = objets[i];
                tabJ2[i] = objets[i+nombreObjetParJoueur];
            }
            joueurs[0].setObjetsJoueur(tabJ1);
            joueurs[1].setObjetsJoueur(tabJ2);
        }
        if (nombreJoueurs == 3){
            Objet[] tabJ3 = new Objet[nombreObjetParJoueur];
            for (int i = 0; i<nombreObjetParJoueur;i++){
                tabJ3[i] = objets[i+(nombreObjetParJoueur*(nombreJoueurs-1))];
            }
            joueurs[2].setObjetsJoueur(tabJ3);
        }
        // A ComplÃ©ter

    }

    /**
     * A Faire (ss 30/05/2021 fini)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer les joueurs de la partie.
     * @return Les joueurs de la partie.
     */
    public Joueur[] getJoueurs() {
        return joueurs;
    }

    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer les piÃ¨ces de la partie.
     * @return Les objets de la partie.
     */
    public Objet[] getObjets() {

        return objets;
    }


    /**
     * A Faire (ss 30/05/2021 fini)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer le plateau de piÃ¨ces de la partie.
     * @return Le plateau de piÃ¨ces.
     */
    public Plateau getPlateau() {
        return plateau;
    }


    /**
     * A Faire (ss 30/05/2021 fini)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer la piÃ¨ce libre de la partie.
     * @return La piÃ¨ce libre.
     */
    public Piece getPieceLibre() {
        return pieceLibre;
    }


    /**
     * A Faire (ss 30/05/2021 fini)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer le nombre de joueurs de la partie.
     * @return Le nombre de joueurs.
     */
    public int getNombreJoueurs() {

        return joueurs.length;
    }


    /**
     * A Faire (ss,AD 31/05/2021 fini)
     *
     * MÃ©thode modifiant les diffÃ©rents Ã©lÃ©ments de la partie suite Ã  l'insertion de la piÃ¨ce libre dans le plateau.
     *
     * @param choixEntree L'entrÃ©e choisie pour rÃ©aliser l'insertion (un nombre entre 0 et 27).
     */
    public void insertionPieceLibre(int choixEntree){
    	Piece tab[] = new Piece[7];
        // Debut en haut a gauche vers en haut a droite et de haut en bas
        if (choixEntree<7){
            Piece tmp = plateau.getPiece(6,choixEntree);
            for (int i = 0;i<6;i++){
            	tab[i]=plateau.getPiece(i, choixEntree);
            }
            for (int i = 0;i<6;i++){
            plateau.positionnePiece(tab[i],i+1,choixEntree);
            }
           plateau.positionnePiece(pieceLibre,0,choixEntree);
           pieceLibre = tmp;
            
        }else if ( choixEntree >= 7 && choixEntree <14){
            // de haut en bas droite vers la gauche
            Piece tmp = plateau.getPiece(choixEntree-7,0);
            for (int i = 6;i>=0;i--){
                 tab[i]=plateau.getPiece((choixEntree-7),i);
                 
                 }
            for (int i = 6;i>0;i--){
                 plateau.positionnePiece(tab[i],choixEntree-7,i-1);
                 }
            this.plateau.positionnePiece(pieceLibre,choixEntree-7,6);
            pieceLibre = tmp;
        } else if (choixEntree < 21) {
            // de droite a gauche et de bas en haut
            Piece tmp = this.plateau.getPiece(6, 6-choixEntree%7);
            for (int i = 6; i >=0; i--) {
               tab[i]=plateau.getPiece(i, 6-choixEntree%7);
              
            }
            for (int i = 6;i>0;i--){
                plateau.positionnePiece(tab[i],i-1,6-choixEntree%7);
                }
            plateau.positionnePiece(pieceLibre, 6,6-choixEntree%7);
            pieceLibre=tmp;
        }else{
            // bas en haut et de gauche a droite
            Piece tmp = plateau.getPiece(6-choixEntree%7,0);
            for (int i = 0;i<6;i++){
               tab[i]=plateau.getPiece(6-choixEntree%7,i);
            }
            for(int i=0;i<6;i++) {
            	 plateau.positionnePiece(tab[i],6-choixEntree%7,i+1);
            }
            plateau.positionnePiece(pieceLibre,6-choixEntree%7,0);
            pieceLibre = tmp;
        }
    }


    /**
     * MÃ©thode retournant une copie.
     *
     * @return Une copie des Ã©lÃ©ments.
     */
    public ElementsPartie copy(){
        Objet[] nouveauxObjets=new Objet[(this.objets).length];
        for (int i=0;i<objets.length;i++)
            nouveauxObjets[i]=(this.objets[i]).copy();
        Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
        for (int i=0;i<nombreJoueurs;i++)
            nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
        Plateau nouveauPlateau=(this.plateau).copy();
        Piece nouvellePieceLibre=(this.pieceLibre).copy();
        ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre);
        return nouveauxElements;
    }


}
