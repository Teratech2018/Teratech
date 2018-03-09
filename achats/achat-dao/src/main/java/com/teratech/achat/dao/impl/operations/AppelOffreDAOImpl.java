
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.AppelOffreDAOLocal;
import com.teratech.achat.dao.ifaces.operations.AppelOffreDAORemote;
import com.teratech.achat.model.operations.AppelOffre;

@Stateless(mappedName = "AppelOffreDAO")
public class AppelOffreDAOImpl
    extends AbstractGenericDAO<AppelOffre, Long>
    implements AppelOffreDAOLocal, AppelOffreDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public AppelOffreDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AppelOffre> getManagedEntityClass() {
        return (AppelOffre.class);
    }

}
