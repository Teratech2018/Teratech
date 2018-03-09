
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FichePaiementProfDAO")
public class FichePaiementProfDAOImpl
    extends AbstractGenericDAO<FichePaiementProf, Long>
    implements FichePaiementProfDAOLocal, FichePaiementProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FichePaiementProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichePaiementProf> getManagedEntityClass() {
        return (FichePaiementProf.class);
    }

}
