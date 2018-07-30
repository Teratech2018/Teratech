
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.StatutManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.StatutManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.StatutDAOLocal;
import com.keren.courrier.model.referentiel.Statut;

@TransactionAttribute
@Stateless(mappedName = "StatutManager")
public class StatutManagerImpl
    extends AbstractGenericManager<Statut, Long>
    implements StatutManagerLocal, StatutManagerRemote
{

    @EJB(name = "StatutDAO")
    protected StatutDAOLocal dao;

    public StatutManagerImpl() {
    }

    @Override
    public GenericDAO<Statut, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
