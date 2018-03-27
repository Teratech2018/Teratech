
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAORemote;
import com.keren.kerenpaie.model.paie.ParametreAvance;

@Stateless(mappedName = "ParametreAvanceDAO")
public class ParametreAvanceDAOImpl
    extends AbstractGenericDAO<ParametreAvance, Long>
    implements ParametreAvanceDAOLocal, ParametreAvanceDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public ParametreAvanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ParametreAvance> getManagedEntityClass() {
        return (ParametreAvance.class);
    }

}
