
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.EntrepriseManagerLocal;
import com.teratech.gmao.core.ifaces.base.EntrepriseManagerRemote;
import com.teratech.gmao.dao.ifaces.base.EntrepriseDAOLocal;
import com.teratech.gmao.model.base.Entreprise;

@TransactionAttribute
@Stateless(mappedName = "EntrepriseManager")
public class EntrepriseManagerImpl
    extends AbstractGenericManager<Entreprise, Long>
    implements EntrepriseManagerLocal, EntrepriseManagerRemote
{

    @EJB(name = "EntrepriseDAO")
    protected EntrepriseDAOLocal dao;

    public EntrepriseManagerImpl() {
    }

    @Override
    public GenericDAO<Entreprise, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
