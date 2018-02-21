
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.invetaire.BaseInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.BaseInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.invetaire.BaseInventaireDAOLocal;
import com.teratech.stock.model.invetaire.BaseInventaire;

@TransactionAttribute
@Stateless(mappedName = "BaseInventaireManager")
public class BaseInventaireManagerImpl
    extends AbstractGenericManager<BaseInventaire, Long>
    implements BaseInventaireManagerLocal, BaseInventaireManagerRemote
{

    @EJB(name = "BaseInventaireDAO")
    protected BaseInventaireDAOLocal dao;

    public BaseInventaireManagerImpl() {
    }

    @Override
    public GenericDAO<BaseInventaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
