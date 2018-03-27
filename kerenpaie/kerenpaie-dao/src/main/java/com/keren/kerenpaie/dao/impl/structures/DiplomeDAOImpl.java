
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.DiplomeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.DiplomeDAORemote;
import com.keren.kerenpaie.model.structures.Diplome;

@Stateless(mappedName = "DiplomeDAO")
public class DiplomeDAOImpl
    extends AbstractGenericDAO<Diplome, Long>
    implements DiplomeDAOLocal, DiplomeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public DiplomeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Diplome> getManagedEntityClass() {
        return (Diplome.class);
    }

}
