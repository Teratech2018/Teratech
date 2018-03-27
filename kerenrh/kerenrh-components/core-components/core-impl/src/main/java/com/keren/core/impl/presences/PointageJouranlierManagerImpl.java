
package com.keren.core.impl.presences;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.presences.PointageJouranlierManagerLocal;
import com.keren.core.ifaces.presences.PointageJouranlierManagerRemote;
import com.keren.dao.ifaces.presences.PointageJouranlierDAOLocal;
import com.keren.model.presences.PointageJouranlier;

@TransactionAttribute
@Stateless(mappedName = "PointageJouranlierManager")
public class PointageJouranlierManagerImpl
    extends AbstractGenericManager<PointageJouranlier, Long>
    implements PointageJouranlierManagerLocal, PointageJouranlierManagerRemote
{

    @EJB(name = "PointageJouranlierDAO")
    protected PointageJouranlierDAOLocal dao;

    public PointageJouranlierManagerImpl() {
    }

    @Override
    public GenericDAO<PointageJouranlier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
