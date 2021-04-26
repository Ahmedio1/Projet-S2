package test;
import grafix.interfaceGraphique.IG;

public class MaDemoIG {

	public void demoGraphique() {
		
		Object parametres[];
		parametres=IG.saisirParametres();
		int nbJoueurs=((Integer)parametres[0]).intValue(); 
		IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",nbJoueurs);
		IG.rendreVisibleFenetreJeu(); 
		IG.jouerUnSon(2); 
		IG.pause(300); 
		IG.jouerUnSon(2); 
		
		
		String message[]={
					"",
					"Bonjour !	",
					"Cliquer pour continuer ...",
					""
		};
		IG.afficherMessage(message); 
		IG.miseAJourAffichage(); 
				
		//configuration perso
		int numImageJoueur0=((Integer)parametres[(0*3)+3]).intValue();
		int numImageJoueur1=((Integer)parametres[(1*3)+3]).intValue();
		int numImageJoueur2=((Integer)parametres[(2*3)+3]).intValue();
		String nomJoueur0=(String)parametres[(0*3)+1];
		String nomJoueur1=(String)parametres[(1*3)+1];
		String nomJoueur2=(String)parametres[(2*3)+1];
		String categorieJoueur0=(String)parametres[(0*3)+2];
		String categorieJoueur1=(String)parametres[(1*3)+2];
		String categorieJoueur2=(String)parametres[(2*3)+2];
		IG.changerNomJoueur(0, nomJoueur0+" ("+categorieJoueur0+")");
		IG.changerNomJoueur(1, nomJoueur1+" ("+categorieJoueur1+")");
		IG.changerNomJoueur(2, nomJoueur2+" ("+categorieJoueur2+")");
		IG.changerImageJoueur(0,numImageJoueur0);
		IG.changerImageJoueur(1,numImageJoueur1);
		IG.changerImageJoueur(2,numImageJoueur2);
		IG.miseAJourAffichage();
		
		// placer les pieces 2 de type 0
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				IG.changerPiecePlateau(i,j,2,0);// 2 premiers coordonnees, 3e la piece,4e la rotation
			}}
		//Piece hors plateau
		IG.changerPieceHorsPlateau(1,0);
		
		//Mettre les objets dans la main du perso
		for (int i=0;i<6;i++){
			IG.changerObjetJoueur(0,i,i);
			IG.changerObjetJoueur(1,i+6,i);
			IG.changerObjetJoueur(2,i+12,i);
		}
		
		IG.miseAJourAffichage();
		
		//Placement des objets sur le plateau
		int numObjet=0;
		for (int i=0;i<7;i++) // nombre de ligne 
			for (int j=0;j<7;j++)//nombre de colonne
				if(numObjet<18) {
				IG.placerObjetPlateau((numObjet++)%18,i,j);
				};
				
			//Placer les joueurs sur les milieux	
			IG.placerJoueurPrecis(0,3,0,1,0);
			IG.placerJoueurPrecis(1,3,6,1,2);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//Faire les 4 clic
		
		//1er clic
		//rotation
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {				
					IG.changerPiecePlateau(i,j,2,1);// 2 premiers coordonnees, 3e la piece,4e la rotation
			}}
		//deplacement vers le centre
		IG.placerJoueurPrecis(0,3,0,1,1);
		IG.placerJoueurPrecis(1,3,6,1,1);
		//placer la bille
		IG.placerBilleSurPlateau(3,0,1,0,1);
		IG.placerBilleSurPlateau(3,6,1,2,1);
		//message
		String messageclic1[]={
				"",
				"Apres 1er clic	",
				"Cliquer pour continuer ...",
				""
		};
			
		IG.afficherMessage(messageclic1); 
		IG.miseAJourAffichage();
		//retier objet plateau et transparence 
		IG.enleverObjetPlateau(0,0);
		IG.changerObjetJoueurAvecTransparence(0,0,0);
			
	
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//2eme clic
		//rotation
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {				
					IG.changerPiecePlateau(i,j,2,2);// 2 premiers coordonnees, 3e la piece,4e la rotation
			}}
		//deplacement vers le centre
		IG.placerJoueurPrecis(0,3,0,1,2);
		IG.placerJoueurPrecis(1,3,6,1,0);
		//placer la bille
		IG.placerBilleSurPlateau(3,0,1,1,1);
		IG.placerBilleSurPlateau(3,6,1,1,1);
		//message
		String messageclic2[]={
				"",
				"Apres 2eme clic	",
				"Cliquer pour continuer ...",
				""
		};
			
		IG.afficherMessage(messageclic2); 
		IG.miseAJourAffichage();
		//retier objet plateau et transparence 
		IG.enleverObjetPlateau(0,1);
		IG.changerObjetJoueurAvecTransparence(0,1,1);
		

		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		//3eme clic
		//rotation
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {				
					IG.changerPiecePlateau(i,j,2,3);// 2 premiers coordonnees, 3e la piece,4e la rotation
			}}
		//deplacement vers le centre
		IG.placerJoueurPrecis(0,3,1,1,0);
		IG.placerJoueurPrecis(1,3,5,1,2);
		//placer la bille
		IG.placerBilleSurPlateau(3,0,1,2,1);
		IG.placerBilleSurPlateau(3,6,1,0,1);
		//message
		String messageclic3[]={
				"",
				"Apres 3eme clic	",
				"Cliquer pour continuer ...",
				""
		};
			
		IG.afficherMessage(messageclic3); 
		IG.miseAJourAffichage();
		//retier objet plateau et transparence 
		IG.enleverObjetPlateau(0,2);
		IG.changerObjetJoueurAvecTransparence(0,2,2);
			

		IG.miseAJourAffichage();
		IG.attendreClic();
		
		//4eme clic
		//rotation
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {				
					IG.changerPiecePlateau(i,j,2,0);// 2 premiers coordonnees, 3e la piece,4e la rotation
			}}
		//deplacement vers le centre
		IG.placerJoueurPrecis(0,3,1,1,1);
		IG.placerJoueurPrecis(1,3,5,1,1);
		//placer la bille
		IG.placerBilleSurPlateau(3,1,1,0,1);
		IG.placerBilleSurPlateau(3,5,1,2,1);
		//message
		String messageclic4[]={
				"",
				"Apres 4eme clic	",
				"Cliquer pour continuer ...",
				""
	};
			
		IG.afficherMessage(messageclic4); 
		IG.miseAJourAffichage();
		//retier objet plateau et transparence 
		IG.enleverObjetPlateau(0,3);
		IG.changerObjetJoueurAvecTransparence(0,3,3);
			

			IG.miseAJourAffichage();
			IG.attendreClic();
		
		//afficher 1er joueur gagnant
		IG.afficherGagnant(0);
		IG.miseAJourAffichage();
		
		//message fleche
		String messagefleche[]={
				"",
				"Cliquer sur une fleche...",
				 "...pour quitter",
				""
	};
		IG.afficherMessage(messagefleche); 
		IG.miseAJourAffichage();
		//Cliquer sur une fleche pour quitter
		IG.attendreChoixEntree();
		IG.pause(2);
		//fermeture
		IG.fermerFenetreJeu();
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		
		MaDemoIG demo = new MaDemoIG();
		
		demo.demoGraphique();
	}
}
