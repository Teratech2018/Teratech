
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EchellonDAO")
public class EchellonDAOImpl
    extends AbstractGenericDAO<Echellon, Long>
    implements EchellonDAOLocal, EchellonDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EchellonDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Echellon> getManagedEntityClass() {
        return (Echellon.class);
    }

}
