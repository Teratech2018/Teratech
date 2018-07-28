
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.DivisionDAOLocal;
import com.teratech.gmao.dao.ifaces.base.DivisionDAORemote;
import com.teratech.gmao.model.base.Division;

@Stateless(mappedName = "DivisionDAO")
public class DivisionDAOImpl
    extends AbstractGenericDAO<Division, Long>
    implements DivisionDAOLocal, DivisionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public DivisionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Division> getManagedEntityClass() {
        return (Division.class);
    }

}
