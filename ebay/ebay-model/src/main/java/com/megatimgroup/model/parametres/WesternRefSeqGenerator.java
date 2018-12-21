/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.parametres;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="WS_SEQ_GEN")
public class WesternRefSeqGenerator implements Serializable, Comparable<WesternRefSeqGenerator> {

    @Id
    @Column(name="CODE")
    private String code ="TR";
    
    @Column(name="SEQ_VAL")
    private long val ;

    
    /**
     * 
     */
    public WesternRefSeqGenerator() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }
    
    
    
    public int compareTo(WesternRefSeqGenerator o) {
        return code.compareTo(o.code);
    }
    
}
