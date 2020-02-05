package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by HP DX2400 Custom on 19/08/2016.
 */
public class DragonGenomeTest {

    @Test
    public void testDragonLociSequence() {

        ArrayList<Gene> geneStrand1 = new ArrayList<Gene>();
        geneStrand1.add(BodyPlanGene.KOMODYTE);
        geneStrand1.add(BaseColourGene.BLUE);
        geneStrand1.add(BaseColourGene.BLUE);
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
        geneStrand2.add(BaseColourGene.YELLOW);
        geneStrand2.add(BaseColourGene.YELLOW);
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


        DragonGenome testGenome = new DragonGenome(
                geneStrand1,
                geneStrand2);

        String s = testGenome.toString();

        System.out.println();
        System.out.println(s);
    }

}