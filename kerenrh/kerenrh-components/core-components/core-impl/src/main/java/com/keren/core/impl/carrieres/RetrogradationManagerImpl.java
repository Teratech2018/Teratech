
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.RetrogradationManagerLocal;
import com.keren.core.ifaces.carrieres.RetrogradationManagerRemote;
import com.keren.dao.ifaces.carrieres.RetrogradationDAOLocal;
import com.keren.model.carrieres.Retrogradation;

@TransactionAttribute
@Stateless(mappedName = "RetrogradationManager")
public class RetrogradationManagerImpl
    extends AbstractGenericManager<Retrogradation, Long>
    implements RetrogradationManagerLocal, RetrogradationManagerRemote
{

    @EJB(name = "RetrogradationDAO")
    protected RetrogradationDAOLocal dao;

    public RetrogradationManagerImpl() {
    }

    @Override
    public GenericDAO<Retrogradation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
