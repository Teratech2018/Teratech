
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

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
