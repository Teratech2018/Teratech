
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.model.operations.Champ;
import com.megatimgroup.model.operations.Modele;

import java.awt.Frame;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Boite de dialogue d'edition ModeleDialog

 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ModeleDialog
    extends AbstractEditTemplateDialog<Modele, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;

    /**
     * Constructeur par defaut
     * 
     */
    public ModeleDialog() {
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public ModeleDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public ModeleDialog(Frame parent, String title) {
         super(parent , title);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param typeOperation
     * @param parent
     * @param modal
     */
    public ModeleDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
         super(parent , modal ,typeOperation );
         interne = false ;
         setSize(650, 450);
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.String
     */
    @Override
    public String getPrimaryKey(Modele object) {
        return object.getCode() ;
    }

    /**
     * Methode permettant de retourner nom de l'action
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getActionName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     * 
     * @return
     *     java.util.Map
     */
    @Override
    public Map getReportParameters() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getJasperFileName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le titre de la fenetre
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowTitle() {
        return (MessagesBundle.getMessage("modele.edit").toUpperCase());
    }

    /**
     * Methode permettant de retourner l'icone de la fenetre
     * 
     * @return
     *     javax.swing.ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        try{
        ImageIcon icon = null;
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("modele.edit.image")));
        return icon;
        }catch(Exception ex){;}
        return null;
    }

    /**
     * Methode permettant de retourner le panel des champs
     * 
     * @return
     *     javax.swing.JPanel
     */
    @Override
    public JPanel getFiledsPanel() {
        if ((middlePanel==null)) {
            middlePanel = new ModeleEditPanel() ;
        }
        return (middlePanel);
    }

    /**
     * Methode permettant de retourner l'instance de la fenetre principale
     * 
     * @return
     *     javax.swing.JFrame
     */
    @Override
    public JFrame getApplicationFrame() {
        return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowClassName() {
         return "com.megatimgroup.views.operations.ModeleIFrame" ;
    }

    @Override
    public boolean beforeSave() {
       if(currentObject.getNodes()!=null){
            int index = 0 ;
            for(NodeObject node : currentObject.getNodes()){
              if(node!=null){
                  Champ champ = new Champ(node);
                  champ.setIndex(index);
                  currentObject.add(champ);
                  index = index + 1 ;
              }
            }
        } 
       //System.out.println("--------------------------------------------   "+currentObject);
      return super.beforeSave();
   }

    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }

}
