
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.CommandeDAOLocal;
import com.keren.posweb.dao.ifaces.CommandeDAORemote;
import com.keren.posweb.model.Commande;

@Stateless(mappedName = "CommandeDAO")
public class CommandeDAOImpl
    extends AbstractGenericDAO<Commande, Long>
    implements CommandeDAOLocal, CommandeDAORemote
{

    @PersistenceContext(unitName = "posweb")
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
