
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.CategorieDAOLocal;
import com.keren.dao.ifaces.employes.CategorieDAORemote;
import com.keren.model.employes.Categorie;

@Stateless(mappedName = "CategorieDAO")
public class CategorieDAOImpl
    extends AbstractGenericDAO<Categorie, Long>
    implements CategorieDAOLocal, CategorieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CategorieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Categorie> getManagedEntityClass() {
        return (Categorie.class);
    }

}
