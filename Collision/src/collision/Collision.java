/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collision;

import javax.swing.JFrame;

/**
 *
 * @author cgallinaro
 */
public class Collision {

    private static void createAndShowGUI() {
    	JFrame frame = new JFrame("Draw Rectangle");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(800, 600);
        
    	Rects panel = new Rects();
    	frame.add(panel);
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
