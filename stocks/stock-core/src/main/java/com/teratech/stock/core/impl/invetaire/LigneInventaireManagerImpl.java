
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.stock.core.ifaces.invetaire.LigneInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.LigneInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.invetaire.LigneInventaireDAOLocal;
import com.teratech.stock.model.invetaire.LigneInventaire;

@TransactionAttribute
@Stateless(mappedName = "LigneInventaireManager")
public class LigneInventaireManagerImpl
    extends AbstractGenericManager<LigneInventaire, Long>
    implements LigneInventaireManagerLocal, LigneInventaireManagerRemote
{

    @EJB(name = "LigneInventaireDAO")
    protected LigneInventaireDAOLocal dao;

    public LigneInventaireManagerImpl() {
    }

    @Override
    public GenericDAO<LigneInventaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
