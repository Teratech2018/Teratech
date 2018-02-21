
package com.teratech.stock.dao.impl.invetaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.invetaire.BaseInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.BaseInventaireDAORemote;
import com.teratech.stock.model.invetaire.BaseInventaire;

@Stateless(mappedName = "BaseInventaireDAO")
public class BaseInventaireDAOImpl
    extends AbstractGenericDAO<BaseInventaire, Long>
    implements BaseInventaireDAOLocal, BaseInventaireDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public BaseInventaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BaseInventaire> getManagedEntityClass() {
        return (BaseInventaire.class);
    }

}
