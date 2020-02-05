package dougrowena.games.dragonBreeder.genetics;

/**
 * Created by HP DX2400 Custom on 16/08/2016.
 */
public class Gene {

    public static final Gene NULL_ALLELE = new Gene("NULL_ALLELE");
    public static final Gene NEGATIVE_ALLELE = new Gene("NEGATIVE_ALLELE");
    public static final Gene MISSING_ALLELE = new Gene("MISSING_ALLELE");

    protected String name;

    public Gene(final String name) {

        assert name != null;

        this.name = name;
    }

    public String getName() {
        return name;
    }

}
