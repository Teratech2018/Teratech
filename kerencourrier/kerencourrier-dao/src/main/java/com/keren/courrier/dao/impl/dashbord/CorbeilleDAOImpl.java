
package com.keren.courrier.dao.impl.dashbord;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.dashbord.CorbeilleDAOLocal;
import com.keren.courrier.dao.ifaces.dashbord.CorbeilleDAORemote;
import com.keren.courrier.model.dashbord.Corbeille;

@Stateless(mappedName = "CorbeilleDAO")
public class CorbeilleDAOImpl
    extends AbstractGenericDAO<Corbeille, Long>
    implements CorbeilleDAOLocal, CorbeilleDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CorbeilleDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Corbeille> getManagedEntityClass() {
        return (Corbeille.class);
    }

}
