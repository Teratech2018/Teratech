
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.UtilisateurCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.UtilisateurCourrierDAORemote;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;

@Stateless(mappedName = "UtilisateurCourrierDAO")
public class UtilisateurCourrierDAOImpl
    extends AbstractGenericDAO<UtilisateurCourrier, Long>
    implements UtilisateurCourrierDAOLocal, UtilisateurCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public UtilisateurCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<UtilisateurCourrier> getManagedEntityClass() {
        return (UtilisateurCourrier.class);
    }

}
