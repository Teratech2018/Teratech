
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.SoumettreSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.SoumettreSalaireDAORemote;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;

@Stateless(mappedName = "SoumettreSalaireDAO")
public class SoumettreSalaireDAOImpl
    extends AbstractGenericDAO<SoumettreSalaire, Long>
    implements SoumettreSalaireDAOLocal, SoumettreSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public SoumettreSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SoumettreSalaire> getManagedEntityClass() {
        return (SoumettreSalaire.class);
    }

}
