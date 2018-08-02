
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.RubriqueDAOLocal;
import com.teratech.gmao.dao.ifaces.base.RubriqueDAORemote;
import com.teratech.gmao.model.base.Rubrique;

@Stateless(mappedName = "RubriqueDAO")
public class RubriqueDAOImpl
    extends AbstractGenericDAO<Rubrique, Long>
    implements RubriqueDAOLocal, RubriqueDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public RubriqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Rubrique> getManagedEntityClass() {
        return (Rubrique.class);
    }

}
