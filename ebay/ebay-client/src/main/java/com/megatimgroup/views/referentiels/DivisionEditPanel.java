
package com.megatimgroup.views.referentiels;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.megatim.common.annotations.Champ;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;


/**
 * Panel d'edition DivisionEditPanel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DivisionEditPanel
    extends JPanel
{

    private MessagesBundle bundle;
    private MessagesBundle resourcebundle;
    public final static String FRAME_NAME = ("com.megatimgroup.views.referentiels.DivisionIFrame");
    private IocContext context = new IocContext();
    @Champ(mappedBy = "code", type = java.lang.String.class, nullable = false, update = false, errorMessageField = "lbmcode", errorMessage = "division.code.error")
    private JTextField code;
    private JLabel lbcode;
    private JLabel lbmcode;
    @Champ(mappedBy = "designation", type = java.lang.String.class, errorMessageField = "lbmdesignation", errorMessage = "division.designation.error")
    private JTextField designation;
    private JLabel lbdesignation;
    private JLabel lbmdesignation;

    public DivisionEditPanel() {
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
     * Methode permettant d'initialiser les composants
     * 
     */
    private void initComponents() {
        code = new JTextField() ;
        code.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        code.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                char car = e.getKeyChar();
                String charS = ""+car ;
                
                if(!charS.matches("[0-9]")||code.getText().trim().length()>=5){
                    e.consume();
                }
            }
            
        });
        lbcode = new JLabel();
        lbmcode = new JLabel();
         lbcode.setText(MessagesBundle.getMessage( "ebay.code"));
        designation = new JTextField() ;
        designation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbdesignation = new JLabel();
        lbmdesignation = new JLabel();
         lbdesignation.setText(MessagesBundle.getMessage( "ebay.designation"));
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
        hg.addGroup(col1h) ; 
        hg.addGroup(col2h) ; 
        hg.addGroup(col3h) ; 
    }

}
