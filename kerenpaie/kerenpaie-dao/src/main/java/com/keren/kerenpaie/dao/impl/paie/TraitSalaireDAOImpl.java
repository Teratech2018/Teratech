
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.TraitSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.TraitSalaireDAORemote;
import com.keren.kerenpaie.model.paie.TraitSalaire;

@Stateless(mappedName = "TraitSalaireDAO")
public class TraitSalaireDAOImpl
    extends AbstractGenericDAO<TraitSalaire, Long>
    implements TraitSalaireDAOLocal, TraitSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public TraitSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TraitSalaire> getManagedEntityClass() {
        return (TraitSalaire.class);
    }

}
