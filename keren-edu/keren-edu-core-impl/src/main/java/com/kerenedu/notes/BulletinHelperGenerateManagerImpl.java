
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "BulletinHelperGenerateManager")
public class BulletinHelperGenerateManagerImpl
    extends AbstractGenericManager<BulletinHelperGenerate, Long>
    implements BulletinHelperGenerateManagerLocal, BulletinHelperGenerateManagerRemote
{

    @EJB(name = "BulletinHelperGenerateDAO")
    protected BulletinHelperGenerateDAOLocal dao;

    public BulletinHelperGenerateManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinHelperGenerate, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
