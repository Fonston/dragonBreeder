package dougrowena.games.dragonBreeder.genetics.genetypes;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class StrengthGene extends StatGene {

    public static final StrengthGene WEAK_POSITIVE_STRENGTH =
            new StrengthGene("WEAK_POSITIVE_STRENGTH", 1, 1, 0);
    public static final StrengthGene STRONG_POSITIVE_STRENGTH =
            new StrengthGene("STRONG_POSITIVE_STRENGTH", 2, 2, 1);
    public static final StrengthGene KOMODYTE_STRENGTH =
            new StrengthGene("KOMODYTE_STRENGTH", 3, 3, 1);

    public StrengthGene(final String name,
                        final int dominance,
                        final int statBoost,
                        final int recessiveStatBoost) {

        super(name, dominance, statBoost, recessiveStatBoost);
    }
}
