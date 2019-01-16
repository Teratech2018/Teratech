
package com.basaccount.dao.impl.ventes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.basaccount.dao.ifaces.ventes.FactureVenteDAOLocal;
import com.basaccount.dao.ifaces.ventes.FactureVenteDAORemote;
import com.basaccount.model.ventes.FactureVente;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FactureVenteDAO")
public class FactureVenteDAOImpl
    extends AbstractGenericDAO<FactureVente, Long>
    implements FactureVenteDAOLocal, FactureVenteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FactureVenteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FactureVente> getManagedEntityClass() {
        return (FactureVente.class);
    }

}
