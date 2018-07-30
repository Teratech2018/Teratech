
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAORemote;
import com.keren.courrier.model.courrier.TraitementCourrier;

@Stateless(mappedName = "TraitementCourrierDAO")
public class TraitementCourrierDAOImpl
    extends AbstractGenericDAO<TraitementCourrier, Long>
    implements TraitementCourrierDAOLocal, TraitementCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public TraitementCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitementCourrier> getManagedEntityClass() {
        return (TraitementCourrier.class);
    }

}
