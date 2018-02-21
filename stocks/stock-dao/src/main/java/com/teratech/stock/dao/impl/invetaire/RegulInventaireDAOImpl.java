
package com.teratech.stock.dao.impl.invetaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.invetaire.RegulInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.RegulInventaireDAORemote;
import com.teratech.stock.model.invetaire.RegulInventaire;

@Stateless(mappedName = "RegulInventaireDAO")
public class RegulInventaireDAOImpl
    extends AbstractGenericDAO<RegulInventaire, Long>
    implements RegulInventaireDAOLocal, RegulInventaireDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public RegulInventaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RegulInventaire> getManagedEntityClass() {
        return (RegulInventaire.class);
    }

}
