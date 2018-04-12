
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.NominationManagerLocal;
import com.keren.core.ifaces.carrieres.NominationManagerRemote;
import com.keren.dao.ifaces.carrieres.NominationDAOLocal;
import com.keren.model.carrieres.Nomination;

@TransactionAttribute
@Stateless(mappedName = "NominationManager")
public class NominationManagerImpl
    extends AbstractGenericManager<Nomination, Long>
    implements NominationManagerLocal, NominationManagerRemote
{

    @EJB(name = "NominationDAO")
    protected NominationDAOLocal dao;

    public NominationManagerImpl() {
    }

    @Override
    public GenericDAO<Nomination, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
