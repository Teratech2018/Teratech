
package com.kerenedu.dao.impl.report;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.dao.ifaces.report.ViewPaiementJournalierDAOLocal;
import com.kerenedu.dao.ifaces.report.ViewPaiementJournalierDAORemote;
import com.kerenedu.model.report.ViewPaiementJournalier;

@Stateless(mappedName = "ViewPaiementJournalierDAO")
public class ViewPaiementJournalierDAOImpl
    extends AbstractGenericDAO<ViewPaiementJournalier, Long>
    implements ViewPaiementJournalierDAOLocal, ViewPaiementJournalierDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ViewPaiementJournalierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ViewPaiementJournalier> getManagedEntityClass() {
        return (ViewPaiementJournalier.class);
    }

}
