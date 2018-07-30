
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierDAORemote;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;

@Stateless(mappedName = "LigneBorderoCourrierDAO")
public class LigneBorderoCourrierDAOImpl
    extends AbstractGenericDAO<LigneBorderoCourrier, Long>
    implements LigneBorderoCourrierDAOLocal, LigneBorderoCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LigneBorderoCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBorderoCourrier> getManagedEntityClass() {
        return (LigneBorderoCourrier.class);
    }

}
