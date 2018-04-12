
package com.keren.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.structures.VilleDAOLocal;
import com.keren.dao.ifaces.structures.VilleDAORemote;
import com.keren.model.structures.Ville;

@Stateless(mappedName = "VilleDAO")
public class VilleDAOImpl
    extends AbstractGenericDAO<Ville, Long>
    implements VilleDAOLocal, VilleDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public VilleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Ville> getManagedEntityClass() {
        return (Ville.class);
    }

}
