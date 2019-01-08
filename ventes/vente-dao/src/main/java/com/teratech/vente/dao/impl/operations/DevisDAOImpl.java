
package com.teratech.vente.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.operations.DevisDAOLocal;
import com.teratech.vente.dao.ifaces.operations.DevisDAORemote;
import com.teratech.vente.model.operations.Devis;

@Stateless(mappedName = "DevisDAO")
public class DevisDAOImpl
    extends AbstractGenericDAO<Devis, Long>
    implements DevisDAOLocal, DevisDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public DevisDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Devis> getManagedEntityClass() {
        return (Devis.class);
    }

}
