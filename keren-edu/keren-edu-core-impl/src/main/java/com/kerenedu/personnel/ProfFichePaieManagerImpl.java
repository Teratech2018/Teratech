
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ProfFichePaieManager")
public class ProfFichePaieManagerImpl
    extends AbstractGenericManager<ProfFichePaie, Long>
    implements ProfFichePaieManagerLocal, ProfFichePaieManagerRemote
{

    @EJB(name = "ProfFichePaieDAO")
    protected ProfFichePaieDAOLocal dao;

    public ProfFichePaieManagerImpl() {
    }

    @Override
    public GenericDAO<ProfFichePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
