package dougrowena.games.dragonBreeder.genetics.phenotype;

import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.BaseColourGene;
import dougrowena.games.dragonBreeder.genetics.genetypes.StripeColourGene;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 02/10/2016.
 */
public class StripeColourPhenotype extends JLabel {

    public static final StripeColourPhenotype WHITE_STRIPES =
            new StripeColourPhenotype(
                    StripeColourGene.WHITE_STRIPES.getName(),
                    StripeColourGene.WHITE_STRIPES.getColour(),
                    StripeColourGene.WHITE_STRIPES);
    public static final StripeColourPhenotype GREY_STRIPES =
            new StripeColourPhenotype(
                    StripeColourGene.GREY_STRIPES.getName(),
                    StripeColourGene.GREY_STRIPES.getColour(),
                    StripeColourGene.GREY_STRIPES);
    public static final StripeColourPhenotype SLATE_STRIPES =
            new StripeColourPhenotype(
                    StripeColourGene.SLATE_STRIPES.getName(),
                    StripeColourGene.SLATE_STRIPES.getColour(),
                    StripeColourGene.SLATE_STRIPES);
    public static final StripeColourPhenotype BROWN_STRIPES =
            new StripeColourPhenotype(
                    StripeColourGene.BROWN_STRIPES.getName(),
                    StripeColourGene.BROWN_STRIPES.getColour(),
                    StripeColourGene.BROWN_STRIPES);
    public static final StripeColourPhenotype BLACK_STRIPES =
            new StripeColourPhenotype(
                    StripeColourGene.BLACK_STRIPES.getName(),
                    StripeColourGene.BLACK_STRIPES.getColour(),
                    StripeColourGene.BLACK_STRIPES);

    public static StripeColourPhenotype[] KNOWN_TYPES =
            new StripeColourPhenotype[] {
                    BLACK_STRIPES,
                    SLATE_STRIPES,
                    GREY_STRIPES,
                    BROWN_STRIPES,
                    WHITE_STRIPES
            };


    private String colourName;
    private Color colour;

    private StripeColourGene typicalGene;

    private StripeColourPhenotype(final String name,
                                  final Color colour,
                                  final StripeColourGene typicalGene) {
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

    public StripeColourGene getTypicalGene() {
        return typicalGene;
    }

    public String toString() {
        return colourName;
    }

    public static StripeColourPhenotype getPhenotypicalGene(final Gene geneA,
                                                            final Gene geneB) {

        StripeColourGene stripeColourGeneA;
        StripeColourGene stripeColourGeneB;

        if (geneA instanceof StripeColourGene) {
            stripeColourGeneA = (StripeColourGene) geneA;
        } else {
            if (    geneA == StripeColourGene.NULL_ALLELE ||
                    geneA == StripeColourGene.NEGATIVE_ALLELE ||
                    geneA == StripeColourGene.MISSING_ALLELE) {
                stripeColourGeneA = StripeColourGene.WHITE_STRIPES;
            } else {
                stripeColourGeneA = null;
                assert (false) : 100;
            }
        }

        if (geneB instanceof StripeColourGene) {
            stripeColourGeneB = (StripeColourGene) geneB;
        } else {
            if (    geneB == StripeColourGene.NULL_ALLELE ||
                    geneB == StripeColourGene.NEGATIVE_ALLELE ||
                    geneB == StripeColourGene.MISSING_ALLELE) {
                stripeColourGeneB = StripeColourGene.WHITE_STRIPES;
            } else {
                stripeColourGeneB = null;
                assert (false) : 101;
            }
        }

        return getPhenotypicalGeneInternal(stripeColourGeneA, stripeColourGeneB);

    }

    private static StripeColourPhenotype getPhenotypicalGeneInternal(
            final StripeColourGene geneA,
            final StripeColourGene geneB) {

        if (    geneA == StripeColourGene.BLACK_STRIPES ||
                geneB == StripeColourGene.BLACK_STRIPES) {
            return BLACK_STRIPES;
        }

        if (    geneA == StripeColourGene.BROWN_STRIPES ||
                geneB == StripeColourGene.BROWN_STRIPES) {
            return BROWN_STRIPES;
        }

        if (    geneA == StripeColourGene.SLATE_STRIPES ||
                geneB == StripeColourGene.SLATE_STRIPES) {
            return SLATE_STRIPES;
        }

        if (    geneA == StripeColourGene.GREY_STRIPES ||
                geneB == StripeColourGene.GREY_STRIPES) {
            return GREY_STRIPES;
        }

        return WHITE_STRIPES;
    }
}
