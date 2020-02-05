package dougrowena.games.dragonBreeder.genetics.genetypes;

import dougrowena.games.dragonBreeder.genetics.Gene;

import java.awt.*;

/**
 * Created by HP DX2400 Custom on 18/08/2016.
 */
public class StripeColourGene extends Gene {

    public static final StripeColourGene WHITE_STRIPES =
            new StripeColourGene("WHITE", Color.WHITE);
    public static final StripeColourGene GREY_STRIPES =
            new StripeColourGene("GREY", new Color(100,100,100));
    public static final StripeColourGene SLATE_STRIPES =
            new StripeColourGene("SLATE", new Color(60,60, 60));
    public static final StripeColourGene BROWN_STRIPES =
            new StripeColourGene("BROWN", new Color(40, 20, 10));
    public static final StripeColourGene BLACK_STRIPES =
            new StripeColourGene("BLACK", Color.BLACK);

    public static final StripeColourGene[] KNOWN_STRIPE_COLOUR_GENES =
            new StripeColourGene[] {
                    WHITE_STRIPES,
                    GREY_STRIPES,
                    SLATE_STRIPES,
                    BROWN_STRIPES,
                    BLACK_STRIPES
            };



    private Color colour;

    public StripeColourGene(String name, Color colour) {
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


}
