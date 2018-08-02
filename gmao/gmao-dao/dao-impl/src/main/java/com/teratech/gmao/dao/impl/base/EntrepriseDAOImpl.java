
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.EntrepriseDAOLocal;
import com.teratech.gmao.dao.ifaces.base.EntrepriseDAORemote;
import com.teratech.gmao.model.base.Entreprise;

@Stateless(mappedName = "EntrepriseDAO")
public class EntrepriseDAOImpl
    extends AbstractGenericDAO<Entreprise, Long>
    implements EntrepriseDAOLocal, EntrepriseDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public EntrepriseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Entreprise> getManagedEntityClass() {
        return (Entreprise.class);
    }

}
