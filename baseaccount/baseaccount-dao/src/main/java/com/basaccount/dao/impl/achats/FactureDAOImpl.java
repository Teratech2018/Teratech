
package com.basaccount.dao.impl.achats;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.basaccount.dao.ifaces.achats.FactureDAOLocal;
import com.basaccount.dao.ifaces.achats.FactureDAORemote;
import com.basaccount.model.achats.Facture;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FactureDAO")
public class FactureDAOImpl
    extends AbstractGenericDAO<Facture, Long>
    implements FactureDAOLocal, FactureDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FactureDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Facture> getManagedEntityClass() {
        return (Facture.class);
    }

}
