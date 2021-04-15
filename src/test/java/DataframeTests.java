package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Dataframe.Colonne;
import Dataframe.Dataframe;

class DataframeTests {

	@Test
	void ConstructeurTest() {
		Dataframe d = new Dataframe();
		assertEquals(d.getDataframe().size(), 0, "La taille de la colonne doit être à 0");
	}
	
	@Test 
	void Constructeur2Test() {
		//colonnes
		ArrayList<Integer> colonne1 = new ArrayList<Integer>();
		colonne1.add(1);
		Colonne<Integer> c = new Colonne<Integer>(colonne1, "col1");
		
		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		Colonne<String> c2 = new Colonne<String>(colonne2, "col2");
		
		ArrayList<Colonne> data = new ArrayList<Colonne>();
		data.add(c);
		data.add(c2);
		
		Dataframe dataframe = new Dataframe(data);
		
		assertEquals(dataframe.nbColonnes(), 2, "il y a deux colonnes");
	}
	
	@Test 
	void getDataframeTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne(new ArrayList<String>(), "colonne"));
		assertEquals(d.getDataframe().isEmpty(), false, "la dataframe contiens une colonne");
	}
	
	@Test
	void nbColonnesTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne(new ArrayList<String>(), "colonne"));
		assertEquals(d.nbColonnes(), 1, "il y a une colonne");
		d.addColonne(new Colonne());
		assertEquals(d.nbColonnes(), 2, "il y a une colonne de plus");
	}
	
	@Test
	void getColonneTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne(new ArrayList<String>(), "colonne"));
		assertEquals(d.getColonne("colonne").getLabel(), "colonne", "Le label de la colonne est bien colonne" );
	}
	
	@Test
	void nbLignesTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne(new ArrayList<String>(), "cString"));
		d.addColonne(new Colonne(new ArrayList<Integer>(), "cInt"));
		
		Colonne col1 = d.getColonne("cString");
		Colonne col2 = d.getColonne("cInt");
		
		col1.addElem("Licorne");
		col2.addElem(22);
		col2.addElem(43);
		
		assertEquals(d.nbLignes(), 2, "Il y a deux lignes dans le dataframe");
		col1.addElem("HIHOU");
		assertEquals(d.nbLignes(), 2, "Il y a toujours deux lignes");
		col1.addElem("youpi");
		assertEquals(d.nbLignes(), 3, "Il y a maintenant 3 lignes");

	}
	
	
}
