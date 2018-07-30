
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.LigneDiffusionDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.LigneDiffusionDAORemote;
import com.keren.courrier.model.referentiel.LigneDiffusion;

@Stateless(mappedName = "LigneDiffusionDAO")
public class LigneDiffusionDAOImpl
    extends AbstractGenericDAO<LigneDiffusion, Long>
    implements LigneDiffusionDAOLocal, LigneDiffusionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LigneDiffusionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneDiffusion> getManagedEntityClass() {
        return (LigneDiffusion.class);
    }

}
