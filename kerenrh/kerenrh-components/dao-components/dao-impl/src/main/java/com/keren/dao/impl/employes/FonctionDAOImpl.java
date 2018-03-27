
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.FonctionDAOLocal;
import com.keren.dao.ifaces.employes.FonctionDAORemote;
import com.keren.model.employes.Fonction;

@Stateless(mappedName = "FonctionDAO")
public class FonctionDAOImpl
    extends AbstractGenericDAO<Fonction, Long>
    implements FonctionDAOLocal, FonctionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FonctionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Fonction> getManagedEntityClass() {
        return (Fonction.class);
    }

}
