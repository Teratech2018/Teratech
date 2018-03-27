
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.NiveauEtudeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.NiveauEtudeDAORemote;
import com.keren.kerenpaie.model.structures.NiveauEtude;

@Stateless(mappedName = "NiveauEtudeDAO")
public class NiveauEtudeDAOImpl
    extends AbstractGenericDAO<NiveauEtude, Long>
    implements NiveauEtudeDAOLocal, NiveauEtudeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public NiveauEtudeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NiveauEtude> getManagedEntityClass() {
        return (NiveauEtude.class);
    }

}
