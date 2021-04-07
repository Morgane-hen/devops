package Dataframe;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		//colonnes
		ArrayList<Integer> colonne1 = new ArrayList<Integer>();
		colonne1.add(1);
		colonne1.add(2);
		Colonne<Integer> c = new Colonne(colonne1, "col1");
		
		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		colonne2.add("Poire");
		Colonne<String> c2 = new Colonne(colonne2, "col2");
		
		//Dataframe
		Dataframe data = new Dataframe();
		data.addColonne(c);
		data.addColonne(c2);
		
		//affichage
		data.afficherDataframe();
	}
}
