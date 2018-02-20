/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatim.common.clients;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.TypeOperation;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author DEV_4
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractTransfertTemplateDialog<T extends Object, PK extends Serializable>
        extends javax.swing.JDialog implements KeyListener {

    /**
     *
     * @param parent
     * @param modal
     * @param type
     * @param datas
     */
    public AbstractTransfertTemplateDialog(JFrame parent, boolean modal, TypeOperation type, List<T> datas) {
        super(parent, modal);
        this.typeOperation = type;
        initComponents();
        buildViewComponents(datas);
        this.addKeyListener(this);

    }

    /**
     *
     * @param owner
     * @param datas
     */
    public AbstractTransfertTemplateDialog(Frame owner, List<T> datas) {
        super(owner);
        buildViewComponents(datas);
        this.addKeyListener(this);
    }

    /**
     *
     * @param owner
     * @param title
     * @param datas
     */
    public AbstractTransfertTemplateDialog(Frame owner, String title, List<T> datas) {
        super(owner, title);
        buildViewComponents(datas);
        this.addKeyListener(this);
    }

    /**
     *
     * @param datas
     */
    public AbstractTransfertTemplateDialog(List<T> datas) {

        this.setModal(true);
        initComponents();
        buildViewComponents(datas);
        this.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btsave = new javax.swing.JButton();
        btcancel = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanel.setPreferredSize(new java.awt.Dimension(0, 60));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        btsave.setText("Enregistrer");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        btcancel.setText("Quitter");
        btcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(btsave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btcancel, btsave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btcancel, btsave});

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelActionPerformed
        // TODO add your handling code here:
        quitter();
    }//GEN-LAST:event_btcancelActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btsaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancel;
    protected javax.swing.JButton btsave;
    private javax.swing.JPanel centerPanel;
    protected javax.swing.JTable dataTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    protected javax.swing.JPanel middlePanel;
    protected AbstractListTemplateFrame parentFrame;
    protected T currentObject = null;
    protected GenericManager manager = null;
    protected TypeOperation typeOperation = TypeOperation.NEW;
    protected boolean interne = Boolean.FALSE;
    protected AbstractTableBaseListModel model = null;
    protected int selectedRow = -1;
    protected List<T> datas = null;

    /**
     * ******************************************************************************************************
     */
    /**
     *
     *********************************************************************************************************
     */
    /**
     * Construction de l'interface graphique
     *
     * @param datas
     */
    public void buildViewComponents(List<T> datas) {
        //Construction de la banniere
        buildBanniere();
        //centerPanel.setLayout(new BorderLayout());
        //middlePanel = getFiledsPanel();
        //centerPanel.add(middlePanel, BorderLayout.CENTER);
        this.datas = datas;
        if (typeOperation == TypeOperation.VIEW) {
            btsave.setEnabled(false);
            btsave.setVisible(false);
        }
        btsave.setText(getSaveTitle());
        btsave.setToolTipText(getSaveTooltip());
        btsave.setIcon(getSaveIcon());
        btcancel.setText(getCancelTitle());
        btcancel.setToolTipText(getCancelTooltip());
        btcancel.setIcon(getCancelIcon());

    }

    /**
     * Construction de la banniere de l'application
     */
    public void buildBanniere() {
        JLabel lblIcon = new javax.swing.JLabel();
        JLabel lblTitle = new javax.swing.JLabel();
        //Intitialisation logo
        ImageIcon icon = CommonsUtilities.getIcone();
        this.setIconImage(icon.getImage());
        this.setTitle(getTitle());
        //traitement du panel Header
        headerPanel.setLayout(new BorderLayout());
        if (getHeaderPanel() != null) {
            JPanel entetePanel = getHeaderPanel();
            lblIcon.setIcon(getImage());
            entetePanel.add(lblIcon);
            lblTitle.setFont(CommonsUtilities.getFontTitreFrame());
            lblTitle.setForeground(CommonsUtilities.COULEUR_TITRE_FRAME);
            lblTitle.setText(getWindowTitle());
            lblTitle.setName("lblTitle"); // NOI18N
            entetePanel.add(lblTitle);
            if (entetePanel != null) {
                headerPanel.add(entetePanel, BorderLayout.CENTER);
            }
        }
    }

    /**
     * Recupere les valeurs et construit des objects
     *
     * @throws IllegalAccessException
     */
    public void collecteCurrentObjectData() throws IllegalAccessException {

    }

    protected List<T> getSelectedRows() {

        List<T> selectedDatas = new ArrayList<T>();

        List<T> modelDatas = model.getElements();

        for (T data : datas) {

            if (isSelected(data)) {
                selectedDatas.add(data);
            }
        }
        return selectedDatas;
    }

    /**
     *
     */
    public void save() {

        try {
            boolean precondition = beforeSave();

            if (precondition) {
                getManager().save(getSelectedRows());
                afterSave();
            }
            //Mise a jour de la fen�tre parent si elle existe
            if (getParentFrame() != null) {
                getParentFrame().search();
            }
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            Messages.Messages(getApplicationFrame(), true, NotificationType.ERROR, "Une erreur est survenue lors du traitement.", ex.getMessage(), "");
        }
    }

    /**
     *
     * @return
     */
    public T getCurrentObject() {
        return currentObject;
    }

    /**
     *
     * @param currentObject
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public void setCurrentObject(T currentObject) throws IllegalArgumentException, IllegalAccessException {
        this.currentObject = currentObject;

    }

    /**
     *
     * @throws JRException
     */
    public void imprimer(Object data) {

        try {
            String reportFilePath = getJasperFileName();
            // Si le fichier ne se termine pas par .jasper
            if (!reportFilePath.endsWith(".jasper")) {
                reportFilePath = reportFilePath + ".jasper";
            }

            // Creation d'un File sur le fichier
            File reportFile = new File(reportFilePath);

            // Si l'objet n'existe pas
            if (!reportFile.exists()) {
                throw new RuntimeException("gepa.report.helper.buildreport.reportfile.notexist");
            }

            // Si l'objet n'est pas un fichier
            if (!reportFile.isFile()) {
                throw new RuntimeException("gepa.report.helper.buildreport.reportfile.notexist");
            }

            // Chargement du Rapport
            JasperReport report = null;

            // Etat rempli
            JasperPrint jasperPrint = null;

            List values = new ArrayList();
            values.add(data);
            // Chargement du report
            report = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(report, this.getReportParameters(), new JRBeanCollectionDataSource(values, false));

            // Presentation de l'etat
            this.showReport(jasperPrint);
        } catch (Exception ex) {
            ex.printStackTrace();
            Messages.Messages(getApplicationFrame(), true, NotificationType.ERROR, "Une erreur est survenue lors du traitement.", ex.getMessage(), "");
        }

    }

    /**
     * Methode de presentation d'un etat
     *
     * @param jasperPrint Etat � afficher
     */
    protected void showReport(JasperPrint jasperPrint) throws Exception {

        // Si le fichier jasper est null, arret
        if (jasperPrint == null) {
            return;
        }

        // Creation du viewer
        JRViewer jrViewer = new JRViewer(jasperPrint);

        // Creation de la boite de dilogue
        JDialog dialog = new JDialog(getApplicationFrame());

        // Injection du viewer dans la boite de dialogue
        dialog.getContentPane().add(jrViewer);

        // Gestion de la fermeture de la boite
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Titre de la boite
        dialog.setTitle("Etat");

        // set modal a true
        dialog.setModal(true);
        // Dimension de la boite
        dialog.setSize(1300, 800);

        //dialog.pack();  
        // Centrage de la boite sur l'IHM
        dialog.setLocationRelativeTo(getApplicationFrame());
        dialog.setVisible(true);

    }

    /**
     * Suppression des donn�es du SI
     */
    public void delete() {
        try {
            if (currentObject == null) {
                return;
            }

            boolean status = beforeDelete();

            if (!status) {
                return;
            }

            getManager().delete(getPrimaryKey(currentObject));

            afterDelete();

            if (getParentFrame() != null) {
                getParentFrame().search();
            }

            this.dispose();
        } catch (Exception ex) {
            //Coupler a gestionnaire des exceptions
            ex.printStackTrace();
        }
    }

    public void quitter() {
        this.dispose();
    }

    /**
     * Obtention de l'identification de l'entit�
     *
     * @param Object
     * @return
     */
    protected abstract PK getPrimaryKey(T Object);

    /**
     * Fen�tre principale de l'application
     *
     * @return
     */
    protected abstract JFrame getApplicationFrame();

    /**
     * nom de l'action permettant l'appel de cette fen�tre
     *
     * @return
     */
    protected abstract String getActionName();

    /**
     * Bar d'outil dans la fenetre d'edition
     *
     * @return
     */
    //protected abstract JToolBar getToolBar();
    /**
     * Entete de page
     *
     * @return
     */
    protected JPanel getHeaderPanel() {
        return CommonsUtilities.headerPanel();
    }

    /**
     * Pied de page
     *
     * @return
     */
    protected JPanel getFooterPanel() {

        return CommonsUtilities.footerPanel();
    }

    /**
     * Titre de la f�nete
     *
     * @return
     */
    protected abstract String getWindowTitle();

    /**
     * Nom de la classe implementant l'interface
     *
     * @return
     */
    public abstract String getWindowClassName();

    /**
     * Icon de la f�netre zone de banniere
     *
     * @return
     */
    protected abstract ImageIcon getImage();

    /**
     * Parametres des raport
     *
     * @return
     */
    protected abstract Map getReportParameters();

    /**
     * Nom du fichier
     *
     * @return
     */
    protected abstract String getJasperFileName();

    /**
     * Return la valeur de la colonne boolean
     *
     * @param objet
     * @return
     */
    protected abstract boolean isSelected(T objet);

    /**
     *
     * @param currentObject
     * @return
     */
    protected boolean updatable(T currentObject) {
        return true;
    }

    /**
     *
     * @param currentObject
     * @return
     */
    protected boolean deletable(T currentObject) {
        return true;
    }

    /**
     *
     * @param object
     * @param manager
     * @param typeOperation
     * @param window
     * @return
     */
    //public abstract JInternalFrame getEditInternalFrame(T object , GenericManager manager , TypeOperation typeOperation , JFrame window);
    /**
     * Title of save button
     *
     * @return
     */
    public String getSaveTitle() {
        return MessagesBundle.getMessage("save");
    }

    /**
     *
     * @return
     */
    public String getSaveTooltip() {

        return MessagesBundle.getMessage("save_tooltip");
    }

    /**
     *
     * @return
     */
    public String getCancelTooltip() {

        return MessagesBundle.getMessage("cancel_tooltip");
    }

    /**
     * Icon of save button
     *
     * @return
     */
    public ImageIcon getSaveIcon() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/megatim/tools/images/button_save.png"));
        return icon;
    }

    public String getCancelTitle() {
        return MessagesBundle.getMessage("cancel");
    }

    public ImageIcon getCancelIcon() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/megatim/tools/images/button_cancel.png"));
        return icon;
    }

    /**
     *
     * @return
     */
    protected boolean beforeDelete() {
        return true;
    }

    /**
     *
     * @return
     */
    protected boolean afterDelete() {
        return true;
    }

    /**
     * Actions avant la mise a jour du currrentObject
     *
     * @param currentObject
     * @return
     */
    protected boolean beforeSetCurrentObject() {
        return true;
    }

    /**
     * Actions apres mise a jour du currentObject
     *
     * @return
     */
    protected boolean afterSetCurrentObject() {
        return true;
    }

    /**
     * Verificateur de la pr�condition avant sauvegarde
     *
     * @return
     */
    protected boolean beforeSave() {
        if (getSelectedRows() == null || getSelectedRows().isEmpty()) {
            Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.INFOS, MessagesBundle.getMessage("transferer.selected.null.msg"), null, "");
            return false;
        } else if (Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.WARNING, MessagesBundle.getMessage("confirmation.transfert.msg"), "")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verification postcondition avant sauvegarde
     *
     * @return
     */
    public boolean afterSave() {       
        return true;
    }

    /**
     *
     * @return
     */
    public GenericManager getManager() {
        return manager;
    }

    /**
     *
     * @param manager
     */
    public void setManager(GenericManager manager) {
        this.manager = manager;
    }

    /**
     *
     * @return
     */
    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    /**
     *
     * @param typeOperation
     */
    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    /**
     *
     * @return
     */
    public AbstractListTemplateFrame getParentFrame() {
        return parentFrame;
    }

    /**
     *
     * @param parentFrame
     */
    public void setParentFrame(AbstractListTemplateFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public boolean isInterne() {
        return interne;
    }

    public void setInterne(boolean interne) {
        this.interne = interne;
    }

    public AbstractTableBaseListModel getModel() {
        return model;
    }

    public void setModel(AbstractTableBaseListModel model) {
        this.model = model;
        //Ajout du model dans le JTable et des donn�es
        if (this.model != null) {
            this.model.setElements(datas);
            dataTable.setModel(this.model);
        }
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    /**
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        //System.out.println("GGGGGGGGGGGGGGGGGGGGG::::::::::::::::::::::::::"+e.getKeyChar()+" ::::::::::: "+e.getSource());
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }

    /**
     *
     * @param e
     */
    @SuppressWarnings("empty-statement")
    public void keyPressed(KeyEvent e) {
        //System.out.println("GGGGGGGGGGGGGGGGGGGGG::::::::::::::::::::::::::"+e.getKeyChar()+" ::::::::::: "+e.getSource());
    }

    /**
     *
     * @param e
     */
    @SuppressWarnings("empty-statement")
    public void keyTyped(KeyEvent e) {;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        //model.setElements(datas);
        //dataTable.setModel(model);
    }

}
