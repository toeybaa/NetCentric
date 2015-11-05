package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame {
    static int windowWidth = 1000;
    static int windowHeight = 700;
    JButton startButton, gameSetting;

    public Home(String title) {
        super(title);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = Game.createAndShowGUI();
                dispose();
            }

        });
        this.add(startButton, BorderLayout.NORTH);
        gameSetting = new JButton("Setting");
        this.add(gameSetting, BorderLayout.SOUTH);

    }


    public static void createAndShowGUI() {
        Home frame = new Home("Rainy Word V0.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight); // set the size of GUI
        frame.getContentPane().setBackground(new Color(0, 0, 0, 50));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }


}
