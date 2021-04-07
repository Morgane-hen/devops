package Dataframe;

import java.util.ArrayList;
import java.util.*;

public class Dataframe {

	
	private ArrayList<Colonne> dataframe;
	static int cpt_colonne = 0;
	
	/*
	 * cr�ation d'une dataframe vide
	 */
	public Dataframe()
	{
		dataframe = new ArrayList<Colonne>();
	}
	
	/*
	 * cr�ation d'une dataframe � partir d'un tableau contenant les objets souhait�s
	 */
	public Dataframe(ArrayList<Colonne> _dataframe)
	{
		this.dataframe = _dataframe;
		cpt_colonne = _dataframe.size();
	}	
	
	/*
	 * @param  colonne : arrayList contenant les objets de la colonne
	 */
	public void addColonne(Colonne colonne)
	{
		//ajout d'une colonne
		dataframe.add(colonne);
		cpt_colonne++;
	}
	
	public void afficherDataframe() {
		for (int i=0; i<dataframe.size(); i++) {
			dataframe.get(i).afficheColone();
		}
	}
	
	
	
	
	
}
