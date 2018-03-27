
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.ParametreAvanceManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ParametreAvanceManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAOLocal;
import com.keren.kerenpaie.model.paie.ParametreAvance;

@TransactionAttribute
@Stateless(mappedName = "ParametreAvanceManager")
public class ParametreAvanceManagerImpl
    extends AbstractGenericManager<ParametreAvance, Long>
    implements ParametreAvanceManagerLocal, ParametreAvanceManagerRemote
{

    @EJB(name = "ParametreAvanceDAO")
    protected ParametreAvanceDAOLocal dao;

    public ParametreAvanceManagerImpl() {
    }

    @Override
    public GenericDAO<ParametreAvance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
