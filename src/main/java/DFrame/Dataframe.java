package DFrame;

import java.util.ArrayList;

public class Dataframe<E> {

	private final ArrayList<Colonne<E>> dataframe;
	private int cpt_colonne = 0;
	
	/**
	 * cr�ation d'une dataframe vide
	 */
	public Dataframe()
	{
		dataframe = new ArrayList<Colonne<E>>();
	}

	/**
	 * cr�ation d'une dataframe � partir d'un tableau contenant les objets souhait�s
	 * @param _dataframe
	 */
	public Dataframe(ArrayList<Colonne<E>> _dataframe)
	{
		this.dataframe = _dataframe;
		cpt_colonne = dataframe.size();
	}

	/**
	 *
	 * @return : accesseur sur l'ensemble des colonnes
	 */
	public  ArrayList<Colonne<E>> getDataframe(){
		return dataframe;
	}
	
	/*
	 * Retourne le nombre de colonnes
	 * */
	public int nbColonnes() {
		return cpt_colonne;
	}

	/**
	 *
	 * @param colonne : arrayList contenant les objets de la colonne
	 */
	public void addColonne(Colonne<E> colonne)
	{
		//ajout d'une colonne
		this.dataframe.add(colonne);
		cpt_colonne++;
	}

	/**
	 *
	 * @param label : nom d'une colonne
	 * @return : la colonne avec le label indiqué
	 */
	public Colonne<E> getColonne(String label) {
		Colonne<E> c = new Colonne<>();
		for (Colonne<E> eColonne : dataframe) {
			if (eColonne.getLabel().equals(label)) {
				c = eColonne;
			}
		}
		if (c.getLabel().equals("")) {
			return null;
		}else {
			return c;
		}
	}

	/**
	 *
	 * @param index : numéro de la colonne
	 * @return : la colonne ayant l'indice index dans l'arrayList dataframe
	 */
	public Colonne<E> getColonne(int index){
		return dataframe.get(index);
	}

	/**
	 *
	 * @return : le nombres de lignes du dataframe
	 */
	public int nbLignes() {
		int nb=0;
		for (Colonne<E> eColonne : dataframe) {
			if (eColonne.colonneSize() > nb) {
				nb = eColonne.colonneSize();
			}
		}
		return nb;
	}
	
	/**Testé sans Junit**/

	/**
	 * Affiche le dataframe par colonne
	 */
	public void afficherColonnesDataframe() {
		for (Colonne<E> eColonne : dataframe) {
			eColonne.afficheColone();
		}
	}
	
	/**
	 * Affiche le dataframe par ligne
	 */
	public void afficherLignesDataframe() {
		int nblignes = this.nbLignes();
		for (int j= 0 ; j<nblignes; j++) {
			System.out.println();
			System.out.println("Ligne "+(j+1)+":");
			for (Colonne<E> eColonne : dataframe) {
				eColonne.afficherElem(j);
			}
		}
	}

	/**
	 * Afficher les 5 premières lignes du dataframe
	 */
	public void afficherPremieresLignes() {

		int j = 0;
		boolean fini = false;
		while(j < 5 && !fini)
		{
			System.out.println("");
			System.out.println("Ligne "+(j+1)+":");
			for (int i=0; i<dataframe.size(); i++) {
				if(dataframe.get(i).getElem(j) != null)
				{
					dataframe.get(i).afficherElem(j);
				}
				else
				{
					fini = true;
				}

			}
			j++;
		}
		
	}
	
	/**
	 * Afficher les 5 dernières lignes du dataframe
	 */
	public void afficherDernieresLignes() {

		int j = 5;

		for (Colonne c: this.dataframe)
		{
			if(c.colonneSize() < j)
			{
				j = c.colonneSize();
			}
		}

		while(j > 0)
		{
			System.out.println("");
			System.out.println("Ligne "+(this.nbLignes()-j+1)+" :");
			for (int i=0; i<dataframe.size(); i++)
			{
				dataframe.get(i).afficherElem(this.nbLignes()-j);
			}
			j--;
		}

	}
	
	/**A tester avec Junit et sans**/

	/**
	 *
	 * @param labels : ArrayList des colonnes qui composeront le nouveau dataframe
	 * @return : le nouveau dataframe créé
	 */
	public Dataframe createNewDataframeFromColonnes(ArrayList<String> labels) {
		Dataframe data = new Dataframe();
		for(int i=0; i<labels.size(); i++) {
			data.addColonne(this.getColonne(labels.get(i)));
		}
		return data;
	}
	
	/*
	 * Creation d'un Dataframe a partir des lignes d'un autre
	 * */

	/**
	 *
	 * @param index :
	 * @return : nouveau dataframe rempli à partir de celui-ci
	 */
	public Dataframe createNewDataframeFromLines( ArrayList<Integer> index) {
		
		Dataframe data = new Dataframe();
		int nb = this.nbColonnes();
		
		//Creation du nombre de colonne
		for(int i=0; i<nb; i++) {
			Colonne c = new Colonne();
			data.addColonne(c);
		}
		
		//Remplissage du nouveau dataframe 
		for(int i=0; i<index.size(); i++) {
			for(int j=0; j<nb; j++) {
				Colonne c = data.getColonne(j);
				c.addElem(this.getColonne(j).getElem(index.get(i)));
			}
		}
		return data;
		
	}

	/**
	 *
	 * @return : Dataframe avec les colonnes créées avec le même label que this
	 */
	public Dataframe copieVide()
	{
		Dataframe res = new Dataframe();

		for (Colonne c: this.dataframe)
		{
				Colonne c_bis = new Colonne(c.getLabel());
				res.addColonne(c_bis);
		}

		return res;
	}

	/**
	 *
	 * @param receveur : dataframe qui recoit les données de this
	 * @param index_ligne : ligne de this qu'il faut ajouter dans receveur
	 */
	public void ajouteLigne(Dataframe receveur, int index_ligne)
	{
		if(index_ligne < 0)
		{
			//exception
			System.out.println("erreur : "+index_ligne);
		}

		Dataframe res = new Dataframe();
		for (Colonne c: this.dataframe)
		{
			if(index_ligne < c.colonneSize())
			{
				//on vérifie que la colonne existe bien dans le deuxième dataframe
				if(receveur.getColonne(c.getLabel()) != null)
				{
					//ajoute l'élément numéro index_ligne de la colonne c au dataframe receveur
					receveur.getColonne(c.getLabel()).addElem(c.getElem(index_ligne));
				}
			}
		}
	}

	/**
	 *
	 * @param label : nom de la colonne servant à sélectionner
	 * @param equal : la valeur sélective
	 * @return : le nouveau dataframe avec les lignes sélectionnées
	 */
	public Dataframe selectionEqual(String label, Number equal)
	{
		Dataframe  data = this.copieVide();
		boolean colonne_trouvee = false;
		int cpt_colonne = 0;
		if(this.getColonne(label) != null && this.getColonne(label).colonneSize() != 0)
		{
			//la colonne à sélectionné a été trouvée
			//on sélectionne les éléments souhaités
			int cpt = 0;
			for (Number elem: (ArrayList<Number>)this.getColonne(label).getColonne())
			{
				double new_elem = elem.doubleValue();
				double new_equal = equal.doubleValue();
				if(new_elem == new_equal)
				{
					//on ajoute la ligne complète au nouveau dataframe
					this.ajouteLigne(data, cpt);
				}
				cpt++;
			}

			return data;
		}
		else
		{
			//pas de colonne avec ce label, on renvoie vide
			return new Dataframe();
		}
	}

	/**
	 *
	 * @param label : nom de la colonne servant à sélectionner
	 * @param borne_inf : la valeur à dépasser
	 * @param equal : si true, valeur supérieure ou égale
	 * @return : le nouveau dataframe avec les lignes sélectionnées
	 */
	public Dataframe selectionSup(String label, Number borne_inf, boolean equal)
	{
		Dataframe  data = this.copieVide();
		boolean colonne_trouvee = false;
		int cpt_colonne = 0;
		if(this.getColonne(label) != null && this.getColonne(label).colonneSize() != 0)
		{
			//la colonne a sélectionné a été trouvée

			//on sélectionne les éléments souhaités
			int cpt = 0;
			for (Number elem: (ArrayList<Number>) this.getColonne(label).getColonne())
			{
				double new_elem = elem.doubleValue();
				double new_borne_inf = borne_inf.doubleValue();
				if(new_elem > new_borne_inf || ((new_elem == new_borne_inf) && equal))
				{
					//on ajoute la ligne complète au nouveau dataframe
					this.ajouteLigne(data, cpt);
				}
				cpt++;
			}

			return data;
		}
		else
		{
			//pas de colonne avec ce label, on renvoie vide
			return new Dataframe();
		}
	}

	/**
	 *
	 * @param label : nom de la colonne servant à sélectionner
	 * @param borne_sup : la valeur à ne pas dépasser
	 * @param equal : si true, valeur inférieure ou égale
	 * @return : le nouveau dataframe avec les lignes sélectionnées
	 */
	public Dataframe selectionInf(String label, Number borne_sup, boolean equal)
	{
		Dataframe  data = this.copieVide();
		boolean colonne_trouvee = false;
		int cpt_colonne = 0;
		if(this.getColonne(label) != null && this.getColonne(label).colonneSize() != 0)
		{
			//la colonne a sélectionné a été trouvée

			//on sélectionne les éléments souhaités
			int cpt = 0;
			for (Number elem: (ArrayList<Number>)this.getColonne(label).getColonne())
			{
				double new_elem = elem.doubleValue();
				double new_borne_sup = borne_sup.doubleValue();
				if(new_elem < new_borne_sup || ((new_elem == new_borne_sup) && equal))
				{
					//on ajoute la ligne complète au nouveau dataframe
					this.ajouteLigne(data, cpt);
				}
				cpt++;
			}
			return data;
		}
		else
		{
			//pas de colonne avec ce label, on renvoie vide
			return new Dataframe();
		}
	}

	/**
	 *
	 * @param label : nom de la colonne servant à sélectionner
	 * @param equal : la valeur sélective
	 */
	public Dataframe selectionEqual(String label, String equal)
	{
		Dataframe  data = this.copieVide();
		boolean colonne_trouvee = false;
		int cpt_colonne = 0;
		if(this.getColonne(label) != null && this.getColonne(label).colonneSize() != 0)
		{
			//la colonne a sélectionné a été trouvée
			//on sélectionne les éléments souhaités
			int cpt = 0;
			for (String elem: (ArrayList<String>)this.getColonne(label).getColonne())
			{
				if(elem.equals(equal))
				{
					//on ajoute la ligne complète au nouveau dataframe
					this.ajouteLigne(data, cpt);
					data.getColonne(0).getLabel();
				}
				cpt++;
			}
			return data;
		}
		else
		{
			//pas de colonne avec ce label, on renvoie vide
			return new Dataframe();
		}
	}
	
	
}
