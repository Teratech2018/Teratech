
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneConvensionDAO")
public class LigneConvensionDAOImpl
    extends AbstractGenericDAO<LigneConvension, Long>
    implements LigneConvensionDAOLocal, LigneConvensionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneConvensionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneConvension> getManagedEntityClass() {
        return (LigneConvension.class);
    }

}
