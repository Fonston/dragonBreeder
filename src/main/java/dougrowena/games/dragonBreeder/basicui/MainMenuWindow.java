package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.basicui.utilityComponents.VButton;
import dougrowena.games.dragonBreeder.dragon.Dragon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 29/12/2016.
 */
public class MainMenuWindow extends JDialog {

    public static final String MAIN_MENU_TITLE = "Main Menu";
    public static final String SAVE_TEXT = "Save";
    public static final String LOAD_TEXT = "Load";
    public static final String DELETE_TEXT = "Delete";
    public static final String QUIT_TEXT = "Quit";

    private DragonBreederFrame parent;
    private VButton saveButton;
    private VButton loadButton;
    private VButton deleteButton;
    private VButton quitButton;

    public MainMenuWindow(final DragonBreederFrame parent) {
        super(parent, MAIN_MENU_TITLE, ModalityType.APPLICATION_MODAL);

        this.parent = parent;

        saveButton = new VButton(SAVE_TEXT);
        loadButton = new VButton(LOAD_TEXT);
        deleteButton=new VButton(DELETE_TEXT);
        quitButton = new VButton(QUIT_TEXT);

        setLayout(new GridLayout(4,1));

        add(saveButton);
        add(loadButton);
        add(deleteButton);
        add(quitButton);

    }

}
