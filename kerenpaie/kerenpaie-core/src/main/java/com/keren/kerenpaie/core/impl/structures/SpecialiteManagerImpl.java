
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.SpecialiteManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.SpecialiteManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.SpecialiteDAOLocal;
import com.keren.kerenpaie.model.structures.Specialite;

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
