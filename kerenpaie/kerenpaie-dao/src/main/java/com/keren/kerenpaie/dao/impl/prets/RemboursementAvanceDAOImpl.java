
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementAvanceDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementAvanceDAORemote;
import com.keren.kerenpaie.model.prets.RemboursementAvance;

@Stateless(mappedName = "RemboursementAvanceDAO")
public class RemboursementAvanceDAOImpl
    extends AbstractGenericDAO<RemboursementAvance, Long>
    implements RemboursementAvanceDAOLocal, RemboursementAvanceDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public RemboursementAvanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RemboursementAvance> getManagedEntityClass() {
        return (RemboursementAvance.class);
    }

}
