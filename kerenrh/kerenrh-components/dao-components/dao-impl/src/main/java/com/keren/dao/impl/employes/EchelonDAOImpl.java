
package com.keren.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.employes.EchelonDAOLocal;
import com.keren.dao.ifaces.employes.EchelonDAORemote;
import com.keren.model.employes.Echelon;

@Stateless(mappedName = "EchelonDAO")
public class EchelonDAOImpl
    extends AbstractGenericDAO<Echelon, Long>
    implements EchelonDAOLocal, EchelonDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EchelonDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Echelon> getManagedEntityClass() {
        return (Echelon.class);
    }

}
