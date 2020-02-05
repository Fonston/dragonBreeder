package dougrowena.games.dragonBreeder.basicui;

import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.genetics.genomegenerators.KomodyteGenerator;
import dougrowena.games.dragonBreeder.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class DragonBreederFrame extends JFrame {

    public static final String TITLE = "Dragon Breeder";
    private final DragonBreederPanel breederPanel;
    private final DragonDesignerPanel designerPanel;
    private final PredictedCharacteristicsPanel characteristicsPanel;
    //private final PreviewPanel previewPanel;
    private final DragonPreviewCanvas previewCanvas;

    private Dragon currentDragon;
    private Player player;

    public static void main (String[] args) {

        Player player = new Player("Test");
        player.addDragon(KomodyteGenerator.REX);
        player.addDragon(KomodyteGenerator.RUBY);

        DragonBreederFrame frame = new DragonBreederFrame(player);

        frame.setVisible(true);
        //frame.show();

    }


    public DragonBreederFrame(final Player player) {
        super(TITLE);

        assert (player != null) : 1;

        this.player = player;

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        setSize(1300, 700);
        //setResizable(false);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        breederPanel = new DragonBreederPanel(this, player);
        designerPanel = new DragonDesignerPanel(this);
        characteristicsPanel =
                new PredictedCharacteristicsPanel(this);
        //previewPanel = new PreviewPanel();
        previewCanvas = new DragonPreviewCanvas(this);
        add(breederPanel);
        add(designerPanel);
        add(characteristicsPanel);
        add(previewCanvas);


        //add(previewPanel);

        SpringLayout.Constraints breederPanelConstraints =
                layout.getConstraints(breederPanel);

        breederPanelConstraints.setHeight(new RelativeHeightSpring(this, 0.33f));
        breederPanelConstraints.setY(new RelativeHeightSpring(this, 0.66f));
        breederPanelConstraints.setX(Spring.constant(0));
        breederPanelConstraints.setWidth(new RelativeWidthSpring(this, 0.33f));


        //layout.putConstraint(
        //        SpringLayout.NORTH, designerPanel, 0,
        //        SpringLayout.NORTH, this);
        //layout.putConstraint(
        //        SpringLayout.WEST, designerPanel, 0,
        //        SpringLayout.WEST, this);
        //layout.putConstraint(
        //        SpringLayout.WIDTH, designerPanel,
        //        Spring.scale(layout.getConstraint(SpringLayout.WIDTH, this), 0.33f),
        //        SpringLayout.WEST, this
        //);
        //layout.putConstraint(
        //        SpringLayout.HEIGHT, designerPanel,
        //        Spring.scale(layout.getConstraint(SpringLayout.HEIGHT, this), 0.66f),
        //        SpringLayout.NORTH, this
        //);


        SpringLayout.Constraints designerPanelConstraints =
                layout.getConstraints(designerPanel);
        designerPanelConstraints.setHeight(new RelativeHeightSpring(this, 0.66f));
        designerPanelConstraints.setY(Spring.constant(0));
        designerPanelConstraints.setX(Spring.constant(0));
        designerPanelConstraints.setWidth(new RelativeWidthSpring(this, 0.33f));

        SpringLayout.Constraints characteristicsPanelConstraints =
                layout.getConstraints(characteristicsPanel);
        characteristicsPanelConstraints.setHeight(new RelativeHeightSpring(this, 0.33f));
        characteristicsPanelConstraints.setY(new RelativeHeightSpring(this, 0.66f));
        characteristicsPanelConstraints.setX(new RelativeWidthSpring(this, 0.33f));
        characteristicsPanelConstraints.setWidth(new RelativeWidthSpring(this, 0.66f));

        SpringLayout.Constraints previewCanvasConstraints =
                layout.getConstraints(previewCanvas);
        previewCanvasConstraints.setY(Spring.constant(0));
        previewCanvasConstraints.setHeight(new RelativeHeightSpring(this, 0.66f));
        previewCanvasConstraints.setX(new RelativeWidthSpring(this, 0.33f));
        previewCanvasConstraints.setWidth(new RelativeWidthSpring(this, 0.66f));

        // initialise dragon to null
        setCurrentDragon(null);

    }

    public void setCurrentDragon(final Dragon currentDragon) {

        if (this.currentDragon == currentDragon) {
            return;
        }

        this.currentDragon = currentDragon;

        if (characteristicsPanel != null) {
            characteristicsPanel.setCurrentDragon(currentDragon);
        }

        if (previewCanvas != null) {
            previewCanvas.setDragon(currentDragon);
        }
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paintComponents - " +
                " width=" + g.getClip().getBounds().getWidth() +
                " height=" + g.getClip().getBounds().getHeight());

        g.drawImage(
                Imgs.NOTEBOOK_BACKGROUND,
                0, 0, this.getWidth(), this.getHeight(), this);
        super.paint(g);

    }

    public void updateParentLists() {
        breederPanel.updateParentLists();
    }

    public void addDragon (final Dragon dragon) {

        if (dragon == null) {
            return;
        }

        player.addDragon(dragon);

    }

    public void removeDragon (final Dragon dragon) {

        if (dragon == null) {
            return;
        }

        player.removeDragon(dragon);

    }

}
