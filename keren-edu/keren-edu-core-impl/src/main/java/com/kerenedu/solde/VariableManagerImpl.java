
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "VariableManager")
public class VariableManagerImpl
    extends AbstractGenericManager<Variable, Long>
    implements VariableManagerLocal, VariableManagerRemote
{

    @EJB(name = "VariableDAO")
    protected VariableDAOLocal dao;

    public VariableManagerImpl() {
    }

    @Override
    public GenericDAO<Variable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
