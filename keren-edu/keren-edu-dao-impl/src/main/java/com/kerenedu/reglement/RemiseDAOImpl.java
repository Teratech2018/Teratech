
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RemiseDAO")
public class RemiseDAOImpl
    extends AbstractGenericDAO<Remise, Long>
    implements RemiseDAOLocal, RemiseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RemiseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Remise> getManagedEntityClass() {
        return (Remise.class);
    }

}
