
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.NatureCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.NatureCourrierDAORemote;
import com.keren.courrier.model.referentiel.NatureCourrier;

@Stateless(mappedName = "NatureCourrierDAO")
public class NatureCourrierDAOImpl
    extends AbstractGenericDAO<NatureCourrier, Long>
    implements NatureCourrierDAOLocal, NatureCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public NatureCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NatureCourrier> getManagedEntityClass() {
        return (NatureCourrier.class);
    }

}
