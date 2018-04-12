
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerLocal;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerRemote;
import com.keren.dao.ifaces.recrutement.CandidatureSpontaneDAOLocal;
import com.keren.model.recrutement.CandidatureSpontane;

@TransactionAttribute
@Stateless(mappedName = "CandidatureSpontaneManager")
public class CandidatureSpontaneManagerImpl
    extends AbstractGenericManager<CandidatureSpontane, Long>
    implements CandidatureSpontaneManagerLocal, CandidatureSpontaneManagerRemote
{

    @EJB(name = "CandidatureSpontaneDAO")
    protected CandidatureSpontaneDAOLocal dao;

    public CandidatureSpontaneManagerImpl() {
    }

    @Override
    public GenericDAO<CandidatureSpontane, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
