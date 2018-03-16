
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

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
