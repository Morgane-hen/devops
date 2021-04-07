package Dataframe;

import java.util.ArrayList;

public class Colonne<E> {

	private ArrayList<E> colonne;
	private String label = "";
	
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
	public Colonne(ArrayList<E> elem, String _label)
	{
		this.colonne = elem;
		this.label = _label;
	}
	
	public ArrayList<E> getColonne(){
		return colonne;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void afficheColone() {
		String affichage = this.label + " => ";
		for (int i=0; i<colonne.size(); i++) {
			if(i == 0)
			{
				affichage += "elem: "+colonne.get(i)+ "\n";
			}
			else
			{
				affichage+="	elem: "+colonne.get(i)+ "\n";
			}
			
		}
		System.out.println(affichage);
	}
	
	public int nb_elem()
	{
		return this.colonne.size();
	}
	
}
