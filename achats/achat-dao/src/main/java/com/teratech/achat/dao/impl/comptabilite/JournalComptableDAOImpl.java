
package com.teratech.achat.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.comptabilite.JournalComptableDAOLocal;
import com.teratech.achat.dao.ifaces.comptabilite.JournalComptableDAORemote;
import com.teratech.achat.model.comptabilite.JournalComptable;

@Stateless(mappedName = "JournalComptableDAO")
public class JournalComptableDAOImpl
    extends AbstractGenericDAO<JournalComptable, Long>
    implements JournalComptableDAOLocal, JournalComptableDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public JournalComptableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<JournalComptable> getManagedEntityClass() {
        return (JournalComptable.class);
    }

}
