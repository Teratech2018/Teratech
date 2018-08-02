
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CalendrierIntervenantDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CalendrierIntervenantDAORemote;
import com.teratech.gmao.model.base.CalendrierIntervenant;

@Stateless(mappedName = "CalendrierIntervenantDAO")
public class CalendrierIntervenantDAOImpl
    extends AbstractGenericDAO<CalendrierIntervenant, Long>
    implements CalendrierIntervenantDAOLocal, CalendrierIntervenantDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CalendrierIntervenantDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CalendrierIntervenant> getManagedEntityClass() {
        return (CalendrierIntervenant.class);
    }

}
