package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

/**
 * This type of Gene is associated with a stat.  It contains a
 * rating for how dominant (or recessive) it is, a stat for what
 * it contributes if it is dominant and a stat for what it
 * contributes if recessive
 *
 * Created by HP DX2400 Custom on 19/08/2016.
 */
public class StatGene extends Gene {

    // copies of the generic genes used just for internal
    // processing of generic non-stat genes.

    private static final StatGene NULL_ALLELE_STAT;
    private static final StatGene NEGATIVE_ALLELE_STAT;
    private static final StatGene MISSING_ALLELE_STAT;

    static {
        // Least significant gene
        NULL_ALLELE_STAT = new StatGene("NULL_ALLELE_STAT", 0,0,0);
        NULL_ALLELE_STAT.dominance = -3;

        MISSING_ALLELE_STAT = new StatGene("MISSING_ALLELE_STAT", 0, 0, 0);
        MISSING_ALLELE_STAT.dominance = -2;

        NEGATIVE_ALLELE_STAT = new StatGene("NEGATIVE_ALLELE_STAT", 0, -3, -1);
        NEGATIVE_ALLELE_STAT.dominance = -1;

    }

    protected int dominance;
    protected int statBoost;
    protected int recessiveStatBoost;

    public StatGene(final String name,
                    final int dominance,
                    final int statBoost,
                    final int recessiveStatBoost) {

        super(name);

        assert (dominance >= 0) : 1;

        this.dominance = dominance;
        this.statBoost = statBoost;
        this.recessiveStatBoost = recessiveStatBoost;

    }

    public int getDominance() {
        return dominance;
    }

    public int getStatBoost() {
        return statBoost;
    }

    public int getRecessiveStatBoost() {
        return recessiveStatBoost;
    }

    public static int determineStat(final Gene geneA,
                                    final Gene geneB) {

        // Check that there are no nulls
        assert (geneA != null) : 1;
        assert (geneB != null) : 2;

        // Convert any of the known generic genes into our own
        // internal StatGene versions of those genes (for the purposes of
        // simplifying the code).
        if (geneA == NULL_ALLELE) {
            return  determineStat(NULL_ALLELE_STAT, geneB);
        } else if (geneA == NEGATIVE_ALLELE) {
            return determineStat(NEGATIVE_ALLELE_STAT, geneB);
        } else if (geneA == MISSING_ALLELE) {
            return determineStat(MISSING_ALLELE_STAT, geneB);
        } else if (geneB == NULL_ALLELE) {
            return determineStat(geneA, NULL_ALLELE_STAT);
        } else if (geneB == NEGATIVE_ALLELE) {
            return determineStat(geneA, NEGATIVE_ALLELE_STAT);
        } else if (geneB == MISSING_ALLELE) {
            return determineStat(geneA, MISSING_ALLELE_STAT);
        }

        // Everything should be a stat gene at this point.
        // If there's a non-stat gene around then we want to know about it.
        assert (geneA instanceof StatGene) : 100;
        assert (geneB instanceof StatGene) : 101;

        StatGene statGeneA = (StatGene) geneA;
        StatGene statGeneB = (StatGene) geneB;

        // We're assuming that geneA is either dominant or
        // equally dominant when compared to geneB, if that
        // is not the case then we return the result with the
        // genes swapped the other way around.

        if (statGeneA.dominance < statGeneB.dominance) {
            return determineStat(geneB, geneA);
        }

        // Now that we've normalised the genes to stat genes and we've
        // got them in the right all we have to do is work out the
        // stats.

        return statGeneA.statBoost + statGeneB.recessiveStatBoost;

    }
}
