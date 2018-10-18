
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LigneElementVariableManager")
public class LigneElementVariableManagerImpl
    extends AbstractGenericManager<LigneElementVariable, Long>
    implements LigneElementVariableManagerLocal, LigneElementVariableManagerRemote
{

    @EJB(name = "LigneElementVariableDAO")
    protected LigneElementVariableDAOLocal dao;

    public LigneElementVariableManagerImpl() {
    }

    @Override
    public GenericDAO<LigneElementVariable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
