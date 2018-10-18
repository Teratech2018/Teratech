
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "TraitSalaireManager")
public class TraitSalaireManagerImpl
    extends AbstractGenericManager<TraitSalaire, Long>
    implements TraitSalaireManagerLocal, TraitSalaireManagerRemote
{

    @EJB(name = "TraitSalaireDAO")
    protected TraitSalaireDAOLocal dao;

    public TraitSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<TraitSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
