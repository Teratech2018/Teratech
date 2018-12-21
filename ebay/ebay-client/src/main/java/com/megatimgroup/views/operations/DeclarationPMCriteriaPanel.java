
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


/**
 * Panel de recherche DeclarationPMCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPMCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationPMIFrame");
    private IocContext context = new IocContext();
    @Search(field = "reference", type = java.lang.String.class)
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Search(field = "natureJuridique", type = com.megatimgroup.model.referentiels.NatureJuridique.class)
    private CustomComboBox naturejuridique;
    private JLabel lbnaturejuridique;
    private JLabel lbmnaturejuridique;
    @Search(field = "ville", type = com.megatimgroup.model.referentiels.Ville.class)
    private CustomComboBox ville;
    private JLabel lbville;
    private JLabel lbmville;
    @Search(field = "section", type = com.megatimgroup.model.referentiels.Section.class)
    private CustomComboBox section;
    private JLabel lbsection;
    private JLabel lbmsection;

    public DeclarationPMCriteriaPanel() {
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
    public CustomComboBox getNatureJuridique() {
        return naturejuridique;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getVille() {
        return ville;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getSection() {
        return section;
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
        naturejuridique = new CustomComboBox() ;
        naturejuridique.setManager(getNatureJuridiqueManager());
        naturejuridique.loadData() ;
        lbnaturejuridique = new JLabel();
        lbmnaturejuridique = new JLabel();
         lbnaturejuridique.setText(MessagesBundle.getMessage( "ebay.naturejuridique"));
        ville = new CustomComboBox() ;
        ville.setManager(getVilleManager());
        ville.loadData() ;
        lbville = new JLabel();
        lbmville = new JLabel();
         lbville.setText(MessagesBundle.getMessage( "ebay.ville"));
        section = new CustomComboBox() ;
        section.setManager(getSectionManager());
        section.loadData() ;
        lbsection = new JLabel();
        lbmsection = new JLabel();
         lbsection.setText(MessagesBundle.getMessage( "ebay.section"));
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
 	                .addComponent(lbnaturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(naturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
 	                .addGap(0, 2, 10)
                .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbville, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(lbsection, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                
             );
             layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                 		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbreference)
                                 .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbnaturejuridique)
                                 .addComponent(naturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                             .addGap(0, 10, Short.MAX_VALUE)	
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbville)
                                 .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbsection)
                                 .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
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
    private GenericManager getNatureJuridiqueManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.NatureJuridiqueManagerImpl");
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
    private GenericManager getNatureClienteleManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.NatureClienteleManagerImpl");
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
    private GenericManager getStatusResidenceManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.StatusResidenceManagerImpl");
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
    private GenericManager getVilleManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.VilleManagerImpl");
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
    private GenericManager getSectionManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.SectionManagerImpl");
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
    private GenericManager getDivisionManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.DivisionManagerImpl");
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
    private GenericManager getGroupeManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.GroupeManagerImpl");
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
    private GenericManager getClasseManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.ClasseManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

}
