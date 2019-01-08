
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.CiviliteDAOLocal;
import com.teratech.vente.dao.ifaces.base.CiviliteDAORemote;
import com.teratech.vente.model.base.Civilite;

@Stateless(mappedName = "CiviliteDAO")
public class CiviliteDAOImpl
    extends AbstractGenericDAO<Civilite, Long>
    implements CiviliteDAOLocal, CiviliteDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public CiviliteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Civilite> getManagedEntityClass() {
        return (Civilite.class);
    }

}
