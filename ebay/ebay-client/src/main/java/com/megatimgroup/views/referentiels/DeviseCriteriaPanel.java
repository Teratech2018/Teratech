
package com.megatimgroup.views.referentiels;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotations.Search;
import com.megatim.common.clients.CustomComboBox;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;


/**
 * Panel de recherche DeviseCriteriaPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeviseCriteriaPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.referentiels.DeviseIFrame");
    private IocContext context = new IocContext();
    @Search(field = "code", type = java.lang.String.class)
    private JTextField code;
    private JLabel lbcode;
    private JLabel lbmcode;
    @Search(field = "designation", type = java.lang.String.class)
    private JTextField designation;
    private JLabel lbdesignation;
    private JLabel lbmdesignation;
    @Search(field = "pays", type = com.megatimgroup.model.referentiels.Pays.class)
    private CustomComboBox pays;
    private JLabel lbpays;
    private JLabel lbmpays;

    public DeviseCriteriaPanel() {
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
     *     com.megatim.common.clients.CustomComboBox
     */
    public CustomComboBox getPays() {
        return pays;
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
        pays = new CustomComboBox() ;
        pays.setManager(getPaysManager());
        pays.loadData() ;
        lbpays = new JLabel();
        lbmpays = new JLabel();
         lbpays.setText(MessagesBundle.getMessage( "ebay.pays"));
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
        col1h.addComponent(lbpays, javax.swing.GroupLayout.DEFAULT_SIZE , 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        col2h.addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE , 350 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        col3h.addComponent( lbmpays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) ;
        GroupLayout.ParallelGroup colpaysv = (layout.createParallelGroup() );
        colpaysv.addComponent(lbpays, javax.swing.GroupLayout.DEFAULT_SIZE, 23, javax.swing.GroupLayout.DEFAULT_SIZE) ;
        colpaysv.addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE , 23 , javax.swing.GroupLayout.PREFERRED_SIZE) ;
        colpaysv.addComponent( lbmpays, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE) ;
        sg.addGroup(colpaysv) ; 
        hg.addGroup(col1h) ; 
        hg.addGroup(col2h) ; 
        hg.addGroup(col3h) ; 
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

}
