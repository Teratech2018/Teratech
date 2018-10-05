
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang.StringUtils;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.CaSeqGeneratorDAOLocal;
import com.keren.courrier.dao.ifaces.others.CaSeqGeneratorDAORemote;
import com.keren.courrier.model.others.CaSeqGenerator;

@Stateless(mappedName = "CaSeqGeneratorDAO")
public class CaSeqGeneratorDAOImpl
    extends AbstractGenericDAO<CaSeqGenerator, Long>
    implements CaSeqGeneratorDAOLocal, CaSeqGeneratorDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CaSeqGeneratorDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CaSeqGenerator> getManagedEntityClass() {
        return (CaSeqGenerator.class);
    }

	private Long nextNumber() {
		  //To change body of generated methods, choose Tools | Templates.
        try{ 
       Long number = 0L;
       
  //     em.getTransaction().begin();
       StoredProcedureQuery sp = em.createStoredProcedureQuery("nextcanumber");
       // set parameters
       sp.registerStoredProcedureParameter("code", String.class, ParameterMode.IN);
       sp.registerStoredProcedureParameter("nombre", Integer.class, ParameterMode.OUT);
       sp.setParameter("code","2018");
       // execute la procedure
       sp.execute();
       // get result     
       Integer value = (Integer) sp.getOutputParameterValue("nombre");
       number =  new Long(value);
	    //Query query = em.createNativeQuery("{call nextEngNumber(?)}");
	    
      // query.setParameter(1, codeExercice);
       ///System.out.println("BorderoSequenceGeneratorDAOImpl.nextBorderoNumber(String codeExercice) :::::::::::: "+number);
       
      // number = (Long) query.getSingleResult();
      // em.getTransaction().commit();
       
       return number;
     }catch(Exception ex){
         ex.printStackTrace(); 
         throw new RuntimeException(ex);
     }
   }
	
	  public  String getNextCode(String date){
	        
	        String code = null ;
	        
	        Long number = this.nextNumber();
	        System.out.println("SequenceGenerator.getNextCode() next code "+number);
	        if(number==null)
	               return null;
	        code = "CA/"+StringUtils.leftPad(String.valueOf(number), 4, "0")+"/"+date;
	        
	        return code ;
	    }

}
