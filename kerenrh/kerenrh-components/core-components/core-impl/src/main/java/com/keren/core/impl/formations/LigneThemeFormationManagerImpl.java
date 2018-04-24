
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.LigneThemeFormationManagerLocal;
import com.keren.core.ifaces.formations.LigneThemeFormationManagerRemote;
import com.keren.dao.ifaces.formations.LigneThemeFormationDAOLocal;
import com.keren.model.formations.LigneThemeFormation;

@TransactionAttribute
@Stateless(mappedName = "LigneThemeFormationManager")
public class LigneThemeFormationManagerImpl
    extends AbstractGenericManager<LigneThemeFormation, Long>
    implements LigneThemeFormationManagerLocal, LigneThemeFormationManagerRemote
{

    @EJB(name = "LigneThemeFormationDAO")
    protected LigneThemeFormationDAOLocal dao;

    public LigneThemeFormationManagerImpl() {
    }

    @Override
    public GenericDAO<LigneThemeFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
