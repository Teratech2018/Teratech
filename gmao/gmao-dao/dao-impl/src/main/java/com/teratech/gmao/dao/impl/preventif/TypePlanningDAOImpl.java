
package com.teratech.gmao.dao.impl.preventif;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.preventif.TypePlanningDAOLocal;
import com.teratech.gmao.dao.ifaces.preventif.TypePlanningDAORemote;
import com.teratech.gmao.model.preventif.TypePlanning;

@Stateless(mappedName = "TypePlanningDAO")
public class TypePlanningDAOImpl
    extends AbstractGenericDAO<TypePlanning, Long>
    implements TypePlanningDAOLocal, TypePlanningDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public TypePlanningDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypePlanning> getManagedEntityClass() {
        return (TypePlanning.class);
    }

}
