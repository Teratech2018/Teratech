
package com.keren.dao.impl.carrieres;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.carrieres.AffectationDAOLocal;
import com.keren.dao.ifaces.carrieres.AffectationDAORemote;
import com.keren.model.carrieres.Affectation;

@Stateless(mappedName = "AffectationDAO")
public class AffectationDAOImpl
    extends AbstractGenericDAO<Affectation, Long>
    implements AffectationDAOLocal, AffectationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AffectationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Affectation> getManagedEntityClass() {
        return (Affectation.class);
    }

}
