import DFrame.Colonne;
import DFrame.Dataframe;
import DFrame.StatistiquesNumber;
import DFrame.StatistiquesString;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		//colonnes
		ArrayList<Double> colonne1 = new ArrayList<Double>();
		colonne1.add(1.0);
		colonne1.add(2.7);
		colonne1.add(3.9);
		colonne1.add(4.3);
		colonne1.add(5.1);
		colonne1.add(6.0);
		colonne1.add(7.0);
		colonne1.add(8.0);
		Colonne<Double> c = new Colonne<Double>(colonne1, "col1");
		
		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		colonne2.add("Poire");
		colonne2.add("Framboise");
		colonne2.add("Peche");
		colonne2.add("Cerise");
		colonne2.add("Pasteque");
		colonne2.add("Cerise");
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
		System.out.println("");

		//Creation d'un dataframe a partir d'un autre
		System.out.println("***************************Creation d'un Dataframe à partir des colonnes 1 et 2******");
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("col1");
		labels.add("col2");
		Dataframe newData = data.createNewDataframeFromColonnes(labels);
		newData.afficherLignesDataframe();
		System.out.println("");
		System.out.println("");
		System.out.println("***************************Creation d'un Dataframe à partir des lignes 3, 5, 7******");
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		indexs.add(2); //car on commence le compte à 0
		indexs.add(4);
		indexs.add(6);
		Dataframe anotherData = data.createNewDataframeFromLines(indexs);
		anotherData.afficherLignesDataframe();
		System.out.println("");
		System.out.println("");
		System.out.println("***************************Fin des créations de Dataframe***************************");
		System.out.println("");
		
		//Statistques sur les dataframes
		//System.out.println("***************************Statistiques de Dataframe********************************");

		Dataframe selection = data.selectionEqual("col1", 7);
		selection.afficherColonnesDataframe();
		selection.afficherDernieresLignes();

		System.out.println();
		System.out.println("***************************Stats Nombres****************************************");
		StatistiquesNumber stats_n = new StatistiquesNumber(c);
		stats_n.afficheStats();
		System.out.println("***************************Fin de l'affichage****************************************");
		System.out.println();
		System.out.println("***************************Stats String****************************************");
		StatistiquesString stats_s = new StatistiquesString(c2);
		stats_s.afficheStats();
		System.out.println("***************************Fin de l'affichage****************************************");
    
	}
}
