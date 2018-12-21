/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatim.common.annotations.Connector;
import com.megatim.common.annotations.Exclude;
import com.megatim.common.annotations.Predicate;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.model.archivage.ArchiveOperation;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 *
 * @author Commercial_2
 */
public class WesternItem implements Serializable, Comparable<WesternItem> {

    
    private String pays ;
    
    private String devise ;
    
    private String terminal;
    
    private String opId ;
    
    private String superId ;
    
    private String userName ;
    
    @Predicate(label="MTCN")
    @Exclude(classes={DeclarationFinanciere.class,ArchiveOperation.class},
            champs={"mtcn","mtcn"},connector= Connector.AND,value="")
    private String mtcn;
    
    private String reciever ;
    
    private String sender ;
    
    private String paysDestination;
    
    private String deviseDestination ;
    
    private String transactiontype ;
    
    private String datecreation;
    
    private String montant ;
    
    private String fraistransfert;
    
    private String fraislivraison;
    
    private String fraismessage;
    
    private String remise;
    
    private String montant_a_collecter ;
    
    private String taux_change;
    
    private String montant_paye ;
    
    private String total_frais;
    
    private String total_taxe;
    
    private String type_paiement;
    /**
     * 
     */
    public WesternItem() {
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMtcn() {
        return mtcn;
    }

    public void setMtcn(String mtcn) {
        this.mtcn = mtcn;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPaysDestination() {
        return paysDestination;
    }

    public void setPaysDestination(String paysDestination) {
        this.paysDestination = paysDestination;
    }

    public String getDeviseDestination() {
        return deviseDestination;
    }

    public void setDeviseDestination(String deviseDestination) {
        this.deviseDestination = deviseDestination;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getFraistransfert() {
        return fraistransfert;
    }

    public void setFraistransfert(String fraistransfert) {
        this.fraistransfert = fraistransfert;
    }

    public String getFraislivraison() {
        return fraislivraison;
    }

    public void setFraislivraison(String fraislivraison) {
        this.fraislivraison = fraislivraison;
    }

    public String getFraismessage() {
        return fraismessage;
    }

    public void setFraismessage(String fraismessage) {
        this.fraismessage = fraismessage;
    }

    public String getRemise() {
        return remise;
    }

    public void setRemise(String remise) {
        this.remise = remise;
    }

    public String getMontant_a_collecter() {
        return montant_a_collecter;
    }

    public void setMontant_a_collecter(String montant_a_collecter) {
        this.montant_a_collecter = montant_a_collecter;
    }

    public String getTaux_change() {
        return taux_change;
    }

    public void setTaux_change(String taux_change) {
        this.taux_change = taux_change;
    }

    public String getMontant_paye() {
        return montant_paye;
    }

    public void setMontant_paye(String montant_paye) {
        this.montant_paye = montant_paye;
    }

    public String getTotal_frais() {
        return total_frais;
    }

    public void setTotal_frais(String total_frais) {
        this.total_frais = total_frais;
    }

    public String getTotal_taxe() {
        return total_taxe;
    }

    public void setTotal_taxe(String total_taxe) {
        this.total_taxe = total_taxe;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    
    /**
     * 
     * @param o
     * @return 
     */
    public int compareTo(WesternItem o) {
        return 1;
    }
    
    /**
     * Conversion des 
     * @return 
     */
    public EbayItem getItem(){
        
        EbayItem item  = new EbayItem();
        
        item.setReference("reference");
        
        item.setQualite("M/MME");
        
        item.setTitre("AUCUN");
        
        item.setNom(getReciever());
        
        item.setNationalite("CMR");
        
        item.setProfession("AUCUNE");
        
        item.setNatureClientele("ORD");
        
        item.setStatusResidence("NR");
        
        item.setDesignation(getReciever());
        
        item.setMontant(getMontant_paye());
        
        item.setSens("C");
        
        if(!getTransactiontype().trim().equalsIgnoreCase("PAID")){
            item.setSens("D");
        }
        
        item.setDevise("XAF");
        
        item.setDateOperation(getDatecreation());
        
        item.setType("TR");
        
        item.setPays("CMR");
        
        item.setMotif("9.9.9.9.9.9");
        
        item.setMtcn(getMtcn());
        
        
        
        return item ;
    }

    @Override
    public String toString() {
        return "WesternItem{" + "pays=" + pays + ", devise=" + devise + ", terminal=" + terminal + ", opId=" + opId + ", superId=" + superId + ", userName=" + userName + ", mtcn=" + mtcn + ", reciever=" + reciever + ", sender=" + sender + ", paysDestination=" + paysDestination + ", deviseDestination=" + deviseDestination + ", transactiontype=" + transactiontype + ", datecreation=" + datecreation + ", montant=" + montant + ", fraistransfert=" + fraistransfert + ", fraislivraison=" + fraislivraison + ", fraismessage=" + fraismessage + ", remise=" + remise + ", montant_a_collecter=" + montant_a_collecter + ", taux_change=" + taux_change + ", montant_paye=" + montant_paye + ", total_frais=" + total_frais + ", total_taxe=" + total_taxe + ", type_paiement=" + type_paiement + '}';
    }
    
    
    /**
     * Renvoie la liste des champs separe par ','
     * @return 
     */
    public static String getFields(){
        
        Field[] fields = WesternItem.class.getDeclaredFields();
        
        StringBuilder builder = new StringBuilder();
        
        int index = 0 ;
        
        for(Field field : fields){
            
            if(index==0){
                builder.append(field.getName());
            } else{
                builder.append(",").append(field.getName());
            }
            
            index++ ;
        }
        
        return builder.toString();
    }
    
}
