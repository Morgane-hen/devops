package Dataframe;

import java.util.ArrayList;

public class Colonne<E> {

	private ArrayList<E> colonne;
	
	/*
	 * cr�ation d'une colonne vide
	 */
	public Colonne()
	{
		this.colonne = new ArrayList<E>();
	}
	
	/*
	 * cr�ation d'une colonne
	 */
	public Colonne(ArrayList<E> elem)
	{
		this.colonne = elem;
	}
	
	public ArrayList<E> getColonne(){
		return colonne;
	}
	
	public void afficheColone() {
		for (int i=0; i<colonne.size(); i++) {
			System.out.println("elem: "+colonne.get(i));
		}
	}
	
}
