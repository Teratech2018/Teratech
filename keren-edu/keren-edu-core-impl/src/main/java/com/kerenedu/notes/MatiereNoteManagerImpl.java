
package com.kerenedu.notes;

import java.util.ArrayList;
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
import com.kerenedu.configuration.Appreciation;
import com.kerenedu.configuration.AppreciationDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.PeriodeScolaire;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "MatiereNoteManager")
public class MatiereNoteManagerImpl
    extends AbstractGenericManager<MatiereNote, Long>
    implements MatiereNoteManagerLocal, MatiereNoteManagerRemote
{

    @EJB(name = "MatiereNoteDAO")
    protected MatiereNoteDAOLocal dao;
    
    @EJB(name = "AppreciationDAO")
    protected AppreciationDAOLocal daoapp;

    public MatiereNoteManagerImpl() {
    }

    @Override
    public GenericDAO<MatiereNote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
   	public List<MatiereNote> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	PeriodeScolaire periode = CacheMemory.getPeriode();
    	Classe classe = CacheMemory.getClasse();
    	Examen examen = CacheMemory.getExamen();
    	Professeur prof = CacheMemory.getProf();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(periode!=null){
			container.addEq("examen.id", examen.getId());
		}//end if(periode!=null)
		if(classe!=null){
			container.addEq("classe.id", classe.getId());
		}//end if(classe!=null)
		if(prof!=null){
			container.addEq("prof.id", prof.getId());
		}//end if(classe!=null)
		predicats.addAll(container.getPredicats());
   		List<MatiereNote> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<MatiereNote> result = new ArrayList<MatiereNote>();
   		for(MatiereNote elev:datas){
   			result.add(new MatiereNote(elev));
   		}
   		return result;
   	}

   	@Override
   	public MatiereNote find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		MatiereNote note = super.find(propertyName, entityID);
   		MatiereNote data = new MatiereNote(note);
   		
   		for(NoteDetail detail : note.getNotelisttr()){
   			data.getNotelisttr().add(new NoteDetail(detail));
   		}
  
   	   return data;
   	}

   	@Override
   	public List<MatiereNote> findAll() {
   		// TODO Auto-generated method stub
   		List<MatiereNote> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public MatiereNote delete(Long id) {
   		// TODO Auto-generated method stub
   		MatiereNote elev = super.delete(id);
   		return new MatiereNote(elev);
   	}
   	
   	

	/* (non-Javadoc)
	 * @see com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager#processBeforeSave(java.lang.Object)
	 */
	@Override
	public void processBeforeSave(MatiereNote entity) {
		// appreciation 
		List<NoteDetail> notes = new ArrayList<NoteDetail>();
		
		for(NoteDetail not : entity.getNotelisttr()){
			not.setObs(this.getAppreciation(not));
			notes.add(not);
		}
		entity.setNotelisttr(notes);
		super.processBeforeSave(entity);
	}
	
	
	
	@Override
	public void processBeforeUpdate(MatiereNote entity) {
	List<NoteDetail> notes = new ArrayList<NoteDetail>();
		
		for(NoteDetail not : entity.getNotelisttr()){
			
			not.setObs(this.getAppreciation(not));
			notes.add(not);
		}
		entity.setNotelisttr(notes);
		super.processAfterUpdate(entity);
	}

	private String getAppreciation(NoteDetail note){
		String app= " default";
		Appreciation value = daoapp.getAppreciation(note);
		if(value!=null){
			app = value.getLibelle();
		}else{
			app= "Default";
		}
		return app;
	}

}
