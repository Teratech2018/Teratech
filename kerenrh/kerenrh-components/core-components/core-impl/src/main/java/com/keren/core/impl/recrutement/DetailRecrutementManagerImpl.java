
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.DetailRecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.DetailRecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.DetailRecrutementDAOLocal;
import com.keren.model.recrutement.DetailRecrutement;

@TransactionAttribute
@Stateless(mappedName = "DetailRecrutementManager")
public class DetailRecrutementManagerImpl
    extends AbstractGenericManager<DetailRecrutement, Long>
    implements DetailRecrutementManagerLocal, DetailRecrutementManagerRemote
{

    @EJB(name = "DetailRecrutementDAO")
    protected DetailRecrutementDAOLocal dao;

    public DetailRecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<DetailRecrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
