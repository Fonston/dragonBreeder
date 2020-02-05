package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import javax.swing.*;
import java.awt.*;

public class ScriptFontSelecter {

    public static Font getScriptFont() {

        JLabel defaultLabel = new JLabel("Hello");
        Font defaultLabelFont  = defaultLabel.getFont();

        int size = (int) (1.25 * defaultLabelFont.getSize());
        Font temp = null; // new Font("Viner Hand ITC", Font.BOLD, size);

        System.out.println("Attempting to get Viner Hand ITC");
        if (temp == null) {

            System.out.println("Couldn't find Viner Hand ITC");
            temp = new Font("Segoe Script Bold", Font.BOLD, size);

            if (temp == null) {
                System.out.println("Couldn't find Segoe Script Bold");
                temp = defaultLabelFont;
            }
        }

        return temp;

    }
}
