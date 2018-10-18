
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfesseurcloneDAO")
public class ProfesseurcloneDAOImpl
    extends AbstractGenericDAO<Professeurclone, Long>
    implements ProfesseurcloneDAOLocal, ProfesseurcloneDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfesseurcloneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Professeurclone> getManagedEntityClass() {
        return (Professeurclone.class);
    }

}
