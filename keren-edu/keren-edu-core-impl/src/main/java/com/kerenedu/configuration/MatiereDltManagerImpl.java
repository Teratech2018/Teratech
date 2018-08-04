
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "MatiereDltManager")
public class MatiereDltManagerImpl
    extends AbstractGenericManager<MatiereDlt, Long>
    implements MatiereDltManagerLocal, MatiereDltManagerRemote
{

    @EJB(name = "MatiereDltDAO")
    protected MatiereDltDAOLocal dao;

    public MatiereDltManagerImpl() {
    }

    @Override
    public GenericDAO<MatiereDlt, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
