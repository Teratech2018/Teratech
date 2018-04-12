
package com.keren.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.structures.EtablissementDAOLocal;
import com.keren.dao.ifaces.structures.EtablissementDAORemote;
import com.keren.model.structures.Etablissement;

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
