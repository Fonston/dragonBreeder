package dougrowena.games.dragonBreeder.basicui;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ImgsTest {

    @Test
    public void avgColourSinglePixel() {

        byte[] red = new byte[] {-1};
        byte[] green = new byte[] {0};
        byte[] blue = new byte[] {0};
        byte[] alpha = new byte[] {-1};

        int[] avgColour = Imgs.getAverageRGBAFromSeparateChannels(
                red, green,blue,alpha);

        assertEquals (255, avgColour[Imgs.RED_INDEX]);
        assertEquals (0, avgColour[Imgs.GREEN_INDEX]);
        assertEquals (0, avgColour[Imgs.BLUE_INDEX]);
        assertEquals (255, avgColour[Imgs.ALPHA_INDEX]);

    }

    @Test
    public void avgColourThreebyThreePixel() {

        // red all negative
        byte[] red = new byte[] {
                -128, -128, -128,
                -128, -128, -128,
                -128, -128, -128
        };
        // green all positive
        byte[] green = new byte[] {
                1,1,1,
                1,1,1,
                1,1,1,
        };
        // blue a mix of + and - to ensure totals are correct
        // when the bytes are converted into longs
        byte[] blue = new byte[] {
                -1 , -1, -1,
                127,127,127,
                -1 , -1, -1

        };
        // just zero
        byte[] alpha = new byte[] {
                -1,-1,-1,
                -1,-1,-1,
                -1,-1,-1
        };

        int[] avgColour = Imgs.getAverageRGBAFromSeparateChannels(
                red, green,blue,alpha);

        assertEquals (128, avgColour[Imgs.RED_INDEX]);
        assertEquals (1, avgColour[Imgs.GREEN_INDEX]);
        assertEquals (212, avgColour[Imgs.BLUE_INDEX]);
        assertEquals (255, avgColour[Imgs.ALPHA_INDEX]);

    }



}
