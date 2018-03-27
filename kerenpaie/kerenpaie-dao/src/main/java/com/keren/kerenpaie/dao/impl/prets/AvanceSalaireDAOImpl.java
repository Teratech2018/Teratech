
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.AvanceSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.AvanceSalaireDAORemote;
import com.keren.kerenpaie.model.prets.AvanceSalaire;

@Stateless(mappedName = "AvanceSalaireDAO")
public class AvanceSalaireDAOImpl
    extends AbstractGenericDAO<AvanceSalaire, Long>
    implements AvanceSalaireDAOLocal, AvanceSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public AvanceSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AvanceSalaire> getManagedEntityClass() {
        return (AvanceSalaire.class);
    }

}
