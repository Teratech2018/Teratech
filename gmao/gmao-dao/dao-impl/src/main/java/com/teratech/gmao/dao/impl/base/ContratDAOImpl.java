
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.ContratDAOLocal;
import com.teratech.gmao.dao.ifaces.base.ContratDAORemote;
import com.teratech.gmao.model.base.Contrat;

@Stateless(mappedName = "ContratDAO")
public class ContratDAOImpl
    extends AbstractGenericDAO<Contrat, Long>
    implements ContratDAOLocal, ContratDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ContratDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Contrat> getManagedEntityClass() {
        return (Contrat.class);
    }

}
