
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.CommandeDAOLocal;
import com.teratech.vente.dao.ifaces.operations.CommandeDAORemote;
import com.teratech.vente.model.operations.Commande;

@Stateless(mappedName = "CommandeDAO")
public class CommandeDAOImpl
    extends AbstractGenericDAO<Commande, Long>
    implements CommandeDAOLocal, CommandeDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public CommandeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Commande> getManagedEntityClass() {
        return (Commande.class);
    }

}
