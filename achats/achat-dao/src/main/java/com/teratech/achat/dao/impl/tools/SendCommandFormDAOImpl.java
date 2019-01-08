
package com.teratech.achat.dao.impl.tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.tools.SendCommandFormDAOLocal;
import com.teratech.achat.dao.ifaces.tools.SendCommandFormDAORemote;
import com.teratech.achat.model.tools.SendCommandForm;

@Stateless(mappedName = "SendCommandFormDAO")
public class SendCommandFormDAOImpl
    extends AbstractGenericDAO<SendCommandForm, Long>
    implements SendCommandFormDAOLocal, SendCommandFormDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public SendCommandFormDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SendCommandForm> getManagedEntityClass() {
        return (SendCommandForm.class);
    }

}
