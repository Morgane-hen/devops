package Dataframe;

import java.util.ArrayList;
import Dataframe.*;
import java.util.*;

public class Dataframe<E> {

	private ArrayList<Colonne<E>> dataframe;
	private int cpt_colonne = 0;
	
	/*
	 * cr�ation d'une dataframe vide
	 */
	public Dataframe()
	{
		dataframe = new ArrayList<Colonne<E>>();
	}
	
	/*
	 * cr�ation d'une dataframe � partir d'un tableau contenant les objets souhait�s
	 */
	public Dataframe(ArrayList<Colonne<E>> _dataframe)
	{
		this.dataframe = _dataframe;
		cpt_colonne = dataframe.size();
	}
	
	/*
	 * Retourne le dataframe
	 * */
	public  ArrayList<Colonne<E>> getDataframe(){
		return dataframe;
	}
	
	/*
	 * Retourne le nombre de colonnes
	 * */
	public int nbColonnes() {
		return cpt_colonne;
	}
	
	/*
	 * @param  colonne : arrayList contenant les objets de la colonne
	 */
	public void addColonne(Colonne<E> colonne)
	{
		//ajout d'une colonne
		this.dataframe.add(colonne);
		cpt_colonne++;
	}
	
	/*
	 * Retourne une colonne
	 * @param label : nom d'une colonne
	 * */
	public Colonne<E> getColonne(String label) {
		Colonne<E> c = new Colonne<E>();
		for (int i=0; i<dataframe.size(); i++) {
			if(dataframe.get(i).getLabel().equals(label)) {
				c = dataframe.get(i);
			}
		}
		if (c.getLabel().equals("")) {
			return null;
		}else {
			return c;
		}
	}
	
	/*
	 * Retourne le nombres de lignes du dataframe
	 * */
	public int nbLignes() {
		int nb=0;
		for(int i=0; i<dataframe.size(); i++) {
			if (dataframe.get(i).colonneSize()>nb) {
				nb = dataframe.get(i).colonneSize();
			}
		}
		return nb;
	}
	
	/*
	 * Affiche le datafrmae par colonne
	 * */
	public void afficherColonnesDataframe() {
		for (int i=0; i<dataframe.size(); i++) {
			dataframe.get(i).afficheColone();
		}
	}
	
	/*
	 * Affiche le dataframe par ligne
	 * */
	public void afficherLignesDataframe() {
		int nblignes = this.nbLignes();
		for (int j= 0 ; j<nblignes; j++) {
			System.out.println("");
			System.out.println("Ligne "+(j+1)+":");
			for (int i=0; i<dataframe.size(); i++) {
				dataframe.get(i).afficherElem(j);
			}
		}
	}
	
	/*
	 * Afficher les 5 premières lignes du dataframe
	 * */
	public void afficherPremieresLignes() {
		for (int j= 0 ; j<5; j++) {
			System.out.println("");
			System.out.println("Ligne "+(j+1)+":");
			for (int i=0; i<dataframe.size(); i++) {
				dataframe.get(i).afficherElem(j);
			}
		}
		
	}
	
	/*
	 * Afficher les 5 dernières lignes du dataframe
	 * */
	public void afficherDernieresLignes() {
		for (int j= this.nbLignes() ; j>this.nbLignes()-5; j--) {
			System.out.println("");
			System.out.println("Ligne "+j+":");
			for (int i=0; i<dataframe.size(); i++) {
				dataframe.get(i).afficherElem(j-1);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
