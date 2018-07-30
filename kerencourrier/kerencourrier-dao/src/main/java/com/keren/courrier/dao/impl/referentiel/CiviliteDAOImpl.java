
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.CiviliteDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CiviliteDAORemote;
import com.keren.courrier.model.referentiel.Civilite;

@Stateless(mappedName = "CiviliteDAO")
public class CiviliteDAOImpl
    extends AbstractGenericDAO<Civilite, Long>
    implements CiviliteDAOLocal, CiviliteDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CiviliteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Civilite> getManagedEntityClass() {
        return (Civilite.class);
    }

}
