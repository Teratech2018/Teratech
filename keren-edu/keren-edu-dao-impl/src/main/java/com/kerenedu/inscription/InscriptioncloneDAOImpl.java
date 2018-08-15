
package com.kerenedu.inscription;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "InscriptioncloneDAO")
public class InscriptioncloneDAOImpl
    extends AbstractGenericDAO<Inscriptionclone, Long>
    implements InscriptioncloneDAOLocal, InscriptioncloneDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public InscriptioncloneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Inscriptionclone> getManagedEntityClass() {
        return (Inscriptionclone.class);
    }

}
