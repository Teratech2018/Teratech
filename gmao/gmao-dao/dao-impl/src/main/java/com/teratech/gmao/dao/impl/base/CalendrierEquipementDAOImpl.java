
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CalendrierEquipementDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CalendrierEquipementDAORemote;
import com.teratech.gmao.model.base.CalendrierEquipement;

@Stateless(mappedName = "CalendrierEquipementDAO")
public class CalendrierEquipementDAOImpl
    extends AbstractGenericDAO<CalendrierEquipement, Long>
    implements CalendrierEquipementDAOLocal, CalendrierEquipementDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CalendrierEquipementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CalendrierEquipement> getManagedEntityClass() {
        return (CalendrierEquipement.class);
    }

}
