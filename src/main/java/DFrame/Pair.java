package DFrame;

public class Pair {

    private String clef;
    private int repet;

    public Pair(String _clef, int _repet)
    {
        this.clef = _clef;
        this.repet = _repet;
    }


    public int getRepet() {
        return repet;
    }

    public String getClef() {
        return clef;
    }
}
