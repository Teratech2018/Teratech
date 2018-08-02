
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.CompartimentClasseurDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CompartimentClasseurDAORemote;
import com.keren.courrier.model.referentiel.CompartimentClasseur;

@Stateless(mappedName = "CompartimentClasseurDAO")
public class CompartimentClasseurDAOImpl
    extends AbstractGenericDAO<CompartimentClasseur, Long>
    implements CompartimentClasseurDAOLocal, CompartimentClasseurDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CompartimentClasseurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CompartimentClasseur> getManagedEntityClass() {
        return (CompartimentClasseur.class);
    }

}
