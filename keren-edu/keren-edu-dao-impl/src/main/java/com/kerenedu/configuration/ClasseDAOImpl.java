
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ClasseDAO")
public class ClasseDAOImpl
    extends AbstractGenericDAO<Classe, Long>
    implements ClasseDAOLocal, ClasseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ClasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Classe> getManagedEntityClass() {
        return (Classe.class);
    }

}
