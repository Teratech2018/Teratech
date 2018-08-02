
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.GroupeUtilisateurManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.GroupeUtilisateurManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.GroupeUtilisateurDAOLocal;
import com.keren.courrier.model.referentiel.GroupeUtilisateur;

@TransactionAttribute
@Stateless(mappedName = "GroupeUtilisateurManager")
public class GroupeUtilisateurManagerImpl
    extends AbstractGenericManager<GroupeUtilisateur, Long>
    implements GroupeUtilisateurManagerLocal, GroupeUtilisateurManagerRemote
{

    @EJB(name = "GroupeUtilisateurDAO")
    protected GroupeUtilisateurDAOLocal dao;

    public GroupeUtilisateurManagerImpl() {
    }

    @Override
    public GenericDAO<GroupeUtilisateur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
