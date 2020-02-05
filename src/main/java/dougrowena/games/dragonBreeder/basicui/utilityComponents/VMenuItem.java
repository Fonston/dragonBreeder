package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import dougrowena.games.dragonBreeder.basicui.Imgs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Douglas Warren
 */
public class VMenuItem<T> extends JMenuItem {

    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();

    }

    private VMenuBox<T> parent;
    private T item;

    public VMenuItem(VMenuBox<T> parent, T item) {
        super(item.toString());

        this.item = item;
        this.parent = parent;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setSelectedItem(item);
            }
        });
        setFont(VINTER_HAND_ITC);
        setBackground(Imgs.NOTEBOOK_BACKGROUND_COLOUR);

    }
}
