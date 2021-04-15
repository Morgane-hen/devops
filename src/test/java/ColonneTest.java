import org.junit.*;
import Dataframe.*;

import static org.junit.Assert.*;


public class ColonneTest {

	
	@Test
	public void premierTest()
	{
		Colonne c = new Colonne();
		int nb_elem = c.nb_elem();
		assertTrue("test nb_elem", nb_elem == 0);
	}
	
}
