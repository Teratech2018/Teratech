
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.recrutement.AffectationCandidatManagerLocal;
import com.keren.core.ifaces.recrutement.AffectationCandidatManagerRemote;
import com.keren.dao.ifaces.recrutement.AffectationCandidatDAOLocal;
import com.keren.dao.ifaces.recrutement.BesionRecrutementDAOLocal;
import com.keren.dao.ifaces.recrutement.RecrutementDAOLocal;
import com.keren.model.recrutement.AffectationCandidat;
import com.keren.model.recrutement.BesionRecrutement;
import com.keren.model.recrutement.CandidatureSpontane;
import com.keren.model.recrutement.EtapeRecrutement;
import com.keren.model.recrutement.Recrutement;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "AffectationCandidatManager")
public class AffectationCandidatManagerImpl
    extends AbstractGenericManager<AffectationCandidat, Long>
    implements AffectationCandidatManagerLocal, AffectationCandidatManagerRemote
{

    @EJB(name = "AffectationCandidatDAO")
    protected AffectationCandidatDAOLocal dao;
    
    @EJB(name = "RecrutementDAO")
    protected RecrutementDAOLocal recrutementDao;
    
     @EJB(name = "BesionRecrutementDAO")
    protected BesionRecrutementDAOLocal besiondao;

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
    
    @Override
    public List<AffectationCandidat> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
               
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        //On initialise les les objets
        List<AffectationCandidat> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<AffectationCandidat> results = new ArrayList<AffectationCandidat>();
        
        for(AffectationCandidat data:datas){
            results.add(new AffectationCandidat(data));
        }
        return results;
    }
    
    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats);
    }
    
    @Override
    public List<AffectationCandidat> findAll() {
        List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<AffectationCandidat> results = new ArrayList<AffectationCandidat>();

        for(AffectationCandidat data:datas){
            results.add(new AffectationCandidat(data));
        }
        return results;
    }

    @Override
    public AffectationCandidat find(String propertyName, Long entityID) {
        AffectationCandidat data = super.find(propertyName, entityID);
        AffectationCandidat result = new AffectationCandidat(data);
        
        for(CandidatureSpontane candidature : data.getCandidatures()){
            result.getCandidatures().add(new CandidatureSpontane(candidature));
        }
        
        return result;
    }
    
    @Override
    public AffectationCandidat delete(Long id) {
        
        AffectationCandidat data = super.find("id", id);
        AffectationCandidat result = new AffectationCandidat(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }

    @Override
    public AffectationCandidat valide(AffectationCandidat entity) {
        
        //Initialisaiton
        Recrutement recrutement = null;
        
        //>Chargement du besion
        BesionRecrutement besion = besiondao.findByPrimaryKey("id", entity.getId());
        if(entity.getState().trim().equalsIgnoreCase("valide")){
            
            //On met à jour l'etat
            entity.setState("confirmation");
            
            //On set les valeurs importantes
            for(CandidatureSpontane candidature : entity.getCandidatures()){
                
                //On creer un recrutement
                recrutement = new Recrutement();
                
                //On recupere la candidature
                recrutement.setCandidature(candidature);
                
                //Affectation du besion lie
                recrutement.setBesion(besion);
                
                //On save
                recrutementDao.save(recrutement);
            }
            
            entity = dao.update(entity.getId(), entity);       
        }
        
        AffectationCandidat result = new AffectationCandidat(entity);
        
        for(CandidatureSpontane candidature : entity.getCandidatures()){
            result.getCandidatures().add(new CandidatureSpontane(candidature));
        }        
        return result;
    }

    @Override
    public AffectationCandidat annule(AffectationCandidat entity) {
        
        //Variables
        AffectationCandidat result = null;
        
        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
            entity = dao.update(entity.getId(), entity);            
        }
        
       result = new AffectationCandidat(entity);
        
        for(CandidatureSpontane candidature : entity.getCandidatures()){
            result.getCandidatures().add(new CandidatureSpontane(candidature));
        }        
        return result;
    }
}
