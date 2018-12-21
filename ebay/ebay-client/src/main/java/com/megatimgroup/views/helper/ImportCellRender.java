/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.EbayMessage;
import com.megatimgroup.ebaytools.client.EbayMessageItem;
import com.megatimgroup.ebaytools.client.MessageType;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Commercial_2
 */
public class ImportCellRender implements TreeCellRenderer{

    private JLabel icon ;
    
    private JLabel text ;
    
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        
        if(value instanceof DefaultMutableTreeNode){
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value ;
            
            if(node.isRoot()){
                icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/mon.png")));
                text = new JLabel(node.getUserObject().toString());
            }else if(node.isLeaf()){
                
                if(node.getUserObject() instanceof EbayMessageItem){
                    
                    EbayMessageItem item = (EbayMessageItem) node.getUserObject();
                    text = new JLabel(item.toString());
                    if(item.getStatut().equals(MessageType.IN_PROGRESS)||item.getStatut().equals(MessageType.INITIAL)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/pg.png")));
                    }else if(item.getStatut().equals(MessageType.IN_ERROR)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/err.png")));
                    }else if(item.getStatut().equals(MessageType.DONE)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/ok.png")));
                    }
                    
                }else if(node.getUserObject() instanceof EbayMessage){
                    EbayMessage item = (EbayMessage) node.getUserObject();
                    text = new JLabel(item.toString());
                    if(item.getStatut().equals(MessageType.IN_PROGRESS)||item.getStatut().equals(MessageType.INITIAL)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/pg.png")));
                    }else if(item.getStatut().equals(MessageType.IN_ERROR)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/err.png")));
                    }else if(item.getStatut().equals(MessageType.DONE)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/ok.png")));
                    }
                }
            }else{
                
                 if(node.getUserObject() instanceof EbayMessage){
                    EbayMessage item = (EbayMessage) node.getUserObject();
                    text = new JLabel(item.toString());
                    if(item.getStatut().equals(MessageType.IN_PROGRESS)||item.getStatut().equals(MessageType.INITIAL)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/pg.png")));
                    }else if(item.getStatut().equals(MessageType.IN_ERROR)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/err.png")));
                    }else if(item.getStatut().equals(MessageType.DONE)){
                        icon = new JLabel(new ImageIcon(getClass().getResource("/com/ebay/images/ok.png")));
                    }
                }
            }
        }
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(BorderLayout.WEST,icon);
        panel.add(BorderLayout.CENTER,text);
        
        return panel;
    }
    
}
