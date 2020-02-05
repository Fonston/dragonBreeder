package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.genetics.phenotype.BaseColourPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.StripeColourPhenotype;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by HP DX2400 Custom on 20/09/2016.
 */
public class Imgs {

    public static final BufferedImage ADULT_BASIC;
    public static final BufferedImage ADULT_BROWN;
    public static final BufferedImage ADULT_DARK_POINTS;
    public static final BufferedImage ADULT_GREY;
    public static final BufferedImage ADULT_SLATE;
    public static final BufferedImage ADULT_SPOTS;
    public static final BufferedImage ADULT_STRIPES;
    public static final BufferedImage ADULT_WHITE;
    public static final BufferedImage HATCHLING_BASIC;
    public static final BufferedImage HATCHLING_BROWN;
    public static final BufferedImage HATCHLING_DARK_POINTS;
    public static final BufferedImage HATCHLING_GREY;
    public static final BufferedImage HATCHLING_SLATE;
    public static final BufferedImage HATCHLING_SPOTS;
    public static final BufferedImage HATCHLING_STRIPES;
    public static final BufferedImage HATCHLING_WHITE;
    public static final BufferedImage JUVENILE_BASIC;
    public static final BufferedImage JUVENILE_BROWN;
    public static final BufferedImage JUVENILE_DARK_POINTS;
    public static final BufferedImage JUVENILE_GREY;
    public static final BufferedImage JUVENILE_SLATE;
    public static final BufferedImage JUVENILE_SPOTS;
    public static final BufferedImage JUVENILE_STRIPES;
    public static final BufferedImage JUVENILE_WHITE;

    public static final HashMap<BaseColourPhenotype, Image> HATCHLING_BASE_COLOURS;
    public static final HashMap<BaseColourPhenotype, Image> JUVENILE_BASE_COLOURS;
    public static final HashMap<BaseColourPhenotype, Image> ADULT_BASE_COLOURS;

    public static final HashMap<StripeColourPhenotype, Image> HATCHLING_STRIPE_COLOURS;
    public static final HashMap<StripeColourPhenotype, Image> JUVENILE_STRIPE_COLOURS;
    public static final HashMap<StripeColourPhenotype, Image> ADULT_STRIPE_COLOURS;


    public static final BufferedImage NOTEBOOK_BACKGROUND;
    public static final Color NOTEBOOK_BACKGROUND_COLOUR;

    public static final Image NOTEBOOK_BACK_TOP_LEFT;
    public static final Image NOTEBOOK_BACK_TOP_RIGHT;
    public static final Image NOTEBOOK_BACK_BOTTOM_LEFT;
    public static final Image NOTEBOOK_BACK_BOTTOM_RIGHT;

    public static final Image ESTIMATE_BUTTON_IMAGE;

    public static final double REFERENCE_WIDTH_HEIGHT_RATIO;

    public static final int RED_INDEX = 0;
    public static final int GREEN_INDEX = 1;
    public static final int BLUE_INDEX = 2;
    public static final int ALPHA_INDEX = 3;
    public static final int RGBA_TUPLE_SIZE = 4;

    static {

        ADULT_BASIC           = getResourceImage(
                "/Breeder Transparencies/Adult Basic.png");
        ADULT_BROWN           = getResourceImage(
                "/Breeder Transparencies/Adult Brown.png");
        ADULT_DARK_POINTS     = getResourceImage(
                "/Breeder Transparencies/Adult Dark Points.png");
        ADULT_GREY            = getResourceImage(
                "/Breeder Transparencies/Adult Grey.png");
        ADULT_SLATE           = getResourceImage(
                "/Breeder Transparencies/Adult Slate.png");
        ADULT_SPOTS           = getResourceImage(
                "/Breeder Transparencies/Adult Spots.png");
        ADULT_STRIPES         = getResourceImage(
                "/Breeder Transparencies/Adult Stripes.png");
        ADULT_WHITE           = getResourceImage(
                "/Breeder Transparencies/Adult White.png");
        HATCHLING_BASIC       = getResourceImage(
                "/Breeder Transparencies/Hatchling Basic.png");
        HATCHLING_BROWN       = getResourceImage(
                "/Breeder Transparencies/Hatchling Brown.png");
        HATCHLING_DARK_POINTS = getResourceImage(
                "/Breeder Transparencies/Hatchling Dark Points.png");
        HATCHLING_GREY        = getResourceImage(
                "/Breeder Transparencies/Hatchling Grey.png");
        HATCHLING_SLATE       = getResourceImage(
                "/Breeder Transparencies/Hatchling Slate.png");
        HATCHLING_SPOTS       = getResourceImage(
                "/Breeder Transparencies/Hatchling Spots.png");
        HATCHLING_STRIPES     = getResourceImage(
                "/Breeder Transparencies/Hatchling Stripes.png");
        HATCHLING_WHITE       = getResourceImage(
                "/Breeder Transparencies/Hatchling White.png");
        JUVENILE_BASIC        = getResourceImage(
                "/Breeder Transparencies/Juvenile Basic.png");
        JUVENILE_BROWN        = getResourceImage(
                "/Breeder Transparencies/Juvenile Brown.png");
        JUVENILE_DARK_POINTS  = getResourceImage(
                "/Breeder Transparencies/Juvenile Dark Points.png");
        JUVENILE_GREY        = getResourceImage(
                "/Breeder Transparencies/Juvenile Grey.png");
        JUVENILE_SLATE        = getResourceImage(
                "/Breeder Transparencies/Juvenile Slate.png");
        JUVENILE_SPOTS        = getResourceImage(
                "/Breeder Transparencies/Juvenile Spots.png");
        JUVENILE_STRIPES      = getResourceImage(
                "/Breeder Transparencies/Juvenile Stripes.png");
        JUVENILE_WHITE        = getResourceImage(
                "/Breeder Transparencies/Juvenile White.png");
        NOTEBOOK_BACKGROUND   = getResourceImage(
                "/Breeder Transparencies/Notebook Background.png");
        NOTEBOOK_BACKGROUND_COLOUR = getAverageColour(NOTEBOOK_BACKGROUND);

        ESTIMATE_BUTTON_IMAGE   = getResourceImage(
                "/Breeder Transparencies/Estimate_Button.png");

        HATCHLING_BASE_COLOURS = new HashMap<BaseColourPhenotype, Image>();
        for (BaseColourPhenotype type : BaseColourPhenotype.KNOWN_TYPES) {
            HATCHLING_BASE_COLOURS.put(
                    type,
                    recolourImage(HATCHLING_SLATE, type.getColour())
            );
        }

        JUVENILE_BASE_COLOURS = new HashMap<BaseColourPhenotype, Image>();
        for (BaseColourPhenotype type : BaseColourPhenotype.KNOWN_TYPES) {
            JUVENILE_BASE_COLOURS.put(
                    type,
                    recolourImage(JUVENILE_SLATE, type.getColour())
            );
        }
        ADULT_BASE_COLOURS = new HashMap<BaseColourPhenotype, Image>();
        for (BaseColourPhenotype type : BaseColourPhenotype.KNOWN_TYPES) {
            ADULT_BASE_COLOURS.put(
                    type,
                    recolourImage(ADULT_SLATE, type.getColour())
            );
        }

        HATCHLING_STRIPE_COLOURS = new HashMap<StripeColourPhenotype, Image>();
        for (StripeColourPhenotype type : StripeColourPhenotype.KNOWN_TYPES) {
            HATCHLING_STRIPE_COLOURS.put(
                    type,
                    recolourImage(HATCHLING_STRIPES, type.getColour())
            );
        }

        JUVENILE_STRIPE_COLOURS = new HashMap<StripeColourPhenotype, Image>();
        for (StripeColourPhenotype type : StripeColourPhenotype.KNOWN_TYPES) {
            JUVENILE_STRIPE_COLOURS.put(
                    type,
                    recolourImage(JUVENILE_STRIPES, type.getColour())
            );
        }
        ADULT_STRIPE_COLOURS = new HashMap<StripeColourPhenotype, Image>();
        System.out.println("ADULT_STRIPES colour palette");
        getColours(ADULT_STRIPES);
        for (StripeColourPhenotype type : StripeColourPhenotype.KNOWN_TYPES) {
            //System.out.println("Recoloured image" + type.getColourName() + "\n\n\n\n\n\n");
            ADULT_STRIPE_COLOURS.put(
                    type,
                    recolourImage(ADULT_STRIPES, type.getColour())
            );
        }

        WritableRaster raster = NOTEBOOK_BACKGROUND.getRaster();
        int width = raster.getWidth();
        int height = raster.getHeight();

        final float Y_BOUND = 0.66f;
        final float X_BOUND = 0.33f;

        NOTEBOOK_BACK_TOP_LEFT = NOTEBOOK_BACKGROUND.getSubimage(
                0,
                0,
                (int)(width*X_BOUND),
                (int) (height * Y_BOUND));
        NOTEBOOK_BACK_TOP_RIGHT = NOTEBOOK_BACKGROUND.getSubimage(
                (int)(width*X_BOUND),
                0,
                (int)(width*(1 - X_BOUND)),
                (int) (height * Y_BOUND));
        NOTEBOOK_BACK_BOTTOM_LEFT = NOTEBOOK_BACKGROUND.getSubimage(
                0,
                (int) (height * Y_BOUND),
                (int)(width*X_BOUND),
                (int) (height * ( 1 - Y_BOUND)));
        NOTEBOOK_BACK_BOTTOM_RIGHT = NOTEBOOK_BACKGROUND.getSubimage(
                (int)(width * X_BOUND),
                (int) (height * Y_BOUND),
                (int)(width * ( 1 - X_BOUND)),
                (int) (height * ( 1 - Y_BOUND)));

        double refWidth = (double) ADULT_BASIC.getData().getWidth();
        double refHeight= (double) ADULT_BASIC.getData().getHeight();
        REFERENCE_WIDTH_HEIGHT_RATIO = refWidth / refHeight;

    }

    public static BufferedImage getResourceImage(String relativePath) {

        String resRelativePath = relativePath;
        URL resUrl = DragonPreviewCanvas.class.getResource(resRelativePath);
        BufferedImage i = null;
        try {
            i = ImageIO.read(resUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i;
    }

    public static BufferedImage recolourImage(BufferedImage image,
                                                   Color newColour) {

        if (image == null) {
            return null;
        }

        if (newColour == null) {
            return image;
        }

        WritableRaster raster = image.getRaster();
        DataBuffer buffer = raster.getDataBuffer();
        DataBufferByte byteBuffer = (DataBufferByte) buffer;

        int width = raster.getWidth();
        int height = raster.getHeight();

        byte[] pixels = byteBuffer.getData();

        final int pixelLength = 4;
        int[] argbPixels = new int[pixels.length / pixelLength];
        int[] newPixels = new int[argbPixels.length];
        final int TRANSPARENT = 0;
        final int NEW_COLOR = newColour.getRGB();
        int[] avgColour = getAverageRGBAFromByteArray(pixels);

        for (int pixel = 0; pixel < pixels.length; pixel += pixelLength) {

            int argb = 0;

            argb |= (((int) pixels[pixel] & 0xff) << 24); // alpha
            argb |= ((int) pixels[pixel + 1] & 0xff); // blue
            argb |= (((int) pixels[pixel + 2] & 0xff) << 8); // green
            argb |= (((int) pixels[pixel + 3] & 0xff) << 16); // red

            argbPixels[pixel / 4] = argb;

        }

        final int avgRed = avgColour[RED_INDEX];
        final int avgGreen = avgColour[GREEN_INDEX];
        final int avgBlue = avgColour[BLUE_INDEX];

        final int newRed = newColour.getRed();
        final int newGreen = newColour.getGreen();
        final int newBlue = newColour.getBlue();

        for (int i = 0; i < argbPixels.length; i++) {
            Color pixel = new Color(argbPixels[i], true);
            int alpha = pixel.getAlpha();

            if (alpha == 0) {
                newPixels[i] = TRANSPARENT;
            } else {

                float ratioRed = pixel.getRed();
                if (avgRed > 0) {
                    ratioRed = pixel.getRed() / avgRed;
                }
                float ratioGreen = pixel.getGreen();
                if (avgGreen > 0) {
                    ratioGreen = pixel.getGreen() / avgGreen;
                }
                float ratioBlue = pixel.getBlue();
                if (avgBlue > 0) {
                    ratioBlue = pixel.getBlue() / avgBlue;
                }

                int adjustedRed = (int) (newRed * ratioRed);
                int adjustedGreen = (int) (newGreen * ratioGreen);
                int adjustedBlue = (int) (newBlue * ratioBlue);
                int adjustedAlpha = alpha;
                if (adjustedRed < 0) {
                    adjustedRed = 0;
                } else if (adjustedRed > 255) {
                    adjustedRed = 255;
                }

                if (adjustedGreen < 0) {
                    adjustedGreen = 0;
                } else if (adjustedGreen > 255) {
                    adjustedGreen = 255;
                }

                if (adjustedBlue < 0) {
                    adjustedBlue = 0;
                } else if (adjustedBlue > 255) {
                    adjustedBlue = 255;
                }

                if (adjustedAlpha < 0) {
                    adjustedAlpha = 0;
                } else if (adjustedAlpha > 255) {
                    adjustedAlpha = 255;
                }

                Color newPixel = new Color(
                        adjustedRed,
                        adjustedGreen,
                        adjustedBlue,
                        adjustedAlpha);

                newPixels[i] = newPixel.getRGB();
            }

        }

        HashSet<Integer> pixelSet = new HashSet<Integer>();

        for (int pixel : newPixels) {
            pixelSet.add(pixel);
        }

        for (int pixel : pixelSet) {
            //Color c = new Color(pixel, true);
            //System.out.println("Color c=" + c +
            //        "(r="+c.getRed()+
            //        ",g="+c.getGreen()+
            //        ",b="+c.getBlue()+
            //        ",a="+c.getAlpha()+")");
        }

        SinglePixelPackedSampleModel sppsm = new SinglePixelPackedSampleModel(
                DataBuffer.TYPE_INT,
                width,
                height,
                new int[]{0xff0000,0xff00,0xff,0xff000000}
        );
        DataBufferInt newBuffer = new DataBufferInt(newPixels, newPixels.length);

        WritableRaster newRaster = Raster.createRaster(
                sppsm,
                newBuffer,
                new Point(0,0)).createCompatibleWritableRaster();

        DataBufferInt newBuffer2 = (DataBufferInt) newRaster.getDataBuffer();

        for (int i = 0; i < newPixels.length; i++) {
            newBuffer2.setElem(i, newPixels[i]);
        }
        //newRaster.setPixels(0,0,width,height,newPixels);
        //Raster.createPackedRaster(newBuffer, width,height,32, new Point(0,0));
        //System.out.println("newRaster.getClass()=" + newRaster.getClass());
        //System.out.println("newRaster.getSampleModel()=" + newRaster.getSampleModel().getClass());
        DirectColorModel dcm = new DirectColorModel(
                ColorSpace.getInstance(ColorSpace.CS_sRGB),
                32,
                0x00ff0000,
                0x0000ff00,
                0x000000ff,
                0xff000000,
                false, DataBuffer.TYPE_INT);

        BufferedImage newImage = new BufferedImage(
                dcm, //ColorModel.getRGBdefault(),
                newRaster,
                false,
                new Hashtable()
        );

        return newImage;
    }

    public static void getColours(BufferedImage image) {

        if (image == null) {
            return;
        }

        WritableRaster raster = image.getRaster();
        DataBuffer buffer = raster.getDataBuffer();
        DataBufferByte byteBuffer = (DataBufferByte) buffer;
        int dataType = buffer.getDataType();
        //System.out.println("datatype=" + dataType);
        //System.out.println("buffer=" + buffer.getClass());

        int width = raster.getWidth();
        int height = raster.getHeight();

        //System.out.println("numBands = " + raster.getNumBands());
        byte[] pixels = byteBuffer.getData();

        final int pixelLength = 4;
        int[] argbPixels = new int[pixels.length / pixelLength];
        for (int pixel = 0; pixel < pixels.length; pixel += pixelLength) {
            int argb = 0;
            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
            argb += ((int) pixels[pixel + 1] & 0xff); // blue
            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red

            argbPixels[pixel / 4] = argb;
        }

        Hashtable props = new Hashtable();
        if (image.getPropertyNames() != null) {
            for (String name : image.getPropertyNames()) {
                if (name != null && image.getProperty(name) != null) {
                    props.put(name, image.getProperty(name));
                }
            }
        }

        HashSet<Integer> pixelSet = new HashSet<Integer>();
        for (int pixel : pixels) {
            pixelSet.add(pixel);
        }

        for (int pixel : pixelSet) {

            Color c = new Color(pixel, true);
            System.out.println(
                    "(r="+c.getRed()+
                    ",g="+c.getGreen()+
                    ",b="+c.getBlue()+
                    ",a="+c.getAlpha()+")");
        }
    }

    public static Color getAverageColour(BufferedImage image) {

        if (image == null) {
            return null;
        }


        WritableRaster raster = image.getRaster();
        DataBuffer buffer = raster.getDataBuffer();
        DataBufferByte byteBuffer = (DataBufferByte) buffer;

        byte[] pixels = byteBuffer.getData();

        final int pixelLength = 4;
        int[] argbPixels = new int[pixels.length / pixelLength];
        int[] newPixels = new int[argbPixels.length];

        long totalRed = 0;
        long totalGreen = 0;
        long totalBlue = 0;
        long totalAlpha = 0;
        long countNonTransparent = 0;

        for (int pixel = 0; pixel < pixels.length; pixel += pixelLength) {
            int argb = 0;
            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
            argb += ((int) pixels[pixel + 1] & 0xff); // blue
            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red

            argbPixels[pixel / 4] = argb;

            // If it's a non-transparent then add it to the average colour
            if (pixels[pixel] != 0) {
                totalAlpha += Byte.toUnsignedInt(pixels[pixel]);
                totalBlue += Byte.toUnsignedInt(pixels[pixel + 1]);
                totalGreen += Byte.toUnsignedInt(pixels[pixel + 2]);
                totalRed += Byte.toUnsignedInt(pixels[pixel + 3]);
                countNonTransparent++;
            }
        }
        final int avgRed = (int) (totalRed / countNonTransparent);
        final int avgGreen = (int) (totalGreen / countNonTransparent);
        final int avgBlue = (int) (totalBlue / countNonTransparent);

        return new Color(avgRed, avgGreen, avgBlue);

    }

    /**
     *
     * @param pixels array containing all pixels in abgrabgr order
     * @return
     */
    protected static int[] getAverageRGBAFromByteArray(final byte[] pixels) {
        byte[] alpha = new byte[pixels.length / 4];
        byte[] blue = new byte[pixels.length / 4];
        byte[] green = new byte[pixels.length / 4];
        byte[] red = new byte[pixels.length / 4];

        for (int i = 0; i < pixels.length; i++) {
            int index = i / 4;
            int channel = i % 4;
            switch (channel) {
                case 0:
                    alpha[index] = pixels[i];
                    break;
                case 1:
                    blue[index] = pixels[i];
                    break;
                case 2:
                    green[index] = pixels[i];
                    break;
                case 3:
                    red[index] = pixels[i];
                    break;
                default:
                    // broken
                    break;
            }
        }

        return getAverageRGBAFromSeparateChannels(red,green,blue,alpha);

    }

    protected static int[] getAverageRGBAFromIntArray(final int[] pixels) {
        return null;
    }

    protected static int[] getAverageRGBAFromSeparateChannels(final byte[] red,
                                                        final byte[] green,
                                                        final byte[] blue,
                                                        final byte[] alpha) {

        int size = red.length;
        if (green.length < size) {
            size = green.length;
        }
        if (blue.length < size) {
            size = blue.length;
        }
        if (alpha.length < size) {
            size = alpha.length;
        }

        int[] avgColour = new int[RGBA_TUPLE_SIZE];
        long totalRed = 0;
        long totalGreen = 0;
        long totalBlue = 0;
        long totalAlpha = 0;
        long count = 0;

        for (int i = 0; i < size; i++) {
            if (alpha[i] != 0) {
                totalRed += Byte.toUnsignedInt(red[i]);
                totalGreen += Byte.toUnsignedInt(green[i]);
                totalBlue += Byte.toUnsignedInt(blue[i]);
                totalAlpha += Byte.toUnsignedInt(alpha[i]);
                count++;
            }
        }
        if (count == 0) {
            count = 1;
        }

        //System.out.println("red="+ totalRed);
        //System.out.println("green="+ totalGreen);
        //System.out.println("blue="+ totalBlue);
        //System.out.println("alpha="+ totalAlpha);

        avgColour[RED_INDEX] = (int) (totalRed / count);
        avgColour[GREEN_INDEX] = (int) (totalGreen / count);
        avgColour[BLUE_INDEX] = (int) (totalBlue / count);
        avgColour[ALPHA_INDEX] = (int) (totalAlpha / count);

        return avgColour;

    }

}
