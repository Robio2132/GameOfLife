/*
file name:      LandscapeTests.java
Authors:        Max Bender, Naser Al Madi, and Robbie bennett
last modified:  9/18/2022
How to run:     1. javac LifeSimulation.java     2. java LifeSimulation  (Should return the results and outcome of the tests.)
*/


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LifeSimulation {
    //Displays a Landscape graphically using Swing. The Landscape
    //contains a grid which can be displayed at any scale factor.

    JFrame win;
    protected Landscape scape;
    private LandscapePanel canvas;
    private int gridScale; // width (and height) of each square in the grid

    public LifeSimulation (Landscape scape, int scale) {
        //Initializes a display window for a Landscape.

        // setup the window
        this.win = new JFrame("Game of Life");
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.scape = scape;
        this.gridScale = scale;

        // create a panel in which to display the Landscape
        // put a buffer of two rows around the display grid
        this.canvas = new LandscapePanel((int) (this.scape.getCols() + 4) * this.gridScale,
                (int) (this.scape.getRows() + 4) * this.gridScale);

        // add the panel to the window, layout, and display
        this.win.add(this.canvas, BorderLayout.CENTER);
        this.win.pack();
        this.win.setVisible(true);
    }

    /**
     * Saves an image of the display contents to a file. The supplied
     * filename should have an extension supported by javax.imageio, e.g.
     * "png" or "jpg".
     *
     * @param filename the name of the file to save
     */
    public void saveImage(String filename) {
        //Saves an image of the display contents to a file. The supplied
        //filename should have an extension supported by javax.imageio, e.g.

        // get the file extension from the filename
        String ext = filename.substring(filename.lastIndexOf('.') + 1, filename.length());

        // create an image buffer to save this component
        Component tosave = this.win.getRootPane();
        BufferedImage image = new BufferedImage(tosave.getWidth(), tosave.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // paint the component to the image buffer
        Graphics g = image.createGraphics();
        tosave.paint(g);
        g.dispose();

        // save the image
        try {
            ImageIO.write(image, ext, new File(filename));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private class LandscapePanel extends JPanel {
        //This inner class provides the panel on which Landscape elements
        
        public LandscapePanel(int width, int height) {
            //Constructor.

            super();
            this.setPreferredSize(new Dimension(width, height));
            this.setBackground(Color.lightGray);
        }

        /**
         * Method overridden from JComponent that is responsible for
         * drawing components on the screen. The supplied Graphics
         * object is used to draw.
         * 
         * @param g the Graphics object used for drawing
         */
        public void paintComponent(Graphics g) {
            //Method overridden from JComponent that is responsible for
            //drawing components on the screen. The supplied Graphics
            //object is used to draw.

            // take care of housekeeping by calling parent paintComponent
            super.paintComponent(g);

            // call the Landscape draw method here
            scape.draw(g, gridScale);
        } // end paintComponent

    } 

    // end LandscapePanel
    public void repaint() {
        this.win.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        
        ///Usage Statment.
        if (args.length == 0) {
            System.out.println("Usage: java Grid rows <arg1: int> cols <arg2: int> liveCellChance <arg3: double> num<arg4: int>");
            return;
        }
        
        //Converting string args to ints and floats.
        int arg1 = Integer.parseInt(args[0]);
        int arg2 = Integer.parseInt(args[1]);
        double arg3 = Double.parseDouble(args[2]); //Should be between 0 and 1.
        int arg4 = Integer.parseInt(args[3]);
    
        //Creating objects
        Landscape scape = new Landscape(arg1, arg2, arg3);
        LandscapeDisplay display = new LandscapeDisplay(scape, 6);
    

        ///For loop for main project. Uncomment to run the LifeSimulation as it is meant to be. Make sure no other code below is uncommented. 
        //Check the Read me file or usage statement to run.
        //Best result is when you have 100 rows and cols, an initial value of .5, and run the advance 1000

        for (int i = 0; i < arg4; i++) {
            Thread.sleep(250);
            display.repaint();
            scape.advance();
        }


        ///Extension!!! Additional Rules for the Game that I created.
        ///Uncoment the code below and comment out the code above. After that, check the read me fileor usage statement to run.
        //Best result is when you have 100 rows and cols, an initial value of 1, and run the advance 1000

        /*for (int i = 0; i < arg4; i++) {
            Thread.sleep(1);
            display.repaint();
            scape.advanceExtension();
        }*/

    

        //Uncomment this code and comment out the code above to get the amount of live cells and the sample statistic I used for my reflection (See graph and explanation in my report.)
        /*for(int i=0; i< 1000; i++) {
        Thread.sleep(1);
        display.repaint();
        countAlive += scape.getAliveCount();
        scape.advance();
        countMoves ++;
    

        }
        System.out.println("Total Alive Count:  " + countAlive);
        System.out.println("Sample Statistic of all sample means is :  " + countAlive/1000);*/
    }
}