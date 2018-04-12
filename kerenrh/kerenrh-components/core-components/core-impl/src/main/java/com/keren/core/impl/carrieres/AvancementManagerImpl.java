
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.AvancementManagerLocal;
import com.keren.core.ifaces.carrieres.AvancementManagerRemote;
import com.keren.dao.ifaces.carrieres.AvancementDAOLocal;
import com.keren.model.carrieres.Avancement;

@TransactionAttribute
@Stateless(mappedName = "AvancementManager")
public class AvancementManagerImpl
    extends AbstractGenericManager<Avancement, Long>
    implements AvancementManagerLocal, AvancementManagerRemote
{

    @EJB(name = "AvancementDAO")
    protected AvancementDAOLocal dao;

    public AvancementManagerImpl() {
    }

    @Override
    public GenericDAO<Avancement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
