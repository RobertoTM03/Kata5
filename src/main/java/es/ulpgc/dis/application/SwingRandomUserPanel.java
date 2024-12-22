package es.ulpgc.dis.application;

import es.ulpgc.dis.control.RandomUserLoaderCommand;
import es.ulpgc.dis.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRandomUserPanel extends JPanel {

    private final SwingImageDisplay imageDisplay;
    private final JLabel textLabel;

    public SwingRandomUserPanel() {
        JButton randomButton = new JButton("Get random user");
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = getRandomUser();
                updateText(user);
                updateImage(user);
            }
        });

        imageDisplay = new SwingImageDisplay();

        textLabel = new JLabel();

        setLayout(new BorderLayout());
        add(randomButton, BorderLayout.NORTH);
        add(imageDisplay, BorderLayout.CENTER);
        add(textLabel, BorderLayout.SOUTH);

        randomButton.doClick();
    }

    private void updateImage(User user) {
        imageDisplay.display(user.getPhoto());
    }

    private void updateText(User user) {
        String resultText = "<html>Name: " + user.getName() + "<br>" +
                "Email: " + user.getEmail() + "<br>" +
                "Gender: " + user.getGender() + "</html>";
        textLabel.setText(resultText);
    }

    private User getRandomUser() {
        return new RandomUserLoaderCommand(1).execute().getFirst();
    }
}
