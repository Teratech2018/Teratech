
package com.teratech.gmao.core.impl.preventif;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.preventif.TypePlanningManagerLocal;
import com.teratech.gmao.core.ifaces.preventif.TypePlanningManagerRemote;
import com.teratech.gmao.dao.ifaces.preventif.TypePlanningDAOLocal;
import com.teratech.gmao.model.preventif.TypePlanning;

@TransactionAttribute
@Stateless(mappedName = "TypePlanningManager")
public class TypePlanningManagerImpl
    extends AbstractGenericManager<TypePlanning, Long>
    implements TypePlanningManagerLocal, TypePlanningManagerRemote
{

    @EJB(name = "TypePlanningDAO")
    protected TypePlanningDAOLocal dao;

    public TypePlanningManagerImpl() {
    }

    @Override
    public GenericDAO<TypePlanning, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
