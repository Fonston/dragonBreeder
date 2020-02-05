package dougrowena.games.dragonBreeder.basicui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class RelativeWidthSpring extends Spring {

    private float scaleFactor;
    private Component parent;

    public RelativeWidthSpring(final Component parent,
                               final float scaleFactor) {
        this.parent = parent;
        this.scaleFactor = scaleFactor;
    }


    public int getMinimumValue() {
        return (int) (parent.getWidth() * scaleFactor);
    }

    public int getPreferredValue() {
        return (int) (parent.getWidth() * scaleFactor);
    }

    public int getMaximumValue() {
        return (int) (parent.getWidth() * scaleFactor);
    }

    public int getValue() {
        return (int) (parent.getWidth() * scaleFactor);
    }

    public void setValue(int value) {}
}
