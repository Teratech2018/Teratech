
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.EquipementDAOLocal;
import com.teratech.gmao.dao.ifaces.base.EquipementDAORemote;
import com.teratech.gmao.model.base.Equipement;

@Stateless(mappedName = "EquipementDAO")
public class EquipementDAOImpl
    extends AbstractGenericDAO<Equipement, Long>
    implements EquipementDAOLocal, EquipementDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public EquipementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Equipement> getManagedEntityClass() {
        return (Equipement.class);
    }

}
