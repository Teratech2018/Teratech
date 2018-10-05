/**
 * 
 */
package com.keren.courrier.model.dashbord;

import java.io.Serializable;

import com.core.base.BaseElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nadege
 *
 */
public class ArchiveDashboard extends BaseElement implements Serializable,Comparable<ArchiveDashboard>{

  private List<Corbeille> corbeilles = new ArrayList<Corbeille>();
  
  private List<Raccourci> raccourcis = new ArrayList<Raccourci>();

    /**
     * 
     */
    public ArchiveDashboard() {
    }

    public List<Corbeille> getCorbeilles() {
        return corbeilles;
    }

    public void setCorbeilles(List<Corbeille> corbeilles) {
        this.corbeilles = corbeilles;
    }

    public List<Raccourci> getRaccourcis() {
        return raccourcis;
    }

    public void setRaccourcis(List<Raccourci> raccourcis) {
        this.raccourcis = raccourcis;
    }

     
  
	@Override
    public String getDesignation() {
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

	public int compareTo(ArchiveDashboard o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}