
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.LigneCommandeDAOLocal;
import com.keren.posweb.dao.ifaces.LigneCommandeDAORemote;
import com.keren.posweb.model.LigneCommande;

@Stateless(mappedName = "LigneCommandeDAO")
public class LigneCommandeDAOImpl
    extends AbstractGenericDAO<LigneCommande, Long>
    implements LigneCommandeDAOLocal, LigneCommandeDAORemote
{

    @PersistenceContext(unitName = "posweb")
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
