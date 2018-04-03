
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LigneIndiceSoldeManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.LigneIndiceSoldeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.LigneIndiceSoldeDAOLocal;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;

@TransactionAttribute
@Stateless(mappedName = "LigneIndiceSoldeManager")
public class LigneIndiceSoldeManagerImpl
    extends AbstractGenericManager<LigneIndiceSolde, Long>
    implements LigneIndiceSoldeManagerLocal, LigneIndiceSoldeManagerRemote
{

    @EJB(name = "LigneIndiceSoldeDAO")
    protected LigneIndiceSoldeDAOLocal dao;

    public LigneIndiceSoldeManagerImpl() {
    }

    @Override
    public GenericDAO<LigneIndiceSolde, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
