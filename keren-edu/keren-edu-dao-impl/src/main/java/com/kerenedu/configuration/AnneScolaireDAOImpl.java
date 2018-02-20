
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AnneScolaireDAO")
public class AnneScolaireDAOImpl
    extends AbstractGenericDAO<AnneScolaire, Long>
    implements AnneScolaireDAOLocal, AnneScolaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AnneScolaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AnneScolaire> getManagedEntityClass() {
        return (AnneScolaire.class);
    }

	public AnneScolaire getAnneScolaireCourante() {
		  try{
			  AnneScolaire exercice = (AnneScolaire) em.createQuery("SELECT a FROM AnneScolaire a WHERE a.connected ="+"1").getSingleResult();
			
	            return exercice;
	        }catch(Exception ex){
	            return null;
	        }
	}

}
