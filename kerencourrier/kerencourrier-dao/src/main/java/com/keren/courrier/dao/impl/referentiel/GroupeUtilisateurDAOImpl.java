
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.GroupeUtilisateurDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.GroupeUtilisateurDAORemote;
import com.keren.courrier.model.referentiel.GroupeUtilisateur;

@Stateless(mappedName = "GroupeUtilisateurDAO")
public class GroupeUtilisateurDAOImpl
    extends AbstractGenericDAO<GroupeUtilisateur, Long>
    implements GroupeUtilisateurDAOLocal, GroupeUtilisateurDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public GroupeUtilisateurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<GroupeUtilisateur> getManagedEntityClass() {
        return (GroupeUtilisateur.class);
    }

}
