import DFrame.Colonne;
import DFrame.Dataframe;
import DFrame.Statistiques_number;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		//colonnes
		ArrayList<Integer> colonne1 = new ArrayList<Integer>();
		colonne1.add(1);
		colonne1.add(2);
		colonne1.add(3);
		colonne1.add(4);
		colonne1.add(5);
		colonne1.add(6);
		colonne1.add(7);
		colonne1.add(8);
		Colonne<Integer> c = new Colonne<Integer>(colonne1, "col1");
		
		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		colonne2.add("Poire");
		colonne2.add("Framboise");
		colonne2.add("Peche");
		colonne2.add("Cerise");
		colonne2.add("Pasteque");
		colonne2.add("Pamplemouse");
		colonne2.add("Abricot");
		Colonne<String> c2 = new Colonne<String>(colonne2, "col2");
		
		ArrayList<String> colonne3 = new ArrayList<String>();
		colonne3.add("Haricot");
		colonne3.add("Chou");
		colonne3.add("Fenouil");
		colonne3.add("Poireau");
		colonne3.add("Courgette");
		colonne3.add("Champignon");
		colonne3.add("Poivron");
		colonne3.add("Salade");
		Colonne<String> c3 = new Colonne<String>(colonne3, "col3");
		
		//Dataframe
		Dataframe data = new Dataframe();
		data.addColonne(c);
		data.addColonne(c2);
		data.addColonne(c3);
		
		//affichage
		System.out.println("****************************Affichage du dataframe complet par lignes*****************");
		data.afficherLignesDataframe();
		System.out.println("");
		System.out.println("****************************Fin de L'affichage****************************************");
		System.out.println(" ");
		System.out.println("****************************Affichage des 5 premières lignes**************************");
		data.afficherPremieresLignes();
		System.out.println("");
		System.out.println("***************************Fin de l'affichage****************************************");
		System.out.println(" ");
		System.out.println("****************************Affichage des 5 dernières lignes**************************");
		data.afficherDernieresLignes();
		System.out.println("");
		System.out.println("***************************Fin de l'affichage****************************************");


		Statistiques_number stats_n = new Statistiques_number(c);
	}
}
