
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.VilleManagerLocal;
import com.keren.core.ifaces.structures.VilleManagerRemote;
import com.keren.dao.ifaces.structures.VilleDAOLocal;
import com.keren.model.structures.Ville;

@TransactionAttribute
@Stateless(mappedName = "VilleManager")
public class VilleManagerImpl
    extends AbstractGenericManager<Ville, Long>
    implements VilleManagerLocal, VilleManagerRemote
{

    @EJB(name = "VilleDAO")
    protected VilleDAOLocal dao;

    public VilleManagerImpl() {
    }

    @Override
    public GenericDAO<Ville, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
