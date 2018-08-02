
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.MarqueManagerLocal;
import com.teratech.gmao.core.ifaces.base.MarqueManagerRemote;
import com.teratech.gmao.dao.ifaces.base.MarqueDAOLocal;
import com.teratech.gmao.model.base.Marque;

@TransactionAttribute
@Stateless(mappedName = "MarqueManager")
public class MarqueManagerImpl
    extends AbstractGenericManager<Marque, Long>
    implements MarqueManagerLocal, MarqueManagerRemote
{

    @EJB(name = "MarqueDAO")
    protected MarqueDAOLocal dao;

    public MarqueManagerImpl() {
    }

    @Override
    public GenericDAO<Marque, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
