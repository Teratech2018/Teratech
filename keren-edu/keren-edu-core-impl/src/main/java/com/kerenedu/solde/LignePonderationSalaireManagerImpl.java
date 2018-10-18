
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LignePonderationSalaireManager")
public class LignePonderationSalaireManagerImpl
    extends AbstractGenericManager<LignePonderationSalaire, Long>
    implements LignePonderationSalaireManagerLocal, LignePonderationSalaireManagerRemote
{

    @EJB(name = "LignePonderationSalaireDAO")
    protected LignePonderationSalaireDAOLocal dao;

    public LignePonderationSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<LignePonderationSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
