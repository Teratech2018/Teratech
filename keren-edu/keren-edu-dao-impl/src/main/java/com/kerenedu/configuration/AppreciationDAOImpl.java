
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
			  System.out.println("AppreciationDAOImpl.getAppreciation() requete "+q);
			  System.out.println("AppreciationDAOImpl.getAppreciation() entity factory is "+em.getClass());
			  Query query = em.createNativeQuery(q,Appreciation.class);
			  System.out.println("AppreciationDAOImpl.getAppreciation() je suis ici/////");
			  System.out.println("AppreciationDAOImpl.getAppreciation() entity factory is "+em.getClass());
			  System.out.println("AppreciationDAOImpl.getAppreciation() querry final "+query);
			  List<Appreciation> listapp= query.getResultList();
			  System.out.println("AppreciationDAOImpl.getAppreciation() liste "+listapp);
			  if(listapp!=null){
				  System.out.println("AppreciationDAOImpl.getAppreciation() taille de la liste "+listapp.size());
				  for(Appreciation p : listapp){
					  System.out.println("AppreciationDAOImpl.getAppreciation() apprecition tr===="+p.getId());
				  }
				  app = listapp.get(0);
				  System.out.println("AppreciationDAOImpl.getAppreciation() apreciation trouvée ===="+app.getId());
			  }else{
				  app = new Appreciation();
				  System.out.println("AppreciationDAOImpl.getAppreciation() valeur appreciation RAS ");
			  }

	            return app;
	        }catch(Exception ex){
	            return null;
	        }
	}
}
