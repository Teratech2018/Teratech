
package com.keren.kerenpaie.core.impl.prets;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.prets.LigneRappelManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.LigneRappelManagerRemote;
import com.keren.kerenpaie.dao.ifaces.prets.LigneRappelDAOLocal;
import com.keren.kerenpaie.model.prets.LigneRappel;

@TransactionAttribute
@Stateless(mappedName = "LigneRappelManager")
public class LigneRappelManagerImpl
    extends AbstractGenericManager<LigneRappel, Long>
    implements LigneRappelManagerLocal, LigneRappelManagerRemote
{

    @EJB(name = "LigneRappelDAO")
    protected LigneRappelDAOLocal dao;

    public LigneRappelManagerImpl() {
    }

    @Override
    public GenericDAO<LigneRappel, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
