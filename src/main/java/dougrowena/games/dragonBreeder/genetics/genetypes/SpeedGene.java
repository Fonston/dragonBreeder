package dougrowena.games.dragonBreeder.genetics.genetypes;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class SpeedGene extends StatGene {

    public static final SpeedGene WEAK_POSITIVE_SPEED =
            new SpeedGene("WEAK_POSITIVE_SPEED", 1, 1, 0);
    public static final SpeedGene STRONG_POSITIVE_SPEED =
            new SpeedGene("STRONG_POSITIVE_SPEED", 2, 2, 1);
    public static final SpeedGene SPECIAL_SPEED =
            new SpeedGene("SPECIAL_SPEED", 3, 3, 1);

    public SpeedGene(final String name,
                     final int dominance,
                     final int statBoost,
                     final int recessiveStatBoost) {

        super(name, dominance, statBoost, recessiveStatBoost);
    }
}
