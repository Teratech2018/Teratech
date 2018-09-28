
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EltSalaireDAO")
public class EltSalaireDAOImpl
    extends AbstractGenericDAO<EltSalaire, Long>
    implements EltSalaireDAOLocal, EltSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EltSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EltSalaire> getManagedEntityClass() {
        return (EltSalaire.class);
    }

}
