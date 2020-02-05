package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 09/05/2017.
 */
public class VButton extends JButton {

    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();
    }

    public VButton(String text) {
        super(text);

        setFont(VINTER_HAND_ITC);
        setFocusPainted(false);
        setContentAreaFilled(false);


    }
}
