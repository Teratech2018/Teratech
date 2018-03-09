
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EcheancierDAO")
public class EcheancierDAOImpl
    extends AbstractGenericDAO<Echeancier, Long>
    implements EcheancierDAOLocal, EcheancierDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EcheancierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Echeancier> getManagedEntityClass() {
        return (Echeancier.class);
    }

}
