
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.BonLivraisonDAOLocal;
import com.teratech.vente.dao.ifaces.operations.BonLivraisonDAORemote;
import com.teratech.vente.model.operations.BonLivraison;

@Stateless(mappedName = "BonLivraisonDAO")
public class BonLivraisonDAOImpl
    extends AbstractGenericDAO<BonLivraison, Long>
    implements BonLivraisonDAOLocal, BonLivraisonDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public BonLivraisonDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BonLivraison> getManagedEntityClass() {
        return (BonLivraison.class);
    }

}
