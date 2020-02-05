package dougrowena.games.dragonBreeder.genetics.phenotype;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.FeathersGene;
import dougrowena.games.dragonBreeder.genetics.genetypes.WingsGene;

/**
 * Created by HP DX2400 Custom on 28/12/2016.
 */
public class WingsPhenotype {

    public static WingsPhenotype WINGS =
            new WingsPhenotype("WINGS");
    public static WingsPhenotype NO_WINGS =
            new WingsPhenotype("NO_WINGS");

    private String name;

    private WingsPhenotype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public static WingsPhenotype getWingsPhenotype(final Gene geneA,
                                                   final Gene geneB) {

        if (geneA == WingsGene.WINGS && geneB == WingsGene.WINGS) {
            return WINGS;
        }

        return NO_WINGS;
    }

}
