
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.EtapeRecrutementDAOLocal;
import com.keren.dao.ifaces.recrutement.EtapeRecrutementDAORemote;
import com.keren.model.recrutement.EtapeRecrutement;

@Stateless(mappedName = "EtapeRecrutementDAO")
public class EtapeRecrutementDAOImpl
    extends AbstractGenericDAO<EtapeRecrutement, Long>
    implements EtapeRecrutementDAOLocal, EtapeRecrutementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EtapeRecrutementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EtapeRecrutement> getManagedEntityClass() {
        return (EtapeRecrutement.class);
    }

}
