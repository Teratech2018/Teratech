
package com.teratech.stock.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.operations.ControleQualiteDAOLocal;
import com.teratech.stock.dao.ifaces.operations.ControleQualiteDAORemote;
import com.teratech.stock.model.operations.ControleQualite;

@Stateless(mappedName = "ControleQualiteDAO")
public class ControleQualiteDAOImpl
    extends AbstractGenericDAO<ControleQualite, Long>
    implements ControleQualiteDAOLocal, ControleQualiteDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public ControleQualiteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ControleQualite> getManagedEntityClass() {
        return (ControleQualite.class);
    }

}
