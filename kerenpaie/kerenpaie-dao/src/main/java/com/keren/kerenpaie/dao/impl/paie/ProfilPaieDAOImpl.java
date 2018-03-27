
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAORemote;
import com.keren.kerenpaie.model.paie.ProfilPaie;

@Stateless(mappedName = "ProfilPaieDAO")
public class ProfilPaieDAOImpl
    extends AbstractGenericDAO<ProfilPaie, Long>
    implements ProfilPaieDAOLocal, ProfilPaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
