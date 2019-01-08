
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.LigneReponseDPDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneReponseDPDAORemote;
import com.teratech.achat.model.operations.LigneReponseDP;

@Stateless(mappedName = "LigneReponseDPDAO")
public class LigneReponseDPDAOImpl
    extends AbstractGenericDAO<LigneReponseDP, Long>
    implements LigneReponseDPDAOLocal, LigneReponseDPDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public LigneReponseDPDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneReponseDP> getManagedEntityClass() {
        return (LigneReponseDP.class);
    }

}
