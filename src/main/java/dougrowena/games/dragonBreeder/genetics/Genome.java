package dougrowena.games.dragonBreeder.genetics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import com.google.protobuf.ProtocolStringList;
import dougrowena.games.dragonBreeder.protobuf.*;

/**
 * Created by HP DX2400 Custom on 16/08/2016.
 */
public class Genome {

    private static final Random random;
    public static final String CLASS_PACKAGE_PREFIX = "dougrowena.games.dragonBreeder.";

    static {
        random = new Random();
    }

    private LociSequence sequence;
    private ArrayList<Gene> geneSequenceA;
    private ArrayList<Gene> geneSequenceB;

    public Genome(final LociSequence sequence,
                  final ArrayList<Gene> geneSequenceA,
                  final ArrayList<Gene> geneSequenceB) {

        assert (sequence != null) : 1;
        assert (geneSequenceA != null) : 2;
        assert (geneSequenceB != null) : 3;

        if (!doesGeneSequenceMatchSequence(sequence, geneSequenceA)) {
            for(Gene gene : geneSequenceA) {
                if (gene != null) {
                    System.out.println(gene.getName());
                } else {
                    System.out.println("" + null);
                }
            }

            for(Locus locus : sequence.loci) {
                if (locus != null) {
                    System.out.println(locus.getName());
                }else {
                    System.out.println("" + null);
                }
            }
            assert (false) : 100;
        } else if (!doesGeneSequenceMatchSequence(sequence, geneSequenceB) ) {
            assert (false) : 101;
        }

        this.sequence = sequence;
        this.geneSequenceA = geneSequenceA;
        this.geneSequenceB = geneSequenceB;

    }

    /**
     * Creates a new gene sequence from the host's two gene sequences.
     *
     * @return
     */
    public ArrayList<Gene> produceChildGeneSequence() {

        ArrayList<Gene> childGeneSequence = new ArrayList<Gene>();

        for (int i = 0; i < geneSequenceA.size(); i++) {
            Gene geneA = geneSequenceA.get(i);
            Gene geneB = geneSequenceB.get(i);

            if (random.nextBoolean()) {
                childGeneSequence.add(geneA);
            } else {
                childGeneSequence.add(geneB);
            }
        }

        assert (doesGeneSequenceMatchSequence(
                sequence, childGeneSequence)) : 100;

        return childGeneSequence;
    }

    /**
     * Used to make sure that any gene sequence passed in to the Genome class's
     * constructor is valid for the LociSequence (stops the programmer or
     * person configuring the system from creating an invalid Genome).
     *
     * @param sequence
     * @param geneSequence
     * @return
     */
    public static boolean doesGeneSequenceMatchSequence(
            final LociSequence sequence,
            final ArrayList<Gene> geneSequence) {

        if (sequence == null || geneSequence == null ) {
            return false;
        } else if (sequence.loci == null ) {
            return false;
        } else if (sequence.loci.size() != geneSequence.size()) {
            return false;
        }

        for (int i = 0; i < sequence.loci.size(); i++) {
            Locus locus = sequence.loci.get(i);
            Gene gene = geneSequence.get(i);

            if (!locus.geneFits(gene)) {
                // We found a gene that doesn't fit in the sequence
                // this is not a match
                return false;
            }
        }

        return true;

    }

    /**
     * Returns the contents of the genome in an easy to read format.
     * @return
     */
    public String toString() {
        String s = "";

        final char[] POS = "     ".toCharArray(); // 5 spaces
        // 30 spaces
        final char[] LOC = "                              ".toCharArray();
        // 30 spaces
        final char[] GA = "                              ".toCharArray();
        // 30 spaces
        final char[] GB = "                              ".toCharArray();



        for (int i = 0; i < sequence.loci.size(); i++) {


            s = s + getToStringLine(i) + "\n";
        }

        return s;
    }

    public String getToStringLine(final int index) {
        String s = "";

        final char[] POS = "     ".toCharArray(); // 5 spaces
        // 30 spaces
        final char[] LOC = "                              ".toCharArray();
        // 30 spaces
        final char[] GA = "                              ".toCharArray();
        // 30 spaces
        final char[] GB = "                              ".toCharArray();

        char[] position = new char[POS.length];
        System.arraycopy(POS, 0, position, 0, POS.length);
        char[] location = new char[LOC.length];
        System.arraycopy(LOC, 0, location, 0, LOC.length);
        char[] geneA = new char[GA.length];
        System.arraycopy(GA, 0, geneA, 0, GA.length);
        char[] geneB = new char[GB.length];
        System.arraycopy(GB, 0, geneB, 0, GB.length);

        char[] tmp = ("" + index).toCharArray();
        System.arraycopy(tmp, 0, position, 0, tmp.length);
        s = s + new String(position);

        tmp = sequence.loci.get(index).getName().toCharArray();
        System.arraycopy(tmp, 0, location, 0, tmp.length);
        s = s + new String(location);

        tmp = geneSequenceA.get(index).getName().toCharArray();
        System.arraycopy(tmp, 0, geneA, 0, tmp.length);
        s = s + new String(geneA);

        tmp = geneSequenceB.get(index).getName().toCharArray();
        System.arraycopy(tmp, 0, geneB, 0, tmp.length);
        s = s + new String(geneB);

        return s;
    }

    public LociSequence getSequence() {
        return sequence;
    }

    /**
     * This method returns the gene from gene sequence A at a
     * specific place.
     * @param index
     * @return
     */
    public Gene getSequenceAGene(final int index) {
        return getGeneFromSequence(geneSequenceA, index);
    }

    /**
     * This method returns the gene from gene sequence B at a
     * specific place.
     * @param index
     * @return
     */
    public Gene getSequenceBGene(final int index) {
        return getGeneFromSequence(geneSequenceB, index);
    }

    /**
     * This method returns a gene from a specific index from a
     * specific gene sequence.
     *
     * @param sequence
     * @param index
     * @return
     */
    protected Gene getGeneFromSequence(final ArrayList<Gene> sequence,
                                       final int index) {

        assert (sequence != null) : 1;
        assert (index >= 0) : 2;
        assert (index < sequence.size()) : 3;

        return sequence.get(index);

    }

    public ArrayList<Gene> getGeneSequenceA() {
        return geneSequenceA;
    }

    public ArrayList<Gene> getGeneSequenceB() {
        return geneSequenceB;
    }

    public static GenomeMessage.Genome toProtoBuf(final Genome genome) {

        if (genome == null) {
            return null;
        }

        GenomeMessage.Genome.Builder genomeBuilder =
                GenomeMessage.Genome.newBuilder();

        ArrayList<Gene> sequenceA = genome.getGeneSequenceA();
        ArrayList<Gene> sequenceB = genome.getGeneSequenceB();

        for (int index = 0; index < sequenceA.size(); index++) {
            genomeBuilder.addGeneSequenceA(getStringFromGene(sequenceA.get(index)));
            genomeBuilder.addGeneSequenceB(getStringFromGene(sequenceB.get(index)));
        }

        return genomeBuilder.build();

    }

    public static Genome fromProtobuf(final GenomeMessage.Genome genome,
                                      final LociSequence sequence) {

        if (genome == null || sequence == null) {
            return null;
        }

        ProtocolStringList sequenceA = genome.getGeneSequenceAList();
        ProtocolStringList sequenceB = genome.getGeneSequenceBList();
        ArrayList<Gene> geneSequenceA = new ArrayList<>();
        ArrayList<Gene> geneSequenceB = new ArrayList<>();

        if (sequenceA.size() != sequenceB.size()) {
            return null;
        }

        for ( int index = 0; index < sequenceA.size(); index++) {
            String geneStringA = sequenceA.get(index);
            String geneStringB = sequenceB.get(index);

            Gene geneA = getGeneFromString(geneStringA);
            Gene geneB = getGeneFromString(geneStringB);

            geneSequenceA.add(geneA);
            geneSequenceB.add(geneB);
        }

        return new Genome(sequence, geneSequenceA, geneSequenceB);
    }

    /**
     * This utility method attempts to get a reference to a static field
     * representing a Gene object from a class by decoding a string
     * representation of it.  To this end the part of the string preceding the
     * last dot is treated as the name of the class and the part afterwards
     * represents the name of the field within that class being referenced.
     *
     * In the event that the class of the enclosing Gene cannot be referenced
     * using that first half of the string directly then a known prefix is
     * appended to the class.  This permits the string representation of the
     * field to be shortened by not having to include unnecessarily a lengthy
     * package path.
     *
     * @return A Gene object referenced by the string parameter.
     */
    public static final Gene getGeneFromString(final String field) {

        // Check the field is non null and that there's an appropriate
        // delimiter present
        if (field == null || field.lastIndexOf('.') < 0) {
            return null;
        }

        int index = field.lastIndexOf('.');
        String className = field.substring(0, index);
        String fieldName = field.substring(index + 1);
        try {
            Class realClass = Class.forName(className);
            Field fieldObj = realClass.getField(fieldName);
            Object tmpObj = fieldObj.get(null); // get this static constant
            Gene gene = (Gene) tmpObj;
            return gene;

        } catch (Exception e) {
            // Failed to get the field using the regular class name, let's try
            // to get it if we prefix with a known package prefix.
            System.out.println();

            try {
                String newClassName = CLASS_PACKAGE_PREFIX + className;
                Class realClass = Class.forName(newClassName);
                Field fieldObj = realClass.getField(fieldName);
                Object tmpObj = fieldObj.get(null); // get this static constant
                Gene gene = (Gene) tmpObj;
                return gene;
            } catch (Exception ex) {
                // All out of ideas
                return null;
            }
        }

    }

    /**
     * This method converts a gene object into a string suitable for recording
     * as part of a protobuf.
     *
     * @param gene The gene to convert, should not be null if avoidable
     * @return a string representing the gene or null if the gene was null.
     */
    public static String getStringFromGene(final Gene gene) {

        if (gene == null) {
            return null;
        }

        String name = gene.getName();
        String geneClass = gene.getClass().getName();
        String string = geneClass + "." + name;

        if (string.startsWith(CLASS_PACKAGE_PREFIX)) {
            string = string.replace(CLASS_PACKAGE_PREFIX, "");
        }

        return string;
    }


}
