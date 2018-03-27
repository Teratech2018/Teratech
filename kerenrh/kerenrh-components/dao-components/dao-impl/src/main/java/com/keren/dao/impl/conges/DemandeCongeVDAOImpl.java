
package com.keren.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.conges.DemandeCongeVDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeVDAORemote;
import com.keren.model.conges.DemandeCongeV;

@Stateless(mappedName = "DemandeCongeVDAO")
public class DemandeCongeVDAOImpl
    extends AbstractGenericDAO<DemandeCongeV, Long>
    implements DemandeCongeVDAOLocal, DemandeCongeVDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DemandeCongeVDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeCongeV> getManagedEntityClass() {
        return (DemandeCongeV.class);
    }

}
