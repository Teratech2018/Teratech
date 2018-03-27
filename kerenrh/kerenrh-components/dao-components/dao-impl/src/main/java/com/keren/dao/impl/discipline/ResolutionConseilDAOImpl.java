
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.ResolutionConseilDAOLocal;
import com.keren.dao.ifaces.discipline.ResolutionConseilDAORemote;
import com.keren.model.discipline.ResolutionConseil;

@Stateless(mappedName = "ResolutionConseilDAO")
public class ResolutionConseilDAOImpl
    extends AbstractGenericDAO<ResolutionConseil, Long>
    implements ResolutionConseilDAOLocal, ResolutionConseilDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ResolutionConseilDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ResolutionConseil> getManagedEntityClass() {
        return (ResolutionConseil.class);
    }

}
