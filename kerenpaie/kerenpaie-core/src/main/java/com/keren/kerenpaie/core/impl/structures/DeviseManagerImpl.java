
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.DeviseManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.DeviseManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.DeviseDAOLocal;
import com.keren.kerenpaie.model.structures.Devise;

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
