
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.FamilleDAOLocal;
import com.keren.dao.ifaces.employes.FamilleDAORemote;
import com.keren.model.employes.Famille;

@Stateless(mappedName = "FamilleDAO")
public class FamilleDAOImpl
    extends AbstractGenericDAO<Famille, Long>
    implements FamilleDAOLocal, FamilleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FamilleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Famille> getManagedEntityClass() {
        return (Famille.class);
    }

}
