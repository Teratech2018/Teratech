
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.UniteAchatDAOLocal;
import com.teratech.vente.dao.ifaces.base.UniteAchatDAORemote;
import com.teratech.vente.model.base.UniteAchat;

@Stateless(mappedName = "UniteAchatDAO")
public class UniteAchatDAOImpl
    extends AbstractGenericDAO<UniteAchat, Long>
    implements UniteAchatDAOLocal, UniteAchatDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public UniteAchatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UniteAchat> getManagedEntityClass() {
        return (UniteAchat.class);
    }

}
