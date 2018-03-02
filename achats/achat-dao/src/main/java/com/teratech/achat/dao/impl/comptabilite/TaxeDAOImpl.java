
package com.teratech.achat.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.comptabilite.TaxeDAOLocal;
import com.teratech.achat.dao.ifaces.comptabilite.TaxeDAORemote;
import com.teratech.achat.model.comptabilite.Taxe;

@Stateless(mappedName = "TaxeDAO")
public class TaxeDAOImpl
    extends AbstractGenericDAO<Taxe, Long>
    implements TaxeDAOLocal, TaxeDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public TaxeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Taxe> getManagedEntityClass() {
        return (Taxe.class);
    }

}
