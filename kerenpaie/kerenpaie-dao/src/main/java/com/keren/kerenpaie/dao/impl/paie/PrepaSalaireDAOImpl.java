
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.PrepaSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.PrepaSalaireDAORemote;
import com.keren.kerenpaie.model.paie.PrepaSalaire;

@Stateless(mappedName = "PrepaSalaireDAO")
public class PrepaSalaireDAOImpl
    extends AbstractGenericDAO<PrepaSalaire, Long>
    implements PrepaSalaireDAOLocal, PrepaSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public PrepaSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PrepaSalaire> getManagedEntityClass() {
        return (PrepaSalaire.class);
    }

}
