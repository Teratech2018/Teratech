
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.FichierLieTriDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.FichierLieTriDAORemote;
import com.keren.courrier.model.courrier.FichierLieTri;

@Stateless(mappedName = "FichierLieTriDAO")
public class FichierLieTriDAOImpl
    extends AbstractGenericDAO<FichierLieTri, Long>
    implements FichierLieTriDAOLocal, FichierLieTriDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public FichierLieTriDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FichierLieTri> getManagedEntityClass() {
        return (FichierLieTri.class);
    }

}
