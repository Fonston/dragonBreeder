package dougrowena.games.dragonBreeder.basicui;

import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.util.Hashtable;

/**
 * Created by HP DX2400 Custom on 11/09/2016.
 */
public class GrabberConsumer implements ImageConsumer {

    public int width;
    public int height;
    public Hashtable properties;
    public ColorModel model;
    public int hintFlags;
    public int x;
    public int y;
    public int off;
    public int scansize;

    public int[] intPixels = null;
    public byte[] bytePixels = null;

    public boolean complete = false;
    public int status;

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setProperties(Hashtable<?, ?> props) {
        this.properties = props;
    }

    public void setColorModel(ColorModel model) {
        this.model = model;
    }

    public void setHints(int hintflags) {
        this.hintFlags = hintflags;
    }

    public void setPixels(int x, int y, int w, int h, ColorModel model, byte[] pixels, int off, int scansize) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.model = model;
        this.bytePixels = pixels;
        this.off = off;
        this.scansize = scansize;
    }

    public void setPixels(int x, int y, int w, int h, ColorModel model, int[] pixels, int off, int scansize) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.model = model;
        this.intPixels = pixels;
        this.off = off;
        this.scansize = scansize;

    }

    public void imageComplete(int status) {
        this.status = status;
    }

}
