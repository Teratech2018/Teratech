
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewRetardPaiementDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewRetardPaiementDAORemote;
import com.kerenedu.model.report.ViewRetardPaiement;

@Stateless(mappedName = "ViewRetardPaiementDAO")
public class ViewRetardPaiementDAOImpl
    extends AbstractGenericDAO<ViewRetardPaiement, Long>
    implements ViewRetardPaiementDAOLocal, ViewRetardPaiementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewRetardPaiementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewRetardPaiement> getManagedEntityClass() {
        return (ViewRetardPaiement.class);
    }

}
