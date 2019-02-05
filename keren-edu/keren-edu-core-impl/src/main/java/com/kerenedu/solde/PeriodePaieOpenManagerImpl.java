
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieOpenManager")
public class PeriodePaieOpenManagerImpl
    extends AbstractGenericManager<PeriodePaieOpen, Long>
    implements PeriodePaieOpenManagerLocal, PeriodePaieOpenManagerRemote
{

    @EJB(name = "PeriodePaieOpenDAO")
    protected PeriodePaieOpenDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;

    public PeriodePaieOpenManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaieOpen, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }


}
