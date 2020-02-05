package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 08/05/2017.
 */
public class VTextField extends JTextField{

    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();

    }

    public VTextField() {
        this("");
    }

    public VTextField(String defaultText) {
        super(defaultText);

        setFont(VINTER_HAND_ITC);
        setBackground(new Color(0,0,0,0));
        setHorizontalAlignment(JTextField.CENTER);
    }

}
