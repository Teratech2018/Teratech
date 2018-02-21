
package com.teratech.stock.dao.impl.invetaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.invetaire.LigneInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.LigneInventaireDAORemote;
import com.teratech.stock.model.invetaire.LigneInventaire;

@Stateless(mappedName = "LigneInventaireDAO")
public class LigneInventaireDAOImpl
    extends AbstractGenericDAO<LigneInventaire, Long>
    implements LigneInventaireDAOLocal, LigneInventaireDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public LigneInventaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneInventaire> getManagedEntityClass() {
        return (LigneInventaire.class);
    }

}
