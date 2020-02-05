package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class FeathersGene extends Gene {

    public static final FeathersGene FEATHERS =
            new FeathersGene("WINGS");

    public static final Gene[] KNOWN_FEATHERS =
            new Gene[] {
                    FEATHERS,
                    NULL_ALLELE
            };

    public FeathersGene(String name) {
        super(name);
    }

    public String toString() {
        return name;
    }
}
