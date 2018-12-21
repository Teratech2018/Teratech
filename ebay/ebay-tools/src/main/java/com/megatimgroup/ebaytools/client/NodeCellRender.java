/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author DEV_4
 */
public class NodeCellRender extends MouseAdapter implements TreeCellRenderer{

    private ListVisitor visiteur = null ;
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        //To change body of generated methods, choose Tools | Templates.
        JLabel myLabel = new JLabel();
        JLabel labelExpended = new JLabel();
         JPanel myPanel = new JPanel(new BorderLayout());
         labelExpended.addMouseListener(this);
        if(value instanceof DefaultMutableTreeNode){
            DefaultMutableTreeNode myNode = (DefaultMutableTreeNode) value ;
            String infoText = "-";
            if(selected){
                myPanel.setBackground(new Color(169, 234, 254));                
            }else{
                myPanel.setBackground(new Color(255, 255, 255));
            }
            
            if(leaf){
                NodeObject node = (NodeObject) myNode.getUserObject();
                if(node.isOptional())
                    myLabel.setIcon(new ImageIcon(getClass().getResource("/com/gepa/tools/images/boulevert.png")));
                else if(!node.isOptional())
                    myLabel.setIcon(new ImageIcon(getClass().getResource("/com/gepa/tools/images/boulerouge.png")));
            }else{
              if(!myNode.isRoot())
                  myLabel.setIcon(new ImageIcon(getClass().getResource("/com/gepa/tools/images/node.png")));
              else 
                  myLabel.setIcon(new ImageIcon(getClass().getResource("/com/gepa/tools/images/home.png")));
            }
            
            infoText+=" "+myNode.getUserObject();
            myLabel.setText(infoText);
        }       
        myPanel.add(BorderLayout.WEST,labelExpended);
        myPanel.add(BorderLayout.CENTER,myLabel);
        return myPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        System.out.println("Reinitilisation de la liste =========================================");
        visite();
    }

   

    public void visite(){
        
        if(visiteur!=null){
            visiteur.execute();
        }
    }

    public void setVisiteur(ListVisitor visiteur) {
        this.visiteur = visiteur;
    }
    
    
    
}
