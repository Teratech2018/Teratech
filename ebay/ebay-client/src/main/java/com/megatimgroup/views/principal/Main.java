
package com.megatimgroup.views.principal;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.megatim.security.clients.Authentification;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.ebaytools.client.SplashScreen;


/**
 * Generated Class: Main
 * 
 */
public class Main {


    public Main() {
    }

    public static void main(String[] args) throws Exception {
    	 //Charger le look and feel
        loadLookAndFeel();
        
        
        //Affichager la fenetre de connexion
        launchAuthenficationWindow();
    }
 
    
    /**
     * Methode afficher la fenetre de connexion
     */
    public static void launchAuthenficationWindow() {
    	final ImageIcon icone =EbayUtilities.getIcone();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Authentification authentification = new Authentification(new PrincipalScreen(),false,icone);
                authentification.setLocationRelativeTo(authentification);
                authentification.setSize(350, 220);
                authentification.setVisible(true);
            }
        });
    }
    
    /**
     * Methode pour charger le lookAndFeel
     */
    private static void loadLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            	//javax.swing.UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
            	//javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.luna.LunaLookAndFeel");
            	//javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.smart.SmartLookAndFeel");
            //	javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            //	javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.aero.AeroLookAndFeel");
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


}
