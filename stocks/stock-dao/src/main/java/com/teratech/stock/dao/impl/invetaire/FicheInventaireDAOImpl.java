
package com.teratech.stock.dao.impl.invetaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.invetaire.FicheInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.FicheInventaireDAORemote;
import com.teratech.stock.model.invetaire.FicheInventaire;

@Stateless(mappedName = "FicheInventaireDAO")
public class FicheInventaireDAOImpl
    extends AbstractGenericDAO<FicheInventaire, Long>
    implements FicheInventaireDAOLocal, FicheInventaireDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public FicheInventaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FicheInventaire> getManagedEntityClass() {
        return (FicheInventaire.class);
    }

}
