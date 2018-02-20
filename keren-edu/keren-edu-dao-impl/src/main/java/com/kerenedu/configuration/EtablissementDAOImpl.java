
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EtablissementDAO")
public class EtablissementDAOImpl
    extends AbstractGenericDAO<Etablissement, Long>
    implements EtablissementDAOLocal, EtablissementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EtablissementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Etablissement> getManagedEntityClass() {
        return (Etablissement.class);
    }

}
