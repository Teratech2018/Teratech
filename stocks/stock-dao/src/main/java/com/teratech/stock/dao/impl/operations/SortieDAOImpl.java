
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.SortieDAOLocal;
import com.teratech.stock.dao.ifaces.operations.SortieDAORemote;
import com.teratech.stock.model.operations.Sortie;

@Stateless(mappedName = "SortieDAO")
public class SortieDAOImpl
    extends AbstractGenericDAO<Sortie, Long>
    implements SortieDAOLocal, SortieDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public SortieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Sortie> getManagedEntityClass() {
        return (Sortie.class);
    }

}
