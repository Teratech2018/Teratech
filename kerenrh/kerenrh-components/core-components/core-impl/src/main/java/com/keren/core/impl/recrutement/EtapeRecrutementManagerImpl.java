
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.EtapeRecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.EtapeRecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.EtapeRecrutementDAOLocal;
import com.keren.model.recrutement.EtapeRecrutement;

@TransactionAttribute
@Stateless(mappedName = "EtapeRecrutementManager")
public class EtapeRecrutementManagerImpl
    extends AbstractGenericManager<EtapeRecrutement, Long>
    implements EtapeRecrutementManagerLocal, EtapeRecrutementManagerRemote
{

    @EJB(name = "EtapeRecrutementDAO")
    protected EtapeRecrutementDAOLocal dao;

    public EtapeRecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<EtapeRecrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
