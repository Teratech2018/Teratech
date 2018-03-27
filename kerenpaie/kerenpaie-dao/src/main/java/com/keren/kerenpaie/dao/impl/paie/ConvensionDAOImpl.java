
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAORemote;
import com.keren.kerenpaie.model.paie.Convension;

@Stateless(mappedName = "ConvensionDAO")
public class ConvensionDAOImpl
    extends AbstractGenericDAO<Convension, Long>
    implements ConvensionDAOLocal, ConvensionDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
