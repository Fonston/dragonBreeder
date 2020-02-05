package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class BodyPlanGene extends Gene {

    public static final BodyPlanGene KOMODYTE =
            new BodyPlanGene("KOMODYTE");
    public static final BodyPlanGene TERADYTE =
            new BodyPlanGene("TERADYTE");
    public static final BodyPlanGene PYTHODYTE =
            new BodyPlanGene("PYTHODYTE");
    public static final BodyPlanGene CROCODYTE =
            new BodyPlanGene("CROCODYTE");
    public static final BodyPlanGene ARCODYTE =
            new BodyPlanGene("ARCODYTE");
    public static final BodyPlanGene IGUADYTE =
            new BodyPlanGene("IGUADYTE");
    public static final BodyPlanGene RAPODYTE =
            new BodyPlanGene("RAPODYTE");
    public static final BodyPlanGene GEKKODYTE =
            new BodyPlanGene("GEKKODYTE");

    public static final BodyPlanGene[] KNOWN_BODY_PLANS =
            new BodyPlanGene[] {
                    KOMODYTE,
                    TERADYTE,
                    PYTHODYTE,
                    CROCODYTE,
                    ARCODYTE,
                    IGUADYTE,
                    RAPODYTE,
                    GEKKODYTE
            };

    public static final Gene[] POSSIBLE_BODY_PLANS =
            new Gene[] {
                    KOMODYTE,
                    TERADYTE,
                    PYTHODYTE,
                    CROCODYTE,
                    ARCODYTE,
                    IGUADYTE,
                    RAPODYTE,
                    GEKKODYTE,
                    NULL_ALLELE,
                    NEGATIVE_ALLELE,
                    MISSING_ALLELE
            };

    public BodyPlanGene(String name) {
        super(name);
    }

    public String toString() {
        return name;
    }

    public static BodyPlanGene getPhenotypicalGene(final Gene geneA,
                                                   final Gene geneB) {

        BodyPlanGene bodyPlanGeneA;
        BodyPlanGene bodyPlanGeneB;

        if (geneA instanceof BodyPlanGene) {
            bodyPlanGeneA = (BodyPlanGene) geneA;
        } else {
            if (    geneA == NULL_ALLELE ||
                    geneA == NEGATIVE_ALLELE ||
                    geneA == MISSING_ALLELE) {
                bodyPlanGeneA = GEKKODYTE;
            } else {
                bodyPlanGeneA = null;
                assert (false) : 100;
            }
        }

        if (geneB instanceof BodyPlanGene) {
            bodyPlanGeneB = (BodyPlanGene) geneB;
        } else {
            if (    geneB == NULL_ALLELE ||
                    geneB == NEGATIVE_ALLELE ||
                    geneB == MISSING_ALLELE) {
                bodyPlanGeneB = GEKKODYTE;
            } else {
                bodyPlanGeneB = null;
                assert (false) : 100;
            }
        }

        return getPhenotypicalGeneInternal(bodyPlanGeneA, bodyPlanGeneB);
    }

    private static BodyPlanGene getPhenotypicalGeneInternal(
            final BodyPlanGene geneA,
            final BodyPlanGene geneB) {

        if (geneA == KOMODYTE || geneB == KOMODYTE) {
            return KOMODYTE;
        }

        if (geneA == TERADYTE || geneB == TERADYTE) {
            return TERADYTE;
        }

        if (geneA == PYTHODYTE || geneB == PYTHODYTE) {
            return PYTHODYTE;
        }

        if (geneA == CROCODYTE || geneB == CROCODYTE) {
            return CROCODYTE;
        }

        if (geneA == ARCODYTE || geneB == ARCODYTE) {
            return ARCODYTE;
        }

        if (geneA == IGUADYTE || geneB == IGUADYTE) {
            return IGUADYTE;
        }

        if (geneA == RAPODYTE || geneB == RAPODYTE) {
            return RAPODYTE;
        }

        return GEKKODYTE;

    }
}
