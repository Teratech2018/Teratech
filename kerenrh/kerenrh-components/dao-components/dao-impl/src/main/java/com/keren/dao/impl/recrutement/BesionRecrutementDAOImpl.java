
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.BesionRecrutementDAOLocal;
import com.keren.dao.ifaces.recrutement.BesionRecrutementDAORemote;
import com.keren.model.recrutement.BesionRecrutement;

@Stateless(mappedName = "BesionRecrutementDAO")
public class BesionRecrutementDAOImpl
    extends AbstractGenericDAO<BesionRecrutement, Long>
    implements BesionRecrutementDAOLocal, BesionRecrutementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BesionRecrutementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BesionRecrutement> getManagedEntityClass() {
        return (BesionRecrutement.class);
    }

}
