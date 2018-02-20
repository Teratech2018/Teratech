
package com.kerenedu.inscription;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.school.Eleve;

@Stateless(mappedName = "InscriptionDAO")
public class InscriptionDAOImpl
    extends AbstractGenericDAO<Inscription, Long>
    implements InscriptionDAOLocal, InscriptionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;


    public InscriptionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Inscription> getManagedEntityClass() {
        return (Inscription.class);
    }

	public Inscription getInscriptionEtudiantByAnnee(Eleve eleve, AnneScolaire annee) {
		  try{
			  Inscription inscription = (Inscription) em.createQuery("SELECT a FROM Inscription a "
			  		+ "WHERE a.eleve.matricule ="+eleve.getMatricule()+" and a.anne.code="+annee.getCode()).getSingleResult();

	            return inscription;
	        }catch(Exception ex){
	            return null;
	        }
	}



}
