
package com.megatimgroup.views.operations;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Search;
import com.megatim.common.clients.CustomComboBox;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.toedter.calendar.JDateChooser;


/**
 * Panel de recherche DeclarationFinanciereCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationFinanciereCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationFinanciereIFrame");
    private IocContext context = new IocContext();
    @Search(field = "reference", type = java.lang.String.class)
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Search(field = "sens", type = com.megatimgroup.model.referentiels.SensOperation.class)
    private CustomComboBox sens;
    private JLabel lbsens;
    private JLabel lbmsens;
    @Search(field = "devise", type = com.megatimgroup.model.referentiels.Devise.class)
    private CustomComboBox devise;
    private JLabel lbdevise;
    private JLabel lbmdevise;
    @Search(field = "dateOperation", type = java.util.Date.class)
    private JDateChooser dateoperation;
    private JLabel lbdateoperation;
    private JLabel lbmdateoperation;

    public DeclarationFinanciereCriteriaPanel() {
        initComponents() ; 
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getReference() {
        return reference;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getSens() {
        return sens;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getDevise() {
        return devise;
    }

    /**
     * Getter
     * 
     * @return
     *     com.toedter.calendar.JDateChooser
     */
    public JDateChooser getDateOperation() {
        return dateoperation;
    }

    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
        reference = new JTextField() ;
        reference.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbreference = new JLabel();
        lbmreference = new JLabel();
         lbreference.setText(MessagesBundle.getMessage( "ebay.reference"));
        sens = new CustomComboBox() ;
        sens.setManager(getSensManager());
        sens.loadData() ;
        lbsens = new JLabel();
        lbmsens = new JLabel();
         lbsens.setText(MessagesBundle.getMessage( "ebay.sens"));
        devise = new CustomComboBox() ;
        devise.setManager(getDeviseManager());
        devise.loadData() ;
        lbdevise = new JLabel();
        lbmdevise = new JLabel();
         lbdevise.setText(MessagesBundle.getMessage( "ebay.devise"));
        dateoperation = new JDateChooser() ;
        lbdateoperation = new JLabel();
        lbmdateoperation = new JLabel();
         lbdateoperation.setText(MessagesBundle.getMessage( "ebay.dateoperation"));
         GroupLayout layout = new GroupLayout((this));
         this.setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
         layout.setHorizontalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbreference, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(lbsens, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(sens, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
 	                .addGap(0, 2, 10)
                .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbdevise, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(devise, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(lbdateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(dateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                
             );
             layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                 		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbreference)
                                 .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbsens)
                                 .addComponent(sens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                             .addGap(0, 10, Short.MAX_VALUE)	
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbdevise)
                                 .addComponent(devise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbdateoperation)
                                 .addComponent(dateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                             .addGap(0, 10, Short.MAX_VALUE)
                     		
                 		)
                     
             );
    }

    /**
     * Methode permettant de renvoyer un manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    private GenericManager getSensManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.SensOperationManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

    /**
     * Methode permettant de renvoyer un manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    private GenericManager getDeviseManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.DeviseManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

    /**
     * Methode permettant de renvoyer un manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    private GenericManager getTypeManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.TypeOperationManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

    /**
     * Methode permettant de renvoyer un manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    private GenericManager getPaysManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.PaysManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

    /**
     * Methode permettant de renvoyer un manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */
    private GenericManager getMotifManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.MotifManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

}
