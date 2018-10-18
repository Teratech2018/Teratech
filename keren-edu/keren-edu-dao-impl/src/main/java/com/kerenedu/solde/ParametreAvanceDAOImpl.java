
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ParametreAvanceDAO")
public class ParametreAvanceDAOImpl
    extends AbstractGenericDAO<ParametreAvance, Long>
    implements ParametreAvanceDAOLocal, ParametreAvanceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ParametreAvanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ParametreAvance> getManagedEntityClass() {
        return (ParametreAvance.class);
    }

}
