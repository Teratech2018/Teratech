
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneDAORemote;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.CourrierInterne;

@Stateless(mappedName = "CourrierInterneDAO")
public class CourrierInterneDAOImpl
    extends AbstractGenericDAO<CourrierInterne, Long>
    implements CourrierInterneDAOLocal, CourrierInterneDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierInterneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierInterne> getManagedEntityClass() {
        return (CourrierInterne.class);
    }
    
    public long deleteCourrierRAD(CourrierInterne entity) {
 		 long value = 0  ;
 		  try{
 			  String queryligne ="Delete  from t_liborgc where COUR_ID="+entity.getId()+"";
 			  String querypc ="Delete  from T_PJGC where COU_ID="+entity.getId()+"";
 			  String querycourier ="Delete  from T_COURRGC where ID="+entity.getId()+"";
 			 
 			  value = em.createNativeQuery(queryligne).executeUpdate();
 			  value = em.createNativeQuery(querypc).executeUpdate();
 			  value = em.createNativeQuery(querycourier).executeUpdate();
 	
 	        }catch(Exception ex){

 	        }
 		return value;
 	}

}
