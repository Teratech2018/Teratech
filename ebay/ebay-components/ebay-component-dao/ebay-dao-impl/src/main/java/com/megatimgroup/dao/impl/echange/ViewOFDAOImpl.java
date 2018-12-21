
package com.megatimgroup.dao.impl.echange;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.echange.ViewOFDAO;
import com.megatimgroup.model.echange.ViewOperationFinanciere;
import javax.persistence.EntityManager;
import com.megatim.common.services.IocContext;
import com.megatimgroup.model.parametres.WesternRefSeqGenerator;


/**
 * Classe d'implementation de la DAO

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class ViewOFDAOImpl
    extends AbstractGenericDAO<ViewOperationFinanciere, String>
    implements ViewOFDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public ViewOFDAOImpl() {
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Methode permettant de retourner la classe de l'entite
     * 
     */
    @Override
    public Class<ViewOperationFinanciere> getManagedEntityClass() {
        return (ViewOperationFinanciere.class);
    }


    /**
     * 
     * @param v$prefixe
     * @return 
     */
    public String getnextIdPP(String v$prefixe) {
            String codeNext ="";

            if(v$prefixe!=null) codeNext = v$prefixe.trim();
          
             try{ 
                long number = 0;
                
               em.getTransaction().begin();
                
               WesternRefSeqGenerator seq = em.find(WesternRefSeqGenerator.class, "TR");               
               
               number =  new Long(seq.getVal());
               
               seq.setVal(seq.getVal()+1);
               
               em.merge(seq);
               
               em.getTransaction().commit();

               return codeNext+""+number;
          }catch(Exception ex){
              ex.printStackTrace(); 
              throw new RuntimeException(ex);
          }
        }

}
