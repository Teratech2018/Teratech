
package com.keren.kerenpaie.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.employes.EchelonDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.EchelonDAORemote;
import com.keren.kerenpaie.model.employes.Echelon;

@Stateless(mappedName = "EchelonDAO")
public class EchelonDAOImpl
    extends AbstractGenericDAO<Echelon, Long>
    implements EchelonDAOLocal, EchelonDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
