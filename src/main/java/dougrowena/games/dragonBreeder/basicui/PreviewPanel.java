package dougrowena.games.dragonBreeder.basicui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class PreviewPanel extends JPanel {

    private Canvas canvas;
    private Image image;

    public PreviewPanel() {

        Toolkit kit = Toolkit.getDefaultToolkit();

        image = kit.createImage(
                "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.png");
        System.out.println("Got image " + image);

        setLayout(new BorderLayout());

        canvas = new Canvas() {
            @Override
            public void paint(Graphics graphics) {
                System.out.println("canvas.paint" + graphics.getClip().getBounds());
                int width = graphics.getClip().getBounds().width;
                int height = graphics.getClip().getBounds().height;
                //super.paint(graphics);
                graphics.drawImage(image, 0,0,width,height,Color.CYAN, canvas);

            }
        };

        add(canvas, BorderLayout.CENTER);

    }
}
