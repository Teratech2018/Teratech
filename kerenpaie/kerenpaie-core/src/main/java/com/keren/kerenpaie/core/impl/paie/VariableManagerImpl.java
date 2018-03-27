
package com.keren.kerenpaie.core.impl.paie;

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
import com.keren.kerenpaie.core.ifaces.paie.VariableManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.VariableManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAOLocal;
import com.keren.kerenpaie.model.paie.Variable;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "VariableManager")
public class VariableManagerImpl
    extends AbstractGenericManager<Variable, Long>
    implements VariableManagerLocal, VariableManagerRemote
{

    @EJB(name = "VariableDAO")
    protected VariableDAOLocal dao;

    public VariableManagerImpl() {
    }

    @Override
    public GenericDAO<Variable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Variable delete(Long id) {
		// TODO Auto-generated method stub
		Variable data = super.delete(id);
		return new Variable(data);
	}

	@Override
	public List<Variable> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Variable> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Variable> resutl = new ArrayList<Variable>();
		for(Variable var:datas){
			resutl.add(new Variable(var));
		}
		return resutl;
	}

	@Override
	public Variable find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Variable data= super.find(propertyName, entityID);
		return new Variable(data);
	}

	@Override
	public List<Variable> findAll() {
		// TODO Auto-generated method stub
		List<Variable> datas = super.findAll();
		List<Variable> resutl = new ArrayList<Variable>();
		for(Variable var:datas){
			resutl.add(new Variable(var));
		}
		return resutl;
	}
    
    

}
