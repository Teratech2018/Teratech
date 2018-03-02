
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.ExprBesionDAOLocal;
import com.teratech.achat.dao.ifaces.operations.ExprBesionDAORemote;
import com.teratech.achat.model.operations.ExprBesion;

@Stateless(mappedName = "ExprBesionDAO")
public class ExprBesionDAOImpl
    extends AbstractGenericDAO<ExprBesion, Long>
    implements ExprBesionDAOLocal, ExprBesionDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public ExprBesionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ExprBesion> getManagedEntityClass() {
        return (ExprBesion.class);
    }

}
