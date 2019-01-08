
package com.teratech.achat.dao.impl.tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.tools.ReponseToCommandeDAOLocal;
import com.teratech.achat.dao.ifaces.tools.ReponseToCommandeDAORemote;
import com.teratech.achat.model.tools.ReponseToCommande;

@Stateless(mappedName = "ReponseToCommandeDAO")
public class ReponseToCommandeDAOImpl
    extends AbstractGenericDAO<ReponseToCommande, Long>
    implements ReponseToCommandeDAOLocal, ReponseToCommandeDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public ReponseToCommandeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ReponseToCommande> getManagedEntityClass() {
        return (ReponseToCommande.class);
    }

}
