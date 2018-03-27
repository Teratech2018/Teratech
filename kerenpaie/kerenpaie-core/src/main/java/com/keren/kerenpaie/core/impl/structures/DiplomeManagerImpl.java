
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.DiplomeManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.DiplomeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.DiplomeDAOLocal;
import com.keren.kerenpaie.model.structures.Diplome;

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
