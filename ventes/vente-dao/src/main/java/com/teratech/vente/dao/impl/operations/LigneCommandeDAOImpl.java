
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.LigneCommandeDAOLocal;
import com.teratech.vente.dao.ifaces.operations.LigneCommandeDAORemote;
import com.teratech.vente.model.operations.LigneCommande;

@Stateless(mappedName = "LigneCommandeDAO")
public class LigneCommandeDAOImpl
    extends AbstractGenericDAO<LigneCommande, Long>
    implements LigneCommandeDAOLocal, LigneCommandeDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public LigneCommandeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneCommande> getManagedEntityClass() {
        return (LigneCommande.class);
    }

}
