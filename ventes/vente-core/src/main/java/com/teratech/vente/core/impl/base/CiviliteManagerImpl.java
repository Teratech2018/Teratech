
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.base.CiviliteManagerLocal;
import com.teratech.vente.core.ifaces.base.CiviliteManagerRemote;
import com.teratech.vente.dao.ifaces.base.CiviliteDAOLocal;
import com.teratech.vente.model.base.Civilite;

@TransactionAttribute
@Stateless(mappedName = "CiviliteManager")
public class CiviliteManagerImpl
    extends AbstractGenericManager<Civilite, Long>
    implements CiviliteManagerLocal, CiviliteManagerRemote
{

    @EJB(name = "CiviliteDAO")
    protected CiviliteDAOLocal dao;

    public CiviliteManagerImpl() {
    }

    @Override
    public GenericDAO<Civilite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
