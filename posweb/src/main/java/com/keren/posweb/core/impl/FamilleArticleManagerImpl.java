
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.FamilleArticleManagerLocal;
import com.keren.posweb.core.ifaces.FamilleArticleManagerRemote;
import com.keren.posweb.dao.ifaces.FamilleArticleDAOLocal;
import com.keren.posweb.model.FamilleArticle;

@TransactionAttribute
@Stateless(mappedName = "FamilleArticleManager")
public class FamilleArticleManagerImpl
    extends AbstractGenericManager<FamilleArticle, Long>
    implements FamilleArticleManagerLocal, FamilleArticleManagerRemote
{

    @EJB(name = "FamilleArticleDAO")
    protected FamilleArticleDAOLocal dao;

    public FamilleArticleManagerImpl() {
    }

    @Override
    public GenericDAO<FamilleArticle, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
