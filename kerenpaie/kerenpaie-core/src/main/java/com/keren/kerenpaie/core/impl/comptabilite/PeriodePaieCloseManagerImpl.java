
package com.keren.kerenpaie.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieCloseManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieCloseManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieCloseDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieClose;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieCloseManager")
public class PeriodePaieCloseManagerImpl
    extends AbstractGenericManager<PeriodePaieClose, Long>
    implements PeriodePaieCloseManagerLocal, PeriodePaieCloseManagerRemote
{

    @EJB(name = "PeriodePaieCloseDAO")
    protected PeriodePaieCloseDAOLocal dao;

    public PeriodePaieCloseManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaieClose, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
