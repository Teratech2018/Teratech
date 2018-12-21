
package com.megatimgroup.views.archivage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

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
import com.megatimgroup.model.operations.Modele;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.views.helper.ImportCellRender;
import com.megatimgroup.views.helper.ValidateErrorTDialog;
import com.megatimgroup.views.helper.ValidateErrorTModel;
import com.toedter.calendar.JDateChooser;


/**
 * Panel d'edition ChampEditPanel
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ArchiveBPEditPanel extends JPanel 
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.ChampIFrame");
    private IocContext context = new IocContext();
  
    @Champ(mappedBy = "fileName", type = String.class, errorMessageField = "lbmdevise", errorMessage = "declarationfinanciere.devise.error")
    private JTextField fileName;
    private JLabel lbfileName;
    
//    private static BalanceEditPanel 
    
    private JButton searchButton ;

    public ArchiveBPEditPanel() {
        initComponents() ; 
    }

   

    public JTextField getFileName() {
		return fileName;
	}



	public void setFileName(JTextField fileName) {
		this.fileName = fileName;
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
        sg.addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE); hg.addGroup(col1h) ; 
         panel = new JPanel();
      //  buildConsolePanel(panel);
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
    private void buildPanel(JPanel panel){
      
        fileName = new JTextField() ;
        fileName.setEditable(false);
        fileName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbfileName = new JLabel();
         lbfileName.setText(MessagesBundle.getMessage( "ebay.filename"));
        searchButton = new JButton("Parcourir");        
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
	                .addComponent(lbfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                	)
               
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()	
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbfileName)
                                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                            .addGap(0, 10, Short.MAX_VALUE)
                    		
                		)
                    
            );
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
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte","txt");
//        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File sourceFile = chooser.getSelectedFile();
            fileName.setText(sourceFile.getAbsolutePath());
        }
       
    }   

   

}
