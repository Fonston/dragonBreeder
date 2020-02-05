package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.basicui.utilityComponents.VButton;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VLabel;
import dougrowena.games.dragonBreeder.basicui.utilityComponents.VMenuBox;
import dougrowena.games.dragonBreeder.dragon.Age;
import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.dragon.DragonGenomeStats;
import dougrowena.games.dragonBreeder.dragon.Gender;
import dougrowena.games.dragonBreeder.genetics.Gene;
import dougrowena.games.dragonBreeder.genetics.genetypes.BodyPlanGene;
import dougrowena.games.dragonBreeder.genetics.genetypes.DragonGenome;
import dougrowena.games.dragonBreeder.genetics.genetypes.PatternGene;
import dougrowena.games.dragonBreeder.genetics.genetypes.StripeColourGene;
import dougrowena.games.dragonBreeder.genetics.genomegenerators.KomodyteGenerator;
import dougrowena.games.dragonBreeder.genetics.phenotype.BaseColourPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.StripeColourPhenotype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class DragonDesignerPanel extends JPanel {

    public static final float FIELD_SPACING_PROPORTION_Y = 0.06f;
    public static final float FIELD_SPACING_PROPORTION_X = 0.1f;

    public static final int BORDER_Y = 10;
    public static final int BORDER_X = 10;

    public static final int FIELD_WIDTH = 120;

    public static final String BANNER_TEXT = "Dragon Designer";
    public static final String BREED_TEXT = "Breed:";
    public static final String AGE_TEXT = "Age:";
    public static final String COLOUR_TEXT = "Colour:";
    public static final String PATTERN_TEXT = "Pattern:";
    public static final String PATTERN_COLOUR_TEXT = "Pattern Colour:";
    public static final String ESTIMATE_TEXT = "Estimate:";

    private VLabel bannerLabel;
    private VLabel breedLabel;
    private VLabel ageLabel;
    private VLabel colourLabel;
    private VLabel patternLabel;
    private VLabel patternColourLabel;

    private VMenuBox<BodyPlanGene> breedBox;
    private VMenuBox<Age> ageBox;
    private VMenuBox<BaseColourPhenotype> colourBox;
    private VMenuBox<PatternGene> patternBox;
    private VMenuBox<StripeColourPhenotype> patternColourBox;
    private VButton estimateButton;

    //private DefaultComboBoxModel<BodyPlanGene> breedModel;
    //private DefaultComboBoxModel<Age> ageModel;
    //private DefaultComboBoxModel<BaseColourPhenotype> colourModel;
    //private DefaultComboBoxModel<PatternGene> patternModel;

    private HashSet<PrepaintListener> prepaintListeners;
    private ActionListener estimateButtonListener;
    private DragonBreederFrame parent;


    public DragonDesignerPanel(final DragonBreederFrame parent) {

        // Initialisation
        this.parent = parent;
        prepaintListeners = new HashSet<PrepaintListener>();

        // Create panel

        setLayout(new BorderLayout());

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        // Create contents
        bannerLabel = new VLabel(BANNER_TEXT);
        Font f = bannerLabel.getFont();
        int bigSize = (int) (f.getSize() * 2);
        bannerLabel.setFont(new Font(f.getName(), Font.PLAIN, bigSize));
        breedLabel = new VLabel(BREED_TEXT);
        ageLabel = new VLabel(AGE_TEXT);
        colourLabel = new VLabel(COLOUR_TEXT);
        patternLabel = new VLabel(PATTERN_TEXT);
        patternColourLabel = new VLabel(PATTERN_COLOUR_TEXT);

        breedBox = new VMenuBox();
        breedBox.setMinimumSize(new Dimension(100, 20));
        ageBox = new VMenuBox<>();
        ageBox.setMinimumSize(new Dimension(100, 20));

        colourBox = new VMenuBox<>();
        colourBox.setMinimumSize(new Dimension(100, 20));
        patternBox = new VMenuBox<>();
        patternBox.setMinimumSize(new Dimension(100, 20));
        patternColourBox = new VMenuBox<>();
        patternColourBox.setMinimumSize(new Dimension(100,20));
        estimateButton = new VButton(ESTIMATE_TEXT);


        // Create data models
        breedBox.replaceItems(Arrays.asList(BodyPlanGene.KNOWN_BODY_PLANS));
        ageBox.replaceItems(Arrays.asList(Age.values()));
        colourBox.replaceItems(Arrays.asList(BaseColourPhenotype.KNOWN_TYPES));
        patternBox.replaceItems(Arrays.asList(PatternGene.KNOWN_PATTERNS));
        patternColourBox.replaceItems(Arrays.asList(StripeColourPhenotype.KNOWN_TYPES));

        // Create Listeners
        estimateButtonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setCurrentDragon(generateRandomDragon());
            }
        };
        estimateButton.addActionListener(estimateButtonListener);

        // Add contents
        add(bannerLabel);
        add(breedLabel);
        add(breedBox);
        add(ageLabel);
        add(ageBox);
        add(colourLabel);
        add(colourBox);
        add(patternLabel);
        add(patternBox);
        add(patternColourLabel);
        add(patternColourBox);
        add(estimateButton, BorderLayout.EAST);

        // Lay out contents

        layout.putConstraint(
                SpringLayout.NORTH, bannerLabel, BORDER_Y,
                SpringLayout.NORTH, this);
        layout.putConstraint(
                SpringLayout.WEST, bannerLabel, BORDER_X,
                SpringLayout.WEST, this);

        Spring spacingY = Spring.scale(
                layout.getConstraint(SpringLayout.HEIGHT, this),
                FIELD_SPACING_PROPORTION_Y
        );
        Spring spacingX = Spring.scale(
                layout.getConstraint(SpringLayout.WIDTH, this),
                FIELD_SPACING_PROPORTION_X
        );

        layout.putConstraint(SpringLayout.NORTH, breedLabel,
                spacingY,
                SpringLayout.SOUTH, bannerLabel);
        layout.putConstraint(
                SpringLayout.WEST, breedLabel, BORDER_X,
                SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, ageLabel,
                relativeToFurthestY(layout,spacingY, new Component[]{breedBox, breedLabel}),
                SpringLayout.NORTH, breedLabel);
        layout.putConstraint(
                SpringLayout.WEST, ageLabel, BORDER_X,
                SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, colourLabel,
                relativeToFurthestY(layout,spacingY, new Component[]{ageBox, ageLabel}),
                SpringLayout.NORTH, ageLabel);
        layout.putConstraint(
                SpringLayout.WEST, colourLabel, BORDER_X,
                SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, patternLabel,
                relativeToFurthestY(layout,spacingY, new Component[]{colourBox, colourLabel}),
                SpringLayout.NORTH, colourLabel);
        layout.putConstraint(
                SpringLayout.WEST, patternLabel, BORDER_X,
                SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, patternColourLabel,
                relativeToFurthestY(layout,spacingY, new Component[]{patternBox, patternLabel}),
                SpringLayout.NORTH, patternLabel);
        layout.putConstraint(
                SpringLayout.WEST, patternColourLabel, BORDER_X,
                SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, breedBox,
                spacingY,
                SpringLayout.SOUTH, bannerLabel);
        layout.putConstraint(
                SpringLayout.WEST, breedBox,
                spacingX,
                SpringLayout.EAST, patternColourLabel);
        layout.putConstraint(SpringLayout.WIDTH, breedBox, FIELD_WIDTH, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, ageBox,
                relativeToFurthestY(layout,spacingY, new Component[]{breedBox, breedLabel}),
                SpringLayout.NORTH, breedLabel);
        layout.putConstraint(
                SpringLayout.WEST, ageBox,
                spacingX,
                SpringLayout.EAST, patternColourLabel);
        layout.putConstraint(SpringLayout.WIDTH, ageBox, FIELD_WIDTH, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, colourBox,
                relativeToFurthestY(layout,spacingY, new Component[]{ageBox, ageLabel}),
                SpringLayout.NORTH, ageLabel);
        layout.putConstraint(
                SpringLayout.WEST, colourBox,
                spacingX,
                SpringLayout.EAST, patternColourLabel);
        layout.putConstraint(SpringLayout.WIDTH, colourBox, FIELD_WIDTH, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, patternBox,
                relativeToFurthestY(layout,spacingY, new Component[]{colourBox, colourLabel}),
                SpringLayout.NORTH, colourLabel);
        layout.putConstraint(
                SpringLayout.WEST, patternBox,
                spacingX,
                SpringLayout.EAST, patternColourLabel);
        layout.putConstraint(SpringLayout.WIDTH, patternBox, FIELD_WIDTH, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, patternColourBox,
                relativeToFurthestY(layout,spacingY, new Component[]{patternBox, patternLabel}),
                SpringLayout.NORTH, patternLabel);
        layout.putConstraint(
                SpringLayout.WEST, patternColourBox,
                spacingX,
                SpringLayout.EAST, patternColourLabel);
        layout.putConstraint(SpringLayout.WIDTH, patternColourBox, FIELD_WIDTH, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.SOUTH, estimateButton,
                (-1 * BORDER_Y),
                SpringLayout.SOUTH, this);
        layout.putConstraint(
                SpringLayout.EAST, estimateButton,
                (-1 * BORDER_X),
                SpringLayout.EAST, this);

    }

    @Override
    public void paint(Graphics g) {


        // Send notifications that you're about to repaint
        for (PrepaintListener listener : prepaintListeners) {
            //listener.paintImminent(this);
        }

        // now actually repaint
        super.paint(g);

    }

    public void addPrepaintListener(PrepaintListener listener) {
        prepaintListeners.add(listener);
    }

    public void removePrepaintListener(PrepaintListener listener) {
        prepaintListeners.remove(listener);
    }

    public void clearPrepaintListeners() {
        prepaintListeners.clear();
    }

    public Dragon generateRandomDragon() {

        BodyPlanGene selectedBodyPlan =
                breedBox.getSelected();
                //(BodyPlanGene) breedModel.getSelectedItem();
        BaseColourPhenotype selectedColourType =
                colourBox.getSelected();
                //(BaseColourPhenotype) colourModel.getSelectedItem();
        PatternGene selectedPatternGene =
                patternBox.getSelected();
                //(PatternGene) patternModel.getSelectedItem();
        Age selectedAge =
                ageBox.getSelected();
                //(Age) ageModel.getSelectedItem();
        StripeColourPhenotype selectedStripePhenotype =
                patternColourBox.getSelected();

        if (selectedBodyPlan == BodyPlanGene.KOMODYTE) {
            KomodyteGenerator generator = new KomodyteGenerator();

            DragonGenome genome = generator.generate();
            ArrayList<Gene> geneSequenceA = genome.getGeneSequenceA();
            ArrayList<Gene> geneSequenceB = genome.getGeneSequenceB();

            geneSequenceA.set(DragonGenome.BODY_COLOUR_1_INDEX, selectedColourType.getTypicalGene());
            geneSequenceB.set(DragonGenome.BODY_COLOUR_1_INDEX, selectedColourType.getTypicalGene());

            geneSequenceA.set(DragonGenome.PATTERN_INDEX, selectedPatternGene);
            geneSequenceB.set(DragonGenome.PATTERN_INDEX, selectedPatternGene);

            geneSequenceA.set(DragonGenome.PATTERN_COLOUR_1_INDEX, selectedStripePhenotype.getTypicalGene());
            geneSequenceB.set(DragonGenome.PATTERN_COLOUR_1_INDEX, selectedStripePhenotype.getTypicalGene());

            Random r = new Random();
            Gender gender;
            if (r.nextBoolean()) {
                gender = Gender.FEMALE;
            } else {
                gender = Gender.MALE;
            }

            DragonGenomeStats stats = new DragonGenomeStats(genome);
            Dragon newDragon = new Dragon(stats, "dragon", gender, selectedAge);

            System.out.println("new dragon");
            System.out.println("name: " + newDragon.getName());
            System.out.println("gender: " + newDragon.getGender());
            System.out.println("age: " + newDragon.getAge());
            System.out.println("bodyPlan: " + newDragon.getBodyPlan());
            System.out.println("colour: " + newDragon.getColour());
            System.out.println("pattern: " + newDragon.getPattern());
            System.out.println("feathers: " + newDragon.getFeathers());
            System.out.println("wings: " + newDragon.getWings());

            System.out.println("genomeStats: \n" +
                    newDragon.getGenome().reportGenomeStatistics());

            return newDragon;

        }

        return null;
    }


    @Override
    public void paintComponent(Graphics g) {
        System.out.println("paintComponent - " +
                " width=" + g.getClip().getBounds().getWidth() +
                " height=" + g.getClip().getBounds().getHeight());
        for (PrepaintListener listener : prepaintListeners) {
            listener.paintImminent(this);
        }

        super.paintComponent(g);

        g.drawImage(
                Imgs.NOTEBOOK_BACK_TOP_LEFT,
                0, 0, this.getWidth(), this.getHeight(), this);
    }


    public static Spring relativeToFurthestX(final SpringLayout layout,
                                             final Spring additional,
                                             final Component[] components) {

        final String WIDTH = SpringLayout.WIDTH;

        Spring currentFurthest = Spring.constant(0);

        for (Component component : components) {
            Spring newSpring = layout.getConstraint(WIDTH, component);
            currentFurthest = Spring.max(currentFurthest, newSpring);
        }

        return Spring.sum(additional, currentFurthest);

    }

    public static Spring relativeToFurthestY(final SpringLayout layout,
                                             final Spring additional,
                                             final Component[] components) {

        final String HEIGHT = SpringLayout.HEIGHT;

        Spring currentFurthest = Spring.constant(0);

        for (Component component : components) {
            Spring newSpring = layout.getConstraint(HEIGHT, component);
            currentFurthest = Spring.max(currentFurthest, newSpring);
        }

        return Spring.sum(additional, currentFurthest);

    }
}
