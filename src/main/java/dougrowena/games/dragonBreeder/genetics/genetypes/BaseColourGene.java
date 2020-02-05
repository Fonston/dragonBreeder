package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

import java.awt.*;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class BaseColourGene extends Gene {

    public static final BaseColourGene RED =
            new BaseColourGene("RED", Color.RED);
    public static final BaseColourGene YELLOW =
            new BaseColourGene("YELLOW", Color.YELLOW);
    public static final BaseColourGene BLUE =
            new BaseColourGene("BLUE", Color.BLUE);
    public static final BaseColourGene BLACK =
            new BaseColourGene("BLACK", Color.BLACK);
    public static final BaseColourGene SLATE =
            new BaseColourGene("SLATE", new Color(80, 80, 80));
    public static final BaseColourGene GREY =
            new BaseColourGene("GREY", Color.GRAY);
    public static final BaseColourGene BROWN =
            new BaseColourGene("BROWN", new Color(75, 50, 25));
    public static final BaseColourGene WHITE =
            new BaseColourGene("WHITE", Color.WHITE);

    public static final BaseColourGene WHITE_STRIPES =
            new BaseColourGene("WHITE", Color.WHITE);
    public static final BaseColourGene GREY_STRIPES =
            new BaseColourGene("GREY", new Color(100,100,100));
    public static final BaseColourGene SLATE_STRIPES =
            new BaseColourGene("SLATE", new Color(60,60, 60));
    public static final BaseColourGene BROWN_STRIPES =
            new BaseColourGene("BROWN", new Color(40, 20, 10));
    public static final BaseColourGene BLACK_STRIPES =
            new BaseColourGene("BLACK", Color.BLACK);

    public static final BaseColourGene[] KNOWN_COLOUR_GENES =
            new BaseColourGene[] {
                    //RED,
                    //YELLOW,
                    //BLUE,
                    //BLACK,
                    WHITE,
                    SLATE,
                    GREY,
                    BROWN
            };

    public static final BaseColourGene[] KNOWN_STRIPE_COLOUR_GENES =
            new BaseColourGene[] {
                    WHITE_STRIPES,
                    GREY_STRIPES,
                    SLATE_STRIPES,
                    BROWN_STRIPES,
                    BLACK_STRIPES
            };



    private Color colour;

    public BaseColourGene(String name, Color colour) {
        super(name);

        assert (colour != null) : 1;

        this.colour = colour;
    }

    public Color getColour() {
        return colour;
    }

    public String toString() {
        return name;
    }

    /*
    public static BaseColourGene getPhenotypicalGene(final Gene geneA,
                                                 final Gene geneB) {

        BaseColourGene colourGeneA;
        BaseColourGene colourGeneB;

        if (geneA instanceof BaseColourGene) {
            colourGeneA = (BaseColourGene) geneA;
        } else {
            if (    geneA == NULL_ALLELE ||
                    geneA == NEGATIVE_ALLELE ||
                    geneA == MISSING_ALLELE) {
                colourGeneA = WHITE;
            } else {
                colourGeneA = null;
                assert (false) : 100;
            }
        }

        if (geneB instanceof BaseColourGene) {
            colourGeneB = (BaseColourGene) geneB;
        } else {
            if (    geneB == NULL_ALLELE ||
                    geneB == NEGATIVE_ALLELE ||
                    geneB == MISSING_ALLELE) {
                colourGeneB = WHITE;
            } else {
                colourGeneB = null;
                assert (false) : 101;
            }
        }

        return getPhenotypicalGeneInternal(colourGeneA, colourGeneB);

    }

    private static BaseColourGene getPhenotypicalGeneInternal(
            final BaseColourGene geneA,
            final BaseColourGene geneB) {

        if (geneA == BROWN || geneB == BROWN) {
            return BROWN;
        }

        if (geneA == SLATE || geneB == SLATE) {
            return SLATE;
        }

        if (geneA == GREY || geneB == GREY) {
            return GREY;
        }

        return WHITE;
    }
    */
}
