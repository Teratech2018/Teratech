
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerLocal;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.TraitementDIDAOLocal;
import com.teratech.gmao.model.curative.TraitementDI;

@TransactionAttribute
@Stateless(mappedName = "TraitementDIManager")
public class TraitementDIManagerImpl
    extends AbstractGenericManager<TraitementDI, Long>
    implements TraitementDIManagerLocal, TraitementDIManagerRemote
{

    @EJB(name = "TraitementDIDAO")
    protected TraitementDIDAOLocal dao;

    public TraitementDIManagerImpl() {
    }

    @Override
    public GenericDAO<TraitementDI, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
