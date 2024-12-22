package es.ulpgc.dis.application;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setTitle("Random user display");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        SwingRandomUserPanel swingRandomUserPanel = new SwingRandomUserPanel();
        add(swingRandomUserPanel);
    }
}
