
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.DemandeInterventionDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.DemandeInterventionDAORemote;
import com.teratech.gmao.model.curative.DemandeIntervention;

@Stateless(mappedName = "DemandeInterventionDAO")
public class DemandeInterventionDAOImpl
    extends AbstractGenericDAO<DemandeIntervention, Long>
    implements DemandeInterventionDAOLocal, DemandeInterventionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public DemandeInterventionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeIntervention> getManagedEntityClass() {
        return (DemandeIntervention.class);
    }

}
