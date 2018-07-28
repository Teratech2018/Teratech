
package com.teratech.gmao.dao.impl.preventif;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.preventif.GammeDAOLocal;
import com.teratech.gmao.dao.ifaces.preventif.GammeDAORemote;
import com.teratech.gmao.model.preventif.Gamme;

@Stateless(mappedName = "GammeDAO")
public class GammeDAOImpl
    extends AbstractGenericDAO<Gamme, Long>
    implements GammeDAOLocal, GammeDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public GammeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Gamme> getManagedEntityClass() {
        return (Gamme.class);
    }

}
