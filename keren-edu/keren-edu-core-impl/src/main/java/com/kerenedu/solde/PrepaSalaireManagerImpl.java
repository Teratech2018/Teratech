
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "PrepaSalaireManager")
public class PrepaSalaireManagerImpl
    extends AbstractGenericManager<PrepaSalaire, Long>
    implements PrepaSalaireManagerLocal, PrepaSalaireManagerRemote
{

    @EJB(name = "PrepaSalaireDAO")
    protected PrepaSalaireDAOLocal dao;

    public PrepaSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<PrepaSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
