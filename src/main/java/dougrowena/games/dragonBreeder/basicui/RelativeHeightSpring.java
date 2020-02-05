package dougrowena.games.dragonBreeder.basicui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.RasterFormatException;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class RelativeHeightSpring extends Spring {

    private float scaleFactor;
    private Component parent;

    public RelativeHeightSpring(final Component parent,
                                final float scaleFactor) {
        this.parent = parent;
        this.scaleFactor = scaleFactor;

    }


    public int getMinimumValue() {
        return (int) ((parent.getHeight() - 20) * scaleFactor);
    }

    public int getPreferredValue() {
        return (int) ((parent.getHeight() - 20) * scaleFactor);
    }

    public int getMaximumValue() {
        return (int) ((parent.getHeight() - 20) * scaleFactor);
    }

    public int getValue() {
        return (int) ((parent.getHeight() - 20) * scaleFactor);
    }

    public void setValue(int value) {}

}
