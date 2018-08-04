
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.RappelCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.RappelCourrierDAORemote;
import com.keren.courrier.model.referentiel.RappelCourrier;

@Stateless(mappedName = "RappelCourrierDAO")
public class RappelCourrierDAOImpl
    extends AbstractGenericDAO<RappelCourrier, Long>
    implements RappelCourrierDAOLocal, RappelCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public RappelCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RappelCourrier> getManagedEntityClass() {
        return (RappelCourrier.class);
    }

}
