/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.model.reporting.BordereauBP;
import java.awt.Frame;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Commercial_2
 */
public class ConsoleDialog 
      extends AbstractEditTemplateDialog<BordereauBP, String> {

    /**
     * 
     * @param parent
     * @param modal
     * @param type 
     */
    public ConsoleDialog(JFrame parent, boolean modal, TypeOperation type) {
        super(parent, modal, type);
        
    }

    
    /**
     * 
     * @param owner 
     */
    public ConsoleDialog(Frame owner) {
        super(owner);
    }

    
    /**
     * 
     * @param owner
     * @param title 
     */
    public ConsoleDialog(Frame owner, String title) {
        super(owner, title);
    }

    
    /**
     * 
     */
    public ConsoleDialog() {
        super();
        btsave.setVisible(false);
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    protected JPanel getFiledsPanel() {
        if ((middlePanel==null)) {
            middlePanel = new ConsoleEditPanel() ;
            ((ConsoleEditPanel)middlePanel).setContainer(this);
        }
        return (middlePanel);
    }

    @Override
    protected String getPrimaryKey(BordereauBP Object) {
        return Object.getFileName();
    }

    @Override
    protected JFrame getApplicationFrame() {
        return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
    }

    @Override
    protected String getActionName() {
        return null ; 
    }

    @Override
    protected String getWindowTitle() {
       return (MessagesBundle.getMessage("balance.edit").toUpperCase());
    }

    @Override
    public String getWindowClassName() {
        return null;
    }

    @Override
    protected ImageIcon getImage() {
         try{
            ImageIcon icon = null;
            icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("champ.edit.image")));
            return icon;
         }catch(Exception ex){;}
            return null;
    }

    @Override
    protected Map getReportParameters() {
        return null ; 
    }

    @Override
    protected String getJasperFileName() {
        return null ; 
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    /**
     * 
     */
    @Override
    public void save() {
        this.setVisible(false);
    }

    @Override
    public void quitter() {
       this.setVisible(false);
    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsoleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsoleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsoleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsoleDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsoleDialog dialog = new ConsoleDialog();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
