
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfFichePaieDAO")
public class ProfFichePaieDAOImpl
    extends AbstractGenericDAO<ProfFichePaie, Long>
    implements ProfFichePaieDAOLocal, ProfFichePaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfFichePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ProfFichePaie> getManagedEntityClass() {
        return (ProfFichePaie.class);
    }

}
