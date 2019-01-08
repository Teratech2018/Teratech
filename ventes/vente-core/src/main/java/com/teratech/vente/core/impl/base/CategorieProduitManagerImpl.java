
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.base.CategorieProduitManagerLocal;
import com.teratech.vente.core.ifaces.base.CategorieProduitManagerRemote;
import com.teratech.vente.dao.ifaces.base.CategorieProduitDAOLocal;
import com.teratech.vente.model.base.CategorieProduit;

@TransactionAttribute
@Stateless(mappedName = "CategorieProduitManager")
public class CategorieProduitManagerImpl
    extends AbstractGenericManager<CategorieProduit, Long>
    implements CategorieProduitManagerLocal, CategorieProduitManagerRemote
{

    @EJB(name = "CategorieProduitDAO")
    protected CategorieProduitDAOLocal dao;

    public CategorieProduitManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieProduit, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
