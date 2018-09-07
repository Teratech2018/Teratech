
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.PointVenteManagerLocal;
import com.keren.posweb.core.ifaces.PointVenteManagerRemote;
import com.keren.posweb.dao.ifaces.PointVenteDAOLocal;
import com.keren.posweb.model.PointVente;

@TransactionAttribute
@Stateless(mappedName = "PointVenteManager")
public class PointVenteManagerImpl
    extends AbstractGenericManager<PointVente, Long>
    implements PointVenteManagerLocal, PointVenteManagerRemote
{

    @EJB(name = "PointVenteDAO")
    protected PointVenteDAOLocal dao;

    public PointVenteManagerImpl() {
    }

    @Override
    public GenericDAO<PointVente, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
