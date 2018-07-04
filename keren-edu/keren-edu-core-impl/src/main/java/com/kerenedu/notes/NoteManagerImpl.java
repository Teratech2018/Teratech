
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
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDAOLocal;
import com.kerenedu.configuration.PeriodeScolaire;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.school.EleveDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "NoteManager")
public class NoteManagerImpl
    extends AbstractGenericManager<Note, Long>
    implements NoteManagerLocal, NoteManagerRemote
{

    @EJB(name = "NoteDAO")
    protected NoteDAOLocal dao;
    
    @EJB(name = "MatiereDAO")
    protected MatiereDAOLocal matieredao;
    
    @EJB(name = "EleveDAO")
    protected EleveDAOLocal elevedao;
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal inscriptiondao;

    public NoteManagerImpl() {
    }

    @Override
    public GenericDAO<Note, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Note> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	PeriodeScolaire periode = CacheMemory.getPeriode();
    	Classe classe = CacheMemory.getClasse();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(periode!=null){
			container.addEq("examen.periode", periode);
		}//end if(periode!=null)
		if(classe!=null){
			container.addEq("classe", classe);
		}//end if(classe!=null)
		predicats.addAll(container.getPredicats());
   		List<Note> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Note> result = new ArrayList<Note>();
   		for(Note elev:datas){
   			result.add(new Note(elev));
   		}
   		return result;
   	}

   	@Override
   	public Note find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Note note = super.find(propertyName, entityID);
   		Note data = new Note(note);
   		
   		
   		
   	 RestrictionsContainer container = RestrictionsContainer.newInstance();
	 container.addEq("filiere.code", data.getClasse().getFiliere().getCode());
	 List<Matiere> lisyMatiere = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
	 List<MatiereNote> listMatNot = new ArrayList<MatiereNote>();
	 List<NoteDetail> listnotdlt= new ArrayList<NoteDetail>();
	 container = RestrictionsContainer.newInstance();
	 container.addEq("classe", data.getClasse());
	 List<Inscription> listeleve = inscriptiondao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
  		if(note.getMatierelisttr()==null||note.getMatierelisttr().isEmpty()){
   			for(Matiere mt:lisyMatiere){
   	   		//	MatiereNote mtrt = new MatiereNote(mt,listeleve);
   	   		//	data.getMatierelisttr().add(mtrt);
   	   		}
   		}else{
   			System.out.println("NoteManagerImpl.find() taile note detail list"+note.getMatierelisttr().size());
   			for(MatiereNote mdlt : note.getMatierelisttr()){
   				MatiereNote cmatdlt= new MatiereNote(mdlt);
   				listnotdlt= new ArrayList<NoteDetail>();
   				for(NoteDetail nd :mdlt.getNotelisttr()){
   					listnotdlt.add(new NoteDetail(nd));
   				}
   				cmatdlt.setNotelisttr(listnotdlt);
   				listMatNot.add(cmatdlt);
   	   			}
   			data.setMatierelisttr(listMatNot);
   		}
  
   	   return data;
   	}

   	@Override
   	public List<Note> findAll() {
   		// TODO Auto-generated method stub
   		List<Note> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Note delete(Long id) {
   		// TODO Auto-generated method stub
   		Note elev = super.delete(id);
   		return new Note(elev);
   	}

	/* (non-Javadoc)
	 * @see com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager#processBeforeSave(java.lang.Object)
	 */
	@Override
	public void processBeforeSave(Note entity) {
		List<MatiereNote> listmat = entity.getMatierelisttr();
		
		super.processBeforeSave(entity);
	}


}
