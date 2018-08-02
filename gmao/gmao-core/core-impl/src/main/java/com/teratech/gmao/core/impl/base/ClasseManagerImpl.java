
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.ClasseManagerLocal;
import com.teratech.gmao.core.ifaces.base.ClasseManagerRemote;
import com.teratech.gmao.dao.ifaces.base.ClasseDAOLocal;
import com.teratech.gmao.model.base.Classe;
import com.teratech.gmao.model.base.LigneClasse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ClasseManager")
public class ClasseManagerImpl
    extends AbstractGenericManager<Classe, Long>
    implements ClasseManagerLocal, ClasseManagerRemote
{

    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal dao;

    public ClasseManagerImpl() {
    }

    @Override
    public GenericDAO<Classe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Classe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Classe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Classe>  results = new ArrayList<Classe>();
        for(Classe data:datas){
            results.add(new Classe(data));
        }
        return results;
    }

    @Override
    public List<Classe> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<Classe> datas = super.findAll(); 
        List<Classe>  results = new ArrayList<Classe>();
        for(Classe data:datas){
            results.add(new Classe(data));
        }
        return results;
    }

    @Override
    public Classe find(String propertyName, Long entityID) {
        Classe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Classe result = new Classe(data);
        for(LigneClasse ligne : data.getLignes()){
            result.getLignes().add(new LigneClasse(ligne));
        }
        return result;
    }
    

    @Override
    public Classe delete(Long id) {
        return super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeUpdate(Classe entity) {
        cleanEntity(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Classe entity) {
        cleanEntity(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    private void cleanEntity(Classe entity){
        for(LigneClasse ligne:entity.getLignes()){
            if(ligne.getId()<0){
                ligne.setId(-1);
            }
        }
    }

}
