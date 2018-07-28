
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.PaysManagerLocal;
import com.teratech.gmao.core.ifaces.base.PaysManagerRemote;
import com.teratech.gmao.dao.ifaces.base.PaysDAOLocal;
import com.teratech.gmao.model.base.Pays;

@TransactionAttribute
@Stateless(mappedName = "PaysManager")
public class PaysManagerImpl
    extends AbstractGenericManager<Pays, Long>
    implements PaysManagerLocal, PaysManagerRemote
{

    @EJB(name = "PaysDAO")
    protected PaysDAOLocal dao;

    public PaysManagerImpl() {
    }

    @Override
    public GenericDAO<Pays, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
