
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.AffectationCandidatManagerLocal;
import com.keren.core.ifaces.recrutement.AffectationCandidatManagerRemote;
import com.keren.dao.ifaces.recrutement.AffectationCandidatDAOLocal;
import com.keren.model.recrutement.AffectationCandidat;

@TransactionAttribute
@Stateless(mappedName = "AffectationCandidatManager")
public class AffectationCandidatManagerImpl
    extends AbstractGenericManager<AffectationCandidat, Long>
    implements AffectationCandidatManagerLocal, AffectationCandidatManagerRemote
{

    @EJB(name = "AffectationCandidatDAO")
    protected AffectationCandidatDAOLocal dao;

    public AffectationCandidatManagerImpl() {
    }

    @Override
    public GenericDAO<AffectationCandidat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
