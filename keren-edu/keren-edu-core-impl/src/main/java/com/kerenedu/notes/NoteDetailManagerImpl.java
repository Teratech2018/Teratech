
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
import com.kerenedu.discipline.LigneAbscence;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "NoteDetailManager")
public class NoteDetailManagerImpl
    extends AbstractGenericManager<NoteDetail, Long>
    implements NoteDetailManagerLocal, NoteDetailManagerRemote
{

    @EJB(name = "NoteDetailDAO")
    protected NoteDetailDAOLocal dao;
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal daoClasse;

    public NoteDetailManagerImpl() {
    }

    @Override
    public GenericDAO<NoteDetail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<NoteDetail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<NoteDetail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<NoteDetail> result = new ArrayList<NoteDetail>();
   		for(NoteDetail elev:datas){
   			result.add(new NoteDetail(elev));
   		}
   		return result;
   	}

   	@Override
   	public NoteDetail find(String propertyName, Long entityID) {
   
   		NoteDetail elev = super.find(propertyName, entityID);
   		NoteDetail data = new NoteDetail(elev);
   		return data;
   	}

   	@Override
   	public List<NoteDetail> findAll() {

   		List<NoteDetail> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	
   	
   	@Override
   	public NoteDetail delete(Long id) {
   		NoteDetail elev = super.delete(id);
   		return new NoteDetail(elev);
   	}

	@Override
	public void importNote(List<NoteDetail> notelist, MatiereNote matiere) {
	
		
	}

	@Override
	public List<NoteDetail> findeleve(long idclasse) {
		List<NoteDetail> results = new ArrayList<NoteDetail>();
		if(idclasse>0){
			Classe cls = daoClasse.findByPrimaryKey("id", idclasse);
			CacheMemory.setClasse(cls);
			RestrictionsContainer container = RestrictionsContainer.newInstance();
	   		 container.addEq("classe", cls.getId());
	   		 List<Inscription>records = daoIns.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
	   		 int index =0;
	   		 for(Inscription ins :records){
	   			NoteDetail lgnsbs= new NoteDetail(ins);
	   			 lgnsbs.setId(-index);
	   			 results.add(lgnsbs);
	   			index ++;
	   		 }
		}
		return results;
	}

	@Override
	public long updateforce(ImportNoteClasse entity) {
		// TODO Auto-generated method stub
		return dao.updateforce(entity);
	}




   	
   	
   	


}
