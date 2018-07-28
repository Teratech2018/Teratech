
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.IntervenantDAOLocal;
import com.teratech.gmao.dao.ifaces.base.IntervenantDAORemote;
import com.teratech.gmao.model.base.Intervenant;

@Stateless(mappedName = "IntervenantDAO")
public class IntervenantDAOImpl
    extends AbstractGenericDAO<Intervenant, Long>
    implements IntervenantDAOLocal, IntervenantDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public IntervenantDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Intervenant> getManagedEntityClass() {
        return (Intervenant.class);
    }

}
