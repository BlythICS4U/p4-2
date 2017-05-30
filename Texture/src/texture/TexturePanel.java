/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texture;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author cgallinaro
 */
public class TexturePanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage s = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        try {
            s = ImageIO.read(new File("academy-logo.jpg"));
//            s = ImageIO.read(new File("tile.jpeg"));
        } catch (IOException e) {
        }
        
        super.paintComponent(g);
        
        g.drawImage(s, 100, 100, this);
        
//        Graphics2D g2d = (Graphics2D) g;
//        TexturePaint slatetp = new TexturePaint(s, new Rectangle(0, 0, 100, 100));
//        g2d.setPaint(slatetp);
//        g2d.fillRect(10, 15, 750, 300);
    }

}
