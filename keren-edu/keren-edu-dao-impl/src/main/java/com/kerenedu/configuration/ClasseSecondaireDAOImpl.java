
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ClasseSecondaireDAO")
public class ClasseSecondaireDAOImpl
    extends AbstractGenericDAO<ClasseSecondaire, Long>
    implements ClasseSecondaireDAOLocal, ClasseSecondaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ClasseSecondaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ClasseSecondaire> getManagedEntityClass() {
        return (ClasseSecondaire.class);
    }

}
