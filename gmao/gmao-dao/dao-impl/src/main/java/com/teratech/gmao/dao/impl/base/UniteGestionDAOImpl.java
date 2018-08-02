
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.UniteGestionDAOLocal;
import com.teratech.gmao.dao.ifaces.base.UniteGestionDAORemote;
import com.teratech.gmao.model.base.UniteGestion;

@Stateless(mappedName = "UniteGestionDAO")
public class UniteGestionDAOImpl
    extends AbstractGenericDAO<UniteGestion, Long>
    implements UniteGestionDAOLocal, UniteGestionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public UniteGestionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UniteGestion> getManagedEntityClass() {
        return (UniteGestion.class);
    }

}
