
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.SocieteDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.SocieteDAORemote;
import com.keren.kerenpaie.model.structures.Societe;

@Stateless(mappedName = "SocieteDAO")
public class SocieteDAOImpl
    extends AbstractGenericDAO<Societe, Long>
    implements SocieteDAOLocal, SocieteDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public SocieteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Societe> getManagedEntityClass() {
        return (Societe.class);
    }

}
