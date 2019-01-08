
package com.teratech.vente.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.base.UtilisateurDAOLocal;
import com.teratech.vente.dao.ifaces.base.UtilisateurDAORemote;
import com.teratech.vente.model.base.Utilisateur;

@Stateless(mappedName = "UtilisateurDAO")
public class UtilisateurDAOImpl
    extends AbstractGenericDAO<Utilisateur, Long>
    implements UtilisateurDAOLocal, UtilisateurDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public UtilisateurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Utilisateur> getManagedEntityClass() {
        return (Utilisateur.class);
    }

}
