
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LignePonderationTypeContratManager")
public class LignePonderationTypeContratManagerImpl
    extends AbstractGenericManager<LignePonderationTypeContrat, Long>
    implements LignePonderationTypeContratManagerLocal, LignePonderationTypeContratManagerRemote
{

    @EJB(name = "LignePonderationTypeContratDAO")
    protected LignePonderationTypeContratDAOLocal dao;

    public LignePonderationTypeContratManagerImpl() {
    }

    @Override
    public GenericDAO<LignePonderationTypeContrat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
