/**
 * 
 */
package com.keren.courrier.model.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "v_creport")
public class ViewCourrierReport extends BaseElement implements Serializable,Comparable<ViewCourrierReport>{

  
  
	@Override
    public String getDesignation() {
        this.designation = "Education";
        return "Acceuil"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "ACCEUIL"; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "ACCEUIL";
	}

	public int compareTo(ViewCourrierReport o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}