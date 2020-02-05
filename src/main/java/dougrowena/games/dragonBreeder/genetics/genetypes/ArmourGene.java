package dougrowena.games.dragonBreeder.genetics.genetypes;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class ArmourGene extends StatGene {

    public static final ArmourGene WEAK_POSITIVE_ARMOUR =
            new ArmourGene("WEAK_POSITIVE_ARMOUR", 1, 1, 0);
    public static final ArmourGene STRONG_POSITIVE_ARMOUR =
            new ArmourGene("STRONG_POSITIVE_ARMOUR", 2, 2, 1);
    public static final ArmourGene SPECIAL_POSITIVE_ARMOUR =
            new ArmourGene("SPECIAL_POSITIVE_ARMOUR", 3, 3, 1);

    public ArmourGene(final String name,
                      final int dominance,
                      final int statBoost,
                      final int recessiveStatBoost) {

        super(name, dominance, statBoost, recessiveStatBoost);
    }


}
