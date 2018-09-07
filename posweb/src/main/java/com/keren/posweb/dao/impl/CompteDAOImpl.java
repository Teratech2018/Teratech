
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.CompteDAOLocal;
import com.keren.posweb.dao.ifaces.CompteDAORemote;
import com.keren.posweb.model.Compte;

@Stateless(mappedName = "CompteDAO")
public class CompteDAOImpl
    extends AbstractGenericDAO<Compte, Long>
    implements CompteDAOLocal, CompteDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public CompteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Compte> getManagedEntityClass() {
        return (Compte.class);
    }

}
