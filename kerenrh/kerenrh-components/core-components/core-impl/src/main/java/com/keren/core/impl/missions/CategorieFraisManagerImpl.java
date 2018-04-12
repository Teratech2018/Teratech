
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.CategorieFraisManagerLocal;
import com.keren.core.ifaces.missions.CategorieFraisManagerRemote;
import com.keren.dao.ifaces.missions.CategorieFraisDAOLocal;
import com.keren.model.missions.CategorieFrais;

@TransactionAttribute
@Stateless(mappedName = "CategorieFraisManager")
public class CategorieFraisManagerImpl
    extends AbstractGenericManager<CategorieFrais, Long>
    implements CategorieFraisManagerLocal, CategorieFraisManagerRemote
{

    @EJB(name = "CategorieFraisDAO")
    protected CategorieFraisDAOLocal dao;

    public CategorieFraisManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieFrais, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
