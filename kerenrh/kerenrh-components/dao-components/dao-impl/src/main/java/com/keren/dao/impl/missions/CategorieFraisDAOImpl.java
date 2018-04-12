
package com.keren.dao.impl.missions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.missions.CategorieFraisDAOLocal;
import com.keren.dao.ifaces.missions.CategorieFraisDAORemote;
import com.keren.model.missions.CategorieFrais;

@Stateless(mappedName = "CategorieFraisDAO")
public class CategorieFraisDAOImpl
    extends AbstractGenericDAO<CategorieFrais, Long>
    implements CategorieFraisDAOLocal, CategorieFraisDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CategorieFraisDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CategorieFrais> getManagedEntityClass() {
        return (CategorieFrais.class);
    }

}
