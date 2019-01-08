
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.ControleQualiteDAOLocal;
import com.teratech.achat.dao.ifaces.operations.ControleQualiteDAORemote;
import com.teratech.achat.model.operations.ControleQualite;

@Stateless(mappedName = "ControleQualiteDAO")
public class ControleQualiteDAOImpl
    extends AbstractGenericDAO<ControleQualite, Long>
    implements ControleQualiteDAOLocal, ControleQualiteDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
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
