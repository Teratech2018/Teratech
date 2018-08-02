
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.EtatEquipementDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.EtatEquipementDAORemote;
import com.teratech.gmao.model.curative.EtatEquipement;

@Stateless(mappedName = "EtatEquipementDAO")
public class EtatEquipementDAOImpl
    extends AbstractGenericDAO<EtatEquipement, Long>
    implements EtatEquipementDAOLocal, EtatEquipementDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public EtatEquipementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EtatEquipement> getManagedEntityClass() {
        return (EtatEquipement.class);
    }

}
