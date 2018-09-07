
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.UniteGestionManagerLocal;
import com.keren.posweb.core.ifaces.UniteGestionManagerRemote;
import com.keren.posweb.dao.ifaces.UniteGestionDAOLocal;
import com.keren.posweb.model.UniteGestion;

@TransactionAttribute
@Stateless(mappedName = "UniteGestionManager")
public class UniteGestionManagerImpl
    extends AbstractGenericManager<UniteGestion, Long>
    implements UniteGestionManagerLocal, UniteGestionManagerRemote
{

    @EJB(name = "UniteGestionDAO")
    protected UniteGestionDAOLocal dao;

    public UniteGestionManagerImpl() {
    }

    @Override
    public GenericDAO<UniteGestion, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
