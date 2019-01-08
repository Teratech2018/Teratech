
package com.teratech.achat.core.impl.tools;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.tools.SendDPFormManagerLocal;
import com.teratech.achat.core.ifaces.tools.SendDPFormManagerRemote;
import com.teratech.achat.dao.ifaces.tools.SendDPFormDAOLocal;
import com.teratech.achat.model.tools.SendDPForm;

@TransactionAttribute
@Stateless(mappedName = "SendDPFormManager")
public class SendDPFormManagerImpl
    extends AbstractGenericManager<SendDPForm, Long>
    implements SendDPFormManagerLocal, SendDPFormManagerRemote
{

    @EJB(name = "SendDPFormDAO")
    protected SendDPFormDAOLocal dao;

    public SendDPFormManagerImpl() {
    }

    @Override
    public GenericDAO<SendDPForm, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
