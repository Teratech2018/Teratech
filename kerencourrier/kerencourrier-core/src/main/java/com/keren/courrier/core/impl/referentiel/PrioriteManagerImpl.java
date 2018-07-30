
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.PrioriteManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.PrioriteManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.PrioriteDAOLocal;
import com.keren.courrier.model.referentiel.Priorite;

@TransactionAttribute
@Stateless(mappedName = "PrioriteManager")
public class PrioriteManagerImpl
    extends AbstractGenericManager<Priorite, Long>
    implements PrioriteManagerLocal, PrioriteManagerRemote
{

    @EJB(name = "PrioriteDAO")
    protected PrioriteDAOLocal dao;

    public PrioriteManagerImpl() {
    }

    @Override
    public GenericDAO<Priorite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
