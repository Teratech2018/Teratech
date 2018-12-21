/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Commercial_2
 */

@MappedSuperclass
public class DeclarationBase implements Serializable, Comparable<DeclarationBase> {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    protected long id ;
//    
    //Reference interne de l'agent economique
    @Id
    @Column(name="C_REF")
    @Predicate(max=15,nullable=false,optional=false,label="Reference interne de l'agent economique")
    protected String reference ;    
    

    
    /**
     * 
     */
    public DeclarationBase() {
    }

    
    /**
     * 
     * @param reference 
     */
    public DeclarationBase(String reference) {
        this.reference = reference;
    }
    
    

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


	public int compareTo(DeclarationBase o) {
        return reference.compareTo(o.reference);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.reference != null ? this.reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeclarationBase other = (DeclarationBase) obj;
        if ((this.reference == null) ? (other.reference != null) : !this.reference.equals(other.reference)) {
            return false;
        }
        return true;
    }    
    
    
}
