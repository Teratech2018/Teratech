
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;

@Stateless(mappedName = "FichePaiementDAO")
public class FichePaiementDAOImpl
    extends AbstractGenericDAO<FichePaiement, Long>
    implements FichePaiementDAOLocal, FichePaiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePaiement> getManagedEntityClass() {
        return (FichePaiement.class);
    }
    
   

}
