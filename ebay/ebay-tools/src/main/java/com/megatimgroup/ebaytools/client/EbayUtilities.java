/**
 * 
 */
package com.megatimgroup.ebaytools.client;

import javax.swing.ImageIcon;

/**
 * @author mgt
 *
 */
public class EbayUtilities {
	   // image connexion
    public static ImageIcon getImageLogin(){
    	return new ImageIcon(ClassLoader.getSystemResource("com/megatim/tools/images/banner_login.png")) ;
    }
    
    // image user
    public static ImageIcon getIcone(){
    	 ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/ebay/tools/images/bank.png"));
         return icon;
    }

}
