/**
 * 
 */
package com.keren.courrier.dao.impl.others;

/**
 * @author Nadege
 *
 */
public class SequenceGenerator {
	
	 private static String cadaoName = "com.keren.courrier.dao.impl.others.CaSeqGeneratorDAOImpl";
	 
//	  public static Long getNextNumber(Class<?> type){
//	        Long next = null;
//	        IocContext container = new IocContext();    
//	        try{
//	            if(type.equals(Courrier.class)){
//	            	CaSeqGeneratorDAO sequence = (CaSeqGeneratorDAO) container.lookup(cadaoName);
//	                return sequence.nextNumber();
//	            }
//	        }catch(Exception ex){
//	            ex.printStackTrace();
//	            throw new RuntimeException(ex);
//	        }
//	        return next;
//	            
//	  }
//	  
//	  public static String getNextCode(Class<?> type, String date){
//	        
//	        String code = null ;
//	        
//	        Long number = getNextNumber(type);
//	       // System.out.println("SequenceGenerator.getNextCode() next code "+number);
//	        if(number==null)
//	               return null;
//	        code = "CA/"+StringUtils.leftPad(String.valueOf(number), 4, "0")+"/"+date;
//	        
//	        return code ;
//	    }
}
