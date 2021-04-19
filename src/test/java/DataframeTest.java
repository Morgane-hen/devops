import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import DFrame.Colonne;
import DFrame.Dataframe;

class DataframeTest {

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
		assertFalse(d.getDataframe().isEmpty(), "la dataframe contiens une colonne");
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
	void getColonneLabelTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne(new ArrayList<String>(), "colonne"));
		assertEquals(d.getColonne("colonne").getLabel(), "colonne", "Le label de la colonne est bien colonne" );
	}
	
	@Test
	void getColonneIndexTest() {
		Dataframe d = new Dataframe();
		d.addColonne(new Colonne<String>(new ArrayList<String>(), "colonne"));
		d.addColonne(new Colonne<Integer>(new ArrayList<Integer>(), "colonne2"));
		assertEquals(d.getColonne(0).getLabel(), "colonne", "Le label de la colonne 1 est bien colonne" );
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
	
	@Test 
	void createDataframeFromColonnsTest() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Oui");
		Colonne<String> c = new Colonne<String>(a, "col1");
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("Non");
		Colonne<String> c2 = new Colonne<String>(a2, "col2");
		
		Dataframe d = new Dataframe();
		d.addColonne(c);
		d.addColonne(c2);
		
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("col1");
		
		Dataframe nouveau = d.createNewDataframeFromColonnes(labels);
		
		assertEquals(nouveau.nbColonnes(), 1, "Il n'y a plus qu'une colonne");
		assertEquals(nouveau.getColonne(0).getLabel(), "col1", "Le label de la colonne est col1");
		
	}
	
	@Test
	void createDataframeFromLinesTest() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Oui");
		a.add("Non");
		Colonne<String> c = new Colonne<String>(a, "col1");
		
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("Demain");
		a2.add("Hier");
		Colonne<String> c2 = new Colonne<String>(a2, "col2");
		
		Dataframe d = new Dataframe();
		d.addColonne(c);
		d.addColonne(c2);
		
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		indexs.add(0);
		
		Dataframe nouveau = d.createNewDataframeFromLines(indexs);
		
		assertEquals(nouveau.nbColonnes(), 2, "Il y a toujours 2 colonne");
		assertEquals(nouveau.nbLignes(), 1, "Il y a une seule ligne");
		assertEquals(nouveau.getColonne(0).getElem(0), "Oui", "Le premier Elements de la ligne est Oui");
		assertEquals(nouveau.getColonne(1).getElem(0), "Demain", "Le Deuxieme est Demain");
	}
	
	
}
