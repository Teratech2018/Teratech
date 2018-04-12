
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.FormationManagerLocal;
import com.keren.core.ifaces.formations.FormationManagerRemote;
import com.keren.dao.ifaces.formations.FormationDAOLocal;
import com.keren.model.formations.Formation;

@TransactionAttribute
@Stateless(mappedName = "FormationManager")
public class FormationManagerImpl
    extends AbstractGenericManager<Formation, Long>
    implements FormationManagerLocal, FormationManagerRemote
{

    @EJB(name = "FormationDAO")
    protected FormationDAOLocal dao;

    public FormationManagerImpl() {
    }

    @Override
    public GenericDAO<Formation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
