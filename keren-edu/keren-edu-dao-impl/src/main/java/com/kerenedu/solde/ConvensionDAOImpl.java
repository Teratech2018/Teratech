
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ConvensionDAO")
public class ConvensionDAOImpl
    extends AbstractGenericDAO<Convension, Long>
    implements ConvensionDAOLocal, ConvensionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConvensionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Convension> getManagedEntityClass() {
        return (Convension.class);
    }

}
