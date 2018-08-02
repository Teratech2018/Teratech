
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.AffectationBonTravailDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.AffectationBonTravailDAORemote;
import com.teratech.gmao.model.curative.AffectationBonTravail;

@Stateless(mappedName = "AffectationBonTravailDAO")
public class AffectationBonTravailDAOImpl
    extends AbstractGenericDAO<AffectationBonTravail, Long>
    implements AffectationBonTravailDAOLocal, AffectationBonTravailDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public AffectationBonTravailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AffectationBonTravail> getManagedEntityClass() {
        return (AffectationBonTravail.class);
    }

}
