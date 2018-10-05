
package com.keren.courrier.core.impl.archivage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseManagerLocal;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseDAOLocal;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;

@TransactionAttribute
@Stateless(mappedName = "LigneBorderoLiasseManager")
public class LigneBorderoLiasseManagerImpl
    extends AbstractGenericManager<LigneBorderoLiasse, Long>
    implements LigneBorderoLiasseManagerLocal, LigneBorderoLiasseManagerRemote
{

    @EJB(name = "LigneBorderoLiasseDAO")
    protected LigneBorderoLiasseDAOLocal dao;

    public LigneBorderoLiasseManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBorderoLiasse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
