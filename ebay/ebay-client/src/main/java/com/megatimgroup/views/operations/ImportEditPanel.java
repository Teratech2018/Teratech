
package com.megatimgroup.views.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Champ;
import com.megatim.common.clients.CommonsUtilities;
import com.megatim.common.clients.CustomComboBox;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayMessage;
import com.megatimgroup.ebaytools.client.EbayMessageItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.ValidateError;
import com.megatimgroup.model.operations.Modele;
import com.megatimgroup.views.helper.ImportCellRender;
import com.megatimgroup.views.helper.ValidateErrorTDialog;
import com.megatimgroup.views.helper.ValidateErrorTModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


/**
 * Panel d'edition ChampEditPanel
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ImportEditPanel
    extends JPanel implements Observer
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.ChampIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "modele", type = Modele.class, errorMessageField = "lbmsens", errorMessage = "declarationfinanciere.sens.error")
    private CustomComboBox modele;
    private JLabel lbmodele;
    private JLabel lbmmodele;
    @Champ(mappedBy = "fileName", type = String.class, errorMessageField = "lbmdevise", errorMessage = "declarationfinanciere.devise.error")
    private JTextField fileName;
    private JLabel lbfileName;
    private JLabel lbmfileName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private DefaultMutableTreeNode rootNode ;
    
    private DefaultMutableTreeNode currentTreeNode =null;
    
    private ImportDialog _container ;
    
    private JButton searchButton ;

    public ImportEditPanel() {
        initComponents() ; 
    }

   

    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
        
        GroupLayout layout = new GroupLayout((this));
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.ParallelGroup col1h = (layout.createParallelGroup() );
        GroupLayout.ParallelGroup col2h = (layout.createParallelGroup() );
        GroupLayout.ParallelGroup col3h = (layout.createParallelGroup() );
        GroupLayout.ParallelGroup col1v;
        GroupLayout.ParallelGroup col2v;
        GroupLayout.ParallelGroup col3v;
        GroupLayout.SequentialGroup hg = (layout.createSequentialGroup());
        GroupLayout.ParallelGroup hgp = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hgp.addGroup(hg);
        layout.setHorizontalGroup(hgp);
        GroupLayout.ParallelGroup hv = (layout.createParallelGroup());
        GroupLayout.SequentialGroup sg = layout.createSequentialGroup();
        layout.setVerticalGroup(hv) ;
        hv.addGroup(sg);
        JPanel panel = new JPanel();
        buildPanel(panel);
        // Positionnement des elements 
        hgp.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        sg.addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE); hg.addGroup(col1h) ; 
         panel = new JPanel();
        buildConsolePanel(panel);
        // Positionnement des elements 
        hgp.addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        sg.addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE); hg.addGroup(col1h) ; 
        hg.addGroup(col2h) ; 
        hg.addGroup(col3h) ; 
    }
    
    /**
     * 
     * @param panel 
     */
    private void buildConsolePanel(JPanel panel){
        jScrollPane1 = new javax.swing.JScrollPane();
        MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        rootNode = new DefaultMutableTreeNode(MessagesBundle.getMessage("console.title"));
        setBorder(javax.swing.BorderFactory.createTitledBorder(
 				null, MessagesBundle.getMessage("Suivi des traitements"),
 				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
 				javax.swing.border.TitledBorder.DEFAULT_POSITION,
 				CommonsUtilities.getFontBorderGroupBox(),
 				CommonsUtilities.COULEUR_TITRE_FRAME));
        jTree1 = new javax.swing.JTree(rootNode);        
        jScrollPane1.setViewportView(jTree1);
        jTree1.setCellRenderer(new ImportCellRender());
        jTree1.expandPath(new TreePath(rootNode.getPath()));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
        );
    }
    /**
     * 
     * @param panel 
     */
    private void buildPanel(JPanel panel){
        modele = new CustomComboBox() ;
        modele.setManager(getModeleManager());
        modele.loadData();
        modele.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbmodele = new JLabel();
        lbmmodele = new JLabel();
         lbmodele.setText(MessagesBundle.getMessage( "modele.id"));
        fileName = new JTextField() ;
        fileName.setEditable(false);
        fileName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbfileName = new JLabel();
        lbmfileName = new JLabel();
         lbfileName.setText(MessagesBundle.getMessage( "modele.fieldname"));
        searchButton = new JButton("...");        
        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                seachButtonActionPerformed(e);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbmodele, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modele, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbmodele, lbfileName});
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbmodele)
                    .addComponent(modele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(lbfileName))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {searchButton, lbmodele, lbfileName, modele});
    }
    
     /**
     * Methode permettant de retourner le manager
     * 
     * @return
     *     com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager
     */    
    public GenericManager<Modele, String> getModeleManager()
        
    {
        try {
            IocContext context = new IocContext();
            return (GenericManager)context.lookup("com.megatimgroup.core.impl.operations.ModeleManagerImpl");
        }  catch (Exception _x) {
            return null;
        }
    }
    
    /**
     * 
     * @param evt 
     */
    private void seachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                       
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte","txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File sourceFile = chooser.getSelectedFile();
            fileName.setText(sourceFile.getAbsolutePath());
        }
       
    }   

    /**
     * 
     * @param o
     * @param arg 
     */
    public void update(Observable o, Object arg) {
        
        //Recuperation du messages
        EbayMessage message = (EbayMessage) arg ;
        
        ImportWorker worker = new ImportWorker(message);
        
        worker.start();
        
//        System.out.println("******************* Reception des messages ::::::::::::::::::::::: "+o+"           "+arg+" ******** "+message.getErrors());
    }

    public void setContainer(ImportDialog _container) {
        this._container = _container;
    }
    
    
    
    /**
     * 
     */
    private class ImportWorker extends Thread{
        
        private EbayMessage message ;

        /**
         * 
         * @param message 
         */
        public ImportWorker(EbayMessage message) {
            super();
            this.message = message;
        }

        @Override
        public void run() {
            
            super.run();
            
            //Reinitialisation de la liste des erreurs
//            ImportDialog.setErrors(new ArrayList<ValidateError>());
//            System.out.println("Validator.validate() ::::::::::::::::: ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+message.getErrors()+" :::: ");
            if(message.getStatut().equals(MessageType.INITIAL)){
           
            //Traitement de message initial
            currentTreeNode = new DefaultMutableTreeNode(message);
//            currentTreeNode.
            //Creation des fils
            buildNode(message.getElements());
            //Ajout du noeud dans l'arbre
            rootNode.add(currentTreeNode);
            
            }else{
                //Ajout du dernier noeud
                buildNode(message.getElements().get(message.getElements().size()-1));
            }
            //Sauvegarde des resultat
            if(message.getStatut().equals(MessageType.IN_ERROR)){
                
                if(_container!=null){
                    //Affichage de la fenetre des erreur
                    ValidateErrorTDialog errorDialog = new ValidateErrorTDialog(null, true, TypeOperation.VIEW, message.getErrors());
                     errorDialog.setModel(new ValidateErrorTModel());

                     errorDialog.setLocationRelativeTo(_container);
                     errorDialog.setVisible(true);
                }
            }
            paint(getGraphics());
    //        for(int i=0 ; i<jTree1.getRowCount();i++){
    //            jTree1.expandRow(i);
    //        }        
        }
        
        
        
        
    }
    
    /**
     * Creation d'un noeud
     * @param item 
     */
    private void buildNode(EbayMessageItem item){
        
        //Creation du noeud
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(item);
        currentTreeNode.add(node);
    }
    
    /**
     * 
     * @param items 
     */
    private void buildNode(List<EbayMessageItem> items){
        
        for(EbayMessageItem item : items){
            buildNode(item);
        }
    }

}
