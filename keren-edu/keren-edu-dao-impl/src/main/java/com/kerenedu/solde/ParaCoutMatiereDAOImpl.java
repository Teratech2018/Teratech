
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ParaCoutMatiereDAO")
public class ParaCoutMatiereDAOImpl
    extends AbstractGenericDAO<ParaCoutMatiere, Long>
    implements ParaCoutMatiereDAOLocal, ParaCoutMatiereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ParaCoutMatiereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ParaCoutMatiere> getManagedEntityClass() {
        return (ParaCoutMatiere.class);
    }

}
