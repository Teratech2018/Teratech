
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.TypeCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.TypeCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.TypeCourrierDAOLocal;
import com.keren.courrier.model.referentiel.TypeCourrier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TypeCourrierManager")
public class TypeCourrierManagerImpl
    extends AbstractGenericManager<TypeCourrier, Long>
    implements TypeCourrierManagerLocal, TypeCourrierManagerRemote
{

    @EJB(name = "TypeCourrierDAO")
    protected TypeCourrierDAOLocal dao;

    public TypeCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<TypeCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

     @Override
    public List<TypeCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<TypeCourrier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<TypeCourrier> results = new ArrayList<TypeCourrier>();
        
        for(TypeCourrier data:datas){
            results.add(new TypeCourrier(data));
        }
        
        return results;
    }

    @Override
    public List<TypeCourrier> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<TypeCourrier> datas = super.findAll(); 
        List<TypeCourrier> results = new ArrayList<TypeCourrier>();   
        
        for(TypeCourrier data:datas){
            results.add(new TypeCourrier(data));
        }
        
        return results;
    }

    @Override
    public TypeCourrier find(String propertyName, Long entityID) {
        TypeCourrier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        TypeCourrier result = new TypeCourrier(data);  
        
        return result;
    }
    
    @Override
    public TypeCourrier delete(Long id) {

        // TODO Auto-generated method stub    	
        TypeCourrier data= super.delete(id);

        return new TypeCourrier(data);
    }
}
