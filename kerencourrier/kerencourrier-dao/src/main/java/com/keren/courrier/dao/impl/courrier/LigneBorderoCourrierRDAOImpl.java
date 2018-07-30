
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierRDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierRDAORemote;
import com.keren.courrier.model.courrier.LigneBorderoCourrierR;

@Stateless(mappedName = "LigneBorderoCourrierRDAO")
public class LigneBorderoCourrierRDAOImpl
    extends AbstractGenericDAO<LigneBorderoCourrierR, Long>
    implements LigneBorderoCourrierRDAOLocal, LigneBorderoCourrierRDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LigneBorderoCourrierRDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBorderoCourrierR> getManagedEntityClass() {
        return (LigneBorderoCourrierR.class);
    }

}
