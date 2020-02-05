package dougrowena.games.dragonBreeder.dragon;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.Genome;
import dougrowena.games.dragonBreeder.genetics.genetypes.DragonGenome;
import dougrowena.games.dragonBreeder.genetics.genetypes.StatGene;

/**
 * Created by HP DX2400 Custom on 20/08/2016.
 */
public class DragonGenomeStats {

    public static final int[] STRENGTH_GENES =
            new int[] {6,7,8};
    public static final int[] SPEED_GENES =
            new int[] {9,10,11};
    public static final int[] STAMINA_GENES =
            new int[] {12,13,14};
    public static final int[] INTELLIGENCE_GENES =
            new int[] {15,16,17};
    public static final int[] ARMOUR_GENES =
            new int[] {18,19,20};

    protected DragonGenome genome;

    public DragonGenomeStats(final DragonGenome genome) {

        assert (genome != null) : 1;

        this.genome = genome;

    }

    public int getStrength() {
        return getStatBasics(STRENGTH_GENES);
    }

    public int getSpeed() {
        return getStatBasics(SPEED_GENES);
    }

    public int getStamina() {return getStatBasics(STAMINA_GENES);}

    public int getIntelligence() {
        return getStatBasics(INTELLIGENCE_GENES);
    }

    public int getArmour() {
        return getStatBasics(ARMOUR_GENES);
    }

    /**
     * This is the internal generic method that is used to tally up the stats
     * of a related set of genes (strength, intelligence, etc.) and return
     * those related numbers into a single stat.  It is called by the public
     * getters of the more specific stats
     *
     * @param GENES
     * @return
     */
    protected int getStatBasics(final int[] GENES) {
        int stat = 0;

        for (int index = 0; index < GENES.length; index++) {
            int geneIndex = GENES[index];

            Gene geneA = genome.getSequenceAGene(geneIndex);
            Gene geneB = genome.getSequenceBGene(geneIndex);

            int locusStat = StatGene.determineStat(geneA, geneB);

            stat = stat + locusStat;
        }

        return stat;
    }

    public DragonGenome getGenome() {
        return genome;
    }

    public String reportGenomeStatistics() {
        String s = "";

        for (int i = 0; i < genome.getSequence().loci.size(); i++) {
            // Produce a line for each gene pair
            s = s + genome.getToStringLine(i);

            // If a gene pair is at a position that is at the same position as
            // the first gene in a stat group then print out the combined
            // statistic for that stat group.  If it's the first strength
            // gene then add the total strength of the dragon (based on
            // genetics) to the end of this line.
            if (i == STRENGTH_GENES[0]) {
                s = s + getStrength();
            } else if (i == SPEED_GENES[0]) {
                s = s + getSpeed();
            } else if (i == STAMINA_GENES[0]) {
                s = s + getStamina();
            } else if (i == INTELLIGENCE_GENES[0]) {
                s = s + getIntelligence();
            } else if (i == ARMOUR_GENES[0]) {
                s = s + getArmour();
            }

            // Add line feed to start a new line.
            s = s + "\n";
        }

        return s;
    }
}
