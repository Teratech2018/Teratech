
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EmargementPeriodeDAO")
public class EmargementPeriodeDAOImpl
    extends AbstractGenericDAO<EmargementPeriode, Long>
    implements EmargementPeriodeDAOLocal, EmargementPeriodeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EmargementPeriodeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EmargementPeriode> getManagedEntityClass() {
        return (EmargementPeriode.class);
    }

    public long deleteemarge(EmargementPeriode fp) {
		 long value = 0  ;
		  try{
			  String query1 ="Delete  from e_emarge_dlt_periode where emarg_dlt_id="+fp.getId()+"";
			  value = em.createNativeQuery(query1).executeUpdate();
			  
			  String query ="Delete  from e_emarge_periode where id="+fp.getId()+"";
			  value = em.createNativeQuery(query).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return value;
	}
}
