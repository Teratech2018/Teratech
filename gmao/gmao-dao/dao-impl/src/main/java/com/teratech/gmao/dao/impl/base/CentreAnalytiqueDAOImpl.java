
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CentreAnalytiqueDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CentreAnalytiqueDAORemote;
import com.teratech.gmao.model.base.CentreAnalytique;

@Stateless(mappedName = "CentreAnalytiqueDAO")
public class CentreAnalytiqueDAOImpl
    extends AbstractGenericDAO<CentreAnalytique, Long>
    implements CentreAnalytiqueDAOLocal, CentreAnalytiqueDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CentreAnalytiqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CentreAnalytique> getManagedEntityClass() {
        return (CentreAnalytique.class);
    }

}
