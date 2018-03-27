
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.DeviseManagerLocal;
import com.keren.core.ifaces.structures.DeviseManagerRemote;
import com.keren.dao.ifaces.structures.DeviseDAOLocal;
import com.keren.model.structures.Devise;

@TransactionAttribute
@Stateless(mappedName = "DeviseManager")
public class DeviseManagerImpl
    extends AbstractGenericManager<Devise, Long>
    implements DeviseManagerLocal, DeviseManagerRemote
{

    @EJB(name = "DeviseDAO")
    protected DeviseDAOLocal dao;

    public DeviseManagerImpl() {
    }

    @Override
    public GenericDAO<Devise, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
