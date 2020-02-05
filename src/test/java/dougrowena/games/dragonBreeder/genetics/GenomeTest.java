package dougrowena.games.dragonBreeder.genetics;

import dougrowena.games.dragonBreeder.dragon.Gender;
import dougrowena.games.dragonBreeder.protobuf.GenomeMessage;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by HP DX2400 Custom on 17/08/2016.
 */
public class GenomeTest {

    @Test
    public void testToString() {

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

        Genome testGenome = new Genome(
                lociSequence,
                geneSequenceA,
                geneSequenceB);

        String s = testGenome.toString();

        System.out.println();
        System.out.println(s);
    }

    @Test
    public void testProduceChildGeneSequence() {

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

        Genome testGenome = new Genome(
                lociSequence,
                geneSequenceA,
                geneSequenceB);

        ArrayList<Gene> childSequence1 = testGenome.produceChildGeneSequence();
        ArrayList<Gene> childSequence2 = testGenome.produceChildGeneSequence();

        Genome weirdKid = new Genome(lociSequence, childSequence1, childSequence2);

        String s = weirdKid.toString();

        System.out.println();
        System.out.println(s);


    }

    @Test
    public void protobufConversionTest() {

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

        Genome testGenome = new Genome(
                lociSequence,
                geneSequenceA,
                geneSequenceB);

        String s = testGenome.toString();

        System.out.println();
        System.out.println(s);

        GenomeMessage.Genome testGenomeProtobuf = Genome.toProtoBuf(testGenome);
        System.out.println(testGenomeProtobuf);

        Genome testGenome2 = Genome.fromProtobuf(testGenomeProtobuf, lociSequence);
        String s2 = testGenome2.toString();

        System.out.println(s2);
    }
}
