
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.ExprBesionManagerLocal;
import com.teratech.achat.core.ifaces.operations.ExprBesionManagerRemote;
import com.teratech.achat.dao.ifaces.operations.ExprBesionDAOLocal;
import com.teratech.achat.model.operations.ExprBesion;
import com.teratech.achat.model.operations.LigneExprBesion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ExprBesionManager")
public class ExprBesionManagerImpl
    extends AbstractGenericManager<ExprBesion, Long>
    implements ExprBesionManagerLocal, ExprBesionManagerRemote
{

    @EJB(name = "ExprBesionDAO")
    protected ExprBesionDAOLocal dao;

    public ExprBesionManagerImpl() {
    }

    @Override
    public GenericDAO<ExprBesion, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

   
    

    @Override
    public List<ExprBesion> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ExprBesion> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ExprBesion> result = new ArrayList<ExprBesion>();
        for(ExprBesion exp:datas){
            result.add(new ExprBesion(exp));
        }
        return result;
    }

    @Override
    public List<ExprBesion> findAll() {
        List<ExprBesion> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<ExprBesion> result = new ArrayList<ExprBesion>();
        for(ExprBesion exp:datas){
            result.add(new ExprBesion(exp));
        }
        return result;
    }

    @Override
    public ExprBesion find(String propertyName, Long entityID) {
        ExprBesion data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ExprBesion result = new ExprBesion(data);
        for(LigneExprBesion lex:data.getBesions()){
            result.getBesions().add(new LigneExprBesion(lex));
        }
        return result;
    }

    @Override
    public ExprBesion delete(Long id) {
        ExprBesion data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ExprBesion(data);
    }

    @Override
    public ExprBesion confirmer(ExprBesion entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
             entity.setState("valide");
         }//end if(entity.getState().trim().equalsIgnoreCase("etabli")){
         dao.update(entity.getId(), entity);
         return find("id", entity.getId());         
    }

    @Override
    public ExprBesion annuler(ExprBesion entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("etabli");
        dao.update(entity.getId(), entity);
        return find("id", entity.getId());  
    }
    
    

}
