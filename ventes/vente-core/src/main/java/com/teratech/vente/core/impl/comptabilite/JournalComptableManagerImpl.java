
package com.teratech.vente.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.comptabilite.JournalComptableManagerLocal;
import com.teratech.vente.core.ifaces.comptabilite.JournalComptableManagerRemote;
import com.teratech.vente.dao.ifaces.comptabilite.JournalComptableDAOLocal;
import com.teratech.vente.model.comptabilite.JournalComptable;

@TransactionAttribute
@Stateless(mappedName = "JournalComptableManager")
public class JournalComptableManagerImpl
    extends AbstractGenericManager<JournalComptable, Long>
    implements JournalComptableManagerLocal, JournalComptableManagerRemote
{

    @EJB(name = "JournalComptableDAO")
    protected JournalComptableDAOLocal dao;

    public JournalComptableManagerImpl() {
    }

    @Override
    public GenericDAO<JournalComptable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
