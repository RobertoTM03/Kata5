package es.ulpgc.dis.application;

import es.ulpgc.dis.model.Image;
import es.ulpgc.dis.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    public Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawImage(g);
    }

    private void drawImage(Graphics g) {
        java.awt.Image SwingImage = deserialize();
        g.drawImage(SwingImage, 50, 25, getWidth()-100, getHeight()-50, null);
    }

    private java.awt.Image deserialize() {
        return (java.awt.Image) new SwingImageDeserializer().desearilize(image.content());
    }
}
