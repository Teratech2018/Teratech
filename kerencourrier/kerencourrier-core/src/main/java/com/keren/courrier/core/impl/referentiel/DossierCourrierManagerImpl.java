
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.DossierCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.DossierCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.DossierCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.TypeDossierDAOLocal;
import com.keren.courrier.model.referentiel.DossierCourrier;
import com.keren.courrier.model.referentiel.TypeDossier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "DossierCourrierManager")
public class DossierCourrierManagerImpl
    extends AbstractGenericManager<DossierCourrier, Long>
    implements DossierCourrierManagerLocal, DossierCourrierManagerRemote
{

    @EJB(name = "DossierCourrierDAO")
    protected DossierCourrierDAOLocal dao;
    
    @EJB(name = "TypeDossierDAO")
    protected TypeDossierDAOLocal typeDossierDao;

    public DossierCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<DossierCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<DossierCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<DossierCourrier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<DossierCourrier> results = new ArrayList<DossierCourrier>();
        
        for(DossierCourrier data:datas){
            results.add(new DossierCourrier(data));
        }
        
        return results;
    }

    @Override
    public List<DossierCourrier> findAll() {
        //To change body of generated methods, choose Tools | Templates.
         List<DossierCourrier> datas = super.findAll(); 
        List<DossierCourrier> results = new ArrayList<DossierCourrier>();        
        for(DossierCourrier data:datas){
            results.add(new DossierCourrier(data));
        }
        return results;
    }

    @Override
    public DossierCourrier find(String propertyName, Long entityID) {
        DossierCourrier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        DossierCourrier result = new DossierCourrier(data);         
        for(TypeDossier typeDossier:data.getTypesdossiers()){
            result.getTypesdossiers().add(new TypeDossier(typeDossier));
        }
        
        return result;
    }
    
    @Override
    public DossierCourrier delete(Long id) {

        // TODO Auto-generated method stub    	
        DossierCourrier data= super.delete(id);

        return new DossierCourrier(data);
    }
    
    
}
