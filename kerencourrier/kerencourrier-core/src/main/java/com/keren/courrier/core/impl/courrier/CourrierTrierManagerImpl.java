
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierTrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierTrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierTrierDAOLocal;
import com.keren.courrier.model.courrier.CourrierTrier;

@TransactionAttribute
@Stateless(mappedName = "CourrierTrierManager")
public class CourrierTrierManagerImpl
    extends AbstractGenericManager<CourrierTrier, Long>
    implements CourrierTrierManagerLocal, CourrierTrierManagerRemote
{

    @EJB(name = "CourrierTrierDAO")
    protected CourrierTrierDAOLocal dao;

    public CourrierTrierManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierTrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
