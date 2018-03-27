
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.PosteDAOLocal;
import com.keren.dao.ifaces.employes.PosteDAORemote;
import com.keren.model.employes.Poste;

@Stateless(mappedName = "PosteDAO")
public class PosteDAOImpl
    extends AbstractGenericDAO<Poste, Long>
    implements PosteDAOLocal, PosteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PosteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Poste> getManagedEntityClass() {
        return (Poste.class);
    }

}
