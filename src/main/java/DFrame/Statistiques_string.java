package DFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistiques_string implements Statistiques{


    private Colonne<String> elems;
    private HashMap<String, Integer> elem_repete;
    private HashMap<String, Integer> pourcentage_elem;

    public Statistiques_string(Colonne<String> colonne)
    {
        this.elems = colonne;
        this.elem_repete = new HashMap<>();
        this.pourcentage_elem = new HashMap<>();
        remplitHashMap();
    }

    /**
     * Remplit un HashMap faisant la correspondance entre un élément et le nombre de fois qu'il apparaît
     */
    public void remplitHashMap()
    {
        for(String elem: this.elems.getColonne())
        {
            if(this.elem_repete.containsKey(elem))
            {
                //l'élément existe déjà, on augmente de 1 sa valeur
                this.elem_repete.put(elem, this.elem_repete.get(elem)+1);
            }
            else
            {
                //l'élément n'existe pas encore, on ajoute l'élément comme la clef et 1 ( présent 1 fois)
                this.elem_repete.put(elem, 1);
            }
        }
    }

    /**
     *
     * @return : une arrayList contenant le(s) tuple(s) qui est(sont) répété(s) le plus de fois
     */
    public ArrayList<Pair> plusGrossesRepetes()
    {
        Pair max = new Pair("", 0);
        ArrayList<Pair> resultat = new ArrayList<Pair>();

        for(Map.Entry clef: this.elem_repete.entrySet())
        {
            if((int) clef.getValue() > max.getRepet())
            {
                resultat = new ArrayList<Pair>();
                Pair new_max = new Pair(clef.getKey().toString(), (int) clef.getValue());
                resultat.add(new_max);
                max = new_max;
            }
            else if((int)clef.getValue() == max.getRepet())
            {
                Pair autre_max = new Pair(clef.getKey().toString(), (int) clef.getValue());
                resultat.add(autre_max);
            }
        }

        return resultat;
    }

    /**
     *
     * @return : la même colonne qu'en entrée mais sans les doublons s'il y en a
     */
    public Colonne<String> col_sansDoublon()
    {
        Colonne<String> resultat = new Colonne<>();
        for (Map.Entry tuple: this.elem_repete.entrySet())
        {
            resultat.addElem(tuple.getKey().toString());
        }
        return resultat;
    }

    /**
     * calcul le pourcentage de présence de chaque élément
     */
    @Override
    public void calculStats() {
        HashMap<String, Integer> pourcentage = new HashMap<String, Integer>();

        for(Map.Entry clef: this.elem_repete.entrySet())
        {
            int prct = (int)clef.getValue()*100/this.elems.colonneSize();
            pourcentage.put(clef.getKey().toString(), prct);
        }


        this.pourcentage_elem = pourcentage;
    }

    /**
     * affichage des stats une fois celle-ci calculées (pourcentages et l'élément le plus répété)
     */
    @Override
    public void afficheStats()
    {
        calculStats();
        //on affiche les pourcentages
        for(Map.Entry clef: this.pourcentage_elem.entrySet())
        {

            System.out.println("elem : "+clef.getKey()+ " => "+clef.getValue()+"%");
        }

        System.out.println("Eléments le(s) plus répété(s)");
        for (Pair res: plusGrossesRepetes())
        {
            System.out.println(res.getClef() +" => "+res.getRepet());
        }
    }
}
