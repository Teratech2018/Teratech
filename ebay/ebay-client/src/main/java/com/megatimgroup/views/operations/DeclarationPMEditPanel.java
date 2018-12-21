
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
 * Panel d'edition DeclarationPMEditPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPMEditPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.DeclarationPMIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "reference", type = java.lang.String.class, errorMessageField = "lbmreference", errorMessage = "declarationpm.reference.error")
    private JTextField reference;
    private JLabel lbreference;
    private JLabel lbmreference;
    @Champ(mappedBy = "raisonSocial", type = java.lang.String.class, errorMessageField = "lbmraisonsocial", errorMessage = "declarationpm.raisonsocial.error")
    private JTextField raisonsocial;
    private JLabel lbraisonsocial;
    private JLabel lbmraisonsocial;
    @Champ(mappedBy = "sigle", type = java.lang.String.class, errorMessageField = "lbmsigle", errorMessage = "declarationpm.sigle.error")
    private JTextField sigle;
    private JLabel lbsigle;
    private JLabel lbmsigle;
    @Champ(mappedBy = "siegeSocial", type = java.lang.String.class, errorMessageField = "lbmsiegesocial", errorMessage = "declarationpm.siegesocial.error")
    private JTextField siegesocial;
    private JLabel lbsiegesocial;
    private JLabel lbmsiegesocial;
    @Champ(mappedBy = "registreCommerce", type = java.lang.String.class, errorMessageField = "lbmregistrecommerce", errorMessage = "declarationpm.registrecommerce.error")
    private JTextField registrecommerce;
    private JLabel lbregistrecommerce;
    private JLabel lbmregistrecommerce;
    @Champ(mappedBy = "nomAbrege", type = java.lang.String.class, errorMessageField = "lbmnomabrege", errorMessage = "declarationpm.nomabrege.error")
    private JTextField nomabrege;
    private JLabel lbnomabrege;
    private JLabel lbmnomabrege;
    @Champ(mappedBy = "codeStatistique", type = java.lang.String.class, errorMessageField = "lbmcodestatistique", errorMessage = "declarationpm.codestatistique.error")
    private JTextField codestatistique;
    private JLabel lbcodestatistique;
    private JLabel lbmcodestatistique;
    @Champ(mappedBy = "natureJuridique", type = com.megatimgroup.model.referentiels.NatureJuridique.class, errorMessageField = "lbmnaturejuridique", errorMessage = "declarationpm.naturejuridique.error")
    private CustomComboBox naturejuridique;
    private JLabel lbnaturejuridique;
    private JLabel lbmnaturejuridique;
    @Champ(mappedBy = "dateCreation", type = java.util.Date.class, errorMessageField = "lbmdatecreation", errorMessage = "declarationpm.datecreation.error")
    private JDateChooser datecreation;
    private JLabel lbdatecreation;
    private JLabel lbmdatecreation;
    @Champ(mappedBy = "natureClientele", type = com.megatimgroup.model.referentiels.NatureClientele.class, errorMessageField = "lbmnatureclientele", errorMessage = "declarationpm.natureclientele.error")
    private CustomComboBox natureclientele;
    private JLabel lbnatureclientele;
    private JLabel lbmnatureclientele;
    @Champ(mappedBy = "objetSocial", type = java.lang.String.class, errorMessageField = "lbmobjetsocial", errorMessage = "declarationpm.objetsocial.error")
    private JTextField objetsocial;
    private JLabel lbobjetsocial;
    private JLabel lbmobjetsocial;
    @Champ(mappedBy = "statusResidence", type = com.megatimgroup.model.referentiels.StatusResidence.class, errorMessageField = "lbmstatusresidence", errorMessage = "declarationpm.statusresidence.error")
    private CustomComboBox statusresidence;
    private JLabel lbstatusresidence;
    private JLabel lbmstatusresidence;
    @Champ(mappedBy = "adresse_1", type = java.lang.String.class, errorMessageField = "lbmadresse_1", errorMessage = "declarationpm.adresse_1.error")
    private JTextField adresse_1;
    private JLabel lbadresse_1;
    private JLabel lbmadresse_1;
    @Champ(mappedBy = "adresse_2", type = java.lang.String.class, errorMessageField = "lbmadresse_2", errorMessage = "declarationpm.adresse_2.error")
    private JTextField adresse_2;
    private JLabel lbadresse_2;
    private JLabel lbmadresse_2;
    @Champ(mappedBy = "adresse_3", type = java.lang.String.class, errorMessageField = "lbmadresse_3", errorMessage = "declarationpm.adresse_3.error")
    private JTextField adresse_3;
    private JLabel lbadresse_3;
    private JLabel lbmadresse_3;
    @Champ(mappedBy = "boitepostale", type = java.lang.String.class, errorMessageField = "lbmboitepostale", errorMessage = "declarationpm.boitepostale.error")
    private JTextField boitepostale;
    private JLabel lbboitepostale;
    private JLabel lbmboitepostale;
    @Champ(mappedBy = "ville", type = com.megatimgroup.model.referentiels.Ville.class, errorMessageField = "lbmville", errorMessage = "declarationpm.ville.error")
    private CustomComboBox ville;
    private JLabel lbville;
    private JLabel lbmville;
    @Champ(mappedBy = "fax", type = java.lang.String.class, errorMessageField = "lbmfax", errorMessage = "declarationpm.fax.error")
    private JTextField fax;
    private JLabel lbfax;
    private JLabel lbmfax;
    @Champ(mappedBy = "telephone1", type = java.lang.String.class, errorMessageField = "lbmtelephone1", errorMessage = "declarationpm.telephone1.error")
    private JTextField telephone1;
    private JLabel lbtelephone1;
    private JLabel lbmtelephone1;
    @Champ(mappedBy = "telephone2", type = java.lang.String.class, errorMessageField = "lbmtelephone2", errorMessage = "declarationpm.telephone2.error")
    private JTextField telephone2;
    private JLabel lbtelephone2;
    private JLabel lbmtelephone2;
    @Champ(mappedBy = "telephone3", type = java.lang.String.class, errorMessageField = "lbmtelephone3", errorMessage = "declarationpm.telephone3.error")
    private JTextField telephone3;
    private JLabel lbtelephone3;
    private JLabel lbmtelephone3;
    @Champ(mappedBy = "email", type = java.lang.String.class, errorMessageField = "lbmemail", errorMessage = "declarationpm.email.error")
    private JTextField email;
    private JLabel lbemail;
    private JLabel lbmemail;
    @Champ(mappedBy = "section", type = com.megatimgroup.model.referentiels.Section.class, errorMessageField = "lbmsection", errorMessage = "declarationpm.section.error")
    private CustomComboBox section;
    private JLabel lbsection;
    private JLabel lbmsection;
    @Champ(mappedBy = "division", type = com.megatimgroup.model.referentiels.Division.class, errorMessageField = "lbmdivision", errorMessage = "declarationpm.division.error")
    private CustomComboBox division;
    private JLabel lbdivision;
    private JLabel lbmdivision;
    @Champ(mappedBy = "groupe", type = com.megatimgroup.model.referentiels.Groupe.class, errorMessageField = "lbmgroupe", errorMessage = "declarationpm.groupe.error")
    private CustomComboBox groupe;
    private JLabel lbgroupe;
    private JLabel lbmgroupe;
    @Champ(mappedBy = "classe", type = com.megatimgroup.model.referentiels.Classe.class, errorMessageField = "lbmclasse", errorMessage = "declarationpm.classe.error")
    private CustomComboBox classe;
    private JLabel lbclasse;
    private JLabel lbmclasse;
    
    private JTextField codeEtbl;
    private JLabel lbCodeEtbl;
    private JTextField nomEtbl;
    private JLabel lbNomEtbl;
    
    private JLabel requiert;
    
    
    private JPanel hearderPanel ;
    private JPanel coprsPanel ;

    public DeclarationPMEditPanel() {
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
    public JTextField getRaisonSocial() {
        return raisonsocial;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getSigle() {
        return sigle;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getSiegeSocial() {
        return siegesocial;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getRegistreCommerce() {
        return registrecommerce;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getNomAbrege() {
        return nomabrege;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getCodeStatistique() {
        return codestatistique;
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
     *     com.toedter.calendar.JDateChooser
     */
    public JDateChooser getDateCreation() {
        return datecreation;
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
     *     javax.swing.JTextField
     */
    public JTextField getObjetSocial() {
        return objetsocial;
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
     *     javax.swing.JTextField
     */
    public JTextField getFax() {
        return fax;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getTelephone1() {
        return telephone1;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getTelephone2() {
        return telephone2;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getTelephone3() {
        return telephone3;
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getEmail() {
        return email;
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
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getDivision() {
        return division;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getGroupe() {
        return groupe;
    }

    /**
     * Getter
     * 
     * @return
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getClasse() {
        return classe;
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
        codeEtbl = new JTextField() ;
        codeEtbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbCodeEtbl = new JLabel();
        lbCodeEtbl.setText(MessagesBundle.getMessage( "ebay.code.etbl"));
        
        nomEtbl = new JTextField() ;
        nomEtbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbNomEtbl = new JLabel();
        lbNomEtbl.setText(MessagesBundle.getMessage( "ebay.nom.etbl"));
        requiert= new JLabel();
        requiert.setText("*");
        requiert.setForeground(Color.RED);
        requiert.setBackground(Color.RED);
        
        codeEtbl.setText(CurrentSessionInformations.getCurrentSociete().getCode());
        nomEtbl.setText(CurrentSessionInformations.getCurrentSociete().getIdentifiant());
        raisonsocial = new JTextField() ;
        raisonsocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbraisonsocial = new JLabel();
        lbmraisonsocial = new JLabel();
         lbraisonsocial.setText(MessagesBundle.getMessage( "ebay.raisonsocial")+requiert.getText());
        sigle = new JTextField() ;
        sigle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbsigle = new JLabel();
        lbmsigle = new JLabel();
         lbsigle.setText(MessagesBundle.getMessage( "ebay.sigle")+requiert.getText());
        siegesocial = new JTextField() ;
        siegesocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbsiegesocial = new JLabel();
        lbmsiegesocial = new JLabel();
         lbsiegesocial.setText(MessagesBundle.getMessage( "ebay.siegesocial")+requiert.getText());
        registrecommerce = new JTextField() ;
        registrecommerce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbregistrecommerce = new JLabel();
        lbmregistrecommerce = new JLabel();
         lbregistrecommerce.setText(MessagesBundle.getMessage( "ebay.registrecommerce"));
        nomabrege = new JTextField() ;
        nomabrege.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbnomabrege = new JLabel();
        lbmnomabrege = new JLabel();
         lbnomabrege.setText(MessagesBundle.getMessage( "ebay.nomabrege"));
        codestatistique = new JTextField() ;
        codestatistique.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbcodestatistique = new JLabel();
        lbmcodestatistique = new JLabel();
         lbcodestatistique.setText(MessagesBundle.getMessage( "ebay.codestatistique"));
        naturejuridique = new CustomComboBox() ;
        naturejuridique.setManager(getNatureJuridiqueManager());
        naturejuridique.loadData() ;
        lbnaturejuridique = new JLabel();
        lbmnaturejuridique = new JLabel();
         lbnaturejuridique.setText(MessagesBundle.getMessage( "ebay.naturejuridique")+requiert.getText());
        datecreation = new JDateChooser() ;
        lbdatecreation = new JLabel();
        lbmdatecreation = new JLabel();
         lbdatecreation.setText(MessagesBundle.getMessage( "ebay.datecreation"));
        natureclientele = new CustomComboBox() ;
        natureclientele.setManager(getNatureClienteleManager());
        natureclientele.loadData() ;
        lbnatureclientele = new JLabel();
        lbmnatureclientele = new JLabel();
         lbnatureclientele.setText(MessagesBundle.getMessage( "ebay.natureclientele"));
        objetsocial = new JTextField() ;
        objetsocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbobjetsocial = new JLabel();
        lbmobjetsocial = new JLabel();
         lbobjetsocial.setText(MessagesBundle.getMessage( "ebay.objetsocial")+requiert.getText());
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
         lbville.setText(MessagesBundle.getMessage( "ebay.ville")+requiert.getText());
        fax = new JTextField() ;
        fax.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbfax = new JLabel();
        lbmfax = new JLabel();
         lbfax.setText(MessagesBundle.getMessage( "ebay.fax"));
        telephone1 = new JTextField() ;
        telephone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbtelephone1 = new JLabel();
        lbmtelephone1 = new JLabel();
         lbtelephone1.setText(MessagesBundle.getMessage( "ebay.telephone1"));
        telephone2 = new JTextField() ;
        telephone2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbtelephone2 = new JLabel();
        lbmtelephone2 = new JLabel();
         lbtelephone2.setText(MessagesBundle.getMessage( "ebay.telephone2"));
        telephone3 = new JTextField() ;
        telephone3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbtelephone3 = new JLabel();
        lbmtelephone3 = new JLabel();
         lbtelephone3.setText(MessagesBundle.getMessage( "ebay.telephone3"));
        email = new JTextField() ;
        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbemail = new JLabel();
        lbmemail = new JLabel();
         lbemail.setText(MessagesBundle.getMessage( "ebay.email"));
        section = new CustomComboBox() ;
        section.setManager(getSectionManager());
        section.loadData() ;
        lbsection = new JLabel();
        lbmsection = new JLabel();
         lbsection.setText(MessagesBundle.getMessage( "ebay.section")+requiert.getText());
        division = new CustomComboBox() ;
        division.setManager(getDivisionManager());
        division.loadData() ;
        lbdivision = new JLabel();
        lbmdivision = new JLabel();
         lbdivision.setText(MessagesBundle.getMessage( "ebay.division")+requiert.getText());
        groupe = new CustomComboBox() ;
        groupe.setManager(getGroupeManager());
        groupe.loadData() ;
        lbgroupe = new JLabel();
        lbmgroupe = new JLabel();
         lbgroupe.setText(MessagesBundle.getMessage( "ebay.groupe")+requiert.getText());
        classe = new CustomComboBox() ;
        classe.setManager(getClasseManager());
        classe.loadData() ;
        lbclasse = new JLabel();
        lbmclasse = new JLabel();
         lbclasse.setText(MessagesBundle.getMessage( "ebay.classe")+requiert.getText());
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
 				null, MessagesBundle.getMessage("Déclaration Personne Morale ..."),
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
                       .addComponent(lbraisonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(raisonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(lbregistrecommerce, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(registrecommerce, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbsigle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                	.addComponent(sigle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbsiegesocial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(siegesocial, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbdatecreation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(datecreation, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbnomabrege, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(nomabrege, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbnatureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(natureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbnaturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(naturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbcodestatistique, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(codestatistique, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbstatusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(statusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbville, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10).
                   addGroup(layout.createSequentialGroup()
                       .addComponent(lbboitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(boitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbsection, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbdivision, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(division, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbgroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(groupe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbclasse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(classe, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbfax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbtelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(telephone1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbtelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(telephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbtelephone3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(telephone3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(lbadresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(adresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                       .addComponent(lbadresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
   	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
   	                .addComponent(adresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(0, 2, 10)
                    .addGroup(layout.createSequentialGroup()
                       .addComponent(lbadresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(adresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                 .addComponent(lbraisonsocial)
                                 .addComponent(raisonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(0, 10, Short.MAX_VALUE)	
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbregistrecommerce)
                                 .addComponent(registrecommerce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(lbsigle)
                                 .addComponent(sigle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(0, 10, Short.MAX_VALUE)
 	                  		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	                          .addComponent(lbsiegesocial)
 	                          .addComponent(siegesocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                          .addComponent(lbdatecreation)
 	                          .addComponent(datecreation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	                          .addGap(0, 10, Short.MAX_VALUE)	  
 	                      	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	  	                          .addComponent(lbnomabrege)
 	  	                          .addComponent(nomabrege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 	  	                          .addComponent(lbnatureclientele)
 	  	                          .addComponent(natureclientele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	  	                          .addGap(0, 10, Short.MAX_VALUE)	
 	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	  	                          .addComponent(lbnaturejuridique)
 	  	                          .addComponent(naturejuridique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 	  	                          .addComponent(lbcodestatistique)
 	  	                          .addComponent(codestatistique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	  	                          .addGap(0, 10, Short.MAX_VALUE)	
 	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 	  	                          .addComponent(lbstatusresidence)
 	  	                          .addComponent(statusresidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 	  	                          .addComponent(lbville)
 	  	                          .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	                    	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbboitepostale)
   	  	                          .addComponent(boitepostale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbsection)
   	  	                          .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)
   	  	                  	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbdivision)
   	  	                          .addComponent(division, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbgroupe)
   	  	                          .addComponent(groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	  	                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbclasse)
   	  	                          .addComponent(classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbfax)
   	  	                          .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	  	                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbemail)
   	  	                          .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbtelephone1)
   	  	                          .addComponent(telephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	  	                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbtelephone2)
   	  	                          .addComponent(telephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbtelephone3)
   	  	                          .addComponent(telephone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
   	  	                          .addComponent(lbadresse_1)
   	  	                          .addComponent(adresse_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   	  	                          .addComponent(lbadresse_2)
   	  	                          .addComponent(adresse_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
   	  	                          .addGap(0, 10, Short.MAX_VALUE)	
   	  	                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      	  	                          .addComponent(lbadresse_3)
      	  	                          .addComponent(adresse_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
