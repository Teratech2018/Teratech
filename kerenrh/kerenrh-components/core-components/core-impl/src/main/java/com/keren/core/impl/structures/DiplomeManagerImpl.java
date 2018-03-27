
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.DiplomeManagerLocal;
import com.keren.core.ifaces.structures.DiplomeManagerRemote;
import com.keren.dao.ifaces.structures.DiplomeDAOLocal;
import com.keren.model.structures.Diplome;

@TransactionAttribute
@Stateless(mappedName = "DiplomeManager")
public class DiplomeManagerImpl
    extends AbstractGenericManager<Diplome, Long>
    implements DiplomeManagerLocal, DiplomeManagerRemote
{

    @EJB(name = "DiplomeDAO")
    protected DiplomeDAOLocal dao;

    public DiplomeManagerImpl() {
    }

    @Override
    public GenericDAO<Diplome, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
