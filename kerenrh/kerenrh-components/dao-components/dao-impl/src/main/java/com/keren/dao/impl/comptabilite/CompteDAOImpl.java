
package com.keren.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.comptabilite.CompteDAOLocal;
import com.keren.dao.ifaces.comptabilite.CompteDAORemote;
import com.keren.model.comptabilite.Compte;

@Stateless(mappedName = "CompteDAO")
public class CompteDAOImpl
    extends AbstractGenericDAO<Compte, Long>
    implements CompteDAOLocal, CompteDAORemote
{

    @PersistenceContext(unitName = "keren")
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
