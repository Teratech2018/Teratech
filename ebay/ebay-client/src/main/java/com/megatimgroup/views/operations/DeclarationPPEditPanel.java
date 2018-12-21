
package com.megatimgroup.views.operations;

import java.awt.Color;

import javax.swing.GroupLayout;
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
 * Panel d'edition DeclarationPPEditPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPPEditPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationPPIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "reference", type = java.lang.String.class, errorMessageField = "lbmreference", errorMessage = "declarationpp.reference.error")
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Champ(mappedBy = "qualite", type = com.megatimgroup.model.referentiels.Qualite.class, errorMessageField = "lbmqualite", errorMessage = "declarationpp.qualite.error")
    private CustomComboBox qualite;
    private JLabel lbqualite;
    private JLabel lbmqualite;
    @Champ(mappedBy = "titre", type = com.megatimgroup.model.referentiels.Titre.class, errorMessageField = "lbmtitre", errorMessage = "declarationpp.titre.error")
    private CustomComboBox titre;
    private JLabel lbtitre;
    private JLabel lbmtitre;
    @Champ(mappedBy = "nom", type = java.lang.String.class, errorMessageField = "lbmnom", errorMessage = "declarationpp.nom.error")
    private JTextField nom;
    private JLabel lbnom;
    private JLabel lbmnom;
    @Champ(mappedBy = "prenom", type = java.lang.String.class, errorMessageField = "lbmprenom", errorMessage = "declarationpp.prenom.error")
    private JTextField prenom;
    private JLabel lbprenom;
    private JLabel lbmprenom;
    @Champ(mappedBy = "dateNaissance", type = java.util.Date.class, errorMessageField = "lbmdatenaissance", errorMessage = "declarationpp.datenaissance.error")
    private JDateChooser datenaissance;
    private JLabel lbdatenaissance;
    private JLabel lbmdatenaissance;
    @Champ(mappedBy = "lieuNaissance", type = java.lang.String.class, errorMessageField = "lbmlieunaissance", errorMessage = "declarationpp.lieunaissance.error")
    private JTextField lieunaissance;
    private JLabel lblieunaissance;
    private JLabel lbmlieunaissance;
    @Champ(mappedBy = "nomJeuneFille", type = java.lang.String.class, errorMessageField = "lbmnomjeunefille", errorMessage = "declarationpp.nomjeunefille.error")
    private JTextField nomjeunefille;
    private JLabel lbnomjeunefille;
    private JLabel lbmnomjeunefille;
    @Champ(mappedBy = "nationalite", type = com.megatimgroup.model.referentiels.Nationalite.class, errorMessageField = "lbmnationalite", errorMessage = "declarationpp.nationalite.error")
    private CustomComboBox nationalite;
    private JLabel lbnationalite;
    private JLabel lbmnationalite;
    @Champ(mappedBy = "profession", type = java.lang.String.class, errorMessageField = "lbmprofession", errorMessage = "declarationpp.profession.error")
    private JTextField profession;
    private JLabel lbprofession;
    private JLabel lbmprofession;
    @Champ(mappedBy = "natureClientele", type = com.megatimgroup.model.referentiels.NatureClientele.class, errorMessageField = "lbmnatureclientele", errorMessage = "declarationpp.natureclientele.error")
    private CustomComboBox natureclientele;
    private JLabel lbnatureclientele;
    private JLabel lbmnatureclientele;
    @Champ(mappedBy = "statusResidence", type = com.megatimgroup.model.referentiels.StatusResidence.class, errorMessageField = "lbmstatusresidence", errorMessage = "declarationpp.statusresidence.error")
    private CustomComboBox statusresidence;
    private JLabel lbstatusresidence;
    private JLabel lbmstatusresidence;
    @Champ(mappedBy = "adresse_1", type = java.lang.String.class, errorMessageField = "lbmadresse_1", errorMessage = "declarationpp.adresse_1.error")
    private JTextField adresse_1;
    private JLabel lbadresse_1;
    private JLabel lbmadresse_1;
    @Champ(mappedBy = "adresse_2", type = java.lang.String.class, errorMessageField = "lbmadresse_2", errorMessage = "declarationpp.adresse_2.error")
    private JTextField adresse_2;
    private JLabel lbadresse_2;
    private JLabel lbmadresse_2;
    @Champ(mappedBy = "adresse_3", type = java.lang.String.class, errorMessageField = "lbmadresse_3", errorMessage = "declarationpp.adresse_3.error")
    private JTextField adresse_3;
    private JLabel lbadresse_3;
    private JLabel lbmadresse_3;
    @Champ(mappedBy = "boitepostale", type = java.lang.String.class, errorMessageField = "lbmboitepostale", errorMessage = "declarationpp.boitepostale.error")
    private JTextField boitepostale;
    private JLabel lbboitepostale;
    private JLabel lbmboitepostale;
    @Champ(mappedBy = "ville", type = com.megatimgroup.model.referentiels.Ville.class, errorMessageField = "lbmville", errorMessage = "declarationpp.ville.error")
    private CustomComboBox ville;
    private JLabel lbville;
    private JLabel lbmville;
    @Champ(mappedBy = "precisionDatenaissance", type = com.megatimgroup.model.referentiels.PrecisionDateNaissance.class, errorMessageField = "lbmprecisiondatenaissance", errorMessage = "declarationpp.precisiondatenaissance.error")
    private CustomComboBox precisiondatenaissance;
    private JLabel lbprecisiondatenaissance;
    private JLabel lbmprecisiondatenaissance;
    
    private JTextField codeEtbl;
    private JLabel lbCodeEtbl;
    private JTextField nomEtbl;
    private JLabel lbNomEtbl;
    
    private JLabel requiert;
    private JPanel hearderPanel ;
    private JPanel coprsPanel ;

    public DeclarationPPEditPanel() {
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
     *     javax.swing.JTextField
     */
    public JTextField getNom() {
        return nom;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getPrenom() {
        return prenom;
    }

    /**
     * Getter
     * 
     * @return
     *     com.toedter.calendar.JDateChooser
     */
    public JDateChooser getDateNaissance() {
        return datenaissance;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getLieuNaissance() {
        return lieunaissance;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getNomJeuneFille() {
        return nomjeunefille;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getNationalite() {
        return nationalite;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getProfession() {
        return profession;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getNatureClientele() {
        return natureclientele;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getStatusResidence() {
        return statusresidence;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getAdresse_1() {
        return adresse_1;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getAdresse_2() {
        return adresse_2;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getAdresse_3() {
        return adresse_3;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getBoitepostale() {
        return boitepostale;
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
    public CustomComboBox getPrecisionDatenaissance() {
        return precisiondatenaissance;
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
        nom = new JTextField() ;
        nom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbnom = new JLabel();
        lbmnom = new JLabel();
         lbnom.setText(MessagesBundle.getMessage( "ebay.nom")+requiert.getText());
        prenom = new JTextField() ;
        prenom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbprenom = new JLabel();
        lbmprenom = new JLabel();
         lbprenom.setText(MessagesBundle.getMessage( "ebay.prenom"));
        datenaissance = new JDateChooser() ;
        lbdatenaissance = new JLabel();
        lbmdatenaissance = new JLabel();
         lbdatenaissance.setText(MessagesBundle.getMessage( "ebay.datenaissance"));
        lieunaissance = new JTextField() ;
        lieunaissance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblieunaissance = new JLabel();
        lbmlieunaissance = new JLabel();
         lblieunaissance.setText(MessagesBundle.getMessage( "ebay.lieunaissance"));
        nomjeunefille = new JTextField() ;
        nomjeunefille.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbnomjeunefille = new JLabel();
        lbmnomjeunefille = new JLabel();
         lbnomjeunefille.setText(MessagesBundle.getMessage( "ebay.nomjeunefille")+requiert.getText());
        nationalite = new CustomComboBox() ;
        nationalite.setManager(getNationaliteManager());
        nationalite.loadData() ;
        lbnationalite = new JLabel();
        lbmnationalite = new JLabel();
         lbnationalite.setText(MessagesBundle.getMessage( "ebay.nationalite")+requiert.getText());
        profession = new JTextField() ;
        profession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbprofession = new JLabel();
        lbmprofession = new JLabel();
         lbprofession.setText(MessagesBundle.getMessage( "ebay.profession")+requiert.getText());
        natureclientele = new CustomComboBox() ;
        natureclientele.setManager(getNatureClienteleManager());
        natureclientele.loadData() ;
        lbnatureclientele = new JLabel();
        lbmnatureclientele = new JLabel();
         lbnatureclientele.setText(MessagesBundle.getMessage( "ebay.natureclientele"));
        statusresidence = new CustomComboBox() ;
        statusresidence.setManager(getStatusResidenceManager());
        statusresidence.loadData() ;
        lbstatusresidence = new JLabel();
        lbmstatusresidence = new JLabel();
         lbstatusresidence.setText(MessagesBundle.getMessage( "ebay.statusresidence")+requiert.getText());
        adresse_1 = new JTextField() ;
        adresse_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbadresse_1 = new JLabel();
        lbmadresse_1 = new JLabel();
         lbadresse_1.setText(MessagesBundle.getMessage( "ebay.adresse_1"));
        adresse_2 = new JTextField() ;
        adresse_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbadresse_2 = new JLabel();
        lbmadresse_2 = new JLabel();
         lbadresse_2.setText(MessagesBundle.getMessage( "ebay.adresse_2"));
        adresse_3 = new JTextField() ;
        adresse_3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbadresse_3 = new JLabel();
        lbmadresse_3 = new JLabel();
         lbadresse_3.setText(MessagesBundle.getMessage( "ebay.adresse_3"));
        boitepostale = new JTextField() ;
        boitepostale.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbboitepostale = new JLabel();
        lbmboitepostale = new JLabel();
         lbboitepostale.setText(MessagesBundle.getMessage( "ebay.boitepostale"));
        ville = new CustomComboBox() ;
        ville.setManager(getVilleManager());
        ville.loadData() ;
        lbville = new JLabel();
        lbmville = new JLabel();
         lbville.setText(MessagesBundle.getMessage( "ebay.ville"));
        precisiondatenaissance = new CustomComboBox() ;
        precisiondatenaissance.setManager(getPrecisionDatenaissanceManager());
        precisiondatenaissance.loadData() ;
        lbprecisiondatenaissance = new JLabel();
        lbmprecisiondatenaissance = new JLabel();
         lbprecisiondatenaissance.setText(MessagesBundle.getMessage( "ebay.precisiondatenaissance"));
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
				null, MessagesBundle.getMessage("Déclaration Personne Physisque ..."),
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
                      .addComponent(lbnom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                      .addComponent(lbprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(prenom, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbnomjeunefille, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                	.addComponent(nomjeunefille, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGap(0, 2, 10)
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(lbdatenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(datenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lblieunaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(lieunaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                      .addComponent(lbnationalite, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbqualite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(qualite, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                      .addComponent(lbtitre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbprofession, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                      .addComponent(lbnatureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(natureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbstatusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(statusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(lbville, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbboitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(boitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                      .addComponent(lbprecisiondatenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(precisiondatenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbadresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(adresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                      .addComponent(lbadresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(adresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                      .addComponent(lbadresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
  	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
  	                .addComponent(adresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(lbnom)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE)	
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbprenom)
                                .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbnomjeunefille)
                                .addComponent(nomjeunefille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE)
	                  		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                          .addComponent(lbdatenaissance)
	                          .addComponent(datenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                          .addComponent(lblieunaissance)
	                          .addComponent(lieunaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                          .addGap(0, 10, Short.MAX_VALUE)	  
	                      	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	  	                          .addComponent(lbnationalite)
	  	                          .addComponent(nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	  	                          .addComponent(lbqualite)
	  	                          .addComponent(qualite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	  	                          .addGap(0, 10, Short.MAX_VALUE)	
	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	  	                          .addComponent(lbtitre)
	  	                          .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	  	                          .addComponent(lbprofession)
	  	                          .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	  	                          .addGap(0, 10, Short.MAX_VALUE)	
	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	  	                          .addComponent(lbnatureclientele)
	  	                          .addComponent(natureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	  	                          .addComponent(lbstatusresidence)
	  	                          .addComponent(statusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	  	                          .addGap(0, 10, Short.MAX_VALUE)	
  	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  	  	                          .addComponent(lbville)
  	  	                          .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
  	  	                          .addComponent(lbboitepostale)
  	  	                          .addComponent(boitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  	  	                          .addGap(0, 10, Short.MAX_VALUE)
  	  	                  	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  	  	                          .addComponent(lbprecisiondatenaissance)
  	  	                          .addComponent(precisiondatenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
  	  	                          .addComponent(lbadresse_1)
  	  	                          .addComponent(adresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  	  	                          .addGap(0, 10, Short.MAX_VALUE)	
  	                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  	  	                          .addComponent(lbadresse_2)
  	  	                          .addComponent(adresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
  	  	                          .addComponent(lbadresse_3)
  	  	                          .addComponent(adresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  	  	                          .addGap(0, 10, Short.MAX_VALUE)	
	  	  	                          
                  	  
              		)
                  
          );
  }

}
