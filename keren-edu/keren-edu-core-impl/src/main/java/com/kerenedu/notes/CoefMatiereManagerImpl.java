
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CoefMatiereManager")
public class CoefMatiereManagerImpl
    extends AbstractGenericManager<CoefMatiere, Long>
    implements CoefMatiereManagerLocal, CoefMatiereManagerRemote
{

    @EJB(name = "CoefMatiereDAO")
    protected CoefMatiereDAOLocal dao;
    
    @EJB(name = "MatiereDAO")
    protected MatiereDAOLocal matieredao;

    public CoefMatiereManagerImpl() {
    }

    @Override
    public GenericDAO<CoefMatiere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<CoefMatiere> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<CoefMatiere> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<CoefMatiere> result = new ArrayList<CoefMatiere>();
   		for(CoefMatiere elev:datas){
   			result.add(new CoefMatiere(elev));
   		}
   		return result;
   	}

   	@Override
   	public CoefMatiere find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		CoefMatiere data = super.find(propertyName, entityID);
   		CoefMatiere result = new CoefMatiere(data);
   		List<CoefMatiereDetail> listcmdlt = new ArrayList<CoefMatiereDetail>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("filiere.code", data.getClasse().getFiliere().getCode());
		 List<Matiere> lisyMatiere = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		 if(data.getMatdetailList()==null||data.getMatdetailList().isEmpty()){
		
		 for(Matiere mat:lisyMatiere){
			// listcmdlt = new ArrayList<CoefMatiereDetail>();
			 CoefMatiereDetail cmatdlt= new CoefMatiereDetail(mat);
			 listcmdlt.add(cmatdlt);
		 }
		 result.setMatdetailList(listcmdlt);
   		}else{
   			for(CoefMatiereDetail mdlt : data.getMatdetailList()){
   			// listcmdlt = new ArrayList<CoefMatiereDetail>();
			 CoefMatiereDetail cmatdlt= new CoefMatiereDetail(mdlt);
			 listcmdlt.add(cmatdlt);
   			}
   		 result.setMatdetailList(listcmdlt);	
   		}
		
	   	
 	return result;
	// en fonction de lenumjour contruire l'objet Jours cours
	// et pour chaque jours cours construire les tranche horaire
   		
   	}

   	@Override
   	public List<CoefMatiere> findAll() {
   		// TODO Auto-generated method stub
   		List<CoefMatiere> datas = super.findAll();
   		List<CoefMatiere> result = new ArrayList<CoefMatiere>();
   		for(CoefMatiere elev:datas){
   			result.add(new CoefMatiere(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public CoefMatiere delete(Long id) {
   		// TODO Auto-generated method stub
   		CoefMatiere elev = super.delete(id);
   		return new CoefMatiere(elev);
   	}

	@Override
	public void processBeforeSave(CoefMatiere entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	

}
