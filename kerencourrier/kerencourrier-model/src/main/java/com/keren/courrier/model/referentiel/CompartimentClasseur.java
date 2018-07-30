/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_COMCLGC")
public class CompartimentClasseur extends BaseElement implements Serializable, Comparable<CompartimentClasseur> {

        @Predicate(label = "Compartiment",optional = false,unique = true,search = true)
	private String code ;        
        
        @Predicate(label = "Désignation",optional = true,search = true)
        private String intitule ;       
        
        
        

        public CompartimentClasseur() {
        }

        public CompartimentClasseur(String code, String intitule, String style, CompartimentClasseur parent) {
            this.code = code;
            this.intitule = intitule;
            
        }

        public CompartimentClasseur(String code, String intitule, String style, CompartimentClasseur parent, long id, String designation, String moduleName, long comparedid) {
            super(id, designation, moduleName, comparedid);
            this.code = code;
            this.intitule = intitule;
           
        }

       public CompartimentClasseur(CompartimentClasseur entity) {
            super(entity.id, entity.designation, entity.moduleName, entity.compareid);
            this.code = entity.code;
            this.intitule = entity.intitule;            
        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

  

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Chemises courriers"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Chemise courrier"; //To change body of generated methods, choose Tools | Templates.
    }
       
       
        
        
        @Override
        public int compareTo(CompartimentClasseur o) {
            return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
        }
        
        

}
