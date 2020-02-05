package dougrowena.games.dragonBreeder.genetics.phenotype;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.FeathersGene;
import dougrowena.games.dragonBreeder.protobuf.GenderEnum;

/**
 * Created by HP DX2400 Custom on 28/12/2016.
 */
public class FeathersPhenotype {

    public static FeathersPhenotype FEATHERS =
            new FeathersPhenotype("FEATHERS");
    public static FeathersPhenotype NO_FEATHERS =
            new FeathersPhenotype("NO_FEATHERS");

    private String name;

    private FeathersPhenotype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public static FeathersPhenotype getFeathersPhenotype(final Gene geneA,
                                                         final Gene geneB) {

        if (geneA == FeathersGene.FEATHERS && geneB == FeathersGene.FEATHERS) {
            return FEATHERS;
        }

        return NO_FEATHERS;
    }

}
