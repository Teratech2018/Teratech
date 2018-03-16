
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PaiementProfDAO")
public class PaiementProfDAOImpl
    extends AbstractGenericDAO<PaiementProf, Long>
    implements PaiementProfDAOLocal, PaiementProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PaiementProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PaiementProf> getManagedEntityClass() {
        return (PaiementProf.class);
    }

}
