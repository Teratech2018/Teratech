
package com.teratech.vente.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.others.SendDevisFormManagerLocal;
import com.teratech.vente.core.ifaces.others.SendDevisFormManagerRemote;
import com.teratech.vente.dao.ifaces.others.SendDevisFormDAOLocal;
import com.teratech.vente.model.others.SendDevisForm;

@TransactionAttribute
@Stateless(mappedName = "SendDevisFormManager")
public class SendDevisFormManagerImpl
    extends AbstractGenericManager<SendDevisForm, Long>
    implements SendDevisFormManagerLocal, SendDevisFormManagerRemote
{

    @EJB(name = "SendDevisFormDAO")
    protected SendDevisFormDAOLocal dao;

    public SendDevisFormManagerImpl() {
    }

    @Override
    public GenericDAO<SendDevisForm, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
