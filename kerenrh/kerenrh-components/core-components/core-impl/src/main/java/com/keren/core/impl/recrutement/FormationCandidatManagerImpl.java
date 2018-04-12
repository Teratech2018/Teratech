
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.FormationCandidatManagerLocal;
import com.keren.core.ifaces.recrutement.FormationCandidatManagerRemote;
import com.keren.dao.ifaces.recrutement.FormationCandidatDAOLocal;
import com.keren.model.recrutement.FormationCandidat;

@TransactionAttribute
@Stateless(mappedName = "FormationCandidatManager")
public class FormationCandidatManagerImpl
    extends AbstractGenericManager<FormationCandidat, Long>
    implements FormationCandidatManagerLocal, FormationCandidatManagerRemote
{

    @EJB(name = "FormationCandidatDAO")
    protected FormationCandidatDAOLocal dao;

    public FormationCandidatManagerImpl() {
    }

    @Override
    public GenericDAO<FormationCandidat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
