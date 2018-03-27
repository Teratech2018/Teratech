
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAORemote;
import com.keren.kerenpaie.model.paie.Rubrique;

@Stateless(mappedName = "RubriqueDAO")
public class RubriqueDAOImpl
    extends AbstractGenericDAO<Rubrique, Long>
    implements RubriqueDAOLocal, RubriqueDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public RubriqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Rubrique> getManagedEntityClass() {
        return (Rubrique.class);
    }

}
