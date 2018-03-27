
package com.keren.dao.impl.discipline;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.discipline.ConvocationConseilDAOLocal;
import com.keren.dao.ifaces.discipline.ConvocationConseilDAORemote;
import com.keren.model.discipline.ConvocationConseil;

@Stateless(mappedName = "ConvocationConseilDAO")
public class ConvocationConseilDAOImpl
    extends AbstractGenericDAO<ConvocationConseil, Long>
    implements ConvocationConseilDAOLocal, ConvocationConseilDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConvocationConseilDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConvocationConseil> getManagedEntityClass() {
        return (ConvocationConseil.class);
    }

}
