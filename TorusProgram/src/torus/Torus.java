package torus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;


public class Torus {
    
    private final int torusRadius;
    private final Color torusColor;
    private final double horizontalCenter;
    private final double verticalCenter;
    

    //torus constructor
    public Torus(Point2D center, Color color, int radius){
        
        //gets the x and y values from the center point
        horizontalCenter = center.getX();
        verticalCenter = center.getY();
        
        torusRadius = radius;
        
        torusColor = color;
        
    }
    

    public void paint(Graphics g) {
        //Graphics 2D has more flexibility and tools to work with
    	Graphics2D g2D = (Graphics2D) g;
       
    	//make the origin (0,0) equal to the coordinates of the horizontalCenter and verticalCenter
    	g2D.translate(this.horizontalCenter, this.verticalCenter);
        
        //sets the color to the random color
    	g2D.setColor(this.torusColor);
        
        
        double a = 0;
        double increment = Math.PI/16;

        //while the angle is less than a circle (2 times pi)
        while (a < 2 * Math.PI) {
        	//tells graphics object how far to rotate the object
        	g2D.rotate(a);
        	
                //draws the ovals in a pattern
        	g2D.drawOval(0, 0, this.torusRadius, this.torusRadius);
                      
            //increase the angle slightly each time 
            a = a + increment;
        
        }
    }
}





