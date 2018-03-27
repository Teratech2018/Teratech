
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.MembreConseilDAOLocal;
import com.keren.dao.ifaces.discipline.MembreConseilDAORemote;
import com.keren.model.discipline.MembreConseil;

@Stateless(mappedName = "MembreConseilDAO")
public class MembreConseilDAOImpl
    extends AbstractGenericDAO<MembreConseil, Long>
    implements MembreConseilDAOLocal, MembreConseilDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MembreConseilDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MembreConseil> getManagedEntityClass() {
        return (MembreConseil.class);
    }

}
