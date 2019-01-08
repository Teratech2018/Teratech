
package com.teratech.achat.dao.impl.tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.tools.SendDPFormDAOLocal;
import com.teratech.achat.dao.ifaces.tools.SendDPFormDAORemote;
import com.teratech.achat.model.tools.SendDPForm;

@Stateless(mappedName = "SendDPFormDAO")
public class SendDPFormDAOImpl
    extends AbstractGenericDAO<SendDPForm, Long>
    implements SendDPFormDAOLocal, SendDPFormDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public SendDPFormDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SendDPForm> getManagedEntityClass() {
        return (SendDPForm.class);
    }

}
