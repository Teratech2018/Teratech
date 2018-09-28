
package com.keren.posweb.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.posweb.dao.ifaces.TaxeDAOLocal;
import com.keren.posweb.dao.ifaces.TaxeDAORemote;
import com.keren.posweb.model.Taxe;

@Stateless(mappedName = "TaxeDAO")
public class TaxeDAOImpl
    extends AbstractGenericDAO<Taxe, Long>
    implements TaxeDAOLocal, TaxeDAORemote
{

    @PersistenceContext(unitName = "posweb")
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
