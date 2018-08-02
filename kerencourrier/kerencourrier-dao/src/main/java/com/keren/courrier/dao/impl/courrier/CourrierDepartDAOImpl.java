
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierDepartDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierDepartDAORemote;
import com.keren.courrier.model.courrier.CourrierDepart;

@Stateless(mappedName = "CourrierDepartDAO")
public class CourrierDepartDAOImpl
    extends AbstractGenericDAO<CourrierDepart, Long>
    implements CourrierDepartDAOLocal, CourrierDepartDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierDepartDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierDepart> getManagedEntityClass() {
        return (CourrierDepart.class);
    }
    
    public long deleteCourrierRAD(CourrierDepart entity) {
		 long value = 0  ;
		  try{
			  String queryligne ="Delete  from t_liborgc where COUR_ID="+entity.getId()+"";
			  String querypc ="Delete  from T_PJGC where COU_ID="+entity.getId()+"";
			  String querycourier ="Delete  from T_COURRGC where COU_ID="+entity.getId()+"";
			 
			  value = em.createNativeQuery(queryligne).executeUpdate();
			  value = em.createNativeQuery(querypc).executeUpdate();
			  value = em.createNativeQuery(querycourier).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return value;
	}

}
