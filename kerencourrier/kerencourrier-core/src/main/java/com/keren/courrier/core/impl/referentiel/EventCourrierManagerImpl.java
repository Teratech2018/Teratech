
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.EventCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.EventCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.EventCourrierDAOLocal;
import com.keren.courrier.model.referentiel.EventCourrier;

@TransactionAttribute
@Stateless(mappedName = "EventCourrierManager")
public class EventCourrierManagerImpl
    extends AbstractGenericManager<EventCourrier, Long>
    implements EventCourrierManagerLocal, EventCourrierManagerRemote
{

    @EJB(name = "EventCourrierDAO")
    protected EventCourrierDAOLocal dao;

    public EventCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<EventCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
