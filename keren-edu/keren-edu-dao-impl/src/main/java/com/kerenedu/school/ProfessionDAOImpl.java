
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfessionDAO")
public class ProfessionDAOImpl
    extends AbstractGenericDAO<Profession, Long>
    implements ProfessionDAOLocal, ProfessionDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfessionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Profession> getManagedEntityClass() {
        return (Profession.class);
    }

}
