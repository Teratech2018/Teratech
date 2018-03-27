
package com.keren.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.comptabilite.BanqueDAOLocal;
import com.keren.dao.ifaces.comptabilite.BanqueDAORemote;
import com.keren.model.comptabilite.Banque;

@Stateless(mappedName = "BanqueDAO")
public class BanqueDAOImpl
    extends AbstractGenericDAO<Banque, Long>
    implements BanqueDAOLocal, BanqueDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BanqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Banque> getManagedEntityClass() {
        return (Banque.class);
    }

}
