
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.BanqueManagerLocal;
import com.keren.core.ifaces.comptabilite.BanqueManagerRemote;
import com.keren.dao.ifaces.comptabilite.BanqueDAOLocal;
import com.keren.model.comptabilite.Banque;

@TransactionAttribute
@Stateless(mappedName = "BanqueManager")
public class BanqueManagerImpl
    extends AbstractGenericManager<Banque, Long>
    implements BanqueManagerLocal, BanqueManagerRemote
{

    @EJB(name = "BanqueDAO")
    protected BanqueDAOLocal dao;

    public BanqueManagerImpl() {
    }

    @Override
    public GenericDAO<Banque, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
