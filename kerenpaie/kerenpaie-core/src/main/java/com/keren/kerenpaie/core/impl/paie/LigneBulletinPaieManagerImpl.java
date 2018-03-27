
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LigneBulletinPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.LigneBulletinPaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.LigneBulletinPaieDAOLocal;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;

@TransactionAttribute
@Stateless(mappedName = "LigneBulletinPaieManager")
public class LigneBulletinPaieManagerImpl
    extends AbstractGenericManager<LigneBulletinPaie, Long>
    implements LigneBulletinPaieManagerLocal, LigneBulletinPaieManagerRemote
{

    @EJB(name = "LigneBulletinPaieDAO")
    protected LigneBulletinPaieDAOLocal dao;

    public LigneBulletinPaieManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBulletinPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
