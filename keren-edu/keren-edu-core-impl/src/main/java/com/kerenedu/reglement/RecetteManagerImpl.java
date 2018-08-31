
package com.kerenedu.reglement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "RecetteManager")
public class RecetteManagerImpl
    extends AbstractGenericManager<Recette, Long>
    implements RecetteManagerLocal, RecetteManagerRemote
{

    @EJB(name = "RecetteDAO")
    protected RecetteDAOLocal dao;

    public RecetteManagerImpl() {
    }

    @Override
    public GenericDAO<Recette, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
