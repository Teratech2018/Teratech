
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.RubriqueManagerLocal;
import com.teratech.gmao.core.ifaces.base.RubriqueManagerRemote;
import com.teratech.gmao.dao.ifaces.base.RubriqueDAOLocal;
import com.teratech.gmao.model.base.Rubrique;

@TransactionAttribute
@Stateless(mappedName = "RubriqueManager")
public class RubriqueManagerImpl
    extends AbstractGenericManager<Rubrique, Long>
    implements RubriqueManagerLocal, RubriqueManagerRemote
{

    @EJB(name = "RubriqueDAO")
    protected RubriqueDAOLocal dao;

    public RubriqueManagerImpl() {
    }

    @Override
    public GenericDAO<Rubrique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
