
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.DemandeCongeRDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeRDAORemote;
import com.keren.model.conges.DemandeCongeR;

@Stateless(mappedName = "DemandeCongeRDAO")
public class DemandeCongeRDAOImpl
    extends AbstractGenericDAO<DemandeCongeR, Long>
    implements DemandeCongeRDAOLocal, DemandeCongeRDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandeCongeRDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeCongeR> getManagedEntityClass() {
        return (DemandeCongeR.class);
    }

}
