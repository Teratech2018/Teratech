
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author user
 */
public class SplashScreen extends JWindow {

    private int duration;
    private String splashScreenImageName;

    /** A simple little method to show a title screen in the center
     * of the screen for the amount of time given in the constructor
     **/
    public void showSplash(int duration, String splashScreenImageName) {
        
        //Initialisation des variables  
        int width = 600;
        int height = 298;
        JPanel content;
        Dimension screen;
        
        //Affectation
        this.duration = duration;
        this.splashScreenImageName = splashScreenImageName;

        //Traitement
        content = (JPanel) getContentPane();
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        content.setOpaque(false);
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel image = new JLabel(new ImageIcon(splashScreenImageName));
        content.add(image, BorderLayout.CENTER);

        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }

        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash(this.duration,this.splashScreenImageName);
        System.exit(0);
    }

}
