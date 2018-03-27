
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.LignePonderationSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.LignePonderationSalaireDAORemote;
import com.keren.kerenpaie.model.paie.LignePonderationSalaire;

@Stateless(mappedName = "LignePonderationSalaireDAO")
public class LignePonderationSalaireDAOImpl
    extends AbstractGenericDAO<LignePonderationSalaire, Long>
    implements LignePonderationSalaireDAOLocal, LignePonderationSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public LignePonderationSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePonderationSalaire> getManagedEntityClass() {
        return (LignePonderationSalaire.class);
    }

}
