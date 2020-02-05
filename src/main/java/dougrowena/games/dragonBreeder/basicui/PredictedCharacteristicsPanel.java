package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.basicui.utilityComponents.VButton;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VLabel;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VTextField;
import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.dragon.DragonGenomeStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class PredictedCharacteristicsPanel extends JPanel {

    public static final int X_BORDER = 10;
    public static final int Y_BORDER = 10;
    public static final int X_SPACING = 10;
    public static final int Y_SPACING = 10;
    public static final int FIELD_WIDTH = 40;

    public static final String BANNER_TEXT = "Predicted Characteristics";
    public static final String STRENGTH_TEXT = "Strength:";
    public static final String SPEED_TEXT = "Speed:";
    public static final String INTELLIGENCE_TEXT = "Intelligence:";
    public static final String STAMINA_TEXT = "Stamina:";
    public static final String ARMOUR_TEXT = "Armour:";
    public static final String MAIN_MENU_TEXT = "Main Menu";

    public static final String ARCHIVE_TEXT = "Archive";
    public static final String REMOVE_TEXT = "Remove";
    public static final String INFO_TEXT = "More Info";


    private VLabel bannerLabel;
    private VLabel strengthLabel;
    private VLabel speedLabel;
    private VLabel intelligenceLabel;
    private VLabel staminaLabel;
    private VLabel armourLabel;

    private VLabel strengthField;
    private VLabel speedField;
    private VLabel intelligenceField;
    private VLabel staminaField;
    private VLabel armourField;

    private VButton archiveButton;
    private VButton removeButton;
    private VButton infoButton;

    private VButton mainMenuButton;

    private Dragon currentDragon;
    private DragonBreederFrame parent;

    public PredictedCharacteristicsPanel(final DragonBreederFrame parent) {

        this.parent = parent;

        // initialise
        //setBackground(new Color(250, 220, 180));
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        currentDragon = null;

        // Create objects
        bannerLabel = new VLabel(BANNER_TEXT);
        strengthLabel = new VLabel(STRENGTH_TEXT);
        strengthField = new VLabel();
        speedLabel = new VLabel(SPEED_TEXT);
        speedField = new VLabel();
        intelligenceLabel = new VLabel(INTELLIGENCE_TEXT);
        intelligenceField = new VLabel();
        staminaLabel = new VLabel(STAMINA_TEXT);
        staminaField = new VLabel();
        armourLabel = new VLabel(ARMOUR_TEXT);
        armourField = new VLabel();
        mainMenuButton = new VButton(MAIN_MENU_TEXT);

        archiveButton = new VButton(ARCHIVE_TEXT);
        removeButton = new VButton(REMOVE_TEXT);
        infoButton = new VButton(INFO_TEXT);

        archiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object returnObject = JOptionPane.showInputDialog(
                        parent,
                        "Name this Dragon:",
                        "Archive a Dragon",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null
                ).toString();

                if (returnObject != null) {
                    String name = returnObject.toString();
                    currentDragon.setName(name);
                    parent.addDragon(currentDragon);
                    parent.updateParentLists();
                }

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        parent,
                        "Are you sure you want to remove " + currentDragon.getName(),
                        "Remove Dragon?",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {
                    parent.removeDragon(currentDragon);
                    parent.updateParentLists();
                    parent.setCurrentDragon(null);
                }
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (currentDragon == null) {
                    return;
                }

                String report = currentDragon.reportString();
                JTextArea textArea = new JTextArea(report);
                Font oldFont = textArea.getFont();
                textArea.setFont(new Font(
                        "Courier New", Font.PLAIN, oldFont.getSize()));

                JOptionPane.showMessageDialog(
                        parent,
                        textArea,
                        "Dragon Info",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });



        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuWindow mmw = new MainMenuWindow(parent);
                mmw.setVisible(true);
            }
        });

        // add them

        add(bannerLabel);
        Font f = bannerLabel.getFont();
        int bigSize = f.getSize() * 2;
        bannerLabel.setFont(new Font(f.getName(), Font.PLAIN, bigSize));
        add(archiveButton);
        add(removeButton);
        add(infoButton);
        add(strengthLabel);
        add(strengthField);
        add(speedLabel);
        add(speedField);
        add(intelligenceLabel);
        add(intelligenceField);
        add(staminaLabel);
        add(staminaField);
        add(armourLabel);
        add(armourField);
        add(mainMenuButton);

        // Extract the relevant constraints obejcts.
        SpringLayout.Constraints archiveConstraints =
                layout.getConstraints(archiveButton);
        SpringLayout.Constraints removeConstraints =
                layout.getConstraints(removeButton);
        SpringLayout.Constraints infoConstraints =
                layout.getConstraints(infoButton);
        SpringLayout.Constraints bannerConstraints =
                layout.getConstraints(bannerLabel);
        SpringLayout.Constraints strengthLabelConstraints =
                layout.getConstraints(strengthLabel);
        SpringLayout.Constraints strengthFieldConstraints =
                layout.getConstraints(strengthField);
        SpringLayout.Constraints speedLabelConstraints =
                layout.getConstraints(speedLabel);
        SpringLayout.Constraints speedFieldConstraints =
                layout.getConstraints(speedField);
        SpringLayout.Constraints intelligenceLabelConstraints =
                layout.getConstraints(intelligenceLabel);
        SpringLayout.Constraints intelligenceFieldConstraints =
                layout.getConstraints(intelligenceField);
        SpringLayout.Constraints staminaLabelConstraints =
                layout.getConstraints(staminaLabel);
        SpringLayout.Constraints staminaFieldConstraints =
                layout.getConstraints(staminaField);
        SpringLayout.Constraints armourLabelConstraints =
                layout.getConstraints(armourLabel);
        SpringLayout.Constraints armourFieldConstraints =
                layout.getConstraints(armourField);
        //SpringLayout.Constraints mainMenuButtonConstraints =
        //        layout.getConstraints(mainMenuButton);

        Spring subBannerYConstraint; // Point below the banner
        Spring subTopButtonsYConstraint; // Point below top buttons
        Spring col1XConstraint; // Align left of col1 here
        Spring col2XConstraint; // Align left of col2 here
        Spring col3XConstraint; // Align left of col3 here
        Spring col4XConstraint; // Align left of col4 here
        Spring col5XConstraint; // Align left of col5 here
        Spring col6XConstraint; // Align left of col6 here
        Spring col7XConstraint; // Align left of col7 here


        // configure their placement
        layout.putConstraint(SpringLayout.EAST,  archiveButton, -5, SpringLayout.EAST,  this);
        archiveConstraints.setY(Spring.constant(Y_BORDER));

        removeConstraints.setConstraint(SpringLayout.EAST, Spring.sum(
                Spring.constant(-1 * X_BORDER),
                archiveConstraints.getX())
        );
        removeConstraints.setY(Spring.constant(Y_BORDER));

        infoConstraints.setConstraint(SpringLayout.EAST, Spring.sum(
                Spring.constant(-1 * X_BORDER),
                removeConstraints.getX())
        );
        infoConstraints.setY(Spring.constant(Y_BORDER));
        subTopButtonsYConstraint = Spring.sum(
                Spring.sum(
                        archiveConstraints.getY(),
                        archiveConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        );

        bannerConstraints.setX(Spring.constant(X_BORDER));
        bannerConstraints.setY(Spring.constant(Y_BORDER));
        subBannerYConstraint = Spring.sum(
                Spring.sum(
                        bannerConstraints.getY(),
                        bannerConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        );

        strengthLabelConstraints.setX(Spring.constant(X_BORDER));
        strengthLabelConstraints.setY(subBannerYConstraint);
        speedLabelConstraints.setX(Spring.constant(X_BORDER));
        speedLabelConstraints.setY(Spring.sum(
                Spring.sum(
                        strengthLabelConstraints.getY(),
                        strengthLabelConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        ));
        col2XConstraint = Spring.sum(
                Spring.max(
                        Spring.sum(
                                strengthLabelConstraints.getX(),
                                strengthLabelConstraints.getWidth()
                        ),
                        Spring.sum(
                                speedLabelConstraints.getX(),
                                speedLabelConstraints.getWidth())
                ),
                Spring.constant(X_SPACING)
        );

        strengthFieldConstraints.setX(col2XConstraint);
        strengthFieldConstraints.setY(subBannerYConstraint);
        strengthFieldConstraints.setWidth(Spring.constant(FIELD_WIDTH));
        speedFieldConstraints.setX(col2XConstraint);
        speedFieldConstraints.setY(Spring.sum(
                Spring.sum(
                        strengthFieldConstraints.getY(),
                        strengthFieldConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        ));
        speedFieldConstraints.setWidth(Spring.constant(FIELD_WIDTH));
        col3XConstraint = Spring.sum(
                Spring.max(
                        Spring.sum(
                                strengthFieldConstraints.getX(),
                                strengthFieldConstraints.getWidth()
                        ),
                        Spring.sum(
                                speedFieldConstraints.getX(),
                                speedFieldConstraints.getWidth())
                ),
                Spring.constant(X_SPACING)
        );

        intelligenceLabelConstraints.setX(col3XConstraint);
        intelligenceLabelConstraints.setY(subBannerYConstraint);
        staminaLabelConstraints.setX(col3XConstraint);
        staminaLabelConstraints.setY(Spring.sum(
                Spring.sum(
                        intelligenceLabelConstraints.getY(),
                        intelligenceLabelConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        ));

        col4XConstraint = Spring.sum(
                Spring.max(
                        Spring.sum(
                                intelligenceLabelConstraints.getX(),
                                intelligenceLabelConstraints.getWidth()
                        ),
                        Spring.sum(
                                staminaLabelConstraints.getX(),
                                staminaLabelConstraints.getWidth())
                ),
                Spring.constant(X_SPACING)
        );

        intelligenceFieldConstraints.setX(col4XConstraint);
        intelligenceFieldConstraints.setY(subBannerYConstraint);
        intelligenceFieldConstraints.setWidth(Spring.constant(FIELD_WIDTH));
        staminaFieldConstraints.setX(col4XConstraint);
        staminaFieldConstraints.setY(Spring.sum(
                Spring.sum(
                        intelligenceFieldConstraints.getY(),
                        intelligenceFieldConstraints.getHeight()
                ),
                Spring.constant(Y_SPACING)
        ));
        staminaFieldConstraints.setWidth(Spring.constant(FIELD_WIDTH));

        col5XConstraint = Spring.sum(
                Spring.max(
                        Spring.sum(
                                intelligenceFieldConstraints.getX(),
                                intelligenceFieldConstraints.getWidth()
                        ),
                        Spring.sum(
                                staminaFieldConstraints.getX(),
                                staminaFieldConstraints.getWidth())
                ),
                Spring.constant(X_SPACING)
        );

        armourLabelConstraints.setX(col5XConstraint);
        armourLabelConstraints.setY(subBannerYConstraint);

        col6XConstraint = Spring.sum(
                Spring.sum(
                        armourLabelConstraints.getX(),
                        armourLabelConstraints.getWidth()
                ),
                Spring.constant(X_SPACING)
        );

        armourFieldConstraints.setY(subBannerYConstraint);
        armourFieldConstraints.setX(col6XConstraint);
        armourFieldConstraints.setWidth(Spring.constant(FIELD_WIDTH));

        col7XConstraint = Spring.sum(
                Spring.sum(
                        armourFieldConstraints.getX(),
                        armourFieldConstraints.getWidth()
                ),
                Spring.constant(X_SPACING)
        );

        layout.putConstraint(SpringLayout.SOUTH, mainMenuButton, -5, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST,  mainMenuButton, -5, SpringLayout.EAST,  this);

        // initialise dragon to null
        setCurrentDragon(null);

    }

    public void setCurrentDragon(final Dragon currentDragon) {
        this.currentDragon = currentDragon;

        if (currentDragon == null) {
            strengthField.setText("-");
            speedField.setText("-");
            intelligenceField.setText("-");
            staminaField.setText("-");
            armourField.setText("-");
        } else {
            DragonGenomeStats stats = currentDragon.getGenome();
            strengthField.setText("" + stats.getStrength());
            speedField.setText("" + stats.getSpeed());
            intelligenceField.setText("" + stats.getIntelligence());
            staminaField.setText("" + stats.getStamina());
            armourField.setText("" + stats.getArmour());
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(
                Imgs.NOTEBOOK_BACK_BOTTOM_RIGHT,
                0, 0, this.getWidth(), this.getHeight(), this);
    }

}
