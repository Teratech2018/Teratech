
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
import com.keren.kerenpaie.core.ifaces.paie.ElementSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ElementSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementSalaireDAOLocal;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ElementSalaire;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ElementSalaireManager")
public class ElementSalaireManagerImpl
    extends AbstractGenericManager<ElementSalaire, Long>
    implements ElementSalaireManagerLocal, ElementSalaireManagerRemote
{

    @EJB(name = "ElementSalaireDAO")
    protected ElementSalaireDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;

    
    public ElementSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<ElementSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    
    
	@Override
	public ElementSalaire delete(Long id) {
		// TODO Auto-generated method stub
		ElementSalaire data =  super.delete(id);
		return new ElementSalaire(data);
	}

	@Override
	public List<ElementSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ElementSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ElementSalaire> result = new ArrayList<ElementSalaire>();
		for(ElementSalaire data:datas){
			result.add(new ElementSalaire(data));
		}
		return result;
	}

	@Override
	public ElementSalaire find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ElementSalaire data =  super.find(propertyName, entityID);
		ElementSalaire result = new ElementSalaire(data);
		for(Rubrique rubr:data.getRubriques()){
			result.getRubriques().add(new Rubrique(rubr));
		}
		return result;
	}

	@Override
	public List<ElementSalaire> findAll() {
		// TODO Auto-generated method stub		
		List<ElementSalaire> datas = super.findAll();
		List<ElementSalaire> result = new ArrayList<ElementSalaire>();
		for(ElementSalaire data:datas){
			result.add(new ElementSalaire(data));
		}
		return result;
	}

	@Override
	public ElementSalaire actif(ElementSalaire entity) {
		// TODO Auto-generated method stub
		Employe salarie = employedao.findByPrimaryKey("id", entity.getEmploye().getId());
		Short key = Short.parseShort(entity.getType());
		switch (key) {
		case 0:
			salarie.setSalbase(entity.getValeur());
			break;
		case 1:
			salarie.setIdemlogement(entity.getValeur());
			break;
		case 2:
			salarie.setAnciennitegele(entity.getValeur());
			break;
		case 3:			
			salarie.setTauxsyndical(entity.getValeur());
			break;
		case 4:			
			salarie.setRetraitcomplementaire(entity.getValeur());
			break;
		case 5:			
			salarie.setCmplsalaire(entity.getValeur());
			break;
		case 6:			
			for(Rubrique rubri:entity.getRubriques()){
				if(!salarie.getRubriques().contains(rubri)){
					salarie.getRubriques().add(rubri);
				}//end if(!salarie.getRubriques().contains(rubri)){
			}//end for(Rubrique rubri:entity.getRubriques())
			break;
		case 7:			
			if(entity.getEau()==Boolean.TRUE){
                                salarie.setEau(true);
                        }//end if(entity.getEau()==Boolean.TRUE){
                        if(entity.getElectricite()==Boolean.TRUE){
                            salarie.setElectricite(true);
                        }//end if(entity.getElectricite()==Boolean.TRUE){
                        if(entity.getAlimentaire()==Boolean.TRUE){
                            salarie.setAlimentaire(true);
                        }//end if(entity.getAlimentaire()==Boolean.TRUE){
                        if(entity.getLogement()==Boolean.TRUE){
                            salarie.setLogement(true);
                        }//end if(entity.getLogement()==Boolean.TRUE){
                        if(entity.getVehicule()==Boolean.TRUE){
                            salarie.setVehicule(true);
                        }//end if(entity.getVehicule()==Boolean.TRUE){
			break;
		case 8:			
			salarie.setNoel(entity.getValeur());
			break;
		default:
			break;
		}
		//Mise a jour de l'employé
		employedao.update(salarie.getId(), salarie);
		entity.setState("active");
		//Mise a jour ElementSalaire
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public ElementSalaire inactif(ElementSalaire entity) {
		// TODO Auto-generated method stub
		Employe salarie = employedao.findByPrimaryKey("id", entity.getEmploye().getId());
		Short key = Short.parseShort(entity.getType());
		switch (key) {
                    case 0:
                            salarie.setSalbase(null);
                            break;
                    case 1:
                            salarie.setIdemlogement(null);
                            break;
                    case 2:
                            salarie.setAnciennitegele(null);
                            break;
                    case 3:			
                            salarie.setTauxsyndical(null);
                            break;
                    case 4:			
                            salarie.setRetraitcomplementaire(null);
                            break;
                    case 5:			
                            salarie.setCmplsalaire(null);
                            break;
                    case 6:			
                            for(Rubrique rubri:entity.getRubriques()){
                                if(salarie.getRubriques().contains(rubri)){
                                        salarie.getRubriques().remove(rubri);
                                }//end if(!salarie.getRubriques().contains(rubri)){
                            }//end for(Rubrique rubri:entity.getRubriques())
                            break;
                    case 7:			
                            if(entity.getEau()==Boolean.TRUE){
                                salarie.setEau(false);
                            }//end if(entity.getEau()==Boolean.TRUE){
                            if(entity.getElectricite()==Boolean.TRUE){
                                salarie.setElectricite(false);
                            }//end if(entity.getElectricite()==Boolean.TRUE){
                            if(entity.getAlimentaire()==Boolean.TRUE){
                                salarie.setAlimentaire(false);
                            }//end if(entity.getAlimentaire()==Boolean.TRUE){
                            if(entity.getLogement()==Boolean.TRUE){
                                salarie.setLogement(false);
                            }//end if(entity.getLogement()==Boolean.TRUE){
                            if(entity.getVehicule()==Boolean.TRUE){
                                salarie.setVehicule(false);
                            }//end if(entity.getVehicule()==Boolean.TRUE){
                            break;
                    case 8:			
                            salarie.setNoel(null);
                            break;
                    default:
                            break;
		}
		entity.setState("inactive");
		//Mise a jour de l'employé
		employedao.update(salarie.getId(), salarie);
		//Mise a jour ElementSalaire
		dao.update(entity.getId(), entity);
		return entity;
	}

}
