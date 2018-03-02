
package com.teratech.stock.dao.impl.invetaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.invetaire.LArticleEmplacementLotDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.LArticleEmplacementLotDAORemote;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;

@Stateless(mappedName = "LArticleEmplacementLotDAO")
public class LArticleEmplacementLotDAOImpl
    extends AbstractGenericDAO<LArticleEmplacementLot, Long>
    implements LArticleEmplacementLotDAOLocal, LArticleEmplacementLotDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public LArticleEmplacementLotDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LArticleEmplacementLot> getManagedEntityClass() {
        return (LArticleEmplacementLot.class);
    }

}
