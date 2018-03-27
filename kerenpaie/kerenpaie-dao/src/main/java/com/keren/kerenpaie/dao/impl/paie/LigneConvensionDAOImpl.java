
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.LigneConvensionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.LigneConvensionDAORemote;
import com.keren.kerenpaie.model.paie.LigneConvension;

@Stateless(mappedName = "LigneConvensionDAO")
public class LigneConvensionDAOImpl
    extends AbstractGenericDAO<LigneConvension, Long>
    implements LigneConvensionDAOLocal, LigneConvensionDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
