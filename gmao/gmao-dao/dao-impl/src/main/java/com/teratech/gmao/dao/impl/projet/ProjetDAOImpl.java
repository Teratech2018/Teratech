
package com.teratech.gmao.dao.impl.projet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.projet.ProjetDAOLocal;
import com.teratech.gmao.dao.ifaces.projet.ProjetDAORemote;
import com.teratech.gmao.model.projet.Projet;

@Stateless(mappedName = "ProjetDAO")
public class ProjetDAOImpl
    extends AbstractGenericDAO<Projet, Long>
    implements ProjetDAOLocal, ProjetDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ProjetDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Projet> getManagedEntityClass() {
        return (Projet.class);
    }

}
