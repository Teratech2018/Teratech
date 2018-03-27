
package com.keren.core.impl.conges;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.conges.TypeCongeManagerLocal;
import com.keren.core.ifaces.conges.TypeCongeManagerRemote;
import com.keren.dao.ifaces.conges.TypeCongeDAOLocal;
import com.keren.model.conges.TypeConge;

@TransactionAttribute
@Stateless(mappedName = "TypeCongeManager")
public class TypeCongeManagerImpl
    extends AbstractGenericManager<TypeConge, Long>
    implements TypeCongeManagerLocal, TypeCongeManagerRemote
{

    @EJB(name = "TypeCongeDAO")
    protected TypeCongeDAOLocal dao;

    public TypeCongeManagerImpl() {
    }

    @Override
    public GenericDAO<TypeConge, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
