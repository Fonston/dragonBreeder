package dougrowena.games.dragonBreeder.genetics.phenotype;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.BaseColourGene;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 02/10/2016.
 */
public class BaseColourPhenotype extends JLabel {

    public static final BaseColourPhenotype RED =
            new BaseColourPhenotype(
                    BaseColourGene.RED.getName(),
                    BaseColourGene.RED.getColour(),
                    BaseColourGene.RED);
    public static final BaseColourPhenotype YELLOW =
            new BaseColourPhenotype(
                    BaseColourGene.YELLOW.getName(),
                    BaseColourGene.YELLOW.getColour(),
                    BaseColourGene.YELLOW);
    public static final BaseColourPhenotype BLUE =
            new BaseColourPhenotype(
                    BaseColourGene.BLUE.getName(),
                    BaseColourGene.BLUE.getColour(),
                    BaseColourGene.BLUE);
    public static final BaseColourPhenotype BLACK =
            new BaseColourPhenotype(
                    BaseColourGene.BLACK.getName(),
                    BaseColourGene.BLACK.getColour(),
                    BaseColourGene.BLACK);
    public static final BaseColourPhenotype SLATE =
            new BaseColourPhenotype(
                    BaseColourGene.SLATE.getName(),
                    BaseColourGene.SLATE.getColour(),
                    BaseColourGene.SLATE);
    public static final BaseColourPhenotype GREY =
            new BaseColourPhenotype(
                    BaseColourGene.GREY.getName(),
                    BaseColourGene.GREY.getColour(),
                    BaseColourGene.GREY);
    public static final BaseColourPhenotype BROWN =
            new BaseColourPhenotype(
                    BaseColourGene.BROWN.getName(),
                    BaseColourGene.BROWN.getColour(),
                    BaseColourGene.BROWN);
    public static final BaseColourPhenotype WHITE =
            new BaseColourPhenotype(
                    BaseColourGene.WHITE.getName(),
                    BaseColourGene.WHITE.getColour(),
                    BaseColourGene.WHITE);

    public static BaseColourPhenotype[] KNOWN_TYPES =
            new BaseColourPhenotype[] {
                    RED,
                    YELLOW,
                    BLUE,
                    BLACK,
                    SLATE,
                    GREY,
                    BROWN,
                    WHITE
            };


    private String colourName;
    private Color colour;

    private BaseColourGene typicalGene;

    private BaseColourPhenotype(final String name,
                                final Color colour,
                                final BaseColourGene typicalGene) {
        super(name);

        this.colour = colour;
        this.colourName = name;
        this.typicalGene = typicalGene;
    }


    public String getColourName() {
        return colourName;
    }

    public Color getColour() {
        return colour;
    }

    public BaseColourGene getTypicalGene() {
        return typicalGene;
    }

    public String toString() {
        return colourName;
    }

    public static BaseColourPhenotype getPhenotypicalGene(final Gene geneA,
                                                          final Gene geneB) {

        BaseColourGene baseColourGeneA;
        BaseColourGene baseColourGeneB;

        if (geneA instanceof BaseColourGene) {
            baseColourGeneA = (BaseColourGene) geneA;
        } else {
            if (    geneA == BaseColourGene.NULL_ALLELE ||
                    geneA == BaseColourGene.NEGATIVE_ALLELE ||
                    geneA == BaseColourGene.MISSING_ALLELE) {
                baseColourGeneA = BaseColourGene.WHITE;
            } else {
                baseColourGeneA = null;
                assert (false) : 100;
            }
        }

        if (geneB instanceof BaseColourGene) {
            baseColourGeneB = (BaseColourGene) geneB;
        } else {
            if (    geneB == BaseColourGene.NULL_ALLELE ||
                    geneB == BaseColourGene.NEGATIVE_ALLELE ||
                    geneB == BaseColourGene.MISSING_ALLELE) {
                baseColourGeneB = BaseColourGene.WHITE;
            } else {
                baseColourGeneB = null;
                assert (false) : 101;
            }
        }

        return getPhenotypicalGeneInternal(baseColourGeneA, baseColourGeneB);

    }

    private static BaseColourPhenotype getPhenotypicalGeneInternal(
            final BaseColourGene geneA,
            final BaseColourGene geneB) {

        if (geneA == BaseColourGene.BROWN || geneB == BaseColourGene.BROWN) {
            return BROWN;
        }

        if (geneA == BaseColourGene.SLATE || geneB == BaseColourGene.SLATE) {
            return SLATE;
        }

        if (geneA == BaseColourGene.GREY || geneB == BaseColourGene.GREY) {
            return GREY;
        }

        if (geneA == BaseColourGene.RED || geneB == BaseColourGene.RED) {
            return RED;
        }

        if (geneA == BaseColourGene.YELLOW || geneB == BaseColourGene.YELLOW) {
            return YELLOW;
        }

        if (geneA == BaseColourGene.BLUE || geneB == BaseColourGene.BLUE) {
            return BLUE;
        }

        if (geneA == BaseColourGene.BLACK || geneB == BaseColourGene.BLACK) {
            return BLACK;
        }

        return WHITE;
    }
}
