
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.UniteAchatDAOLocal;
import com.keren.posweb.dao.ifaces.UniteAchatDAORemote;
import com.keren.posweb.model.UniteAchat;

@Stateless(mappedName = "UniteAchatDAO")
public class UniteAchatDAOImpl
    extends AbstractGenericDAO<UniteAchat, Long>
    implements UniteAchatDAOLocal, UniteAchatDAORemote
{

    @PersistenceContext(unitName = "posweb")
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
