
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

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
