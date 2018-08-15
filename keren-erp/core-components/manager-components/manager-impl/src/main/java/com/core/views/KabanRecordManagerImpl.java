
package com.core.views;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "KabanRecordManager")
public class KabanRecordManagerImpl
    extends AbstractGenericManager<KabanRecord, Long>
    implements KabanRecordManagerLocal, KabanRecordManagerRemote
{

    @EJB(name = "KabanRecordDAO")
    protected KabanRecordDAOLocal dao;

    public KabanRecordManagerImpl() {
    }

    @Override
    public GenericDAO<KabanRecord, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
