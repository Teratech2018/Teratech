/**
 * 
 */
package com.megatimgroup.model.parametres;

/**
 * @author mgt
 *
 */
public enum Mois {

   JANVIER("JANVIER", 0),
   FEVRIER("FEVRIER",1),
   MARS("MARS",2),
   AVRIL("AVRIL",3),
   MAI("MAI",4),
   JUIN("JUIN",5),
   JUILLET("JUILLET",6),
   AOUT("AOUT",7),
   SEPTEMBRE("SEPTEMBRE",8),
   OCTOBRE("OCTOBRE",9),
   NOVEMBRE("NOVEMBRE",10),
   DECEMBRE("DECEMBRE",11);

   private String val = "";
   private int value = 0;

   private Mois(String val, int value) {
       this.val = val;
       this.value = value;
   }

   @Override
   public String toString() {
       return val;
   }

   public String getVal() {
       return val;
   }

   public void setVal(String val) {
       this.val = val;
   }

   public int getValue() {
       return value;
   }

   public void setValue(int value) {
       this.value = value;
   }
   
   public String getVal(int value){
	   String val =Mois.JANVIER.getVal();
	   switch (value) {
	   case 0:
		   val= Mois.JANVIER.val;
	   case 1:
		   val= Mois.FEVRIER.val;
	default:
		break;
	}
	return val;
   }

}
