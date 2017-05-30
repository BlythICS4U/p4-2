package torus;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;

import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class TorusProgram extends JComponent implements MouseListener {

    //VARIABLES
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;

    //how many tori have been produced so far
    private int numberOfTori = 0;
    //the number of regular torus shapes
    private static final int MAX_TORI_COUNT = 8;
    //the number of tori in the finale
    private static final int NUM_FINALE_TORI = 10;

    private final Random r = new Random();

    //to create random colours, there is a range of bright and dark colours to 
    //mix together the red, green, and blue components to create a random colour 
    //that stands out against the background
    private static final int MIN_BRIGHT = 100;
    private static final int MAX_BRIGHT = 255;

    private static final int MIN_DARK = 0;
    private static final int MAX_DARK = 150;

    //random size range
    private static final int MIN_SIZE = 25;
    private static final int MAX_SIZE = 75;

    private boolean hasFinaleStarted = false;

    //the last regular torus shape created
    private Torus regTori;

    //the tori that are in the finale
    private final Torus[] finaleTori = new Torus[NUM_FINALE_TORI];

    private int countFinaleTori = 0;

    //automatically generated to incorporate mouse click recognition
    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    //creates a new torus shape by calling the Torus class
    private Torus singleTorus(Point2D point) {
        //pick a random color
        int redval = r.nextInt(MAX_BRIGHT - MIN_BRIGHT) + MIN_BRIGHT;
        int greenval = r.nextInt(MAX_BRIGHT - MIN_BRIGHT) + MIN_BRIGHT;
        int blueval = r.nextInt(MAX_DARK - MIN_DARK) + MIN_DARK;
        Color c = new Color(redval, greenval, blueval);

        //pick a random size
        int size = r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;

        //create the torus shape
        return new Torus(point, c, size);

    }

    //creates finale tori
    private void finale() {

        hasFinaleStarted = true;
        regTori = null;

        int min = 0;
        int max = SCREEN_HEIGHT;
        int range = max - min;

        //finds random value between 0 and screenHeight
        double randomnum = r.nextDouble() * range + min;

        //while there are more tori to be created in the finale...
        while (countFinaleTori < NUM_FINALE_TORI) {

            //create the next torus shape at a random x Position, with y Position at the middle of screen (may be outside of screen at times)
            finaleTori[countFinaleTori] = singleTorus(new Point2D.Double(randomnum, SCREEN_WIDTH / 2));

            randomnum = randomnum + 10;

            countFinaleTori++;
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        //draw a regular torus shape if visible
        if (regTori != null) {
            regTori.paint(g);
        }

        //draw the finale tori
        for (int i = 0; i < countFinaleTori; i++) {
            finaleTori[i].paint(g);

        }

    }

    @Override
    public void mousePressed(MouseEvent x) {

        //if there are more regular tori, shoot a regular torus where clicked
        if (numberOfTori < MAX_TORI_COUNT) {
            regTori = singleTorus(x.getPoint());
            numberOfTori++;
        } //if the finale is to begin (regular tori are out), start the finale
        else if (!hasFinaleStarted) {
            finale();
        }

        repaint();
    }

    //MAIN
    public static void main(String[] args) {

        //creates the window
        JFrame f = new JFrame();
        f.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        //recieves mouse events from the component
        TorusProgram t = new TorusProgram();
        t.addMouseListener(t);

        Container contentPane = f.getContentPane();
        contentPane.add(t, BorderLayout.CENTER);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
