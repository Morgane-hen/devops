
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import DFrame.Colonne;

class ColonneTest {
	
	@Test
	void ConstructeurTest() {
		Colonne c = new Colonne();
		assertEquals(c.colonneSize(), 0, "La taille de la colonne doit être à 0");
	}
	
	@Test
	void Constructeur2Test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		Colonne c = new Colonne(list, "Colonne");
		assertEquals(c.getLabel(), "Colonne", "Le label de la colonne doit etre Colonne");
		assertEquals(c.colonneSize(), 2, "La taille de la colonne doit être de 2");
	}

	@Test 
	void getColonneTest() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		Colonne c = new Colonne(list, "Colonne");
		assertEquals(c.getColonne(), list, "la colonne contient les elements de list");
	}
	
	@Test
	void addElemTest(){ //Rajouter des tests pour verifier que les elements ajouté sont forcément du même Type
		Colonne c = new Colonne();
		c.addElem("carotte");
		assertEquals(c.getElem(0), "carotte", "L'element de la liste est carotte");
		assertEquals(c.colonneSize(), 1, "La colonne contient 1 element");
	}

	@Test
	void addElemTest2(){
		Colonne c = new Colonne();
		c.addElem(3, 7);
		assertEquals(c.getElem(3), 7, "l'élément doit être à la position 3");
	}
	
	//Rajouter tests d'affichage
}
