
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ValiderSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ValiderSalaireDAORemote;
import com.keren.kerenpaie.model.paie.ValiderSalaire;

@Stateless(mappedName = "ValiderSalaireDAO")
public class ValiderSalaireDAOImpl
    extends AbstractGenericDAO<ValiderSalaire, Long>
    implements ValiderSalaireDAOLocal, ValiderSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public ValiderSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ValiderSalaire> getManagedEntityClass() {
        return (ValiderSalaire.class);
    }

}
