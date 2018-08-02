
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.StructureCompanyManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.StructureCompanyManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.LigneDiffusionDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.StructureCompanyDAOLocal;
import com.keren.courrier.model.courrier.ServiceDiffusion;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.User;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "StructureCompanyManager")
public class StructureCompanyManagerImpl
    extends AbstractGenericManager<StructureCompany, Long>
    implements StructureCompanyManagerLocal, StructureCompanyManagerRemote{

    @EJB(name = "StructureCompanyDAO")
    protected StructureCompanyDAOLocal dao;
    
    @EJB(name = "LigneDiffusionDAO")
    protected LigneDiffusionDAOLocal ligneDiffusionDao;

    public StructureCompanyManagerImpl() {
    }

    @Override
    public GenericDAO<StructureCompany, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<StructureCompany> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        
        //Initialisation des variables
        List<StructureCompany> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<StructureCompany> results = new ArrayList<StructureCompany>();        
        //On parcourt la liste des donnees
        for(StructureCompany data:datas){
            results.add(new StructureCompany(data));
        }
        
        return results;
    }

    @Override
    public List<StructureCompany> findAll() {
        
        //Initialisation des variables
        List<StructureCompany> datas = super.findAll(); 
        List<StructureCompany> results = new ArrayList<StructureCompany>();
        
        //On parcourt la liste des donnees
        for(StructureCompany data:datas){
            results.add(new StructureCompany(data));
        }
        return results;
    }

    @Override
    public StructureCompany find(String propertyName, Long entityID) {
        
        //Initialisation des variables
        StructureCompany data = super.find(propertyName, entityID);
        StructureCompany result = new StructureCompany(data);
        
        //On parcourt la liste des donnees
//        for(LigneDiffusion ligne:data.getIntervenants()){
//            result.getIntervenants().add(new LigneDiffusion(ligne));
//        }
//        for(ServiceDiffusion ligne:data.getServices()){
//            result.getServices().add(new ServiceDiffusion(ligne));
//        }
        return result;
    }
    
    @Override
    public void processBeforeSave(StructureCompany entity) {
        
        //Traitement des LigneDiffusion
//        if(entity.getIntervenants()!= null){
//            
//            //On parcourt la liste des donnees
//            List<LigneDiffusion> datas =new ArrayList<LigneDiffusion>();
//            int index =1 ;
//            
//            //On parcourt la liste
//            for(LigneDiffusion intervenant : entity.getIntervenants()){
//              
//              //Initialisation
//              intervenant.setId(-index);
//              datas.add(intervenant);
//              index ++;
//            }
//            
//            //On ajoute la liste
//            entity.getIntervenants().addAll(datas);
//            
//        }
        
        super.processBeforeSave(entity);
    }
    
    @Override
    public StructureCompany delete(Long id) {
        
        //Initialisation des variables
        StructureCompany data = super.delete(id);
        
        return new StructureCompany(data);
    }
    
    

}
