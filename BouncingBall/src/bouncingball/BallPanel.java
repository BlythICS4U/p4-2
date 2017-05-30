/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author cgallinaro
 */
class BallPanel extends JPanel implements ActionListener {

    int delay = 10;
    Timer timer;

    int x = 0;
    int y = 0;
    int radius = 15;

    int dx = 2;
    int dy = 2;

    public BallPanel() {
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);

        if (x < radius) {
            dx = Math.abs(dx);
        }
        if (x > getWidth() - radius) {
            dx = -Math.abs(dx);
        }
        if (y < radius) {
            dy = Math.abs(dy);
        }
        if (y > getHeight() - radius) {
            dy = -Math.abs(dy);
        }

        x += dx;
        y += dy;
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}
