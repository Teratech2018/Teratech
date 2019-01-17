
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "BulletinHelper2Manager")
public class BulletinHelper2ManagerImpl
    extends AbstractGenericManager<BulletinHelper2, Long>
    implements BulletinHelper2ManagerLocal, BulletinHelper2ManagerRemote
{

    @EJB(name = "BulletinHelper2DAO")
    protected BulletinHelper2DAOLocal dao;

    public BulletinHelper2ManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinHelper2, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
