
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "LigneBulletinClasseManager")
public class LigneBulletinClasseManagerImpl
    extends AbstractGenericManager<LigneBulletinClasse, Long>
    implements LigneBulletinClasseManagerLocal, LigneBulletinClasseManagerRemote
{

    @EJB(name = "LigneBulletinClasseDAO")
    protected LigneBulletinClasseDAOLocal dao;

    public LigneBulletinClasseManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBulletinClasse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
