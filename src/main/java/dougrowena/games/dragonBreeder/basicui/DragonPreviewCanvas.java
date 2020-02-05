package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.dragon.Age;
import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.genetics.genetypes.BodyPlanGene;
import dougrowena.games.dragonBreeder.genetics.genetypes.PatternGene;
import dougrowena.games.dragonBreeder.genetics.phenotype.BaseColourPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.StripeColourPhenotype;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 01/09/2016.
 */
public class DragonPreviewCanvas extends JPanel {

    public static final int X_BORDER = 5;
    public static final int Y_BORDER = 5;

    public static final String ARCHIVE_TEXT = "Archive";
    public static final String REMOVE_TEXT = "Remove";
    public static final String INFO_TEXT = "More Info";

    public static final int BACKGROUND_INDEX = 0;
    public static final int COLOUR_INDEX = 1;
    public static final int PATTERN_INDEX = 2;
    public static final int LINEART_INDEX = 3;
    public static final int IMAGE_ARRAY_SIZE = 4;

    private Image[] currentImages;
    private DragonBreederFrame parent;
    private Dragon dragon;

    //private VButton archiveButton;
    //private VButton removeButton;
    //private VButton infoButton;
    private JComboBox<Font> fontPicker;

    public DragonPreviewCanvas(final DragonBreederFrame parent) {

        assert (parent != null) : 1;

        this.parent = parent;

        /*
        archiveButton = new VButton(ARCHIVE_TEXT);
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
                    dragon.setName(name);
                    parent.addDragon(dragon);
                    parent.updateParentLists();
                }

            }
        });

        removeButton = new VButton(REMOVE_TEXT);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        parent,
                        "Are you sure you want to remove " + dragon.getName(),
                        "Remove Dragon?",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {
                    parent.removeDragon(dragon);
                    parent.updateParentLists();
                    parent.setCurrentDragon(null);
                }
            }
        });

        infoButton = new VButton(INFO_TEXT);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dragon == null) {
                    return;
                }

                String report = dragon.reportString();
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
        */


        Font[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        JLabel[] fontLabels = new JLabel[fonts.length];
        for (int i = 0; i < fonts.length; i++ ){
            fontLabels[i] = new JLabel(fonts[i].getName());
            fontLabels[i].setFont(fonts[i]);
        }

        fontPicker = new JComboBox<>(fonts);
        fontPicker.setRenderer(new ComboBoxRenderer());


        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        //add(archiveButton);
        //add(removeButton);
        //add(infoButton);
        //add(fontPicker);

        /*
        layout.putConstraint(SpringLayout.SOUTH, archiveButton,
                (-1 * Y_BORDER),
                SpringLayout.SOUTH, this);
        layout.putConstraint(
                SpringLayout.EAST, archiveButton,
                (-1 * X_BORDER),
                SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, removeButton,
                (-1 * Y_BORDER),
                SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, removeButton,
                (-1 * X_BORDER),
                SpringLayout.WEST, archiveButton);
        layout.putConstraint(SpringLayout.SOUTH, infoButton,
                (-1 * Y_BORDER),
                SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, infoButton,
                (-1 * X_BORDER),
                SpringLayout.WEST, removeButton);
        */
        /*
        layout.putConstraint(SpringLayout.SOUTH, fontPicker,
                (-1 * Y_BORDER),
                SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, fontPicker,
                (-1 * X_BORDER),
                SpringLayout.WEST, infoButton);
        */



        setDragon(null);
        this.currentImages = getCurrentImages();

    }

    class ComboBoxRenderer extends JLabel
            implements ListCellRenderer<Font> {

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        public Component getListCellRendererComponent(
                JList list,
                Font value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            Font font = new Font(value.getName(), Font.PLAIN, 16);
            setText(font.getName());
            setFont(font);


            return this;
        }

    }

    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        int width = (int) graphics.getClip().getBounds().width;
        int height = (int) (graphics.getClip().getBounds().height);

        int tweakedWidth = width;
        int tweakedHeight = height;

        if (((double)width / Imgs.REFERENCE_WIDTH_HEIGHT_RATIO) > height) {
            tweakedWidth = (int) (height * Imgs.REFERENCE_WIDTH_HEIGHT_RATIO);
        } else if (((double)height * Imgs.REFERENCE_WIDTH_HEIGHT_RATIO) > width) {
            tweakedHeight = (int) (width / Imgs.REFERENCE_WIDTH_HEIGHT_RATIO);
        }


        for (int i = 0; i < currentImages.length; i++) {
            Image image = currentImages[i];
            if (image != null) {
                image = image.getScaledInstance(tweakedWidth, tweakedHeight, Image.SCALE_AREA_AVERAGING);
            }

            if (image != null) {
                if ( i == BACKGROUND_INDEX) {
                    graphics.drawImage(image, 0, 0, width, height, this);
                } else {
                    float scaleFactor;
                    if (dragon.getAge() == Age.ADULT) {
                        scaleFactor = 1.0f;
                    } else if (dragon.getAge() == Age.ADOLESCENT) {
                        scaleFactor = 0.75f;
                    } else {
                        scaleFactor = 0.5f;
                    }

                    int scaledWidth = (int) (tweakedWidth * scaleFactor);
                    int scaledHeight = (int) (tweakedHeight * scaleFactor);
                    int scaledX = (width - scaledWidth ) / 2;
                    int scaledY = (height - scaledHeight ) / 2;

                    graphics.drawImage(
                            image, scaledX, scaledY,
                            scaledWidth, scaledHeight, this);

                }
            }
        }

    }

    public void setDragon(final Dragon dragon) {
        if (dragon == this.dragon) {
            return;
        }

        this.dragon = dragon;
        this.currentImages = getCurrentImages();

        repaint();

    }

    private Image[] getCurrentImages() {
        if (dragon == null) {
            return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
        } else if (dragon.getBodyPlan() == BodyPlanGene.KOMODYTE) {
            Image[] dragonImages = new Image[IMAGE_ARRAY_SIZE];

            dragonImages[BACKGROUND_INDEX] = Imgs.NOTEBOOK_BACK_TOP_RIGHT;
            BaseColourPhenotype baseColourPhenotype = dragon.getColour();
            StripeColourPhenotype patternBaseColourPhenotype = dragon.getPatternColour();
            PatternGene patternGene = dragon.getPattern();
            Age age = dragon.getAge();
            if (age == Age.HATCHLING) {
                dragonImages[LINEART_INDEX] = Imgs.HATCHLING_BASIC;
                dragonImages[COLOUR_INDEX] =
                        Imgs.HATCHLING_BASE_COLOURS.get(baseColourPhenotype);
                //if (baseColourPhenotype == BaseColourPhenotype.BROWN) {
                //    dragonImages[COLOUR_INDEX] = Imgs.HATCHLING_BROWN;
                //} else if (baseColourPhenotype == BaseColourPhenotype.SLATE) {
                //    dragonImages[COLOUR_INDEX] = Imgs.HATCHLING_SLATE;
                //} else if (baseColourPhenotype == BaseColourPhenotype.GREY) {
                //    dragonImages[COLOUR_INDEX] = Imgs.HATCHLING_GREY;
                //} else if (baseColourPhenotype == BaseColourPhenotype.WHITE) {
                //    dragonImages[COLOUR_INDEX] = Imgs.HATCHLING_WHITE;
                //} else {
                //    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                //}

                if (patternGene == PatternGene.DARK_POINTS) {
                    dragonImages[PATTERN_INDEX] = Imgs.HATCHLING_DARK_POINTS;
                } else if (patternGene == PatternGene.SPOTS){
                    dragonImages[PATTERN_INDEX] = Imgs.HATCHLING_SPOTS;
                } else if (patternGene == PatternGene.STRIPES) {
                    //dragonImages[PATTERN_INDEX] = Imgs.HATCHLING_STRIPES;
                    dragonImages[PATTERN_INDEX] =
                            Imgs.HATCHLING_STRIPE_COLOURS.get(patternBaseColourPhenotype);
                } else if (patternGene == PatternGene.PLAIN) {
                    dragonImages[PATTERN_INDEX] = null; // no pattern
                } else {
                    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                }

            } else if (age == Age.ADOLESCENT) {
                dragonImages[LINEART_INDEX] = Imgs.JUVENILE_BASIC;
                dragonImages[COLOUR_INDEX] =
                        Imgs.JUVENILE_BASE_COLOURS.get(baseColourPhenotype);
                /*
                if (baseColourPhenotype == BaseColourPhenotype.BROWN) {
                    dragonImages[COLOUR_INDEX] = Imgs.JUVENILE_BROWN;
                } else if (baseColourPhenotype == BaseColourPhenotype.SLATE) {
                    dragonImages[COLOUR_INDEX] = Imgs.JUVENILE_SLATE;
                } else if (baseColourPhenotype == BaseColourPhenotype.GREY) {
                    dragonImages[COLOUR_INDEX] = Imgs.JUVENILE_GREY;
                } else if (baseColourPhenotype == BaseColourPhenotype.WHITE) {
                    dragonImages[COLOUR_INDEX] = Imgs.JUVENILE_WHITE;
                } else {
                    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                }
                */

                if (patternGene == PatternGene.DARK_POINTS) {
                    dragonImages[PATTERN_INDEX] = Imgs.JUVENILE_DARK_POINTS;
                } else if (patternGene == PatternGene.SPOTS){
                    dragonImages[PATTERN_INDEX] = Imgs.JUVENILE_SPOTS;
                } else if (patternGene == PatternGene.STRIPES) {
                    //dragonImages[PATTERN_INDEX] = Imgs.JUVENILE_STRIPES;
                    dragonImages[PATTERN_INDEX] =
                            Imgs.JUVENILE_STRIPE_COLOURS.get(patternBaseColourPhenotype);
                } else if (patternGene == PatternGene.PLAIN) {
                    dragonImages[PATTERN_INDEX] = null; // no pattern
                } else {
                    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                }

            } else if (age == Age.ADULT) {
                dragonImages[LINEART_INDEX] = Imgs.ADULT_BASIC;
                dragonImages[COLOUR_INDEX] =
                        Imgs.ADULT_BASE_COLOURS.get(baseColourPhenotype);
                /*
                if (baseColourPhenotype == BaseColourPhenotype.BROWN) {
                    dragonImages[COLOUR_INDEX] = Imgs.ADULT_BROWN;
                } else if (baseColourPhenotype == BaseColourPhenotype.SLATE) {
                    dragonImages[COLOUR_INDEX] = Imgs.ADULT_SLATE;
                } else if (baseColourPhenotype == BaseColourPhenotype.GREY) {
                    dragonImages[COLOUR_INDEX] = Imgs.ADULT_GREY;
                } else if (baseColourPhenotype == BaseColourPhenotype.WHITE) {
                    dragonImages[COLOUR_INDEX] = Imgs.ADULT_WHITE;
                } else {
                    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                }
                */

                if (patternGene == PatternGene.DARK_POINTS) {
                    dragonImages[PATTERN_INDEX] = Imgs.ADULT_DARK_POINTS;
                } else if (patternGene == PatternGene.SPOTS){
                    dragonImages[PATTERN_INDEX] = Imgs.ADULT_SPOTS;
                } else if (patternGene == PatternGene.STRIPES) {
                    //dragonImages[PATTERN_INDEX] = Imgs.ADULT_STRIPES;
                    dragonImages[PATTERN_INDEX] =
                            Imgs.ADULT_STRIPE_COLOURS.get(patternBaseColourPhenotype);
                } else if (patternGene == PatternGene.PLAIN) {
                    dragonImages[PATTERN_INDEX] = null; // no pattern
                } else {
                    return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
                }
            } else {
                return new Image[] {Imgs.NOTEBOOK_BACK_TOP_RIGHT};
            }

            return dragonImages;
        } else {
            return new Image[]{Imgs.NOTEBOOK_BACK_TOP_RIGHT};
        }
    }

}
