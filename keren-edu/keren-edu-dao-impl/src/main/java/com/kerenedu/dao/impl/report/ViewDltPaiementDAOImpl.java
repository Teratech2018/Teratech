
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewDltPaiementDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewDltPaiementDAORemote;
import com.kerenedu.model.report.ViewDltPaiement;

@Stateless(mappedName = "ViewDltPaiementDAO")
public class ViewDltPaiementDAOImpl
    extends AbstractGenericDAO<ViewDltPaiement, Long>
    implements ViewDltPaiementDAOLocal, ViewDltPaiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewDltPaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewDltPaiement> getManagedEntityClass() {
        return (ViewDltPaiement.class);
    }

}
