package dougrowena.games.dragonBreeder.genetics.genetypes;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class IntelligenceGene extends StatGene {

    public static final IntelligenceGene WEAK_POSITIVE_INTELLIGENCE =
            new IntelligenceGene("WEAK_POSITIVE_INTELLIGENCE", 1, 1, 0);
    public static final IntelligenceGene STRONG_POSITIVE_INTELLIGENCE =
            new IntelligenceGene("STRONG_POSITIVE_INTELLIGENCE", 2, 2, 1);
    public static final IntelligenceGene DIPLODYTE_INTELLIGENCE =
            new IntelligenceGene("DIPLODYTE_INTELLIGENCE", 3, 3, 1);
    public static final IntelligenceGene ARCODYTE_INTELLIGENCE =
            new IntelligenceGene("ARCODYTE_INTELLIGENCE", 4, 4, 1);


    public IntelligenceGene(final String name,
                            final int dominance,
                            final int statBoost,
                            final int recessiveStatBoost) {

        super(name, dominance, statBoost, recessiveStatBoost);
    }
}
