package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Word extends JPanel {

    Random rand = new Random();
    String word;
    boolean visible;
    private int wordXLocation;
    private int wordYLocation;
    private int fallSpeed = 1;


    public Word(int y, String s) {
        generateRandomXLocation();
        wordYLocation = y;
        word = s;
        visible = true;
    }

    public int getYLocation() {
        return wordYLocation;
    }

    public int generateRandomXLocation() {
        return wordXLocation = rand.nextInt(Game.windowWidth - 150);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Menlo", Font.PLAIN, 40));
        g2.setColor(Color.RED);
        g2.drawString(word, wordXLocation, wordYLocation);


    }

    public void update() {


        if (wordYLocation <= Game.windowWidth) {
            wordYLocation += fallSpeed;
        }
    }
}