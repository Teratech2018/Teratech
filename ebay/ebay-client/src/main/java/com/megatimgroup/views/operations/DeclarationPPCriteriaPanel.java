
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
 * Panel de recherche DeclarationPPCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPPCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationPPIFrame");
    private IocContext context = new IocContext();
    @Search(field = "reference", type = java.lang.String.class)
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Search(field = "qualite", type = com.megatimgroup.model.referentiels.Qualite.class)
    private CustomComboBox qualite;
    private JLabel lbqualite;
    private JLabel lbmqualite;
    @Search(field = "titre", type = com.megatimgroup.model.referentiels.Titre.class)
    private CustomComboBox titre;
    private JLabel lbtitre;
    private JLabel lbmtitre;
    @Search(field = "ville", type = com.megatimgroup.model.referentiels.Ville.class)
    private CustomComboBox ville;
    private JLabel lbville;
    private JLabel lbmville;

    public DeclarationPPCriteriaPanel() {
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
    public CustomComboBox getQualite() {
        return qualite;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getTitre() {
        return titre;
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
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
        reference = new JTextField() ;
        reference.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbreference = new JLabel();
        lbmreference = new JLabel();
         lbreference.setText(MessagesBundle.getMessage( "ebay.reference"));
        qualite = new CustomComboBox() ;
        qualite.setManager(getQualiteManager());
        qualite.loadData() ;
        lbqualite = new JLabel();
        lbmqualite = new JLabel();
         lbqualite.setText(MessagesBundle.getMessage( "ebay.qualite"));
        titre = new CustomComboBox() ;
        titre.setManager(getTitreManager());
        titre.loadData() ;
        lbtitre = new JLabel();
        lbmtitre = new JLabel();
         lbtitre.setText(MessagesBundle.getMessage( "ebay.titre"));
        ville = new CustomComboBox() ;
        ville.setManager(getVilleManager());
        ville.loadData() ;
        lbville = new JLabel();
        lbmville = new JLabel();
         lbville.setText(MessagesBundle.getMessage( "ebay.ville"));
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
	                .addComponent(lbqualite, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(qualite, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                	)
	                .addGap(0, 2, 10)
               .addGroup(layout.createSequentialGroup()
	                .addComponent(lbtitre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbville, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                	)
               
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbreference)
                                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbqualite)
                                .addComponent(qualite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                            .addGap(0, 10, Short.MAX_VALUE)	
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbtitre)
                                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbville)
                                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
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
    private GenericManager getQualiteManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.QualiteManagerImpl");
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
    private GenericManager getTitreManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.TitreManagerImpl");
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
    private GenericManager getNationaliteManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.NationaliteManagerImpl");
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
    private GenericManager getPrecisionDatenaissanceManager() {
        try {
             return (GenericManager)context.lookup("com.megatimgroup.core.impl.referentiels.PrecisionDateNaissanceManagerImpl");
        } catch (Exception _x) {
            return null;
        }
    }

}
