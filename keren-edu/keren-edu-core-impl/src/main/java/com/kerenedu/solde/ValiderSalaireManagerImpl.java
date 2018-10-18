
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ValiderSalaireManager")
public class ValiderSalaireManagerImpl
    extends AbstractGenericManager<ValiderSalaire, Long>
    implements ValiderSalaireManagerLocal, ValiderSalaireManagerRemote
{

    @EJB(name = "ValiderSalaireDAO")
    protected ValiderSalaireDAOLocal dao;

    public ValiderSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<ValiderSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
