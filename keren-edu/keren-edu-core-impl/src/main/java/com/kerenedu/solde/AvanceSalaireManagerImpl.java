
package com.kerenedu.solde;

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
import com.core.tools.DateHelper;
import com.kerem.core.KerenExecption;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AvanceSalaireManager")
public class AvanceSalaireManagerImpl
    extends AbstractGenericManager<AvanceSalaire, Long>
    implements AvanceSalaireManagerLocal, AvanceSalaireManagerRemote
{

    @EJB(name = "AvanceSalaireDAO")
    protected AvanceSalaireDAOLocal dao;
    
    @EJB(name = "RemboursementAvanceDAO")
    protected RemboursementAvanceDAOLocal remdao;

    public AvanceSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<AvanceSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
	public AvanceSalaire delete(Long id) {
		// TODO Auto-generated method stub
		AvanceSalaire entity = dao.findByPrimaryKey("id",id);
		for(RemboursementAvance rem:entity.getRemboursements()){
			remdao.delete(rem.getId());
		}
		dao.delete(id);
		return new AvanceSalaire(entity);
	}

	@Override
	public List<AvanceSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		 List<AvanceSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);		 
		 List<AvanceSalaire> result = new ArrayList<AvanceSalaire>();
		 for(AvanceSalaire data:datas){
			 result.add(new AvanceSalaire(data));
		 }
		 return result;
	}

	@Override
	public AvanceSalaire find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		AvanceSalaire data = super.find(propertyName, entityID);
		AvanceSalaire result = new AvanceSalaire(data);
		for(RemboursementAvance rem:data.getRemboursements()){
			result.getRemboursements().add(new RemboursementAvance(rem));
		}
		return result;
	}

	@Override
	public List<AvanceSalaire> findAll() {
		// TODO Auto-generated method stub
		 List<AvanceSalaire> datas = super.findAll();	 
		 List<AvanceSalaire> result = new ArrayList<AvanceSalaire>();
		 for(AvanceSalaire data:datas){
			 result.add(new AvanceSalaire(data));
		 }
		 return result;
	}

	@Override
	public AvanceSalaire generereglement(AvanceSalaire entity) {
		// TODO Auto-generated method stub
		Long traite = (long) (entity.getMontant()/entity.getDuree());
		Double total = 0.0;
		List<RemboursementAvance> remboursements = new ArrayList<RemboursementAvance>();
		for(int i=0;i<entity.getDuree();i++){
			RemboursementAvance rem = new RemboursementAvance();
			rem.setAvance(entity);
			//rem.setSociete(entity.getEmploye().get);
			rem.setDate(DateHelper.nextMonth(entity.getDate(), i));
			if(i==entity.getDuree()){
				rem.setMontant(entity.getMontant()-total);
			}else{
				rem.setMontant((double)traite);
				total +=traite;
			}//end if(i==entity.getDuree())
			remdao.save(rem);
		}//end for(int i=1;i<entity.getDuree();i++){
		//Chargement de l'entity
                entity = find("id", entity.getId());
		return new AvanceSalaire(entity);
	}

	@Override
	public AvanceSalaire confirme(AvanceSalaire entity) {
		// TODO Auto-generated method stub
		entity.setState("confirme");		
		AvanceSalaire data = dao.update(entity.getId(), entity);
	    return new AvanceSalaire(data);
	}

	@Override
	public AvanceSalaire annule(AvanceSalaire entity) {
		// TODO Auto-generated method stub
		entity.setState("annule");		
		AvanceSalaire data =dao.update(entity.getId(), entity);
		 return new AvanceSalaire(data);
	}

	@Override
	public void processBeforeDelete(AvanceSalaire entity) {
		 if(!entity.getState().equals("etabli")){
	           throw new KerenExecption("Cet Avance ne peut être Supprimer");
	    }
		super.processBeforeDelete(entity);
	}
    
	
}
