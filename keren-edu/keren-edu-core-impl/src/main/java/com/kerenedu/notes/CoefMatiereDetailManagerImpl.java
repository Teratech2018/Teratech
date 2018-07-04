
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDAOLocal;
import com.kerenedu.configuration.MatiereDlt;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CoefMatiereDetailManager")
public class CoefMatiereDetailManagerImpl
    extends AbstractGenericManager<CoefMatiereDetail, Long>
    implements CoefMatiereDetailManagerLocal, CoefMatiereDetailManagerRemote
{

    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal dao;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal classedao;
    
    @EJB(name = "MatiereDAO")
    protected MatiereDAOLocal matieredao;

    public CoefMatiereDetailManagerImpl() {
    }

    @Override
    public GenericDAO<CoefMatiereDetail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<CoefMatiereDetail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	Classe classe = CacheMemory.getClasse();

    	RestrictionsContainer container = RestrictionsContainer.newInstance();
		
    	if(classe!=null){
    		 container.addEq("classe.id", classe.getId());
    	}
    	System.out.println("TrancheHoraireCoursManagerImpl.filter() classe memory "+classe.getId());
    	predicats.addAll(container.getPredicats());
   		List<CoefMatiereDetail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
   		for(CoefMatiereDetail elev:datas){
   			result.add(new CoefMatiereDetail(elev));
   		}
   		return result;
   	}

   	@Override
   	public CoefMatiereDetail find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		CoefMatiereDetail elev = super.find(propertyName, entityID);
   		CoefMatiereDetail data = new CoefMatiereDetail(elev);
   		return data;
   	}

   	@Override
   	public List<CoefMatiereDetail> findAll() {
   		// TODO Auto-generated method stub
   		List<CoefMatiereDetail> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public CoefMatiereDetail delete(Long id) {
   		// TODO Auto-generated method stub
   		CoefMatiereDetail elev = super.delete(id);
   		return new CoefMatiereDetail(elev);
   	}

   	public List<CoefMatiereDetail> findMatiereFiliere(Long id) {
		System.out.println(CoefMatiereManagerImpl.class.toString()+" ========================================== "+id);
		List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>() ;
		 List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(id>0){
			// recherche l'objet classe
			// verifier si existe dejà
			container = RestrictionsContainer.newInstance();
			container.addEq("id",id);
			Classe classe = classedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			 container.addEq("classe.id",id);
			 result = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 
			if(result==null||result.isEmpty()||result.size()==0){
				container = RestrictionsContainer.newInstance();
				 container.addEq("filiere.id",classe.getFiliere().getId());
				 List<Matiere> matieres = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				 long index = 1 ;
				List<MatiereDlt> lisyMatiere = matieres.get(0).getMatieres();
				 for(MatiereDlt mat:lisyMatiere){
					// listcmdlt = new ArrayList<CoefMatiereDetail>();
					 CoefMatiereDetail cmatdlt= new CoefMatiereDetail(mat);	
					 cmatdlt.setId(-index);					 
					 datas.add(cmatdlt);
					 index++;
				 }
			}else{
				System.out.println("CoefMatiereManagerImpl.findMatiereFiliere() size is "+result.size());
				for(CoefMatiereDetail mftl : result){
					datas.add(new CoefMatiereDetail(mftl));
				}
			} // end if(result==null||result.isEmpty())

		}//end if(id!=-1){
		return datas;
	}

	public List<CoefMatiereDetail> findprofclasse(Long id) {
		 List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 System.out.println("CoefMatiereDetailManagerImpl.findprofclasse() classe id"+id);
		if(id>0){
			 container = RestrictionsContainer.newInstance();
			 container.addEq("classe.id",id);
			 datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 System.out.println("CoefMatiereDetailManagerImpl.findprofclasse() prof classe is  is "+datas.size());
		}
		return datas;
	}
}
