
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.BonCommandeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonCommandeDAORemote;
import com.teratech.achat.model.operations.BonCommande;

@Stateless(mappedName = "BonCommandeDAO")
public class BonCommandeDAOImpl
    extends AbstractGenericDAO<BonCommande, Long>
    implements BonCommandeDAOLocal, BonCommandeDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public BonCommandeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BonCommande> getManagedEntityClass() {
        return (BonCommande.class);
    }

}
