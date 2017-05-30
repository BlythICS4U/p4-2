/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texture;

import javax.swing.JFrame;

/**
 *
 * @author cgallinaro
 */
public class Texture {

    private static void createAndShowGUI() {
	JFrame frame = new JFrame("Textures");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	frame.add(new TexturePanel());
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}
