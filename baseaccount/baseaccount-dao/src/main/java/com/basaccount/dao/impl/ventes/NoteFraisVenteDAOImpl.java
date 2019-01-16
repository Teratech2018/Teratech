
package com.basaccount.dao.impl.ventes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.basaccount.dao.ifaces.ventes.NoteFraisVenteDAOLocal;
import com.basaccount.dao.ifaces.ventes.NoteFraisVenteDAORemote;
import com.basaccount.model.ventes.NoteFraisVente;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteFraisVenteDAO")
public class NoteFraisVenteDAOImpl
    extends AbstractGenericDAO<NoteFraisVente, Long>
    implements NoteFraisVenteDAOLocal, NoteFraisVenteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteFraisVenteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteFraisVente> getManagedEntityClass() {
        return (NoteFraisVente.class);
    }

}
