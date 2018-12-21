
package com.megatimgroup.views.operations;

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
import com.megatimgroup.model.parametres.StatutDeclaration;
import com.toedter.calendar.JDateChooser;


/**
 * Panel de recherche DeclarationFinanciereCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class BalanceCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationFinanciereIFrame");
    private IocContext context = new IocContext();

    @Search(field = "dateDebut", type = java.util.Date.class)
    private JDateChooser dateDebut;
    private JLabel lbdateDebut;

    @Search(field = "dateFin", type = java.util.Date.class)
    private JDateChooser dateFin;
    private JLabel lbdateFin;
    
    @Champ(mappedBy = "lMoisGeneration", type = String.class)
    private StatutDeclaration moisGeneration = StatutDeclaration.INITITIAL;

    public BalanceCriteriaPanel() {
        initComponents() ; 
    }

   
    
    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
      
        dateDebut = new JDateChooser() ;
        lbdateDebut= new JLabel();
        lbdateDebut.setText(MessagesBundle.getMessage( "ebay.date.debut"));
         
         dateFin = new JDateChooser() ;
         lbdateFin = new JLabel();
         
         lbdateFin.setText(MessagesBundle.getMessage( "ebay.date.fin"));
         GroupLayout layout = new GroupLayout((this));
         this.setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
         layout.setHorizontalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbdateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(lbdateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
 	          
             );
             layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                 		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbdateDebut)
                                 .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbdateFin)
                                 .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                             .addGap(0, 10, Short.MAX_VALUE)	
                             )
             );
    }

   
   

}
