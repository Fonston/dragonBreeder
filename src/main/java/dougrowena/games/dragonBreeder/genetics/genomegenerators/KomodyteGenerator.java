package dougrowena.games.dragonBreeder.genetics.genomegenerators;

import dougrowena.games.dragonBreeder.dragon.Age;
import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.dragon.DragonGenomeStats;
import dougrowena.games.dragonBreeder.dragon.Gender;
import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.*;

import java.util.ArrayList;

/**
 * Created by HP DX2400 Custom on 21/08/2016.
 */
public class KomodyteGenerator extends GenomeGenerator {

    public static final DragonGenome TYPICAL_KOMODYTE;

    public static final Dragon REX;
    public static final Dragon RUBY;

    static {
        ArrayList<Gene> geneStrand1 = new ArrayList<Gene>();
        geneStrand1.add(BodyPlanGene.KOMODYTE);
        geneStrand1.add(BaseColourGene.BROWN);
        geneStrand1.add(StripeColourGene.BROWN_STRIPES);
        geneStrand1.add(Gene.NULL_ALLELE);
        geneStrand1.add(Gene.NULL_ALLELE);
        geneStrand1.add(PatternGene.PLAIN);
        geneStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        geneStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        geneStrand1.add(StrengthGene.KOMODYTE_STRENGTH);
        geneStrand1.add(SpeedGene.STRONG_POSITIVE_SPEED);
        geneStrand1.add(Gene.MISSING_ALLELE);
        geneStrand1.add(Gene.MISSING_ALLELE);
        geneStrand1.add(StaminaGene.STRONG_POSITIVE_STAMINA);
        geneStrand1.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        geneStrand1.add(Gene.MISSING_ALLELE);
        geneStrand1.add(IntelligenceGene.STRONG_POSITIVE_INTELLIGENCE);
        geneStrand1.add(Gene.MISSING_ALLELE);
        geneStrand1.add(Gene.MISSING_ALLELE);
        geneStrand1.add(ArmourGene.STRONG_POSITIVE_ARMOUR);
        geneStrand1.add(ArmourGene.WEAK_POSITIVE_ARMOUR);
        geneStrand1.add(Gene.MISSING_ALLELE);

        ArrayList<Gene> geneStrand2 = new ArrayList<Gene>();
        geneStrand2.add(BodyPlanGene.KOMODYTE);
        geneStrand2.add(BaseColourGene.BROWN);
        geneStrand2.add(StripeColourGene.BROWN_STRIPES);
        geneStrand2.add(Gene.NULL_ALLELE);
        geneStrand2.add(Gene.NULL_ALLELE);
        geneStrand2.add(PatternGene.PLAIN);
        geneStrand2.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        geneStrand2.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        geneStrand2.add(StrengthGene.KOMODYTE_STRENGTH);
        geneStrand2.add(SpeedGene.WEAK_POSITIVE_SPEED);
        geneStrand2.add(Gene.MISSING_ALLELE);
        geneStrand2.add(Gene.MISSING_ALLELE);
        geneStrand2.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        geneStrand2.add(Gene.NULL_ALLELE);
        geneStrand2.add(Gene.MISSING_ALLELE);
        geneStrand2.add(IntelligenceGene.WEAK_POSITIVE_INTELLIGENCE);
        geneStrand2.add(Gene.MISSING_ALLELE);
        geneStrand2.add(Gene.MISSING_ALLELE);
        geneStrand2.add(ArmourGene.WEAK_POSITIVE_ARMOUR);
        geneStrand2.add(ArmourGene.WEAK_POSITIVE_ARMOUR);
        geneStrand2.add(Gene.MISSING_ALLELE);


        TYPICAL_KOMODYTE = new DragonGenome(
                geneStrand1,
                geneStrand2);

        ArrayList<Gene> rexStrand1 = new ArrayList<Gene>();
        rexStrand1.add(BodyPlanGene.KOMODYTE);
        rexStrand1.add(BaseColourGene.BROWN);
        rexStrand1.add(StripeColourGene.BROWN_STRIPES);
        rexStrand1.add(Gene.NULL_ALLELE);
        rexStrand1.add(Gene.NULL_ALLELE);
        rexStrand1.add(PatternGene.DARK_POINTS);
        rexStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        rexStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        rexStrand1.add(StrengthGene.KOMODYTE_STRENGTH);
        rexStrand1.add(SpeedGene.STRONG_POSITIVE_SPEED);
        rexStrand1.add(Gene.MISSING_ALLELE);
        rexStrand1.add(Gene.MISSING_ALLELE);
        rexStrand1.add(StaminaGene.STRONG_POSITIVE_STAMINA);
        rexStrand1.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        rexStrand1.add(Gene.MISSING_ALLELE);
        rexStrand1.add(IntelligenceGene.STRONG_POSITIVE_INTELLIGENCE);
        rexStrand1.add(Gene.MISSING_ALLELE);
        rexStrand1.add(Gene.MISSING_ALLELE);
        rexStrand1.add(ArmourGene.STRONG_POSITIVE_ARMOUR);
        rexStrand1.add(ArmourGene.WEAK_POSITIVE_ARMOUR);
        rexStrand1.add(Gene.MISSING_ALLELE);

        ArrayList<Gene> rexStrand2 = new ArrayList<Gene>();
        rexStrand2.add(BodyPlanGene.KOMODYTE);
        rexStrand2.add(BaseColourGene.GREY);
        rexStrand2.add(StripeColourGene.GREY_STRIPES);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(PatternGene.PLAIN);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(StrengthGene.STRONG_POSITIVE_STRENGTH);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(SpeedGene.STRONG_POSITIVE_SPEED);
        rexStrand2.add(Gene.MISSING_ALLELE);
        rexStrand2.add(Gene.MISSING_ALLELE);
        rexStrand2.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(Gene.MISSING_ALLELE);
        rexStrand2.add(IntelligenceGene.WEAK_POSITIVE_INTELLIGENCE);
        rexStrand2.add(Gene.MISSING_ALLELE);
        rexStrand2.add(Gene.MISSING_ALLELE);
        rexStrand2.add(Gene.NULL_ALLELE);
        rexStrand2.add(ArmourGene.STRONG_POSITIVE_ARMOUR);
        rexStrand2.add(Gene.MISSING_ALLELE);

        DragonGenome rexGenome = new DragonGenome(rexStrand1, rexStrand2);
        REX = new Dragon(
                new DragonGenomeStats(rexGenome),
                "REX",
                Gender.MALE,
                Age.ADULT);


        ArrayList<Gene> rubyStrand1 = new ArrayList<Gene>();
        rubyStrand1.add(BodyPlanGene.KOMODYTE);
        rubyStrand1.add(BaseColourGene.SLATE);
        rubyStrand1.add(StripeColourGene.SLATE_STRIPES);
        rubyStrand1.add(Gene.NULL_ALLELE);
        rubyStrand1.add(Gene.NULL_ALLELE);
        rubyStrand1.add(PatternGene.STRIPES);
        rubyStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        rubyStrand1.add(StrengthGene.WEAK_POSITIVE_STRENGTH);
        rubyStrand1.add(StrengthGene.STRONG_POSITIVE_STRENGTH);
        rubyStrand1.add(SpeedGene.STRONG_POSITIVE_SPEED);
        rubyStrand1.add(Gene.MISSING_ALLELE);
        rubyStrand1.add(Gene.MISSING_ALLELE);
        rubyStrand1.add(StaminaGene.STRONG_POSITIVE_STAMINA);
        rubyStrand1.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        rubyStrand1.add(Gene.MISSING_ALLELE);
        rubyStrand1.add(IntelligenceGene.STRONG_POSITIVE_INTELLIGENCE);
        rubyStrand1.add(Gene.MISSING_ALLELE);
        rubyStrand1.add(Gene.MISSING_ALLELE);
        rubyStrand1.add(ArmourGene.STRONG_POSITIVE_ARMOUR);
        rubyStrand1.add(ArmourGene.WEAK_POSITIVE_ARMOUR);
        rubyStrand1.add(Gene.MISSING_ALLELE);

        ArrayList<Gene> rubyStrand2 = new ArrayList<Gene>();
        rubyStrand2.add(BodyPlanGene.KOMODYTE);
        rubyStrand2.add(BaseColourGene.GREY);
        rubyStrand2.add(StripeColourGene.GREY_STRIPES);
        rubyStrand2.add(Gene.NULL_ALLELE);
        rubyStrand2.add(Gene.NULL_ALLELE);
        rubyStrand2.add(PatternGene.PLAIN);
        rubyStrand2.add(Gene.NULL_ALLELE);
        rubyStrand2.add(StrengthGene.STRONG_POSITIVE_STRENGTH);
        rubyStrand2.add(StrengthGene.STRONG_POSITIVE_STRENGTH);
        rubyStrand2.add(SpeedGene.WEAK_POSITIVE_SPEED);
        rubyStrand2.add(Gene.MISSING_ALLELE);
        rubyStrand2.add(Gene.MISSING_ALLELE);
        rubyStrand2.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        rubyStrand2.add(StaminaGene.WEAK_POSITIVE_STAMINA);
        rubyStrand2.add(Gene.MISSING_ALLELE);
        rubyStrand2.add(IntelligenceGene.WEAK_POSITIVE_INTELLIGENCE);
        rubyStrand2.add(Gene.MISSING_ALLELE);
        rubyStrand2.add(Gene.MISSING_ALLELE);
        rubyStrand2.add(ArmourGene.STRONG_POSITIVE_ARMOUR);
        rubyStrand2.add(Gene.NULL_ALLELE);
        rubyStrand2.add(Gene.MISSING_ALLELE);

        DragonGenome rubyGenome = new DragonGenome(rubyStrand1, rubyStrand2);
        RUBY = new Dragon(
                new DragonGenomeStats(rubyGenome),
                "RUBY",
                Gender.FEMALE,
                Age.ADULT);

    }

    public static final int[] MISSING_GENES =
            new int[] {
                    // no missing strength genes
                    9, 10, // advanced and elite speed loci missing
                    13, // only elite stamina missing
                    15, 16, // advanced and elite intelligence loci missing
                    19 };// only elite armour missing


    // Profile of Strength gene probabilities
    // Anything above 75% is KOMODYTE_STRENGTH
    public static final int STRONG_POSITIVE_STR_THRESHOLD = 75;
    public static final int WEAK_POSITIVE_STR_THRESHOLD = 50;
    public static final int NULL_STR_THRESHOLD = 30;
    public static final int NEGATIVE_STR_THRESHOLD = 10;

    // Profile of Speed gene probabilities
    // Anything Above 50% is strong positive
    public static final int WEAK_POSITIVE_SPE_THRESHOLD = 50;
    public static final int NULL_SPE_THRESHOLD = 10;
    public static final int NEGATIVE_SPE_THRESHOLD = 5;

    // Profile of Stamina gene probabilities
    // Anything above 66% is the strong positive
    public static final int WEAK_POSITIVE_STA_THRESHOLD = 66;
    public static final int NULL_STA_THRESHOLD = 33;
    public static final int NEGATIVE_STA_THRESHOLD = 10;

    // Profile of Intelligence gene probabilities
    // Anything above  50% is a strong positive
    public static final int WEAK_POSITIVE_INT_THRESHOLD = 50;
    public static final int NULL_INT_THRESHOLD = 10;
    public static final int NEGATIVE_INT_THRESHOLD = 5;

    // Profile of Armour gene probabilities
    // Anything over 66& is the strong positive
    public static final int WEAK_POSITIVE_ARM_THRESHOLD = 66;
    public static final int NULL_ARM_THRESHOLD = 33;
    public static final int NEGATIVE_ARM_THRESHOLD = 10;





    public KomodyteGenerator() {
        super(
                BodyPlanGene.KOMODYTE, // obviously it's a komodyte
                null, // don't care what the colour is
                Gene.NULL_ALLELE, // no wings
                Gene.NULL_ALLELE, // no feathers
                PatternGene.PLAIN // default pattern is plain
                );
    }

    public DragonGenome generate() {

        ArrayList<Gene> geneStrand1 = new ArrayList<Gene>();
        ArrayList<Gene> geneStrand2 = new ArrayList<Gene>();

        for (int i = 0; i < DragonGenome.SEQUENCE_LENGTH; i++) {

            boolean isMissingGene = false;
            for (int j = 0; j < MISSING_GENES.length; j++) {
                if (i == MISSING_GENES[j]) {
                    isMissingGene = true;
                    break;
                }
            }

            if (isMissingGene) {
                geneStrand1.add(Gene.MISSING_ALLELE);
                geneStrand2.add(Gene.MISSING_ALLELE);
            } else if (isGeneGeneric(i)) {
                geneStrand1.add(getKnownGenericGeneForIndex(i));
                geneStrand2.add(getKnownGenericGeneForIndex(i));
            } else if (DragonGenome.isStrengthLocus(i)) {
                geneStrand1.add(generateRandomStrengthGene());
                geneStrand2.add(generateRandomStrengthGene());
            } else if (DragonGenome.isSpeedLocus(i)) {
                geneStrand1.add(generateRandomSpeedGene());
                geneStrand2.add(generateRandomSpeedGene());
            } else if (DragonGenome.isStaminaLocus(i)) {
                geneStrand1.add(generateRandomStaminaGene());
                geneStrand2.add(generateRandomStaminaGene());
            } else if (DragonGenome.isIntelligenceLocus(i)) {
                geneStrand1.add(generateRandomIntelligenceGene());
                geneStrand2.add(generateRandomIntelligenceGene());
            } else if (DragonGenome.isArmourLocus(i)) {
                geneStrand1.add(generateRandomArmourGene());
                geneStrand2.add(generateRandomArmourGene());
            } else {
                // If we get here then we don't know how to fill in
                // this gene

                System.out.println(
                        "Don't know what to put in this locus i=" + i +
                        " locus=" +
                        DragonGenome.DRAGON_SEQUENCE.loci.get(i).getName()
                );

                assert (false) : 100;
            }

        }

        return new DragonGenome(geneStrand1, geneStrand2);
    }


    private Gene generateRandomStrengthGene() {
        int randomPercentage = random.nextInt(100);

        if (randomPercentage < NEGATIVE_STR_THRESHOLD) {
            return Gene.NEGATIVE_ALLELE;
        } else if (randomPercentage < NULL_STR_THRESHOLD) {
            return Gene.NULL_ALLELE;
        } else if (randomPercentage < WEAK_POSITIVE_STR_THRESHOLD) {
            return StrengthGene.WEAK_POSITIVE_STRENGTH;
        } else if (randomPercentage < STRONG_POSITIVE_STR_THRESHOLD) {
            return StrengthGene.STRONG_POSITIVE_STRENGTH;
        } else {
            return StrengthGene.KOMODYTE_STRENGTH;
        }
    }

    private Gene generateRandomStaminaGene() {
        int randomPercentage = random.nextInt(100);

        if (randomPercentage < NEGATIVE_STA_THRESHOLD) {
            return Gene.NEGATIVE_ALLELE;
        } else if (randomPercentage < NULL_STA_THRESHOLD) {
            return Gene.NULL_ALLELE;
        } else if (randomPercentage < WEAK_POSITIVE_STA_THRESHOLD) {
            return StaminaGene.WEAK_POSITIVE_STAMINA;
        } else {
            return StaminaGene.STRONG_POSITIVE_STAMINA;
        }

    }

    private Gene generateRandomSpeedGene() {
        int randomPercentage = random.nextInt(100);

        if (randomPercentage < NEGATIVE_SPE_THRESHOLD) {
            return Gene.NEGATIVE_ALLELE;
        } else if (randomPercentage < NULL_SPE_THRESHOLD) {
            return Gene.NULL_ALLELE;
        } else if (randomPercentage < WEAK_POSITIVE_SPE_THRESHOLD) {
            return SpeedGene.WEAK_POSITIVE_SPEED;
        } else {
            return SpeedGene.STRONG_POSITIVE_SPEED;
        }

    }

    private Gene generateRandomIntelligenceGene() {
        int randomPercentage = random.nextInt(100);

        if (randomPercentage < NEGATIVE_INT_THRESHOLD) {
            return Gene.NEGATIVE_ALLELE;
        } else if (randomPercentage < NULL_INT_THRESHOLD) {
            return Gene.NULL_ALLELE;
        } else if (randomPercentage < WEAK_POSITIVE_INT_THRESHOLD) {
            return IntelligenceGene.WEAK_POSITIVE_INTELLIGENCE;
        } else {
            return IntelligenceGene.STRONG_POSITIVE_INTELLIGENCE;
        }

    }

    private Gene generateRandomArmourGene() {
        int randomPercentage = random.nextInt(100);

        if (randomPercentage < NEGATIVE_ARM_THRESHOLD) {
            return Gene.NEGATIVE_ALLELE;
        } else if (randomPercentage < NULL_ARM_THRESHOLD) {
            return Gene.NULL_ALLELE;
        } else if (randomPercentage < WEAK_POSITIVE_ARM_THRESHOLD) {
            return ArmourGene.WEAK_POSITIVE_ARMOUR;
        } else {
            return ArmourGene.STRONG_POSITIVE_ARMOUR;
        }

    }
}
