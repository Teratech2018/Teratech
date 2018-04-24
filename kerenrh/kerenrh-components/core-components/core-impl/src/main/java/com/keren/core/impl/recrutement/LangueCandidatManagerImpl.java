
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.LangueCandidatManagerLocal;
import com.keren.core.ifaces.recrutement.LangueCandidatManagerRemote;
import com.keren.dao.ifaces.recrutement.LangueCandidatDAOLocal;
import com.keren.model.recrutement.LangueCandidat;

@TransactionAttribute
@Stateless(mappedName = "LangueCandidatManager")
public class LangueCandidatManagerImpl
    extends AbstractGenericManager<LangueCandidat, Long>
    implements LangueCandidatManagerLocal, LangueCandidatManagerRemote
{

    @EJB(name = "LangueCandidatDAO")
    protected LangueCandidatDAOLocal dao;

    public LangueCandidatManagerImpl() {
    }

    @Override
    public GenericDAO<LangueCandidat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
