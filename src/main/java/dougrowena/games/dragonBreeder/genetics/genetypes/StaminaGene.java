package dougrowena.games.dragonBreeder.genetics.genetypes;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class StaminaGene extends StatGene {

    public static final StaminaGene WEAK_POSITIVE_STAMINA =
            new StaminaGene("WEAK_POSITIVE_STAMINA", 1, 1, 0);
    public static final StaminaGene STRONG_POSITIVE_STAMINA =
            new StaminaGene("STRONG_POSITIVE_STAMINA", 2, 2, 1);
    public static final StaminaGene IGUADYTE_STAMINA =
            new StaminaGene("IGUADYTE_STAMINA", 3, 3, 1);

    public StaminaGene(final String name,
                       final int dominance,
                       final int statBoost,
                       final int recessiveStatBoost) {

        super(name,dominance,statBoost,recessiveStatBoost);
    }
}
