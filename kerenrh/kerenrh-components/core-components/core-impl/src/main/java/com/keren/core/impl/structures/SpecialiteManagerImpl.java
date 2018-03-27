
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.SpecialiteManagerLocal;
import com.keren.core.ifaces.structures.SpecialiteManagerRemote;
import com.keren.dao.ifaces.structures.SpecialiteDAOLocal;
import com.keren.model.structures.Specialite;

@TransactionAttribute
@Stateless(mappedName = "SpecialiteManager")
public class SpecialiteManagerImpl
    extends AbstractGenericManager<Specialite, Long>
    implements SpecialiteManagerLocal, SpecialiteManagerRemote
{

    @EJB(name = "SpecialiteDAO")
    protected SpecialiteDAOLocal dao;

    public SpecialiteManagerImpl() {
    }

    @Override
    public GenericDAO<Specialite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
