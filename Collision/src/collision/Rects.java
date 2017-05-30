/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author cgallinaro
 */
class Rects extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D r1 = new Rectangle2D.Double(100d, 100d, 200d, 50d);
        Rectangle2D r2 = new Rectangle2D.Double(130d, 60d, 20d, 25d);

        g2.setColor(Color.RED);
        g2.draw(r1);

        g2.setColor(Color.BLUE);
        g2.draw(r2);

        if (r1.intersects(r2) || r2.intersects(r1)) {
            System.out.println("Intersects");
        } else {
            System.out.println("No Intersection");
        }
    }
}
