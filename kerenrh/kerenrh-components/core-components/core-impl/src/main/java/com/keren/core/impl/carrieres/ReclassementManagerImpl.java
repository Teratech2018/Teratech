
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.ReclassementManagerLocal;
import com.keren.core.ifaces.carrieres.ReclassementManagerRemote;
import com.keren.dao.ifaces.carrieres.ReclassementDAOLocal;
import com.keren.model.carrieres.Reclassement;

@TransactionAttribute
@Stateless(mappedName = "ReclassementManager")
public class ReclassementManagerImpl
    extends AbstractGenericManager<Reclassement, Long>
    implements ReclassementManagerLocal, ReclassementManagerRemote
{

    @EJB(name = "ReclassementDAO")
    protected ReclassementDAOLocal dao;

    public ReclassementManagerImpl() {
    }

    @Override
    public GenericDAO<Reclassement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
