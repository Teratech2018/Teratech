
package com.keren.kerenpaie.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.employes.PosteManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.PosteManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.PosteDAOLocal;
import com.keren.kerenpaie.model.employes.Poste;

@TransactionAttribute
@Stateless(mappedName = "PosteManager")
public class PosteManagerImpl
    extends AbstractGenericManager<Poste, Long>
    implements PosteManagerLocal, PosteManagerRemote
{

    @EJB(name = "PosteDAO")
    protected PosteDAOLocal dao;

    public PosteManagerImpl() {
    }

    @Override
    public GenericDAO<Poste, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
