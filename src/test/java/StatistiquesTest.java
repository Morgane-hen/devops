import DFrame.Colonne;
import DFrame.Pair;
import DFrame.StatistiquesNumber;
import DFrame.StatistiquesString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatistiquesTest {

	private Colonne<Integer> c;
	private Colonne<Float> cfloat;
	private Colonne<Double> cdouble;
	private Colonne<String> c2;

	@Test
	void StatistiquesInt() {

		ArrayList<Integer> colonne1 = new ArrayList<Integer>();
		colonne1.add(1);
		colonne1.add(2);
		colonne1.add(3);
		colonne1.add(4);
		colonne1.add(5);
		colonne1.add(6);
		colonne1.add(7);
		colonne1.add(8);
		c = new Colonne<Integer>(colonne1, "col1");

		StatistiquesNumber stats_n = new StatistiquesNumber(c);
		stats_n.calculStats();
		assertEquals(stats_n.getMoyenne(), 4.5, "La moyenne doit être de 4,5");
		assertEquals(stats_n.getEcart_type(), 2.0, "L'écart-type doit être de 1,5");
	}

	@Test
	void StatistiquesFloat() {

		ArrayList<Float> colonne1 = new ArrayList<Float>();
		colonne1.add(1.0F);
		colonne1.add(2.0F);
		colonne1.add(3.0F);
		colonne1.add(4.0F);
		colonne1.add(5.0F);
		colonne1.add(6.0F);
		colonne1.add(7.0F);
		colonne1.add(8.0F);
		cfloat = new Colonne<Float>(colonne1, "col1");

		StatistiquesNumber stats_n = new StatistiquesNumber(cfloat);
		stats_n.calculStats();
		assertEquals(stats_n.getMoyenne(), 4.5, "La moyenne doit être de 4,5");
		assertEquals(stats_n.getEcart_type(), 2.0, "L'écart-type doit être de 1,5");
	}

	@Test
	void StatistiquesDouble() {

		ArrayList<Double> colonne1 = new ArrayList<Double>();
		colonne1.add(1.0);
		colonne1.add(2.0);
		colonne1.add(3.0);
		colonne1.add(4.0);
		colonne1.add(5.0);
		colonne1.add(6.0);
		colonne1.add(7.0);
		colonne1.add(8.0);
		cdouble = new Colonne<Double>(colonne1, "col1");

		StatistiquesNumber stats_n = new StatistiquesNumber(cdouble);
		stats_n.calculStats();
		assertEquals(stats_n.getMoyenne(), 4.5, "La moyenne doit être de 4,5");
		assertEquals(stats_n.getEcart_type(), 2.0, "L'écart-type doit être de 1,5");
	}
	
	@Test
	void StatistiquesMots() {

		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		colonne2.add("Poire");
		colonne2.add("Framboise");
		colonne2.add("Peche");
		colonne2.add("Cerise");
		colonne2.add("Pasteque");
		colonne2.add("Cerise");
		colonne2.add("Abricot");
		c2 = new Colonne<String>(colonne2, "col2");

		StatistiquesString stats_s = new StatistiquesString(c2);
		stats_s.calculStats();
		Colonne<String> sans_doublon = new Colonne<>();

		sans_doublon.addElem("Cerise");
		sans_doublon.addElem("Framboise");
		sans_doublon.addElem("Pasteque");
		sans_doublon.addElem("Poire");
		sans_doublon.addElem("Abricot");
		sans_doublon.addElem("Pomme");
		sans_doublon.addElem("Peche");

		int cpt = 0;
		assertEquals(sans_doublon.colonneSize(), stats_s.col_sansDoublon().colonneSize(), "Les éléments ne doivent pas être répétés");

		for (String fruit: sans_doublon.getColonne()) {

			assertEquals(fruit, stats_s.col_sansDoublon().getElem(cpt), "Il ne doit pas y avoir de doublon");
			cpt++;
		}

		ArrayList<Pair> repete = new ArrayList<>();
		repete.add(new Pair("Cerise", 2));
		assertEquals(repete.get(0).getRepet(), stats_s.plusGrossesRepetes().get(0).getRepet());
		assertEquals(repete.get(0).getClef(), stats_s.plusGrossesRepetes().get(0).getClef());
	}

	void StatistiquesMotsPourcentages() {

		ArrayList<String> colonne2 = new ArrayList<String>();
		colonne2.add("Pomme");
		colonne2.add("Poire");
		colonne2.add("Framboise");
		colonne2.add("Peche");
		colonne2.add("Cerise");
		colonne2.add("Pasteque");
		colonne2.add("Cerise");
		colonne2.add("Abricot");
		c2 = new Colonne<String>(colonne2, "col2");

		StatistiquesString stats_s = new StatistiquesString(c2);
		stats_s.calculStats();
		Colonne<String> sans_doublon = new Colonne<>();

		sans_doublon.addElem("Cerise");
		sans_doublon.addElem("Framboise");
		sans_doublon.addElem("Pasteque");
		sans_doublon.addElem("Poire");
		sans_doublon.addElem("Abricot");
		sans_doublon.addElem("Pomme");
		sans_doublon.addElem("Peche");

		int cpt = 0;
		assertEquals(sans_doublon.colonneSize(), stats_s.col_sansDoublon().colonneSize(), "Les éléments ne doivent pas être répétés");

		for (String fruit: sans_doublon.getColonne()) {

			assertEquals(fruit, stats_s.col_sansDoublon().getElem(cpt), "Il ne doit pas y avoir de doublon");
			cpt++;
		}

		ArrayList<Pair> repete = new ArrayList<>();
		repete.add(new Pair("Cerise", 2));
		assertEquals(repete.get(0).getRepet(), stats_s.plusGrossesRepetes().get(0).getRepet());
		assertEquals(repete.get(0).getClef(), stats_s.plusGrossesRepetes().get(0).getClef());
	}

}
