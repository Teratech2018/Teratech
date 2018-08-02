
package com.kerenedu.configuration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.notes.NoteDetail;

@Stateless(mappedName = "AppreciationDAO")
public class AppreciationDAOImpl
    extends AbstractGenericDAO<Appreciation, Long>
    implements AppreciationDAOLocal, AppreciationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AppreciationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Appreciation> getManagedEntityClass() {
        return (Appreciation.class);
    }

    
    public Appreciation getAppreciation(NoteDetail entiy) {
		  try{
			  Appreciation app = new Appreciation();
			  String q= "SELECT * FROM e_app a "+ "WHERE a.I_DEB <= "+entiy.getNote()+" and a.I_FIN >= "+entiy.getNote()+"";
			  Query query = em.createNativeQuery(q,Appreciation.class);
			  List<Appreciation> listapp= query.getResultList();
			  if(listapp!=null){
				  app = listapp.get(0);
			  }else{
				  app = new Appreciation();
			  }

	            return app;
	        }catch(Exception ex){
	            return null;
	        }
	}
    
    public Appreciation getAppreciation(long note) {
		  try{
			  Appreciation app = new Appreciation();
			  String q= "SELECT * FROM e_app a "+ "WHERE a.I_DEB <= "+note+" and a.I_FIN >= "+note+"";
			  Query query = em.createNativeQuery(q,Appreciation.class);
			  List<Appreciation> listapp= query.getResultList();
			  if(listapp!=null){
				  app = listapp.get(0);
			  }else{
				  app = new Appreciation();
			  }

	            return app;
	        }catch(Exception ex){
	            return null;
	        }
	}
}
