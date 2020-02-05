package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.LociSequence;
import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.Genome;
import dougrowena.games.dragonBreeder.genetics.Locus;
import dougrowena.games.dragonBreeder.protobuf.DragonGenomeMessage;
import dougrowena.games.dragonBreeder.protobuf.GenomeMessage;

import java.util.ArrayList;

/**
 * Created by HP DX2400 Custom on 20/08/2016.
 */
public class DragonGenome extends Genome {
    public static final LociSequence DRAGON_SEQUENCE =
            new LociSequence();
    public static final int SEQUENCE_LENGTH;

    // Description genes
    public static final int BODY_PLAN_INDEX = 0;
    public static final int BODY_COLOUR_1_INDEX = 1;
    public static final int PATTERN_COLOUR_1_INDEX = 2;
    public static final int WINGS_INDEX = 3;
    public static final int FEATHERS_INDEX = 4;
    public static final int PATTERN_INDEX = 5;

    // Stat genes
    public static final int STRENGTH_1_INDEX = 6;
    public static final int STRENGTH_2_INDEX = 7;
    public static final int STRENGTH_3_INDEX = 8;

    public static final int SPEED_1_INDEX = 9;
    public static final int SPEED_2_INDEX = 10;
    public static final int SPEED_3_INDEX = 11;

    public static final int STAMINA_1_INDEX = 12;
    public static final int STAMINA_2_INDEX = 13;
    public static final int STAMINA_3_INDEX = 14;

    public static final int INTELLIGENCE_1_INDEX = 15;
    public static final int INTELLIGENCE_2_INDEX = 16;
    public static final int INTELLIGENCE_3_INDEX = 17;

    public static final int ARMOUR_1_INDEX = 18;
    public static final int ARMOUR_2_INDEX = 19;
    public static final int ARMOUR_3_INDEX = 20;

    static {
        // Non-stat genes
        DRAGON_SEQUENCE.loci.add(new Locus(BodyPlanGene.class, "BodyPlan"));
        DRAGON_SEQUENCE.loci.add(new Locus(BaseColourGene.class, "Body Colour 1"));
        DRAGON_SEQUENCE.loci.add(new Locus(StripeColourGene.class, "Pattern Colour 1"));
        DRAGON_SEQUENCE.loci.add(new Locus(WingsGene.class, "Wings"));
        DRAGON_SEQUENCE.loci.add(new Locus(FeathersGene.class, "Feathers"));
        DRAGON_SEQUENCE.loci.add(new Locus(PatternGene.class, "Pattern"));

        // Stat genes - Strength
        DRAGON_SEQUENCE.loci.add(
                new Locus(StrengthGene.class, "Basal Strength"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(StrengthGene.class, "Advanced Strength"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(StrengthGene.class, "Elite Strength"));

        // Stat genes - Speed
        DRAGON_SEQUENCE.loci.add(
                new Locus(SpeedGene.class, "Basal Speed"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(SpeedGene.class, "Advanced Speed"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(SpeedGene.class, "Elite Speed"));

        // Stat genes - Stamina
        DRAGON_SEQUENCE.loci.add(
                new Locus(StaminaGene.class, "Basal Stamina"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(StaminaGene.class, "Advanced Stamina"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(StaminaGene.class, "Elite Stamina"));

        // Stat genes - Intelligence
        DRAGON_SEQUENCE.loci.add(
                new Locus(IntelligenceGene.class, "Basal Intelligence"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(IntelligenceGene.class, "Advanced Intelligence"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(IntelligenceGene.class, "Elite Intelligence"));

        // Stat genes - Armour
        DRAGON_SEQUENCE.loci.add(
                new Locus(ArmourGene.class, "Basal Armour"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(ArmourGene.class, "Advanced Armour"));
        DRAGON_SEQUENCE.loci.add(
                new Locus(ArmourGene.class, "Elite Armour"));

        SEQUENCE_LENGTH = DRAGON_SEQUENCE.loci.size();

    }

    public DragonGenome(ArrayList<Gene> geneSequenceA, ArrayList<Gene> geneSequenceB) {
        super(DRAGON_SEQUENCE, geneSequenceA, geneSequenceB);
    }

    public static boolean isStrengthLocus(int index) {
        if (index == STRENGTH_1_INDEX) {
            return true;
        } else if (index == STRENGTH_2_INDEX) {
            return true;
        } else if (index == STRENGTH_3_INDEX) {
            return true;
        }

        return false;
    }

    public static boolean isSpeedLocus(int index) {
        if (index == SPEED_1_INDEX) {
            return true;
        } else if (index == SPEED_2_INDEX) {
            return true;
        } else if (index == SPEED_3_INDEX) {
            return true;
        }

        return false;
    }

    public static boolean isStaminaLocus(int index) {
        if (index == STAMINA_1_INDEX) {
            return true;
        } else if (index == STAMINA_2_INDEX) {
            return true;
        } else if (index == STAMINA_3_INDEX) {
            return true;
        }

        return false;
    }

    public static boolean isIntelligenceLocus(int index) {
        if (index == INTELLIGENCE_1_INDEX) {
            return true;
        } else if (index == INTELLIGENCE_2_INDEX) {
            return true;
        } else if (index == INTELLIGENCE_3_INDEX) {
            return true;
        }

        return false;
    }

    public static boolean isArmourLocus(int index) {
        if (index == ARMOUR_1_INDEX) {
            return true;
        } else if (index == ARMOUR_2_INDEX) {
            return true;
        } else if (index == ARMOUR_3_INDEX) {
            return true;
        }

        return false;
    }

    /**
     * Builds a DragonGenome protobuf from a regular dragon genome object.
     * Largely uses the underlying Genome utility method.
     * @param genome
     * @return
     */
    public static DragonGenomeMessage.DragonGenome toProtobuf(
            final DragonGenome genome) {

        if (genome == null) {
            return null;
        }

        GenomeMessage.Genome baseGenome = Genome.toProtoBuf(genome);
        DragonGenomeMessage.DragonGenome.Builder builder =
                DragonGenomeMessage.DragonGenome.newBuilder();

        builder.setGenome(baseGenome);

        return builder.build();
    }

    /**
     * Reconstructs a DragonGenome object from a protobuf, largely uses the
     * utility method in the Genome class but uses the DRAGON_SEQUENCE for the
     * loci sequence in the conversion.
     * @param genome
     * @return
     */
    public static DragonGenome fromProtobuf(
            final DragonGenomeMessage.DragonGenome genome) {

        if (genome == null) {
            return null;
        }

        Genome baseGenome = Genome.fromProtobuf(
                genome.getGenome(),
                DRAGON_SEQUENCE);

        ArrayList<Gene> geneSequenceA = baseGenome.getGeneSequenceA();
        ArrayList<Gene> geneSequenceB = baseGenome.getGeneSequenceB();

        return new DragonGenome(geneSequenceA, geneSequenceB);
    }

}
