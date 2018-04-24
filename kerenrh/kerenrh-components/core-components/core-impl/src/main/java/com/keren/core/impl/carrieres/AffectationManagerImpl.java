
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
import com.keren.core.ifaces.carrieres.AffectationManagerLocal;
import com.keren.core.ifaces.carrieres.AffectationManagerRemote;
import com.keren.dao.ifaces.carrieres.AffectationDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.carrieres.Affectation;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AffectationManager")
public class AffectationManagerImpl
    extends AbstractGenericManager<Affectation, Long>
    implements AffectationManagerLocal, AffectationManagerRemote
{

    @EJB(name = "AffectationDAO")
    protected AffectationDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;
    

    public AffectationManagerImpl() {
    }

    @Override
    public GenericDAO<Affectation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<Affectation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Affectation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Affectation> results = new ArrayList<Affectation>();
		for(Affectation data:datas){
			results.add(new Affectation(data));
		}
		return results;
	}

	@Override
	public Affectation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Affectation data =  super.find(propertyName, entityID);
		return new Affectation(data);
	}

	@Override
	public List<Affectation> findAll() {
		// TODO Auto-generated method stub		
		List<Affectation> datas = super.findAll();
		List<Affectation> results = new ArrayList<Affectation>();
		for(Affectation data:datas){
			results.add(new Affectation(data));
		}
		return results;
	}

	@Override
	public Affectation valide(Affectation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			entity = dao.update(entity.getId(), entity);
			Employe salarie = entity.getSalarie();
			salarie.setPoste(entity.getPosteN());
			salarie.setFonction(entity.getFonctionN());
			employedao.update(salarie.getId(), salarie);
		}
		return new Affectation(entity);
	}
    
    

}
