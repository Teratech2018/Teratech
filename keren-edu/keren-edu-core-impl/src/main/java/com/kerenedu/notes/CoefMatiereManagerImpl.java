
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
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
    
    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal coefDltdao;
    
    @EJB(name = "MatiereDAO")
    protected MatiereDAOLocal matieredao;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal classedao;
    

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

	
	

	public List<CoefMatiereDetail> findMatiereFiliere(Long id) {
		System.out.println(CoefMatiereManagerImpl.class.toString()+" ========================================== "+id);
		List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>() ;
		 List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(id>0){
			container = RestrictionsContainer.newInstance();
			container.addEq("id",id);
			Classe classe = classedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			 container.addEq("classe.id",id);
			 result = coefDltdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 
			if(result==null||result.isEmpty()||result.size()==0){
				container = RestrictionsContainer.newInstance();
				 container.addEq("filiere.id",classe.getFiliere().getId());
				 List<Matiere> lisyMatiere = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				 long index = 1 ;
				 for(Matiere mat:lisyMatiere){
					// listcmdlt = new ArrayList<CoefMatiereDetail>();
					 CoefMatiereDetail cmatdlt= new CoefMatiereDetail(mat);	
					 cmatdlt.setId(-index);					 
					 datas.add(cmatdlt);
					 index++;
				 }
			}else{
				for(CoefMatiereDetail mftl : result){
					datas.add(new CoefMatiereDetail(mftl));
				}
			} // end if(result==null||result.isEmpty())

		}//end if(id!=-1){
		return datas;
	}
   	

}
