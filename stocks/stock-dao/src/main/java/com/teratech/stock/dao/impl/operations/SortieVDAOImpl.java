
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.SortieVDAOLocal;
import com.teratech.stock.dao.ifaces.operations.SortieVDAORemote;
import com.teratech.stock.model.operations.SortieV;

@Stateless(mappedName = "SortieVDAO")
public class SortieVDAOImpl
    extends AbstractGenericDAO<SortieV, Long>
    implements SortieVDAOLocal, SortieVDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public SortieVDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SortieV> getManagedEntityClass() {
        return (SortieV.class);
    }

}
