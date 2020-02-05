package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.basicui.utilityComponents.VButton;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VComboBox;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VLabel;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VMenuBox;
import dougrowena.games.dragonBreeder.dragon.Age;
import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.dragon.DragonGenomeStats;
import dougrowena.games.dragonBreeder.dragon.Gender;
import dougrowena.games.dragonBreeder.genetics.Breeder;
import dougrowena.games.dragonBreeder.genetics.Genome;
import dougrowena.games.dragonBreeder.genetics.genetypes.DragonGenome;
import dougrowena.games.dragonBreeder.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class DragonBreederPanel extends JPanel  {

    public static final int BORDER_X = 5;
    public static final int BORDER_Y = 25;
    public static final float SPACING_PROPORTION = 0.08f;

    public static final String BANNER_TEXT = "Dragon Breeder";
    public static final String MOTHER_TEXT = "Mother:";
    public static final String FATHER_TEXT = "Father:";
    public static final String ESTIMATE_TEXT = "Estimate:";
    public static final String SHOW_TEXT = "Show";
    private final ActionListener estimateButtonListener;

    // Visible Components
    private VLabel banner;
    private VLabel motherLabel;
    private VLabel fatherLabel;
    private VMenuBox<Dragon> motherList;
    private VMenuBox<Dragon> fatherList;
    private VButton motherShowButton;
    private VButton fatherShowButton;
    private VButton estimateButton;

    // Invisible components
    //private DefaultComboBoxModel<Dragon> motherModel;
    //private DefaultComboBoxModel<Dragon> fatherModel;

    // non-UI fields
    private DragonBreederFrame parent;
    private Player player;

    public DragonBreederPanel(final DragonBreederFrame parent,
                              final Player player) {

        this.parent = parent;
        this.player = player;

        setBackground(new Color(0,0,0,0));
        SpringLayout parentLayout = new SpringLayout();
        setLayout(parentLayout);
        Font[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (int i = 0; i < fonts.length; i++) {
            Font font = fonts[i];

            System.out.println(font.getName());
        }

        // Create the Banner
        banner = new VLabel(BANNER_TEXT);
        Font f = banner.getFont();
        int bigSize = f.getSize() * 2;
        banner.setFont(new Font(f.getName(), Font.PLAIN, bigSize));

        add(banner);
        parentLayout.putConstraint(
                SpringLayout.NORTH, banner, BORDER_Y,
                SpringLayout.NORTH, this);
        parentLayout.putConstraint(
                SpringLayout.WEST, banner, BORDER_X,
                SpringLayout.WEST, this);

        // Create the Panel for specifying parents
        motherLabel = new VLabel(MOTHER_TEXT);
        fatherLabel = new VLabel(FATHER_TEXT);
        motherList = new VMenuBox<>();
        motherList.setMinimumSize(new Dimension(100, 20));
        fatherList = new VMenuBox<>();
        fatherList.setMinimumSize(new Dimension(100, 20));

        updateParentLists();

        add(motherLabel);
        add(motherList);
        add(fatherLabel);
        add(fatherList);

        // Create buttons to show the mother or the father
        motherShowButton = new VButton(SHOW_TEXT);
        motherShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setCurrentDragon(
                        motherList.getSelected());
            }
        });

        fatherShowButton = new VButton(SHOW_TEXT);
        fatherShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setCurrentDragon(
                        fatherList.getSelected());
            }
        });

        add(motherShowButton);
        add(fatherShowButton);


        // Create bottom panel for the Estimate button
        estimateButton = new VButton(ESTIMATE_TEXT);
        //estimateButton.setIcon(new ImageIcon(Imgs.ESTIMATE_BUTTON_IMAGE));
        //estimateButton.setMargin(new Insets(0,0,0,0));
        //estimateButton.setContentAreaFilled(false);
        //estimateButton.setBorderPainted(false);
        //estimateButton.setIcon(new ImageIcon(ESTIMATE_BUTTON_IMAGE));
        add(estimateButton);
        parentLayout.putConstraint(
                SpringLayout.SOUTH, estimateButton, -1 * BORDER_Y,
                SpringLayout.SOUTH, this);
        parentLayout.putConstraint(
                SpringLayout.EAST, estimateButton, -1 * BORDER_X,
                SpringLayout.EAST, this);

        // Create Listeners
        estimateButtonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setCurrentDragon(breedDragons(
                        motherList.getSelected(),
                        fatherList.getSelected()));
            }
        };
        estimateButton.addActionListener(estimateButtonListener);

        parentLayout.putConstraint(
                SpringLayout.NORTH, motherLabel,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, banner
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, motherLabel, BORDER_X,
                SpringLayout.WEST, this);

        parentLayout.putConstraint(
                SpringLayout.NORTH, motherList,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, banner
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, motherList,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.WIDTH, this),
                        SPACING_PROPORTION),
                SpringLayout.EAST, motherLabel
        );

        SpringLayout.Constraints motherListConst =
                parentLayout.getConstraints(motherList);
        motherListConst.setWidth(Spring.constant(100, 100, 100));

        parentLayout.putConstraint(
                SpringLayout.NORTH, motherShowButton,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, banner
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, motherShowButton,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.WIDTH, this),
                        SPACING_PROPORTION),
                SpringLayout.EAST, motherList
        );

        parentLayout.putConstraint(
                SpringLayout.NORTH, fatherLabel,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, motherList
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, fatherLabel, BORDER_X,
                SpringLayout.WEST, this);

        parentLayout.putConstraint(
                SpringLayout.NORTH, fatherList,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, motherList
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, fatherList,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.WIDTH, this),
                        SPACING_PROPORTION),
                SpringLayout.EAST, motherLabel
        );

        SpringLayout.Constraints fatherListConst =
                parentLayout.getConstraints(fatherList);
        fatherListConst.setWidth(Spring.constant(100,100,100));

        parentLayout.putConstraint(
                SpringLayout.NORTH, fatherShowButton,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.HEIGHT, this),
                        SPACING_PROPORTION),
                SpringLayout.SOUTH, motherList
        );
        parentLayout.putConstraint(
                SpringLayout.WEST, fatherShowButton,
                Spring.scale(parentLayout.getConstraint(
                        SpringLayout.WIDTH, this),
                        SPACING_PROPORTION),
                SpringLayout.EAST, fatherList
        );

    }

    public static Dragon breedDragons(
            final Dragon mother,
            final Dragon father) {

        assert (mother != null) : 1;
        assert (mother.getGender() == Gender.FEMALE) : 2;
        assert (father != null) : 3;
        assert (father.getGender() == Gender.MALE) : 4;

        Random r = new Random();
        Gender dragonGender;
        if (r.nextBoolean()) {
            dragonGender = Gender.FEMALE;
        } else {
            dragonGender = Gender.MALE;
        }

        Genome genome = Breeder.breed(mother.getGenes(), father.getGenes());
        DragonGenome dragonGenome = new DragonGenome(
                genome.getGeneSequenceA(),
                genome.getGeneSequenceB());
        DragonGenomeStats stats = new DragonGenomeStats(dragonGenome);

        Dragon newDragon = new Dragon(
                stats,
                "Dragon" + r.nextInt(1000000),
                dragonGender,
                Age.HATCHLING);


        System.out.println("new dragon");
        System.out.print(newDragon.reportString());

        return newDragon;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(
                Imgs.NOTEBOOK_BACK_BOTTOM_LEFT,
                0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void updateParentLists() {

        motherList.replaceItems(player.getFemaleDragons());
        fatherList.replaceItems(player.getMaleDragons());
    }

}
