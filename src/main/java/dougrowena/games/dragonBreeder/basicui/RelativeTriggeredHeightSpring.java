package dougrowena.games.dragonBreeder.basicui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class RelativeTriggeredHeightSpring extends Spring
        implements PrepaintListener, ComponentListener {

    private float scaleFactor;
    private Component parent;
    private float height;

    public RelativeTriggeredHeightSpring(final Component parent,
                                         final float scaleFactor) {

        //System.out.println("RelativeHeightSpring to be constructed");
        this.parent = parent;
        this.scaleFactor = scaleFactor;

        this.height = (float) parent.getHeight();
        //System.out.println("RelativeHeightSpring constructed");

    }


    //public int getMinimumValue() { return (int) (parent.getHeight() * scaleFactor);}
    public int getMinimumValue() { return (int) (height * scaleFactor);}

    public int getPreferredValue() {
        return (int) (height * scaleFactor);
    }

    public int getMaximumValue() {
        return (int) (height * scaleFactor);
    }

    public int getValue() {
        return (int) (height * scaleFactor);
    }

    public void setValue(int value) {}

    public void paintImminent(Component c) {
        height = parent.getHeight();

    }

    public void componentResized(ComponentEvent e) {
        System.out.println("componentResized - parent.getHeight()=" +
                parent.getHeight());

        try {
            throw new RuntimeException();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        height = parent.getHeight();
    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {

    }

    public void componentHidden(ComponentEvent e) {

    }
}
