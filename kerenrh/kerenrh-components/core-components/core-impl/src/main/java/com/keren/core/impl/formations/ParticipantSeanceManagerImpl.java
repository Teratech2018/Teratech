
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.ParticipantSeanceManagerLocal;
import com.keren.core.ifaces.formations.ParticipantSeanceManagerRemote;
import com.keren.dao.ifaces.formations.ParticipantSeanceDAOLocal;
import com.keren.model.formations.ParticipantSeance;

@TransactionAttribute
@Stateless(mappedName = "ParticipantSeanceManager")
public class ParticipantSeanceManagerImpl
    extends AbstractGenericManager<ParticipantSeance, Long>
    implements ParticipantSeanceManagerLocal, ParticipantSeanceManagerRemote
{

    @EJB(name = "ParticipantSeanceDAO")
    protected ParticipantSeanceDAOLocal dao;

    public ParticipantSeanceManagerImpl() {
    }

    @Override
    public GenericDAO<ParticipantSeance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
