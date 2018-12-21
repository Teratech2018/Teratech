/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

/**
 *
 * @author Commercial_2
 */
public enum Periode {
    
    JANVIER("01"),
    FEVRIER("02"),
    MARS("03"),
    AVRIL("04"),
    MAI("05"),
    JUIN("06"),
    JUILLET("07"),
    AOUT("08"),
    SEPTEMBRE("09"),
    OCTOBRE("10"),
    NOVEMBRE("11"),
    DECEMBRE("12");
    
    private String numero ;

    private Periode(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero ;
    }
    
    
}
