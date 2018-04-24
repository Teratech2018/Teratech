
package com.keren.dao.impl.recrutement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.recrutement.DetailRecrutementDAOLocal;
import com.keren.dao.ifaces.recrutement.DetailRecrutementDAORemote;
import com.keren.model.recrutement.DetailRecrutement;

@Stateless(mappedName = "DetailRecrutementDAO")
public class DetailRecrutementDAOImpl
    extends AbstractGenericDAO<DetailRecrutement, Long>
    implements DetailRecrutementDAOLocal, DetailRecrutementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DetailRecrutementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DetailRecrutement> getManagedEntityClass() {
        return (DetailRecrutement.class);
    }

}
