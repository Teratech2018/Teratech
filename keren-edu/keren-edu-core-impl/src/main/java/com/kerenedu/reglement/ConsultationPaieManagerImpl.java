
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ConsultationPaieManager")
public class ConsultationPaieManagerImpl
    extends AbstractGenericManager<ConsultationPaie, Long>
    implements ConsultationPaieManagerLocal, ConsultationPaieManagerRemote
{

    @EJB(name = "ConsultationPaieDAO")
    protected ConsultationPaieDAOLocal dao;

    public ConsultationPaieManagerImpl() {
    }

    @Override
    public GenericDAO<ConsultationPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
