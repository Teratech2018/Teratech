
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.UniteGestionDAOLocal;
import com.keren.posweb.dao.ifaces.UniteGestionDAORemote;
import com.keren.posweb.model.UniteGestion;

@Stateless(mappedName = "UniteGestionDAO")
public class UniteGestionDAOImpl
    extends AbstractGenericDAO<UniteGestion, Long>
    implements UniteGestionDAOLocal, UniteGestionDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public UniteGestionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UniteGestion> getManagedEntityClass() {
        return (UniteGestion.class);
    }

}
