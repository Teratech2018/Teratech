
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.EmploiManagerLocal;
import com.keren.core.ifaces.recrutement.EmploiManagerRemote;
import com.keren.dao.ifaces.recrutement.EmploiDAOLocal;
import com.keren.model.recrutement.Emploi;

@TransactionAttribute
@Stateless(mappedName = "EmploiManager")
public class EmploiManagerImpl
    extends AbstractGenericManager<Emploi, Long>
    implements EmploiManagerLocal, EmploiManagerRemote
{

    @EJB(name = "EmploiDAO")
    protected EmploiDAOLocal dao;

    public EmploiManagerImpl() {
    }

    @Override
    public GenericDAO<Emploi, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
