
package com.keren.kerenpaie.dao.impl.conges;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.conges.DemandeCongeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.conges.DemandeCongeDAORemote;
import com.keren.kerenpaie.model.conges.DemandeConge;

@Stateless(mappedName = "DemandeCongeDAO")
public class DemandeCongeDAOImpl
    extends AbstractGenericDAO<DemandeConge, Long>
    implements DemandeCongeDAOLocal, DemandeCongeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public DemandeCongeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DemandeConge> getManagedEntityClass() {
        return (DemandeConge.class);
    }

}
