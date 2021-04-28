import DFrame.Colonne;
import DFrame.Csv;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//on teste le constructeur avec différents types de données
class CsvTest {
	
	@Test
	void ConstructeurTest() throws Exception {
		Csv fichier = new Csv("src/fichiers_Csv/donnees_test.csv");
		ArrayList<Colonne> colonnes = fichier.getData().getDataframe();
		int cpt = 0;
		for (Colonne colonne: colonnes)
		{
			assertEquals(colonne.colonneSize(),10, "Le nb d'élément dans n'importe quelle colonne doit être égal à 10 : l"+cpt);
			cpt++;
		}
	}

	@Test
	void ConstructeurPasCsvException() {
		assertThrows(IOException.class, () -> {
			new Csv("src/fichiers_Csv/donnees_test.txt");
		});
	}

	@Test
	void ConstructeurCheminException() {
		assertThrows(IOException.class , () -> {
			new Csv("src/donnees_test.csv");
		});
	}
	
	@Test
	void Constructeur2Test() throws Exception {
		Csv fichier = new Csv("src/fichiers_Csv/donnees_incompletes_test.csv");
		ArrayList<Colonne> colonnes = fichier.getData().getDataframe();
		int cpt = 0;
		for (Colonne colonne: colonnes)
		{
			assertEquals(colonne.colonneSize(),10, "Le nb d'élément dans n'importe quelle colonne doit être égal à 10 : l"+cpt);
			cpt++;
		}
	}

	@Test
	void Constructeur3Test() throws Exception {
		Csv fichier = new Csv("src/fichiers_Csv/donnees_test_vide.csv");

		assertEquals(fichier.getData().getDataframe().size(), 1, "Une colonne créée automatiquement si pas de données");
		assertEquals(fichier.getData().getColonne(0).colonneSize(), 0, "l'unique colonne doit être vide");
	}

	@Test
	void Constructeur4Test() throws Exception {
		Csv fichier = new Csv("src/fichiers_Csv/donnees_test.csv");

		assertEquals(fichier.getData().getDataframe().size(), 5, "Une colonne créée automatiquement si pas de données");
	}
}
