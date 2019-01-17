
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.inscription.Inscription;

@Stateless(mappedName = "BulletinHelperDAO")
public class BulletinHelperDAOImpl
    extends AbstractGenericDAO<BulletinHelper, Long>
    implements BulletinHelperDAOLocal, BulletinHelperDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinHelperDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinHelper> getManagedEntityClass() {
        return (BulletinHelper.class);
    }

	@Override
	public BulletinHelper gethelper(Inscription critere) {
		 try{
			 
			 BulletinHelper helper = (BulletinHelper) em.createQuery("SELECT a FROM BulletinHelper a "
			  		+ "WHERE a.inscription.id ="+critere.getId()).getSingleResult();
	            return helper;
	        }catch(Exception ex){
	            return null;
	        }
	}

	@Override
	public LigneHelper getLigneHelper(LigneBulletinClasse ligne, Inscription critere) {
		try{
			LigneHelper helper = (LigneHelper) em.createQuery("SELECT a FROM LigneHelper a "
			  		+ "WHERE a.inscription.id ="+critere.getId()+" and anneeid="+critere.getAnneScolaire()+" and matiere.id="+ligne.getMatiere().getId()).getSingleResult();
	            return helper;
	        }catch(Exception ex){
	            return null;
	        }
	}

}
