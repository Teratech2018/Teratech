
package com.teratech.achat.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.base.SocieteDAOLocal;
import com.teratech.achat.dao.ifaces.base.SocieteDAORemote;
import com.teratech.achat.model.base.Societe;

@Stateless(mappedName = "SocieteDAO")
public class SocieteDAOImpl
    extends AbstractGenericDAO<Societe, Long>
    implements SocieteDAOLocal, SocieteDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public SocieteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Societe> getManagedEntityClass() {
        return (Societe.class);
    }

}
