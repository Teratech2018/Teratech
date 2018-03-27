
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.PayerSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.PayerSalaireDAORemote;
import com.keren.kerenpaie.model.paie.PayerSalaire;

@Stateless(mappedName = "PayerSalaireDAO")
public class PayerSalaireDAOImpl
    extends AbstractGenericDAO<PayerSalaire, Long>
    implements PayerSalaireDAOLocal, PayerSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public PayerSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PayerSalaire> getManagedEntityClass() {
        return (PayerSalaire.class);
    }

}
