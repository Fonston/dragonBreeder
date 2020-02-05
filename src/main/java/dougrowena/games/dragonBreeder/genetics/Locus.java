package dougrowena.games.dragonBreeder.genetics;

/**
 * Created by HP DX2400 Custom on 16/08/2016.
 */
public class Locus {

    private String name;
    private Class<? extends Gene> locus;

    public Locus(final Class<? extends Gene> locus,
                 final String name) {
        assert (locus != null) : 1;
        assert (name != null) : 2;

        this.locus = locus;
        this.name = name;
    }

    public Class<? extends Gene> getLocus() {
        return locus;
    }

    /**
     * Tells you whether or not a given gene fits as part of a sequence.
     * If the gene is null it is always false, if the gene is one of the
     * generic genes in the Gene class then it is true otherwise we test
     * whether or not the gene passed in is an instance of the Gene class
     * at this locus.
     * @param gene
     * @return
     */
    public boolean geneFits(final Gene gene) {

        if (gene == null) {
            return  false;
        } else if (gene == Gene.NEGATIVE_ALLELE) {
            return true;
        } else if (gene == Gene.NULL_ALLELE) {
            return true;
        } else if (gene == Gene.MISSING_ALLELE) {
            return true;
        } else {
            return locus.isInstance(gene);
        }

    }

    public String getName() {
        return name;
    }
}
