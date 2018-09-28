
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.StructureManagerLocal;
import com.keren.posweb.core.ifaces.StructureManagerRemote;
import com.keren.posweb.dao.ifaces.StructureDAOLocal;
import com.keren.posweb.model.Structure;

@TransactionAttribute
@Stateless(mappedName = "StructureManager")
public class StructureManagerImpl
    extends AbstractGenericManager<Structure, Long>
    implements StructureManagerLocal, StructureManagerRemote
{

    @EJB(name = "StructureDAO")
    protected StructureDAOLocal dao;

    public StructureManagerImpl() {
    }

    @Override
    public GenericDAO<Structure, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
