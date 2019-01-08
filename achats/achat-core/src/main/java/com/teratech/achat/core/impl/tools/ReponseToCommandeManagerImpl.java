
package com.teratech.achat.core.impl.tools;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.tools.ReponseToCommandeManagerLocal;
import com.teratech.achat.core.ifaces.tools.ReponseToCommandeManagerRemote;
import com.teratech.achat.dao.ifaces.tools.ReponseToCommandeDAOLocal;
import com.teratech.achat.model.tools.ReponseToCommande;

@TransactionAttribute
@Stateless(mappedName = "ReponseToCommandeManager")
public class ReponseToCommandeManagerImpl
    extends AbstractGenericManager<ReponseToCommande, Long>
    implements ReponseToCommandeManagerLocal, ReponseToCommandeManagerRemote
{

    @EJB(name = "ReponseToCommandeDAO")
    protected ReponseToCommandeDAOLocal dao;

    public ReponseToCommandeManagerImpl() {
    }

    @Override
    public GenericDAO<ReponseToCommande, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
