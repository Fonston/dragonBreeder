package dougrowena.games.dragonBreeder.genetics;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class BreederTest {

    @Test
    public void testBreed() {

        Breeder breeder = new Breeder();


        LociSequence lociSequence = new LociSequence();
        Locus locus1 = new Locus(Gene.class, "locus1");
        Locus locus2 = new Locus(Gene.class, "locus2");
        Locus locus3 = new Locus(Gene.class, "locus3");

        lociSequence.loci.add(locus1);
        lociSequence.loci.add(locus2);
        lociSequence.loci.add(locus3);

        ArrayList<Gene> geneSequenceA = new ArrayList<Gene>();
        geneSequenceA.add(Gene.NULL_ALLELE);
        geneSequenceA.add(Gene.NULL_ALLELE);
        geneSequenceA.add(Gene.MISSING_ALLELE);

        ArrayList<Gene> geneSequenceB = new ArrayList<Gene>();
        geneSequenceB.add(Gene.NEGATIVE_ALLELE);
        geneSequenceB.add(Gene.NULL_ALLELE);
        geneSequenceB.add(Gene.MISSING_ALLELE);

        ArrayList<Gene> geneSequenceC = new ArrayList<Gene>();
        geneSequenceC.add(Gene.NEGATIVE_ALLELE);
        geneSequenceC.add(Gene.MISSING_ALLELE);
        geneSequenceC.add(Gene.NULL_ALLELE);

        ArrayList<Gene> geneSequenceD = new ArrayList<Gene>();
        geneSequenceD.add(Gene.NULL_ALLELE);
        geneSequenceD.add(Gene.MISSING_ALLELE);
        geneSequenceD.add(Gene.NULL_ALLELE);

        Genome testGenome1 = new Genome(
                lociSequence,
                geneSequenceA,
                geneSequenceB);

        Genome testGenome2 = new Genome(
                lociSequence,
                geneSequenceC,
                geneSequenceD
        );

        Genome childGeneome = breeder.breed(testGenome1, testGenome2);

        System.out.println();
        System.out.println(childGeneome.toString());

    }
}
