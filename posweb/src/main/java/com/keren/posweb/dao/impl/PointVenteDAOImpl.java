
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.PointVenteDAOLocal;
import com.keren.posweb.dao.ifaces.PointVenteDAORemote;
import com.keren.posweb.model.PointVente;

@Stateless(mappedName = "PointVenteDAO")
public class PointVenteDAOImpl
    extends AbstractGenericDAO<PointVente, Long>
    implements PointVenteDAOLocal, PointVenteDAORemote
{

    @PersistenceContext(unitName = "posweb")
    protected EntityManager em;

    public PointVenteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PointVente> getManagedEntityClass() {
        return (PointVente.class);
    }

}
