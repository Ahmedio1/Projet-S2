package test;
import grafix.interfaceGraphique.IG;

public class MaDemoIG {

	public void demoGraphique() {
		
		Object parametres[];
		parametres=IG.saisirParametres();
		int nbJoueurs=((Integer)parametres[0]).intValue(); 
		IG.creerFenetreJeu("Démo Librairie IG version 1.9",nbJoueurs);
		IG.rendreVisibleFenetreJeu(); 
		IG.jouerUnSon(2); 
		IG.pause(300); 
		IG.jouerUnSon(2); 
		
		
		String message[]={
					"",
					"Démo Librairie Graphique 1.9...	",
					"Cliquer pour continuer ...",
					""
		};
		IG.afficherMessage(message); 
		IG.miseAJourAffichage(); 
		
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,2,0);// 2 premiers coordonnées, 3e la piece,4e la rotation
				IG.miseAJourAffichage();
			}}
		
		
		int numImageJoueur0=((Integer)parametres[3]).intValue();
		String nomJoueur0=(String)parametres[1];
		String categorieJoueur0=(String)parametres[2];
		IG.attendreClic();
		IG.changerNomJoueur(0, nomJoueur0+" ("+categorieJoueur0+")");
		IG.changerImageJoueur(0,numImageJoueur0);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
	
	
		for (int i=0;i<4;i++){
			IG.changerObjetJoueur(0,i,i);
			IG.changerObjetJoueur(1,i+7,i);
		}
		for (int i=4;i<6;i++){
			IG.changerObjetJoueurAvecTransparence(0,i,i);
			IG.changerObjetJoueurAvecTransparence(1,i+7,i);
		}
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		int numObjet=0;
		for (int i=0;i<7;i++)
			for (int j=0;j<7;j++)
				IG.placerObjetPlateau((numObjet++)%18,i,j);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
	
		IG.changerObjetSelectionne(2);
		
		

		for (int i=0;i<nbJoueurs;i++)
			IG.placerJoueurSurPlateau(i,1+i,1+i);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		for (int i=0;i<nbJoueurs;i++)
			IG.placerJoueurSurPlateau(i,1,1);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		for (int i=0;i<7;i++)
			for (int j=0;j<3;j++){
				IG.placerBilleSurPlateau(2,i,1,j,j);
				IG.placerBilleSurPlateau(3,i,1,j,j+1);
			}
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		IG.changerJoueurSelectionne(1);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		IG.selectionnerFleche(3);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		IG.selectionnerPiecePlateau(2,3);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//Faire les 4 rotations
		for (int l=0;l<=4;l++) {
			for (int i=0;i<7;i++) {
				for (int j=0;j<7;j++) {
					
					if (l==4) {
						IG.changerPiecePlateau(i,j,2,0);// 2 premiers coordonnées, 3e la piece,4e la rotation
						IG.miseAJourAffichage();
						
					}
					else {
						
					IG.changerPiecePlateau(i,j,2,l);// 2 premiers coordonnées, 3e la piece,4e la rotation
					IG.miseAJourAffichage();
					}
				}}
				IG.attendreClic();}

		
		
		IG.changerPieceHorsPlateau(2,2);
		IG.miseAJourAffichage();
		IG.attendreClic();
		message[0]="";
		message[1]="Rotationner la pièce qui se ";
		message[2]="trouve hors du plateau ... ";
		message[3]="Puis sélectionner une flèche ...";
		IG.afficherMessage(message);
		IG.miseAJourAffichage();

		int entree=IG.attendreChoixEntree();
		
		System.out.println("Entrée : "+entree);
		System.out.println("Modele : "+IG.recupererModelePieceHorsPlateau());
		System.out.println("Orienation : "+IG.recupererOrientationPieceHorsPlateau());
		
		
		message[0]="";
		message[1]="Sélectionner une pièce sur ";
		message[2]="le plateau ... ";
		message[3]="";	
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		int choixPiece[]=IG.attendreChoixPiece();
		System.out.println("Pièce sélectionnée : ("+choixPiece[0]+","+choixPiece[1]+")");
			
		
		message[0]="";
		message[1]="C'est terminé !";
		message[2]="Cliquer pour quitter ...";
		message[3]="";
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		IG.fermerFenetreJeu();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		MaDemoIG demo = new MaDemoIG();
		
		demo.demoGraphique();
	}
}
