
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "StatistiqueNotesManager")
public class StatistiqueNotesManagerImpl
    extends AbstractGenericManager<StatistiqueNotes, Long>
    implements StatistiqueNotesManagerLocal, StatistiqueNotesManagerRemote
{

    @EJB(name = "StatistiqueNotesDAO")
    protected StatistiqueNotesDAOLocal dao;

    public StatistiqueNotesManagerImpl() {
    }

    @Override
    public GenericDAO<StatistiqueNotes, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
