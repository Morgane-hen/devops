package DFrame;

import java.util.Locale;

public class StatistiquesNumber implements Statistiques{

    private Colonne<? extends Number> elems;
    private double moyenne;
    private enum type_donnees {INTEGER, FLOAT, DOUBLE};
    private type_donnees type;
    private double ecart_type;

    /**
     *
     * @param colonne : colonne possèdant les nombres que l'on veut étudier
     */
    public StatistiquesNumber(Colonne<? extends Number> colonne)
    {

        String classe = type_elem(colonne);

        //les éléments sont des nombres
        this.elems = colonne;
        this.type = type_donnees.valueOf(classe.toUpperCase());

    }

    /**
     *
     * @param colonne : colonne que l'on étudie
     * @return : string correspondant au type des éléments de la colonne
     */
    public String type_elem(Colonne<? extends Number> colonne)
    {
        String classe = "";

        if(colonne.getColonne().size() > 0)
        {
            //récupération du type des éléments
            classe = colonne.getColonne().get(0).getClass().getName();
        }
        String[] type = classe.split("\\.");
        return type[type.length-1];
    }

    public double getMoyenne() {
        return moyenne;
    }

    public double getEcart_type() {
        return ecart_type;
    }

    /**
     * calcule la moyenne de la colonne passée en paramètre (éléments de type int)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param integer : int servant de témoin pour appeler la méthode adéquate
     */
    public void setMoyenne(Colonne<Integer> elements, int integer)
    {
        int somme = 0;
        for (int elem: elements.getColonne()) {
            somme += elem;
        }
        this.moyenne = (double) somme / this.elems.getColonne().size();
    }

    /**
     * calcule la moyenne de la colonne passée en paramètre (éléments de type floats)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param floatteur : float servant de témoin pour appeler la méthode adéquate
     */
    public void setMoyenne(Colonne<Float> elements, float floatteur)
    {
        double somme = 0;
        for (float elem: elements.getColonne()) {
            somme += elem;
        }
        this.moyenne = somme / this.elems.colonneSize();
    }

    /**
     * calcule la moyenne de la colonne passée en paramètre (éléments de type doubles)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param doubleur : double servant de témoin pour appeler la méthode adéquate
     */
    public void setMoyenne(Colonne<Double> elements, double doubleur)
    {
        double somme = 0;
        for (double elem: elements.getColonne()) {
            somme += elem;
        }
        this.moyenne = somme / this.elems.colonneSize();
    }

    /**
     * calcule l'écart-type de la colonne passée en paramètre (éléments de type int)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param integer : double servant de témoin pour appeler la méthode adéquate
     */
    public void setEcartType(Colonne<Integer> elements, int integer)
    {
        double ecart = 0;
        for (int elem: elements.getColonne()) {
            ecart += Math.abs(this.moyenne - (double) elem);
        }
        this.ecart_type = (double) ecart /this.elems.colonneSize();
    }

    /**
     * calcule la l'écart-type de la colonne passée en paramètre (éléments de type floats)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param floatteur : float servant de témoin pour appeler la méthode adéquate
     */
    public void setEcartType(Colonne<Float> elements, float floatteur)
    {
        float ecart = 0;
        for (float elem: elements.getColonne()) {
            ecart += Math.abs(this.moyenne - elem);
            System.out.println("ecart : "+ecart);
        }
        this.ecart_type = ecart /this.elems.colonneSize();
    }

    /**
     * calcule l'écart-type de la colonne passée en paramètre (éléments de type doubles)
     * @param elements : éléments avec lesquels on fait la moyenne
     * @param doubleur : double servant de témoin pour appeler la méthode adéquate
     */
    public void setEcartType(Colonne<Double> elements, double doubleur)
    {
        double ecart = 0;
        for (double elem: elements.getColonne()) {
            ecart += Math.abs(this.moyenne - (double) elem);
        }
        this.ecart_type = ecart /this.elems.colonneSize();
    }

    /**
     * calcule la moyenne et l'écart-type de la colonne de this ( caste les éléments pour utiliser le type souhaité)
     */
    @Override
    public void calculStats()
    {
        switch(type)
        {
            case INTEGER:
                int temoin1 = 0;
                System.out.println(this.elems.getColonne().size());
                setMoyenne(transformeInt(), temoin1);
                setEcartType(transformeInt(), temoin1);
                break;

            case FLOAT:
                float temoin2 = 0;
                setMoyenne(transformeFloat(), temoin2);
                setEcartType(transformeFloat(), temoin2);
                break;

            case DOUBLE:
                double temoin3 = 0;
                setMoyenne(transformeDouble(), temoin3);
                setEcartType(transformeDouble(), temoin3);
                break;

            default:
                break;
        }

    }

    /**
     * affichage de la moyenne et de l'écart-type
     */
    @Override
    public void afficheStats()
    {
        calculStats();
        System.out.println();
        System.out.println("colonne "+this.elems.getLabel());
        System.out.println("    Moyenne => "+this.moyenne +"\n"+ "    Ecart Type => "+this.ecart_type);

    }

    /**
     *
     * @return : transformation des éléments de la colonne en int
     */
    public Colonne<Integer> transformeInt()
    {
        return (Colonne<Integer>) this.elems;
    }

    /**
     *
     * @return : transformation des éléments de la colonne en float
     */
    public Colonne<Float> transformeFloat()
    {
        return (Colonne<Float>) this.elems;
    }

    /**
     *
     * @return : transformation des éléments de la colonne en double
     */
    public Colonne<Double> transformeDouble()
    {
        return (Colonne<Double>) this.elems;
    }
}
