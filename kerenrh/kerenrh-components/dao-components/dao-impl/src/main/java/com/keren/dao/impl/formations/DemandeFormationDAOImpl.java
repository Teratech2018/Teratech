
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.DemandeFormationDAOLocal;
import com.keren.dao.ifaces.formations.DemandeFormationDAORemote;
import com.keren.model.formations.DemandeFormation;

@Stateless(mappedName = "DemandeFormationDAO")
public class DemandeFormationDAOImpl
    extends AbstractGenericDAO<DemandeFormation, Long>
    implements DemandeFormationDAOLocal, DemandeFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandeFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeFormation> getManagedEntityClass() {
        return (DemandeFormation.class);
    }

}
