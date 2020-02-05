package dougrowena.games.dragonBreeder.genetics.genomegenerators;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.*;

import java.util.Random;

/**
 * Created by HP DX2400 Custom on 21/08/2016.
 */
public abstract class GenomeGenerator {

    protected static final Random random = new Random();

    public static final int BODY_PLAN_INDEX = 0;
    public static final int COLOUR_INDEX_1 = 1;
    public static final int COLOUR_INDEX_2 = 2;
    public static final int WINGS_INDEX = 3;
    public static final int FEATHERS_INDEX = 4;
    public static final int PATTERN_INDEX = 5;

    protected Gene defaultBodyPlan;
    protected Gene defaultColourGene;
    protected Gene defaultWings;
    protected Gene defaultFeathers;
    protected Gene defaultPattern;

    /**
     * This constructor gets the basics in with regard to how to handle the
     * generic genes.
     *
     * Genes can be null, if they are null then a random gene appropriate for
     * that location is put there.
     */
    protected GenomeGenerator(final Gene defaultBodyPlan,
                              final Gene defaultColour,
                              final Gene defaultWings,
                              final Gene defaultFeathers,
                              final Gene defaultPattern) {

        this.defaultBodyPlan = defaultBodyPlan;
        this.defaultColourGene = defaultColour;
        this.defaultWings = defaultWings;
        this.defaultFeathers = defaultFeathers;
        this.defaultPattern = defaultPattern;

    }

    /**
     * Certain genes are generic, if the index passed in corresponds to a gene
     * location that is generic then return true (gene is generic) otherwise
     * return false.
     *
     * @param index
     * @return
     */
    public static boolean isGeneGeneric(final int index) {

        // Check through our list of generic indecies
        if (index == BODY_PLAN_INDEX ) {
            return true;
        } else if (index == COLOUR_INDEX_1) {
            return true;
        } else if (index == COLOUR_INDEX_2) {
            return true;
        } else if (index == WINGS_INDEX) {
            return true;
        } else if (index == FEATHERS_INDEX) {
            return true;
        } else if (index == PATTERN_INDEX) {
            return true;
        }

        // index didn't correspond to one of our generic genes, gene is not generic,
        // return false.
        return false;
    }

    protected Gene getKnownGenericGeneForIndex(final int index) {

        assert (isGeneGeneric(index)) : 1;

        if (index == BODY_PLAN_INDEX ) {
            if (defaultBodyPlan != null) {
                return defaultBodyPlan;
            } else {
                int randomPick = random.nextInt(
                        BodyPlanGene.KNOWN_BODY_PLANS.length);

                return BodyPlanGene.KNOWN_BODY_PLANS[randomPick];
            }
        } else if (index == COLOUR_INDEX_1) {
            if (defaultColourGene != null) {
                return defaultColourGene;
            } else {
                int randomPick = random.nextInt(
                        BaseColourGene.KNOWN_COLOUR_GENES.length);

                return BaseColourGene.KNOWN_COLOUR_GENES[randomPick];
            }
        } else if (index == COLOUR_INDEX_2) {
            if (defaultColourGene != null) {
                return defaultColourGene;
            } else {
                int randomPick = random.nextInt(
                        BaseColourGene.KNOWN_COLOUR_GENES.length);

                return BaseColourGene.KNOWN_COLOUR_GENES[randomPick];
            }
        } else if (index == WINGS_INDEX) {
            if (defaultWings != null) {
                return defaultWings;
            } else {
                int randomPick = random.nextInt(
                        WingsGene.KNOWN_WINGS.length);

                return WingsGene.KNOWN_WINGS[randomPick];
            }
        } else if (index == FEATHERS_INDEX) {
            if (defaultFeathers != null) {
                return defaultFeathers;
            } else {
                int randomPick = random.nextInt(
                        FeathersGene.KNOWN_FEATHERS.length);

                return FeathersGene.KNOWN_FEATHERS[randomPick];
            }
        } else if (index == PATTERN_INDEX) {
            if (defaultPattern != null) {
                return defaultPattern;
            } else {
                int randomPick = random.nextInt(
                        PatternGene.KNOWN_PATTERNS.length);

                return PatternGene.KNOWN_PATTERNS[randomPick];
            }
        }

        // Shouldn't be able to get this far and not already have returned a gene
        assert (true) : 100;

        return null;
    }

    /**
     * This method is used to generate a random DragonGenome, typically this
     * will be overwritten to generate a typical genome for a given dragon
     * sub-species.
     *
     * @return A random genome for a dragon.
     */
    public abstract DragonGenome generate() ;

}
