
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.operations.LigneCommandeManagerLocal;
import com.teratech.vente.core.ifaces.operations.LigneCommandeManagerRemote;
import com.teratech.vente.dao.ifaces.operations.LigneCommandeDAOLocal;
import com.teratech.vente.model.operations.LigneCommande;

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
