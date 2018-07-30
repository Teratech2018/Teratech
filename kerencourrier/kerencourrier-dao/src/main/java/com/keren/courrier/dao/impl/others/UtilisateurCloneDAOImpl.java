
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.UtilisateurCloneDAOLocal;
import com.keren.courrier.dao.ifaces.others.UtilisateurCloneDAORemote;
import com.keren.courrier.model.others.UtilisateurClone;

@Stateless(mappedName = "UtilisateurCloneDAO")
public class UtilisateurCloneDAOImpl
    extends AbstractGenericDAO<UtilisateurClone, Long>
    implements UtilisateurCloneDAOLocal, UtilisateurCloneDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public UtilisateurCloneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UtilisateurClone> getManagedEntityClass() {
        return (UtilisateurClone.class);
    }

}
