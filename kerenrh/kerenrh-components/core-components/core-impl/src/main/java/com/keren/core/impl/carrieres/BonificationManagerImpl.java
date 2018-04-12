
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.BonificationManagerLocal;
import com.keren.core.ifaces.carrieres.BonificationManagerRemote;
import com.keren.dao.ifaces.carrieres.BonificationDAOLocal;
import com.keren.model.carrieres.Bonification;

@TransactionAttribute
@Stateless(mappedName = "BonificationManager")
public class BonificationManagerImpl
    extends AbstractGenericManager<Bonification, Long>
    implements BonificationManagerLocal, BonificationManagerRemote
{

    @EJB(name = "BonificationDAO")
    protected BonificationDAOLocal dao;

    public BonificationManagerImpl() {
    }

    @Override
    public GenericDAO<Bonification, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
