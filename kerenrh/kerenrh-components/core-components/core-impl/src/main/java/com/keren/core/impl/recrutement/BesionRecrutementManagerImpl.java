
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.BesionRecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.BesionRecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.BesionRecrutementDAOLocal;
import com.keren.model.recrutement.BesionRecrutement;

@TransactionAttribute
@Stateless(mappedName = "BesionRecrutementManager")
public class BesionRecrutementManagerImpl
    extends AbstractGenericManager<BesionRecrutement, Long>
    implements BesionRecrutementManagerLocal, BesionRecrutementManagerRemote
{

    @EJB(name = "BesionRecrutementDAO")
    protected BesionRecrutementDAOLocal dao;

    public BesionRecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<BesionRecrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
