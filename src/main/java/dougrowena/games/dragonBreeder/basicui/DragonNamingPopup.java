package dougrowena.games.dragonBreeder.basicui;

import javax.swing.*;

/**
 * Created by HP DX2400 Custom on 27/12/2016.
 */
public class DragonNamingPopup extends JDialog {

    JOptionPane optionPane;

    public DragonNamingPopup() {

        optionPane = new JOptionPane("Name this Dragon:",
                                     JOptionPane.PLAIN_MESSAGE,
                                     JOptionPane.OK_CANCEL_OPTION,
                                     null,
                                     null
                );
    }
}
