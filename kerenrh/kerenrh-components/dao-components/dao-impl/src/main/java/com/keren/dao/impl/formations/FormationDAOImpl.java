
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.FormationDAOLocal;
import com.keren.dao.ifaces.formations.FormationDAORemote;
import com.keren.model.formations.Formation;

@Stateless(mappedName = "FormationDAO")
public class FormationDAOImpl
    extends AbstractGenericDAO<Formation, Long>
    implements FormationDAOLocal, FormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Formation> getManagedEntityClass() {
        return (Formation.class);
    }

}
