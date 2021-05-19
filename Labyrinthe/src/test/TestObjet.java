package test;

import composants.Objet;
import grafix.interfaceGraphique.IG;

public class TestObjet {
	
	public void testObjet() {
		Object parametres[];
		parametres=IG.saisirParametres();
		int nbJoueurs=((Integer)parametres[0]).intValue();
		IG.creerFenetreJeu("Groupe Projet S2 Demo Librairie",nbJoueurs);
		IG.rendreVisibleFenetreJeu();
		IG.jouerUnSon(2);
		IG.pause(300);
		IG.jouerUnSon(2);
		IG.attendreClic();
		String message[]={
				"",
				"Cliquer pour continuer ...",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		Objet[] obj=Objet.nouveauxObjets();
		for (int i=0;i<obj.length;i++) {
			IG.placerObjetPlateau(obj[i].getNumeroObjet(), obj[i].getPosLignePlateau(), obj[i].getPosColonnePlateau());
		}
		IG.miseAJourAffichage();
		IG.attendreClic();
		IG.fermerFenetreJeu();
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		TestObjet demo=new TestObjet();
		demo.testObjet();
	}
}
