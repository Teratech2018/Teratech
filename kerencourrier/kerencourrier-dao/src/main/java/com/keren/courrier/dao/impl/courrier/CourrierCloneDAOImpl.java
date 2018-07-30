
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAORemote;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierDepart;

@Stateless(mappedName = "CourrierCloneDAO")
public class CourrierCloneDAOImpl
    extends AbstractGenericDAO<CourrierClone, Long>
    implements CourrierCloneDAOLocal, CourrierCloneDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierCloneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierClone> getManagedEntityClass() {
        return (CourrierClone.class);
    }
    
    public long deleteCourrierRAD(CourrierClone entity) {
		 long value = 0  ;
		  try{
			  String queryligne ="Delete  from t_liborgc where COUR_ID="+entity.getId()+"";
			  String querypc ="Delete  from T_PJGC where COU_ID="+entity.getId()+"";
			  String querytrt ="Delete  from T_COURRGC where ID="+entity.getId()+"";
			  String querycourier ="Delete  from T_TRACOGC where COU_ID="+entity.getId()+"";
			 
			  value = em.createNativeQuery(queryligne).executeUpdate();
			  value = em.createNativeQuery(querypc).executeUpdate();
			  value = em.createNativeQuery(querytrt).executeUpdate();
			  value = em.createNativeQuery(querycourier).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return value;
	}

}
