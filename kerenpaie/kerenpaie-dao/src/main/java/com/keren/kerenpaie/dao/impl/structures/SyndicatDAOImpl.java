
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.SyndicatDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.SyndicatDAORemote;
import com.keren.kerenpaie.model.structures.Syndicat;

@Stateless(mappedName = "SyndicatDAO")
public class SyndicatDAOImpl
    extends AbstractGenericDAO<Syndicat, Long>
    implements SyndicatDAOLocal, SyndicatDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public SyndicatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Syndicat> getManagedEntityClass() {
        return (Syndicat.class);
    }

}
