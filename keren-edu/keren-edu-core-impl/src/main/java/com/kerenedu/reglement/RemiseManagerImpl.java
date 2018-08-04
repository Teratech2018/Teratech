
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "RemiseManager")
public class RemiseManagerImpl
    extends AbstractGenericManager<Remise, Long>
    implements RemiseManagerLocal, RemiseManagerRemote
{

    @EJB(name = "RemiseDAO")
    protected RemiseDAOLocal dao;

    public RemiseManagerImpl() {
    }

    @Override
    public GenericDAO<Remise, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
