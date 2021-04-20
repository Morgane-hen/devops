import DFrame.Colonne;
import DFrame.Csv;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//on teste le constructeur avec différents types de données
class CsvTest {
	
	@Test
	void ConstructeurTest() {
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
	void Constructeur2Test() {
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
	void Constructeur3Test() {
		Csv fichier = new Csv("src/fichiers_Csv/donnees_test_vide.csv");

		assertEquals(fichier.getData().getDataframe().size(), 1, "Une colonne créée automatiquement si pas de données");
		assertEquals(fichier.getData().getColonne(0).colonneSize(), 0, "l'unique colonne doit être vide");
	}
}
