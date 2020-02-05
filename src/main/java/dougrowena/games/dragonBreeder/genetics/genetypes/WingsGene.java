package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class WingsGene extends Gene {

    public static final WingsGene WINGS =
            new WingsGene("WINGS");

    public static final Gene[] KNOWN_WINGS =
            new Gene[]{
                    WINGS,
                    NULL_ALLELE
            };

    public WingsGene(String name) {
        super(name);
    }

    public String toString() {
        return name;
    }
}
