/**
 * 
 */
package com.keren.kerenpaie.model.structures;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "T_DEVISE")
@XmlRootElement
public class Devise extends BaseElement implements Serializable, Comparable<Devise> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054578651291084917L;

	@Predicate(label = "Devise" ,optional = false,unique = true,search = true)
    private String code ;
     
   @Predicate(label = "Taux actuel" ,optional = false,unique = true,type = Double.class,search = true)
    private Double taux ;    

   /**
    * 
    */
   public Devise() {
   }

   /**
    * 
    * @param code
    * @param taux 
    */
   public Devise(String code, double taux) {
       this.code = code;
       this.taux = taux;
   }

   public String getCode() {
       return code;
   }

   public void setCode(String code) {
       this.code = code;
   }

   public double getTaux() {
       return taux;
   }

   public void setTaux(double taux) {
       this.taux = taux;
   }
   
   

   @Override
   public String getListTitle() {
       return "DEVISES"; //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public String getEditTitle() {
       return "DEVISE"; //To change body of generated methods, choose Tools | Templates.
   }
   
   @Override
   public String getModuleName() {
        //To change body of generated methods, choose Tools | Templates.
       return "kerenrh";
   }

   @Override
   public String toString() {
       return "Devise{" + "code=" + code + ", taux=" + taux + '}';
   }

   @Override
   public String getDesignation() {
       //To change body of generated methods, choose Tools | Templates.
       return code;
   }  
   
   
   
   @Override
   public int compareTo(Devise o) {
       //To change body of generated methods, choose Tools | Templates.
       return code.compareTo(o.code);
   }

}
