
package com.teratech.achat.dao.impl.tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.tools.DARejetDAOLocal;
import com.teratech.achat.dao.ifaces.tools.DARejetDAORemote;
import com.teratech.achat.model.tools.DARejet;

@Stateless(mappedName = "DARejetDAO")
public class DARejetDAOImpl
    extends AbstractGenericDAO<DARejet, Long>
    implements DARejetDAOLocal, DARejetDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public DARejetDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DARejet> getManagedEntityClass() {
        return (DARejet.class);
    }

}
