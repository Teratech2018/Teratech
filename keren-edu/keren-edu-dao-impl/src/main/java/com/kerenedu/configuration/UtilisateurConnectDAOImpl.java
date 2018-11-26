
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "UtilisateurConnectDAO")
public class UtilisateurConnectDAOImpl
    extends AbstractGenericDAO<UtilisateurConnect, Long>
    implements UtilisateurConnectDAOLocal, UtilisateurConnectDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public UtilisateurConnectDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UtilisateurConnect> getManagedEntityClass() {
        return (UtilisateurConnect.class);
    }

}
