
package com.keren.courrier.core.impl.archivage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseRManagerLocal;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseRManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseRDAOLocal;
import com.keren.courrier.model.archivage.LigneBorderoLiasseR;

@TransactionAttribute
@Stateless(mappedName = "LigneBorderoLiasseRManager")
public class LigneBorderoLiasseRManagerImpl
    extends AbstractGenericManager<LigneBorderoLiasseR, Long>
    implements LigneBorderoLiasseRManagerLocal, LigneBorderoLiasseRManagerRemote
{

    @EJB(name = "LigneBorderoLiasseRDAO")
    protected LigneBorderoLiasseRDAOLocal dao;

    public LigneBorderoLiasseRManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBorderoLiasseR, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
