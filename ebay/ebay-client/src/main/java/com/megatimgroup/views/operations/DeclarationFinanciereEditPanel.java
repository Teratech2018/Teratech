
package com.megatimgroup.views.operations;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Champ;
import com.megatim.common.clients.CommonsUtilities;
import com.megatim.common.clients.CustomComboBox;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.views.helper.CurrentSessionInformations;
import com.toedter.calendar.JDateChooser;


/**
 * Panel d'edition DeclarationFinanciereEditPanel

 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationFinanciereEditPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationFinanciereIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "reference",type = java.lang.String.class, errorMessageField = "lbmreference", errorMessage = "declarationfinanciere.reference.error")
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Champ(mappedBy = "designation", type = java.lang.String.class, errorMessageField = "lbmdesignation", errorMessage = "declarationfinanciere.designation.error")
    private JTextField designation;
    private JLabel lbdesignation;
    private JLabel lbmdesignation;
    @Champ(mappedBy = "montant", type = java.math.BigDecimal.class, errorMessageField = "lbmmontant", errorMessage = "declarationfinanciere.montant.error")
    private JFormattedTextField montant;
    private JLabel lbmontant;
    private JLabel lbmmontant;
    @Champ(mappedBy = "sens", type = com.megatimgroup.model.referentiels.SensOperation.class, errorMessageField = "lbmsens", errorMessage = "declarationfinanciere.sens.error")
    private CustomComboBox sens;
    private JLabel lbsens;
    private JLabel lbmsens;
    @Champ(mappedBy = "devise", type = com.megatimgroup.model.referentiels.Devise.class, errorMessageField = "lbmdevise", errorMessage = "declarationfinanciere.devise.error")
    private CustomComboBox devise;
    private JLabel lbdevise;
    private JLabel lbmdevise;
    @Champ(mappedBy = "dateOperation", type = java.util.Date.class, errorMessageField = "lbmdateoperation", errorMessage = "declarationfinanciere.dateoperation.error")
    private JDateChooser dateoperation;
    private JLabel lbdateoperation;
    private JLabel lbmdateoperation;
    @Champ(mappedBy = "type", type = com.megatimgroup.model.referentiels.TypeOperation.class, errorMessageField = "lbmtype", errorMessage = "declarationfinanciere.type.error")
    private CustomComboBox type;
    private JLabel lbtype;
    private JLabel lbmtype;
    @Champ(mappedBy = "pays", type = com.megatimgroup.model.referentiels.Pays.class, errorMessageField = "lbmpays", errorMessage = "declarationfinanciere.pays.error")
    private CustomComboBox pays;
    private JLabel lbpays;
    private JLabel lbmpays;
    @Champ(mappedBy = "motif", type = com.megatimgroup.model.referentiels.Motif.class, errorMessageField = "lbmmotif", errorMessage = "declarationfinanciere.motif.error")
    private CustomComboBox motif;
    private JLabel lbmotif;
    private JLabel lbmmotif;
    @Champ(mappedBy = "commentaire", type = java.lang.String.class, errorMessageField = "lbmcommentaire", errorMessage = "declarationfinanciere.commentaire.error")
    private JTextField commentaire;
    private JLabel lbcommentaire;
    private JLabel lbmcommentaire;
    private JTextField codeEtbl;
    private JLabel lbCodeEtbl;
    private JTextField nomEtbl;
    private JLabel lbNomEtbl;
    
    
    private JPanel hearderPanel ;
    private JPanel coprsPanel ;
    private JLabel requiert;

    public DeclarationFinanciereEditPanel() {
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
     *     javax.swing.JTextField
     */
    public JTextField getDesignation() {
        return designation;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JFormattedTextField
     */
    public JFormattedTextField getMontant() {
        return montant;
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
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getType() {
        return type;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getPays() {
        return pays;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getMotif() {
        return motif;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getCommentaire() {
        return commentaire;
    }

    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
    	 requiert= new JLabel();
         requiert.setText("*");
         requiert.setForeground(Color.RED);
         requiert.setBackground(Color.RED);
        reference = new JTextField() ;
        reference.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbreference = new JLabel();
        lbmreference = new JLabel();
         lbreference.setText(MessagesBundle.getMessage( "ebay.reference")+requiert.getText());
         codeEtbl = new JTextField() ;
         codeEtbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
         lbCodeEtbl = new JLabel();
         lbCodeEtbl.setText(MessagesBundle.getMessage( "ebay.code.etbl"));

         nomEtbl = new JTextField() ;
         nomEtbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
         lbNomEtbl = new JLabel();
         lbNomEtbl.setText(MessagesBundle.getMessage( "ebay.nom.etbl"));
         
         
         codeEtbl.setText(CurrentSessionInformations.getCurrentSociete().getCode());
         nomEtbl.setText(CurrentSessionInformations.getCurrentSociete().getIdentifiant());
         
        designation = new JTextField() ;
        designation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbdesignation = new JLabel();
        lbmdesignation = new JLabel();
         lbdesignation.setText(MessagesBundle.getMessage( "ebay.designation")+requiert.getText());
        montant = new JFormattedTextField() ;
        montant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbmontant = new JLabel();
        lbmmontant = new JLabel();
         lbmontant.setText(MessagesBundle.getMessage( "ebay.montant")+requiert.getText());
        sens = new CustomComboBox() ;
        sens.setManager(getSensManager());
        sens.loadData() ;
        lbsens = new JLabel();
        lbmsens = new JLabel();
         lbsens.setText(MessagesBundle.getMessage( "ebay.sens")+requiert.getText());
        devise = new CustomComboBox() ;
        devise.setManager(getDeviseManager());
        devise.loadData() ;
        lbdevise = new JLabel();
        lbmdevise = new JLabel();
         lbdevise.setText(MessagesBundle.getMessage( "ebay.devise")+requiert.getText());
        dateoperation = new JDateChooser() ;
        lbdateoperation = new JLabel();
        lbmdateoperation = new JLabel();
         lbdateoperation.setText(MessagesBundle.getMessage( "ebay.dateoperation")+requiert.getText());
        type = new CustomComboBox() ;
        type.setManager(getTypeManager());
        type.loadData() ;
        lbtype = new JLabel();
        lbmtype = new JLabel();
         lbtype.setText(MessagesBundle.getMessage( "ebay.type")+requiert.getText());
        pays = new CustomComboBox() ;
        pays.setManager(getPaysManager());
        pays.loadData() ;
        lbpays = new JLabel();
        lbmpays = new JLabel();
         lbpays.setText(MessagesBundle.getMessage( "ebay.pays")+requiert.getText());
        motif = new CustomComboBox() ;
        motif.setManager(getMotifManager());
        motif.loadData() ;
        lbmotif = new JLabel();
        lbmmotif = new JLabel();
         lbmotif.setText(MessagesBundle.getMessage( "ebay.motif")+requiert.getText());
        commentaire = new JTextField() ;
        commentaire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbcommentaire = new JLabel();
        lbmcommentaire = new JLabel();
         lbcommentaire.setText(MessagesBundle.getMessage( "ebay.commentaire")+requiert.getText());
         hearderPanel= new JPanel();
         coprsPanel = new JPanel();
         buildHeader(hearderPanel);
         buildDeclartionPanel(coprsPanel);
         
         JPanel panel = new JPanel();
         BuilPanelAll(panel);
         this.add(panel);
         CommonsUtilities.buildJTextFielddisable(codeEtbl);
         CommonsUtilities.buildJTextFielddisable(nomEtbl);
    }
    
    private void BuilPanelAll(JPanel panel){
  	   
  	   javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(panel);
  	   panel.setLayout(headerPanelLayout);
         headerPanelLayout.setHorizontalGroup(
             headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(hearderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(coprsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         headerPanelLayout.setVerticalGroup(
             headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(headerPanelLayout.createSequentialGroup()
                 .addComponent(hearderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(coprsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
  	   
     }

     
     /**
     *
     * @param panel
     */
    private void buildHeader(JPanel panel) {
    	panel.setBorder(javax.swing.BorderFactory.createTitledBorder(
  				null, MessagesBundle.getMessage("Entête Déclaration ..."),
  				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
  				javax.swing.border.TitledBorder.DEFAULT_POSITION,
  				CommonsUtilities.getFontBorderGroupBox(),
  				CommonsUtilities.COULEUR_TITRE_FRAME));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbCodeEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(codeEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
 	                .addComponent(lbNomEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(nomEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 2, 10) 
                
            );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCodeEtbl)
                                .addComponent(codeEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNomEtbl)
                                .addComponent(nomEtbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE)
                    .addGap(0, 10, Short.MAX_VALUE)	  
                		)
                    
            );
    }
    
    /**
    *
    * @param panel
    */
   private void buildDeclartionPanel(JPanel panel) {
   	panel.setBorder(javax.swing.BorderFactory.createTitledBorder(
 				null, MessagesBundle.getMessage("Déclaration Opérations Financières..."),
 				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
 				javax.swing.border.TitledBorder.DEFAULT_POSITION,
 				CommonsUtilities.getFontBorderGroupBox(),
 				CommonsUtilities.COULEUR_TITRE_FRAME));
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
       panel.setLayout(layout);
       layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
 	                .addComponent(lbreference, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)    	)
               	.addGap(0, 2, 10)
 	                .addGroup(layout.createSequentialGroup()
                       .addComponent(lbdesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(lbmontant, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(montant, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbsens, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                	.addComponent(sens, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbdevise, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(devise, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbpays, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbdateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(dateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbtype, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbmotif, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbcommentaire, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(commentaire, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)               
           );
       layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
               				 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               					.addComponent(lbreference)
                               	.addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                             	.addGap(0, 10, Short.MAX_VALUE)	      
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbdesignation)
                                 .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(0, 10, Short.MAX_VALUE)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbmontant)
                                 .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbsens)
                                 .addComponent(sens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(0, 10, Short.MAX_VALUE)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbdevise)
                                 .addComponent(devise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbpays)
                                 .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(0, 10, Short.MAX_VALUE)
 	                  		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	                          .addComponent(lbdateoperation)
 	                          .addComponent(dateoperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                          .addComponent(lbtype)
 	                          .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	                          .addGap(0, 10, Short.MAX_VALUE)	  
 	                      	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	  	                          .addComponent(lbmotif)
 	  	                          .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	  	                          .addGap(0, 10, Short.MAX_VALUE)	
 	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	  	                          .addComponent(lbcommentaire)
 	  	                          .addComponent(commentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
