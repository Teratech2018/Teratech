
package com.teratech.vente.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.others.SendDevisFormDAOLocal;
import com.teratech.vente.dao.ifaces.others.SendDevisFormDAORemote;
import com.teratech.vente.model.others.SendDevisForm;

@Stateless(mappedName = "SendDevisFormDAO")
public class SendDevisFormDAOImpl
    extends AbstractGenericDAO<SendDevisForm, Long>
    implements SendDevisFormDAOLocal, SendDevisFormDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public SendDevisFormDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SendDevisForm> getManagedEntityClass() {
        return (SendDevisForm.class);
    }

}
