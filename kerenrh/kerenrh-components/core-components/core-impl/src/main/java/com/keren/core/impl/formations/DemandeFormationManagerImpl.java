
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.DemandeFormationManagerLocal;
import com.keren.core.ifaces.formations.DemandeFormationManagerRemote;
import com.keren.dao.ifaces.formations.DemandeFormationDAOLocal;
import com.keren.model.formations.DemandeFormation;

@TransactionAttribute
@Stateless(mappedName = "DemandeFormationManager")
public class DemandeFormationManagerImpl
    extends AbstractGenericManager<DemandeFormation, Long>
    implements DemandeFormationManagerLocal, DemandeFormationManagerRemote
{

    @EJB(name = "DemandeFormationDAO")
    protected DemandeFormationDAOLocal dao;

    public DemandeFormationManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
