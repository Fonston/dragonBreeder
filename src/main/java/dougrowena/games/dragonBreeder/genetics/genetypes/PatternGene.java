package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class PatternGene extends Gene {

    public static final PatternGene PLAIN = new PatternGene("PLAIN");
    public static final PatternGene SPOTS = new PatternGene("SPOTS");
    public static final PatternGene STRIPES = new PatternGene("STRIPES");
    public static final PatternGene DARK_POINTS = new PatternGene("DARK POINTS");

    public static final PatternGene[] KNOWN_PATTERNS =
            new PatternGene[] {
                    PLAIN,
                    SPOTS,
                    STRIPES,
                    DARK_POINTS
            };

    public static final Gene[] POSSIBLE_GENES =
            new Gene[] {
                    PLAIN,
                    SPOTS,
                    STRIPES,
                    DARK_POINTS,
                    NULL_ALLELE,
                    NEGATIVE_ALLELE,
                    MISSING_ALLELE
            };


    public PatternGene(String name) {
        super(name);
    }

    public String toString() {
        return name;
    }

    public static PatternGene getPhenotypicalGene(final Gene geneA,
                                                  final Gene geneB) {
        PatternGene patternGeneA;
        PatternGene patternGeneB;

        if (geneA instanceof PatternGene) {
            patternGeneA = (PatternGene) geneA;
        } else {
            if (    geneA == NULL_ALLELE ||
                    geneA == NEGATIVE_ALLELE ||
                    geneA == MISSING_ALLELE) {
                patternGeneA = PLAIN;
            } else {
                patternGeneA = null;
                assert (false) : 100;
            }
        }

        if (geneB instanceof PatternGene) {
            patternGeneB = (PatternGene) geneB;
        } else {
            if (    geneB == NULL_ALLELE ||
                    geneB == NEGATIVE_ALLELE ||
                    geneB == MISSING_ALLELE) {
                patternGeneB = PLAIN;
            } else {
                patternGeneB = null;
                assert (false) : 100;
            }
        }

        return getPhenotypicalGeneInternal(patternGeneA, patternGeneB);

    }

    private static PatternGene getPhenotypicalGeneInternal(
            final PatternGene geneA,
            final PatternGene geneB
    ) {

        if (geneA == DARK_POINTS || geneB == DARK_POINTS) {
            return DARK_POINTS;
        }

        if (geneA == SPOTS || geneB == SPOTS) {
            return SPOTS;
        }

        if (geneA == STRIPES || geneB == STRIPES) {
            return STRIPES;
        }

        return PLAIN;

    }


}
