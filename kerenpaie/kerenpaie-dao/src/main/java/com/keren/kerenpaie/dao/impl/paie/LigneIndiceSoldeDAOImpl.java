
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.LigneIndiceSoldeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.LigneIndiceSoldeDAORemote;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;

@Stateless(mappedName = "LigneIndiceSoldeDAO")
public class LigneIndiceSoldeDAOImpl
    extends AbstractGenericDAO<LigneIndiceSolde, Long>
    implements LigneIndiceSoldeDAOLocal, LigneIndiceSoldeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public LigneIndiceSoldeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneIndiceSolde> getManagedEntityClass() {
        return (LigneIndiceSolde.class);
    }

}
