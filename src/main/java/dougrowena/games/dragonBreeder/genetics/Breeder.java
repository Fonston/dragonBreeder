package dougrowena.games.dragonBreeder.genetics;

/**
 * Created by HP DX2400 Custom on 16/08/2016.
 */
public class Breeder {

    public static Genome breed(final Genome parentA,
                        final Genome parentB) {

        return new Genome(
                parentA.getSequence(),
                parentA.produceChildGeneSequence(),
                parentB.produceChildGeneSequence());
    }
}
