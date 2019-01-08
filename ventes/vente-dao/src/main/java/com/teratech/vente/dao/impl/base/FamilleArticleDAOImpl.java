
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.FamilleArticleDAOLocal;
import com.teratech.vente.dao.ifaces.base.FamilleArticleDAORemote;
import com.teratech.vente.model.base.FamilleArticle;

@Stateless(mappedName = "FamilleArticleDAO")
public class FamilleArticleDAOImpl
    extends AbstractGenericDAO<FamilleArticle, Long>
    implements FamilleArticleDAOLocal, FamilleArticleDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public FamilleArticleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FamilleArticle> getManagedEntityClass() {
        return (FamilleArticle.class);
    }

}
