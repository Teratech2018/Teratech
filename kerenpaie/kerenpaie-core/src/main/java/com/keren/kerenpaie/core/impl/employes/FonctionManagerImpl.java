
package com.keren.kerenpaie.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.employes.FonctionManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.FonctionManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.FonctionDAOLocal;
import com.keren.kerenpaie.model.employes.Fonction;

@TransactionAttribute
@Stateless(mappedName = "FonctionManager")
public class FonctionManagerImpl
    extends AbstractGenericManager<Fonction, Long>
    implements FonctionManagerLocal, FonctionManagerRemote
{

    @EJB(name = "FonctionDAO")
    protected FonctionDAOLocal dao;

    public FonctionManagerImpl() {
    }

    @Override
    public GenericDAO<Fonction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
