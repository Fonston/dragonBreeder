package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import javax.swing.*;
import java.awt.*;

/**
 * This label extends JLabel but uses the "Viner Hand ITC" font instead of the
 * default font if possible.  Where unavailable the default font is used
 *
 * Created by HP DX2400 Custom on 08/05/2017.
 */
public class VLabel extends JLabel {

    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();

    }

    public VLabel (String text) {
        super(text);

        setFont(VINTER_HAND_ITC);

    }

    public VLabel() {
        this("");

        setFont(VINTER_HAND_ITC);

    }

}
