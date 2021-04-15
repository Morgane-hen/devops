package Dataframe;

import java.util.ArrayList;
import Dataframe.*;
import java.util.*;

public class Dataframe {

	private ArrayList<Colonne<Object>> dataframe;
	static int cpt_colonne = 0;
	
	/*
	 * cr�ation d'une dataframe vide
	 */
	public Dataframe()
	{
		dataframe = new ArrayList<Colonne<Object>>();
	}
	
	/*
	 * cr�ation d'une dataframe � partir d'un tableau contenant les objets souhait�s
	 */
	public Dataframe(ArrayList<Colonne<Object>> _dataframe)
	{
		this.dataframe = _dataframe;
		cpt_colonne = _dataframe.size();
	}	
	
	/*
	 * @param  colonne : arrayList contenant les objets de la colonne
	 */
	public void addColonne(Colonne<Object> colonne)
	{
		//ajout d'une colonne
		this.dataframe.add(colonne);
		cpt_colonne++;
	}
	
	public void afficherDataframe() {
		for (int i=0; i<dataframe.size(); i++) {
			dataframe.get(i).afficheColone();
		}
	}
	
	
	
	
	
}
