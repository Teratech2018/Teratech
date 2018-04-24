
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.SyndicatManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.SyndicatManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.SyndicatDAOLocal;
import com.keren.kerenpaie.model.structures.Syndicat;

@TransactionAttribute
@Stateless(mappedName = "SyndicatManager")
public class SyndicatManagerImpl
    extends AbstractGenericManager<Syndicat, Long>
    implements SyndicatManagerLocal, SyndicatManagerRemote
{

    @EJB(name = "SyndicatDAO")
    protected SyndicatDAOLocal dao;

    public SyndicatManagerImpl() {
    }

    @Override
    public GenericDAO<Syndicat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
