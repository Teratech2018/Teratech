
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ConsultationEchManager")
public class ConsultationEchManagerImpl
    extends AbstractGenericManager<ConsultationEch, Long>
    implements ConsultationEchManagerLocal, ConsultationEchManagerRemote
{

    @EJB(name = "ConsultationEchDAO")
    protected ConsultationEchDAOLocal dao;

    public ConsultationEchManagerImpl() {
    }

    @Override
    public GenericDAO<ConsultationEch, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
