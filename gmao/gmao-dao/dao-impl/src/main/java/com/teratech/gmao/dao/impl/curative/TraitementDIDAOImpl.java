
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.TraitementDIDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.TraitementDIDAORemote;
import com.teratech.gmao.model.curative.TraitementDI;

@Stateless(mappedName = "TraitementDIDAO")
public class TraitementDIDAOImpl
    extends AbstractGenericDAO<TraitementDI, Long>
    implements TraitementDIDAOLocal, TraitementDIDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public TraitementDIDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitementDI> getManagedEntityClass() {
        return (TraitementDI.class);
    }

}
