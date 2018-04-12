
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.CategorieModuleDAOLocal;
import com.keren.dao.ifaces.formations.CategorieModuleDAORemote;
import com.keren.model.formations.CategorieModule;

@Stateless(mappedName = "CategorieModuleDAO")
public class CategorieModuleDAOImpl
    extends AbstractGenericDAO<CategorieModule, Long>
    implements CategorieModuleDAOLocal, CategorieModuleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CategorieModuleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CategorieModule> getManagedEntityClass() {
        return (CategorieModule.class);
    }

}
