
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.PaysManagerLocal;
import com.keren.core.ifaces.structures.PaysManagerRemote;
import com.keren.dao.ifaces.structures.PaysDAOLocal;
import com.keren.model.structures.Pays;

@TransactionAttribute
@Stateless(mappedName = "PaysManager")
public class PaysManagerImpl
    extends AbstractGenericManager<Pays, Long>
    implements PaysManagerLocal, PaysManagerRemote
{

    @EJB(name = "PaysDAO")
    protected PaysDAOLocal dao;

    public PaysManagerImpl() {
    }

    @Override
    public GenericDAO<Pays, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
