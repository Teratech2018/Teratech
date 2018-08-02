
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewAnniversaireDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewAnniversaireDAORemote;
import com.kerenedu.model.report.ViewAnniversaire;

@Stateless(mappedName = "ViewAnniversaireDAO")
public class ViewAnniversaireDAOImpl
    extends AbstractGenericDAO<ViewAnniversaire, Long>
    implements ViewAnniversaireDAOLocal, ViewAnniversaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewAnniversaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewAnniversaire> getManagedEntityClass() {
        return (ViewAnniversaire.class);
    }

}
