
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.OrganeDAOLocal;
import com.teratech.gmao.dao.ifaces.base.OrganeDAORemote;
import com.teratech.gmao.model.base.Organe;

@Stateless(mappedName = "OrganeDAO")
public class OrganeDAOImpl
    extends AbstractGenericDAO<Organe, Long>
    implements OrganeDAOLocal, OrganeDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public OrganeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Organe> getManagedEntityClass() {
        return (Organe.class);
    }

}
