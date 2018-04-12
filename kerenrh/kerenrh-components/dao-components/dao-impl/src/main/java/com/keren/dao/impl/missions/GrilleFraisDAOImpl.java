
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.GrilleFraisDAOLocal;
import com.keren.dao.ifaces.missions.GrilleFraisDAORemote;
import com.keren.model.missions.GrilleFrais;

@Stateless(mappedName = "GrilleFraisDAO")
public class GrilleFraisDAOImpl
    extends AbstractGenericDAO<GrilleFrais, Long>
    implements GrilleFraisDAOLocal, GrilleFraisDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public GrilleFraisDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<GrilleFrais> getManagedEntityClass() {
        return (GrilleFrais.class);
    }

}
