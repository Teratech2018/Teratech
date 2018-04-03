
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.IndiceSoldeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.IndiceSoldeDAORemote;
import com.keren.kerenpaie.model.paie.IndiceSolde;

@Stateless(mappedName = "IndiceSoldeDAO")
public class IndiceSoldeDAOImpl
    extends AbstractGenericDAO<IndiceSolde, Long>
    implements IndiceSoldeDAOLocal, IndiceSoldeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public IndiceSoldeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<IndiceSolde> getManagedEntityClass() {
        return (IndiceSolde.class);
    }

}
