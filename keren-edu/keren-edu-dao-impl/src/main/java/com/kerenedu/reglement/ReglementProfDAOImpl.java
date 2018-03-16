
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ReglementProfDAO")
public class ReglementProfDAOImpl
    extends AbstractGenericDAO<ReglementProf, Long>
    implements ReglementProfDAOLocal, ReglementProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ReglementProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ReglementProf> getManagedEntityClass() {
        return (ReglementProf.class);
    }

}
