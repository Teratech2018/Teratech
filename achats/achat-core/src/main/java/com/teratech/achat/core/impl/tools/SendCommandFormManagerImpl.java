
package com.teratech.achat.core.impl.tools;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.tools.SendCommandFormManagerLocal;
import com.teratech.achat.core.ifaces.tools.SendCommandFormManagerRemote;
import com.teratech.achat.dao.ifaces.tools.SendCommandFormDAOLocal;
import com.teratech.achat.model.tools.SendCommandForm;

@TransactionAttribute
@Stateless(mappedName = "SendCommandFormManager")
public class SendCommandFormManagerImpl
    extends AbstractGenericManager<SendCommandForm, Long>
    implements SendCommandFormManagerLocal, SendCommandFormManagerRemote
{

    @EJB(name = "SendCommandFormDAO")
    protected SendCommandFormDAOLocal dao;

    public SendCommandFormManagerImpl() {
    }

    @Override
    public GenericDAO<SendCommandForm, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
