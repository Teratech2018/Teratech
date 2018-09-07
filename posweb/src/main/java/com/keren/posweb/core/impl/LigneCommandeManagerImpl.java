
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.LigneCommandeManagerLocal;
import com.keren.posweb.core.ifaces.LigneCommandeManagerRemote;
import com.keren.posweb.dao.ifaces.LigneCommandeDAOLocal;
import com.keren.posweb.model.LigneCommande;

@TransactionAttribute
@Stateless(mappedName = "LigneCommandeManager")
public class LigneCommandeManagerImpl
    extends AbstractGenericManager<LigneCommande, Long>
    implements LigneCommandeManagerLocal, LigneCommandeManagerRemote
{

    @EJB(name = "LigneCommandeDAO")
    protected LigneCommandeDAOLocal dao;

    public LigneCommandeManagerImpl() {
    }

    @Override
    public GenericDAO<LigneCommande, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
