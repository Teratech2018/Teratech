
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "HelpProfClasseDAO")
public class HelpProfClasseDAOImpl
    extends AbstractGenericDAO<HelpProfClasse, Long>
    implements HelpProfClasseDAOLocal, HelpProfClasseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public HelpProfClasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<HelpProfClasse> getManagedEntityClass() {
        return (HelpProfClasse.class);
    }

}
