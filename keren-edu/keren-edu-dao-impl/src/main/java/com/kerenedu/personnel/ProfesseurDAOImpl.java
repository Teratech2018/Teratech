
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfesseurDAO")
public class ProfesseurDAOImpl
    extends AbstractGenericDAO<Professeur, Long>
    implements ProfesseurDAOLocal, ProfesseurDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfesseurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Professeur> getManagedEntityClass() {
        return (Professeur.class);
    }

}
