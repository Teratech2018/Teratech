
package com.megatimgroup.views.parametres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Champ;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatim.common.clients.BannierePanel;
import com.megatim.common.clients.CommonsUtilities;
import com.megatim.common.clients.Messages;
import com.megatim.common.clients.NotificationType;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.parametres.Societe;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author user
 */
public class SocieteIFrame extends javax.swing.JInternalFrame {

    private IocContext ctx;
    private GenericManager manager;
    private Societe societe = null;

    /**
     * Creates new form SocieteIFrame
     */
    public SocieteIFrame() {
        ctx = new IocContext();
        manager = getManager();
        initComponents();
        getSociete();
        getBanniere(MessagesBundle.getMessage("ebay.etablissement.financiere").toUpperCase());
        fillBean();
    }

    public void fillBean() {
        try {
            RestrictionsContainer container = RestrictionsContainer.newInstance();
            List<Societe> societes = getManager().filter(container.getPredicats(), null, null, 0, -1);

            if (societes == null || societes.isEmpty()) {
                return;
            }
           // tfcode.setEditable(false);
       //     tfcode.setBackground(CommonsUtilities.desableFieldColor());
            societe = societes.get(0);
            ValidateAndFillBeans.fillViewBean(societe, this);
            if (societe.getLogo() != null) {

                if (apercuPanel != null) {
                    imagePanel.remove(apercuPanel);
                }
                ImageIcon imageIcon = new ImageIcon(societe.getLogo());
                apercuPanel = new BannierePanel(imageIcon.getImage());
                imagePanel.add(apercuPanel, BorderLayout.CENTER);
            }
          
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    private void getSociete() {
        List<Societe> liste = manager.findAll();

        if (!liste.isEmpty()) {

            try {
                societe = liste.get(0);

            } catch (Exception ex) {
                Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            societe = new Societe();
        }

    }

    /**
     *
     * @return
     */
    private GenericManager getManager() {
        GenericManager manager = null;
        try {
            manager = (GenericManager) ctx.lookup("com.megatimgroup.core.impl.parametres.SocieteManagerImpl");
        } catch (InstantiationException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return manager;
    }

    public void getBanniere(String title) {
        JLabel lblIcon = new javax.swing.JLabel();
        JLabel lblTitle = new javax.swing.JLabel();
        //Intitialisation logo
        //this.setIconImage(CommonsUtilities.getIcon());
        this.setTitle(getTitle());
        //traitement du panel Header
        this.jPanelBanniere.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/megatim/tools/images/BtitreNew.png"));

        JPanel entetePanel = new BannierePanel(icon.getImage());

        lblTitle.setFont(new java.awt.Font(CommonsUtilities.POLICE_APPLICATION, 1, 20));
        lblTitle.setForeground(CommonsUtilities.COULEUR_TITRE_FRAME);
        lblTitle.setText(title);
        lblTitle.setName("lblTitle"); // NOI18N
        entetePanel.add(lblTitle);
        this.jPanelBanniere.add(entetePanel, BorderLayout.CENTER);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        extensionPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
         jLabel14 = new javax.swing.JLabel();
     
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        formatPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        paramPanel= new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
             jButton3 = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();
        numerotationPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
       
        jLabel22 = new javax.swing.JLabel();
  
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
       
        jButton5 = new javax.swing.JButton();

        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel24 = new javax.swing.JLabel();

        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        identification = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        raisonsocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        activite = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        complement = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        codepostal = new javax.swing.JTextField();
        ville = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        region = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        identifiant = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        telecopie = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        siteweb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pays = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        options_list1 = new javax.swing.JList();
        btnAnnuler = new javax.swing.JButton();
        btnValider = new javax.swing.JButton();
        jPanelBanniere = new javax.swing.JPanel();
        tfimagefileName= new JTextField();
        tfcode= new JTextField();
        jLabel18.setText("Logo");
        requiert= new JLabel();
        requiert.setText("*");
        requiert.setForeground(Color.RED);
        requiert.setBackground(Color.RED);
        tfimagefileName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfimagefileName.setEnabled(false);
        
        lbpassagerId = new JLabel("Préfixe ID Client De Passage");
        txtpassagerId= new JTextField();        
        lbin = new JLabel("Repèrtoire IN");
        txtIn= new JTextField();   
        lbOut = new JLabel("Repètoire OUT");
        txtOut= new JTextField();   
        lbErr = new JLabel("Repètoire ERR");
        txtErr= new JTextField();   
        jBtnIn = new JButton();
        jBtnOut = new JButton();
        jBtnErr = new JButton();
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jBtnIn.setText("...");
        jBtnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBtnInActionPerformed(evt);
            }
        });

        jBtnOut.setText("...");
        jBtnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBtnOutActionPerformed(evt);
            }
        });

        jBtnErr.setText("...");
        jBtnErr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jBtnErrActionPerformed(evt);
            }
        });

        imagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Apercu "));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(logoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfimagefileName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfimagefileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        imagePanel.setLayout(new BorderLayout());

        javax.swing.GroupLayout numerotationPanelLayout = new javax.swing.GroupLayout(paramPanel);
        paramPanel.setLayout(numerotationPanelLayout);
        numerotationPanelLayout.setHorizontalGroup(
        		numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(numerotationPanelLayout.createSequentialGroup()
 	                .addComponent(lbpassagerId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(txtpassagerId, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                 	.addGroup(numerotationPanelLayout.createSequentialGroup()
 	                .addComponent(lbin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(txtIn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(jBtnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                 	.addGroup(numerotationPanelLayout.createSequentialGroup()
 	                .addComponent(lbOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(txtOut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(jBtnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                 	.addGroup(numerotationPanelLayout.createSequentialGroup()
 	                .addComponent(lbErr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 	                .addComponent(txtErr, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
 	                .addComponent(jBtnErr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                 	)
                
             );
        numerotationPanelLayout.setVerticalGroup(
        		numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(numerotationPanelLayout.createSequentialGroup()
                 		.addGroup(numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbpassagerId)
                                 .addComponent(txtpassagerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 	
                             	.addGroup(numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbin)
                                 .addComponent(txtIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(jBtnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                  .addGroup(numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbOut)
                                 .addComponent(txtOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(jBtnOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 

                                .addGroup(numerotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(lbErr)
                                 .addComponent(txtErr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(jBtnErr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 

                             .addGap(0, 10, Short.MAX_VALUE)
                     		
                 		)
                     
             );
        setClosable(true);
        setResizable(true);

        jLabel1.setText("Raison Social");

        raisonsocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Activité");

        activite.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setText("Adresse");

        adresse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("Complément");

        complement.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setText("CP / Ville");

        codepostal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        ville.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setText("Region / Pays");

        region.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setText("Nom Déclarant"+requiert.getText());

        identifiant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
 				null, MessagesBundle.getMessage("ebay.societeiframe.titre.panel2"),
 				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
 				javax.swing.border.TitledBorder.DEFAULT_POSITION,
 				CommonsUtilities.getFontBorderGroupBox(),
 				CommonsUtilities.COULEUR_TITRE_FRAME));

        jLabel9.setText("Téléphone");

        telephone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setText("Télécopie");

        telecopie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setText("E-Mail");

        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        siteweb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel12.setText("Site Web");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telecopie, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addComponent(email)
                    .addComponent(siteweb)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(telecopie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siteweb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel26.setText("Code Déclarant"+requiert.getText());

        tfcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        pays.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CAMEROUN", "CONGO", "GABON", "GUINEE EQUATORIALE", "REPUBLIQUE CENTRAFRICAINE", "TCHAD" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(raisonsocial)
                    .addComponent(activite)
                    .addComponent(adresse)
                    .addComponent(complement)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(region, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(codepostal, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ville)
                            .addComponent(pays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfcode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tfcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(raisonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(activite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(complement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(codepostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        identification.addTab("Identification", jPanel4);

        

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        optionsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        optionsPanel.setLayout(new java.awt.BorderLayout());

        options_list1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Logo Application","Paramètres" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        options_list1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                options_list1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(options_list1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        identification.addTab("Options", jPanel6);

        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        btnValider.setText("Valider");
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(identification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnValider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnnuler)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuler)
                    .addComponent(btnValider))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelBanniereLayout = new javax.swing.GroupLayout(jPanelBanniere);
        jPanelBanniere.setLayout(jPanelBanniereLayout);
        jPanelBanniereLayout.setHorizontalGroup(
            jPanelBanniereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBanniereLayout.setVerticalGroup(
            jPanelBanniereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBanniere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelBanniere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        try {
            // TODO add your handling code here:
            //societe = new Societe();
            societe = ValidateAndFillBeans.fillBean(this, societe);
            	if(this.beforeSave()){
            		 if(getManager().find("code", societe.getCode()) == null){
                         getManager().save(societe);
                     }else{
                     getManager().update(societe.getCode(), societe);
                    }
                     this.dispose();
            	}else{
            	  Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage("ebay.valeur.obligatoire.null"), MessagesBundle.getMessage("ebay.valeur.obligatoire.null"), "");
            	}
               
          //  this.dispose();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnValiderActionPerformed
    
    public boolean beforeSave() {
    	String eror = "ebay.valeur.obligatoire.null";
    	boolean value = true;
        if (societe.getCode()== null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            value=false;
            return value;
        }
        if(societe.getIdentifiant() == null) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage(eror), MessagesBundle.getMessage(eror), "");
            value=false;
            return value;
        }
		return value; 
     
        }


    private void tfextensionsecuriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfextensionsecuriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfextensionsecuriseActionPerformed

    private void tfexportedPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfexportedPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfexportedPathActionPerformed

    private void tfsaveexportpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsaveexportpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfsaveexportpathActionPerformed

    private void options_list1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_options_list1ValueChanged
        // TODO add your handling code here:
        //System.out.println("SocieteIFrame.options_list1ValueChanged(javax.swing.event.ListSelectionEvent evt) :::::::::::    " + options_list1.getSelectedValue());
        loadPanel(options_list1.getSelectedIndex());
    }//GEN-LAST:event_options_list1ValueChanged



    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif", "png");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                ImageIcon imageIcon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                tfimagefileName.setText(chooser.getSelectedFile().getName());
                image = Files.readAllBytes(chooser.getSelectedFile().toPath());
                if (apercuPanel == null) {
                    imagePanel.setLayout(new BorderLayout());
                    apercuPanel = new BannierePanel(imageIcon.getImage());
                    imagePanel.add(apercuPanel, BorderLayout.CENTER);
                } else {
                    imagePanel.remove(apercuPanel);
                    apercuPanel = new BannierePanel(imageIcon.getImage());
                    imagePanel.add(apercuPanel, BorderLayout.CENTER);
                }
                societe.setLogo(image);
            }
        } catch (IOException ex) {
            Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * 
     * @param evt 
     */
    private void jBtnInActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                       
        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte","txt");
//        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File sourceFile = chooser.getSelectedFile();
            txtIn.setText(sourceFile.getAbsolutePath());
        }
       
    }   

    /**
     * 
     * @param evt 
     */
    private void jBtnOutActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                       
        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte","txt");
//        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File sourceFile = chooser.getSelectedFile();
            txtOut.setText(sourceFile.getAbsolutePath());
        }
       
    }   
    
    /**
     * 
     * @param evt 
     */
    private void jBtnErrActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                       
        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte","txt");
//        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File sourceFile = chooser.getSelectedFile();
            txtErr.setText(sourceFile.getAbsolutePath());
        }
       
    }   

    public JComboBox getPays() {
        return pays;
    }

    public void setPays(JComboBox pays) {
        this.pays = pays;
    }
    
    /**
     *
     * @param index
     */
    private void loadPanel(int index) {
        if (optionsPanel == null) {
            return;
        }
        switch (index) {
           
            case 0:
                if (currentPanel != null) {
                    optionsPanel.remove(currentPanel);
                }
                currentPanel = logoPanel;
                optionsPanel.add(currentPanel, BorderLayout.CENTER);
                return;
            case 1:
                if (currentPanel != null) {
                    optionsPanel.remove(currentPanel);
                }
                currentPanel = paramPanel;
                optionsPanel.add(currentPanel, BorderLayout.CENTER);
                return;
            default:
                return;
        }
    }
    
    private boolean ifFieldsIsValidated() {

        if (!societe.getCode().isEmpty() && societe.getCode() != null) {

        	return false;

        } else {

            //  Notification.getNotificationDialog(PrincipalFrame.principalScreen, true, NotificationType.ERROR, MessagesBundle.getMessage("tierpartenaire.identifiant.null"), MessagesBundle.getMessage("tierpartenaire.identifiant.detail"));
            return false;

        }

    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
  
    private javax.swing.JTabbedPane identification;
    @Champ(mappedBy = "code",nullable = false,type = String.class)
    private javax.swing.JTextField tfcode;
    @Champ(mappedBy = "activite",type = String.class)
    private javax.swing.JTextField activite;
    @Champ(mappedBy = "adresse",type = String.class)
    private javax.swing.JTextField adresse;
    @Champ(mappedBy = "codePostal",type = String.class)
    private javax.swing.JTextField codepostal;
    @Champ(mappedBy = "complement",type = String.class)
    private javax.swing.JTextField complement;
    @Champ(mappedBy = "email",nullable = false,type = String.class)
    private javax.swing.JTextField email;
    private javax.swing.JPanel extensionPanel;
    private javax.swing.JPanel formatPanel;
    @Champ(mappedBy = "identifiant",type = String.class)
    private javax.swing.JTextField identifiant;
    @Champ(mappedBy = "pays",type = String.class)
    private javax.swing.JComboBox pays;
    @Champ(mappedBy = "raisonSocial",nullable = false,type = String.class)
    private javax.swing.JTextField raisonsocial;
    @Champ(mappedBy = "region",type = String.class)
    private javax.swing.JTextField region;
    @Champ(mappedBy = "siteWeb",nullable = false,type = String.class)
    private javax.swing.JTextField siteweb;
    @Champ(mappedBy = "telecopie",nullable = false,type = String.class)
    private javax.swing.JTextField telecopie;
    @Champ(mappedBy = "telephone",type = String.class)
    private javax.swing.JTextField telephone;
    @Champ(mappedBy = "ville",type = String.class)
    private javax.swing.JTextField ville;
    @Champ(mappedBy = "pPassagerId",type = String.class)
    private JTextField txtpassagerId ;
    
    @Champ(mappedBy = "inRepository",type = String.class)
    private JTextField  txtIn;
    private JLabel lbin;
    @Champ(mappedBy = "outRepository",type = String.class)
    private JTextField  txtOut;
    private JLabel lbOut;
    @Champ(mappedBy = "errRepository",type = String.class)
    private JTextField  txtErr;
    private JLabel lbErr;
    private JLabel requiert;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnValider;
    
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    
    private javax.swing.JPanel jPanelBanniere;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel numerotationPanel;
    private javax.swing.JPanel paramPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JList options_list1;
    private JPanel currentPanel;
    private BannierePanel apercuPanel = null;
    private JTextField  tfimagefileName;
    private JLabel lbpassagerId;
    
 
    private javax.swing.JButton jBtnIn;
    private javax.swing.JButton jBtnOut;
    private javax.swing.JButton jBtnErr;
  
    private byte[] image;
    
   

}
