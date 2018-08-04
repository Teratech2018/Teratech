
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "EventEduManager")
public class EventEduManagerImpl
    extends AbstractGenericManager<EventEdu, Long>
    implements EventEduManagerLocal, EventEduManagerRemote
{

    @EJB(name = "EventEduDAO")
    protected EventEduDAOLocal dao;

    public EventEduManagerImpl() {
    }

    @Override
    public GenericDAO<EventEdu, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
