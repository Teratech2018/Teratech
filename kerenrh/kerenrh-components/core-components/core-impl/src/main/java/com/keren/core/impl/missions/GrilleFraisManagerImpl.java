
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.GrilleFraisManagerLocal;
import com.keren.core.ifaces.missions.GrilleFraisManagerRemote;
import com.keren.dao.ifaces.missions.GrilleFraisDAOLocal;
import com.keren.model.missions.GrilleFrais;

@TransactionAttribute
@Stateless(mappedName = "GrilleFraisManager")
public class GrilleFraisManagerImpl
    extends AbstractGenericManager<GrilleFrais, Long>
    implements GrilleFraisManagerLocal, GrilleFraisManagerRemote
{

    @EJB(name = "GrilleFraisDAO")
    protected GrilleFraisDAOLocal dao;

    public GrilleFraisManagerImpl() {
    }

    @Override
    public GenericDAO<GrilleFrais, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
