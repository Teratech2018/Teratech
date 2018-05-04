
package com.keren.core.impl.carrieres;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.RetrogradationManagerLocal;
import com.keren.core.ifaces.carrieres.RetrogradationManagerRemote;
import com.keren.dao.ifaces.carrieres.RetrogradationDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.carrieres.Retrogradation;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RetrogradationManager")
public class RetrogradationManagerImpl
    extends AbstractGenericManager<Retrogradation, Long>
    implements RetrogradationManagerLocal, RetrogradationManagerRemote
{

    @EJB(name = "RetrogradationDAO")
    protected RetrogradationDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;

    public RetrogradationManagerImpl() {
    }

    @Override
    public GenericDAO<Retrogradation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Retrogradation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<Retrogradation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Retrogradation> results = new ArrayList<Retrogradation>();

        for(Retrogradation data:datas){
            results.add(new Retrogradation(data));
        }

        return results;
    }

    @Override
    public Retrogradation find(String propertyName, Long entityID) {

        // TODO Auto-generated method stub
        Retrogradation data = super.find(propertyName, entityID);
        return new Retrogradation(data);
    }

    @Override
    public List<Retrogradation> findAll() {

        // TODO Auto-generated method stub		
        List<Retrogradation> datas = super.findAll();
        List<Retrogradation> results = new ArrayList<Retrogradation>();

        for(Retrogradation data:datas){
            results.add(new Retrogradation(data));
        }

        return results;
    }

    @Override
    public Retrogradation delete(Long id) {

        // TODO Auto-generated method stub    	
        Retrogradation data= super.delete(id);

        return new Retrogradation(data);
    }

    @Override
    public Retrogradation valide(Retrogradation entity) {

        // TODO Auto-generated method stub
        if(entity.getState().equals("etabli")){
            entity.setState("valide");
            entity = dao.update(entity.getId(), entity);
            Employe salarie = entity.getSalarie();
            salarie.setCategorie(entity.getCategorieN());
            salarie.setEchelon(entity.getEchelonN());
            employedao.update(salarie.getId(), salarie);
            //Chargement des
        }

        return new Retrogradation(entity);
    } 
}
