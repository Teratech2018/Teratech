
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.EscaleManagerLocal;
import com.keren.core.ifaces.missions.EscaleManagerRemote;
import com.keren.dao.ifaces.missions.EscaleDAOLocal;
import com.keren.model.missions.Escale;

@TransactionAttribute
@Stateless(mappedName = "EscaleManager")
public class EscaleManagerImpl
    extends AbstractGenericManager<Escale, Long>
    implements EscaleManagerLocal, EscaleManagerRemote
{

    @EJB(name = "EscaleDAO")
    protected EscaleDAOLocal dao;

    public EscaleManagerImpl() {
    }

    @Override
    public GenericDAO<Escale, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
