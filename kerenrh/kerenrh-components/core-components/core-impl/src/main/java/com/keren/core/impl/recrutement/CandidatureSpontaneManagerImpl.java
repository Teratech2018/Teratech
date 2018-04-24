
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerLocal;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerRemote;
import com.keren.dao.ifaces.recrutement.CandidatureSpontaneDAOLocal;
import com.keren.model.recrutement.CandidatureSpontane;
import com.keren.model.recrutement.ExperienceCandidat;
import com.keren.model.recrutement.FormationCandidat;
import com.keren.model.recrutement.LangueCandidat;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    
    @Override
    public List<CandidatureSpontane> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CandidatureSpontane> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<CandidatureSpontane> results = new ArrayList<CandidatureSpontane>();
        for(CandidatureSpontane data:datas){
            results.add(new CandidatureSpontane(data));
        }
        return results;
    }

    @Override
    public List<CandidatureSpontane> findAll() {
        List<CandidatureSpontane> datas = super.findAll();
        List<CandidatureSpontane> results = new ArrayList<CandidatureSpontane>();

        for(CandidatureSpontane data:datas){
            results.add(new CandidatureSpontane(data));
        }
        return results;
    }

    @Override
    public CandidatureSpontane find(String propertyName, Long entityID) {
        CandidatureSpontane data = super.find(propertyName, entityID);
        CandidatureSpontane result = new CandidatureSpontane(data);

        for(FormationCandidat aas:data.getFormations()){
            result.getFormations().add(new FormationCandidat(aas));
        }

        for(ExperienceCandidat aas:data.getExperiences()){
            result.getExperiences().add(new ExperienceCandidat(aas));
        }

        for(LangueCandidat aas:data.getLangues()){
            result.getLangues().add(new LangueCandidat(aas));
        }

        return result;
    }
    
}
