package Dataframe;

import java.util.ArrayList;

public class Dataframe {

	
	private ArrayList<Object> dataframe;
	static int cpt_colonne = 0;
	
	/*
	 * cr�ation d'une dataframe vide
	 */
	public Dataframe()
	{
		dataframe = new ArrayList<Object>();
	}
	
	/*
	 * cr�ation d'une dataframe � partir d'un tableau contenant les objets souhait�s
	 */
	public Dataframe(ArrayList<Object> _dataframe)
	{
		this.dataframe = _dataframe;
		int size = _dataframe.size();
		cpt_colonne = size;
	}
	
	
	/*
	 * @param  colonne : arrayList contenant les objets de la colonne
	 */
	public void addColonne(ArrayList<Object> colonne)
	{
		//ajout d'une colonne
		dataframe.add(colonne);
		cpt_colonne++;
	}
	
	
	
	
	
}
