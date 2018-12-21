
package com.megatimgroup.views.operations;

import com.megatim.common.annotations.Champ;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.ListVisitor;
import com.megatimgroup.ebaytools.client.NodeCellRender;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.views.helper.TreeHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * Panel d'edition ModeleEditPanel

 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ModeleEditPanel
    extends JPanel implements  ListVisitor,MouseListener
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.operations.ModeleIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "code", type = java.lang.String.class, nullable = false, update = false, errorMessageField = "lbmcode", errorMessage = "modele.code.error")
    private JTextField code;
    private JLabel lbcode;
    private JLabel lbmcode;
    @Champ(mappedBy = "designation", type = java.lang.String.class, errorMessageField = "lbmdesignation", errorMessage = "modele.designation.error")
    private JTextField designation;
    private JLabel lbdesignation;
    private JLabel lbmdesignation;
    private JPanel elementsPanel;
    // Variables declaration - do not modify
    private javax.swing.JButton addButton;
    private javax.swing.JButton removeButton;
    @Champ(mappedBy = "nodes", type = java.util.List.class, errorMessageField = "lbmelements", errorMessage = "modele.elements.error")    
    private javax.swing.JList elements;
    private DefaultListModel listeModel = null;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private DefaultMutableTreeNode rootModel = null;
    private DefaultMutableTreeNode physiqueNode =null;
    private DefaultMutableTreeNode moraleNode =null;
    private DefaultMutableTreeNode financiereNode =null;
    
    //Panel
//    private JPanel middlePanel ;
    

    public ModeleEditPanel() {
        initComponents() ; 
    }

    /**
     * Getter
     * 
     * @return
     *     javax.swing.JTextField
     */
    public JTextField getCode() {
        return code;
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
     *     com.megatim.common.utilities.AbstractTablePanel
     */
    public JPanel getElementsPanel() {
        return elementsPanel;
    }

    /**
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
        code = new JTextField() ;
        code.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbcode = new JLabel();
        lbmcode = new JLabel();
         lbcode.setText(MessagesBundle.getMessage( "ebay.code"));
        designation = new JTextField() ;
        designation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbdesignation = new JLabel();
        lbmdesignation = new JLabel();
        lbdesignation.setText(MessagesBundle.getMessage( "ebay.designation"));
        elementsPanel = new JPanel();
        buildPanel(elementsPanel);
        //elements.setModel( new com.megatimgroup.views.operations.ChampModel());
        
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
        // Positionnement des elements 
        col1h.addComponent(lbcode, javax.swing.GroupLayout.DEFAULT_SIZE , 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        col2h.addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE , 100 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        col3h.addComponent( lbmcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) ;
        GroupLayout.ParallelGroup colcodev = (layout.createParallelGroup() );
        colcodev.addComponent(lbcode, javax.swing.GroupLayout.DEFAULT_SIZE, 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        colcodev.addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE , 23 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        colcodev.addComponent( lbmcode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE) ;
        sg.addGroup(colcodev) ; 
        // Positionnement des elements 
        col1h.addComponent(lbdesignation, javax.swing.GroupLayout.DEFAULT_SIZE , 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        col2h.addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE , 350 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        col3h.addComponent( lbmdesignation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) ;
        GroupLayout.ParallelGroup coldesignationv = (layout.createParallelGroup() );
        coldesignationv.addComponent(lbdesignation, javax.swing.GroupLayout.DEFAULT_SIZE, 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        coldesignationv.addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE , 23 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        coldesignationv.addComponent( lbmdesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE) ;
        sg.addGroup(coldesignationv) ; 
        // Positionnement des elements 
        hgp.addComponent(elementsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        sg.addComponent(elementsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        hg.addGroup(col1h) ; 
        hg.addGroup(col2h) ; 
        hg.addGroup(col3h) ; 
    }
    
    /**
     * 
     * @return 
     */
    private void  buildPanel(JPanel panel){
         jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeModel = new DefaultListModel();
        elements = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jTree1.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(jTree1);        
        rootModel = new DefaultMutableTreeNode("Entités");
        jTree1 = new javax.swing.JTree(rootModel);
        physiqueNode = TreeHelper.buildNode(TreeHelper.buildFromClass(DeclarationPP.class));
        rootModel.add(physiqueNode);
        moraleNode = TreeHelper.buildNode(TreeHelper.buildFromClass(DeclarationPM.class));
        rootModel.add(moraleNode);
        financiereNode = TreeHelper.buildNode(TreeHelper.buildFromClass(DeclarationFinanciere.class));
        rootModel.add(financiereNode);
        NodeCellRender render = new NodeCellRender();
        render.setVisiteur(this);
        jTree1.setCellRenderer(render);
        elements.setBorder(new javax.swing.border.MatteBorder(null));
        elements.setModel(listeModel);
        jScrollPane1.setViewportView(jTree1);
        
        jScrollPane2.setViewportView(elements);

        addButton.setText("  >>   ");
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
            }
        });
        removeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                removeButtonActionPerformed(e);
            }
        });
        removeButton.setText("  <<   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton)
                .addContainerGap())
        );
    }

    /**
     * 
     */
    public void execute() {
         //To change body of generated methods, choose Tools | Templates.
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        
        DefaultMutableTreeNode rootNode = node;
        if(node.isLeaf())
           rootNode =  (DefaultMutableTreeNode) node.getParent();
        for(int i=0 ; i<rootNode.getChildCount();i++){
            NodeObject nodeObject = (NodeObject) ((DefaultMutableTreeNode)rootNode.getChildAt(i)).getUserObject();
            if(!nodeObject.isOptional()){
                if(!listeModel.contains(nodeObject)){
                    //throw new ManagerException(MessagesBundle.getMessage("import.nonoptional.short"), "Le champ "+nodeObject.getName()+" est obligatoire");
                }
            }
            
        }
    }
    
    /**
     * 
     * @param evt 
     */
     private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        if(!node.isLeaf()) 
                    return ;
        //The node is a Leaf
        NodeObject nodeObject = (NodeObject) node.getUserObject();
        
        if(listeModel.contains(nodeObject))
                              return ;
        //Ajout dans la liste de model        
        listeModel.addElement(nodeObject);
    }                                        

     /**
      * 
      * @param evt 
      */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        NodeObject nodeObject = (NodeObject) elements.getSelectedValue();
        
        listeModel.removeElement(nodeObject);
    }                                        

    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
         if(jTree1!=null&&e.getSource().equals(jTree1)&&jTree1.getSelectionPath()!=null){
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
            
            if(node==null)
                       return ;
            
            if(!node.isLeaf()){
                listeModel = new DefaultListModel();
                elements.setModel(listeModel);
            }
           // System.out.println("Reinitilisation de la liste ========================================="+node);
        }
    }

    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

}
