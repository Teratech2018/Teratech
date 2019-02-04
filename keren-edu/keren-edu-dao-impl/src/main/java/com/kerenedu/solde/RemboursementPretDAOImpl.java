
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RemboursementPretDAO")
public class RemboursementPretDAOImpl
    extends AbstractGenericDAO<RemboursementPret, Long>
    implements RemboursementPretDAOLocal, RemboursementPretDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RemboursementPretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RemboursementPret> getManagedEntityClass() {
        return (RemboursementPret.class);
        
        
    }
    

	@Override
	public long updateforce(String value) {
		 long va = 0  ;
		  try{
			
				 String query ="update e_remprt set ownermodule ='"+value+"' ";
				 System.out.println("InscriptionDAOImpl.updateforce() query "+query);
				  va = em.createNativeQuery(query).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return va;
	}

}
