
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.CourrierADeclasserDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierADeclasserDAORemote;
import com.keren.courrier.model.courrier.CourrierADeclasser;

@Stateless(mappedName = "CourrierADeclasserDAO")
public class CourrierADeclasserDAOImpl
    extends AbstractGenericDAO<CourrierADeclasser, Long>
    implements CourrierADeclasserDAOLocal, CourrierADeclasserDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CourrierADeclasserDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CourrierADeclasser> getManagedEntityClass() {
        return (CourrierADeclasser.class);
    }

}
