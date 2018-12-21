
package com.megatimgroup.views.archivage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Champ;
import com.megatim.common.annotations.Search;
import com.megatim.common.clients.CustomComboBox;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.security.enumerations.EnumStatutAutorisation;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.model.parametres.StatutDeclaration;
import com.toedter.calendar.JDateChooser;


/**
 * Panel de recherche DeclarationFinanciereCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class ArchiveCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationFinanciereIFrame");
    private IocContext context = new IocContext();

    @Search(field = "lMois", type = String.class)
    private CustomComboBox cbxMois;
    private JLabel lMois;

    

    public ArchiveCriteriaPanel() {
        initComponents() ; 
    }

   
    
    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
      
        cbxMois = new CustomComboBox() ;
        cbxMois= this.valeurMois();
        lMois= new JLabel();
        lMois.setText(MessagesBundle.getMessage( "MOIS"));

         GroupLayout layout = new GroupLayout((this));
         this.setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
         layout.setHorizontalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
 	                .addComponent(lMois, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(cbxMois, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
 	          
             );
             layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                 		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lMois)
                                 .addComponent(cbxMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                             .addGap(0, 10, Short.MAX_VALUE)	
                             )
             );
    }

    @SuppressWarnings("unchecked")
    public CustomComboBox valeurMois() {
        CustomComboBox cbxTypeBdr = new CustomComboBox();
        cbxTypeBdr.setModel(new DefaultComboBoxModel(Mois.values()));
        return cbxTypeBdr;
    }



	public CustomComboBox getCbxMois() {
		return cbxMois;
	}



	public void setCbxMois(CustomComboBox cbxMois) {
		this.cbxMois = cbxMois;
	}




}
