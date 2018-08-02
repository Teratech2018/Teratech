
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "TypeRemiseManager")
public class TypeRemiseManagerImpl
    extends AbstractGenericManager<TypeRemise, Long>
    implements TypeRemiseManagerLocal, TypeRemiseManagerRemote
{

    @EJB(name = "TypeRemiseDAO")
    protected TypeRemiseDAOLocal dao;

    public TypeRemiseManagerImpl() {
    }

    @Override
    public GenericDAO<TypeRemise, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
