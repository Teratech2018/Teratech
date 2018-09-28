
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ProfilPaieDAO")
public class ProfilPaieDAOImpl
    extends AbstractGenericDAO<ProfilPaie, Long>
    implements ProfilPaieDAOLocal, ProfilPaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ProfilPaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ProfilPaie> getManagedEntityClass() {
        return (ProfilPaie.class);
    }

}
