
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.LigneRappelDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.LigneRappelDAORemote;
import com.keren.kerenpaie.model.prets.LigneRappel;

@Stateless(mappedName = "LigneRappelDAO")
public class LigneRappelDAOImpl
    extends AbstractGenericDAO<LigneRappel, Long>
    implements LigneRappelDAOLocal, LigneRappelDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public LigneRappelDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneRappel> getManagedEntityClass() {
        return (LigneRappel.class);
    }

}
