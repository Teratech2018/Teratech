
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.ExperienceCandidatManagerLocal;
import com.keren.core.ifaces.recrutement.ExperienceCandidatManagerRemote;
import com.keren.dao.ifaces.recrutement.ExperienceCandidatDAOLocal;
import com.keren.model.recrutement.ExperienceCandidat;

@TransactionAttribute
@Stateless(mappedName = "ExperienceCandidatManager")
public class ExperienceCandidatManagerImpl
    extends AbstractGenericManager<ExperienceCandidat, Long>
    implements ExperienceCandidatManagerLocal, ExperienceCandidatManagerRemote
{

    @EJB(name = "ExperienceCandidatDAO")
    protected ExperienceCandidatDAOLocal dao;

    public ExperienceCandidatManagerImpl() {
    }

    @Override
    public GenericDAO<ExperienceCandidat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
