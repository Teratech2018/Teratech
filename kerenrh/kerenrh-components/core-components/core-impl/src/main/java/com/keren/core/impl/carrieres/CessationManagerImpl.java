
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.CessationManagerLocal;
import com.keren.core.ifaces.carrieres.CessationManagerRemote;
import com.keren.dao.ifaces.carrieres.CessationDAOLocal;
import com.keren.model.carrieres.Cessation;

@TransactionAttribute
@Stateless(mappedName = "CessationManager")
public class CessationManagerImpl
    extends AbstractGenericManager<Cessation, Long>
    implements CessationManagerLocal, CessationManagerRemote
{

    @EJB(name = "CessationDAO")
    protected CessationDAOLocal dao;

    public CessationManagerImpl() {
    }

    @Override
    public GenericDAO<Cessation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
