
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfesseurChoiceDAO")
public class ProfesseurChoiceDAOImpl
    extends AbstractGenericDAO<ProfesseurChoice, Long>
    implements ProfesseurChoiceDAOLocal, ProfesseurChoiceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfesseurChoiceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ProfesseurChoice> getManagedEntityClass() {
        return (ProfesseurChoice.class);
    }

}
