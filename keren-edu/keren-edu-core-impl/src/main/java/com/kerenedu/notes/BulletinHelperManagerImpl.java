
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "BulletinHelperManager")
public class BulletinHelperManagerImpl
    extends AbstractGenericManager<BulletinHelper, Long>
    implements BulletinHelperManagerLocal, BulletinHelperManagerRemote
{

    @EJB(name = "BulletinHelperDAO")
    protected BulletinHelperDAOLocal dao;

    public BulletinHelperManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinHelper, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
