
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Apr 13 22:06:46 WAT 2018
 * 
 */
@Path("/traitnote")
public class TraitNoteRSImpl
    extends AbstractGenericService<TraitNote, Long>
    implements TraitNoteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "TraitNoteManagerImpl", interf = TraitNoteManagerRemote.class)
    protected TraitNoteManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
    protected CoefMatiereDetailManagerRemote managerMatiere;
    
    @Manager(application = "kereneducation", name = "MatiereNoteManagerImpl", interf = MatiereNoteManagerRemote.class)
    protected MatiereNoteManagerRemote managerNote;
    
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
    protected InscriptionManagerRemote managerEleve;

    public TraitNoteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitNote, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new TraitNote(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(TraitNoteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TraitNoteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public TraitNote update(Long id, TraitNote entity) {
    	CacheMemory.setPeriode(entity.getPeriode().getPeriode());
    	CacheMemory.setFiliere(entity.getClasse().getFiliere());
    	CacheMemory.setClasse(entity.getClasse());
    	CacheMemory.setExamen(entity.getPeriode());
        return entity; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TraitNote save(TraitNote entity) {
        //To change body of generated methods, choose Tools | Templates.
    	CacheMemory.setPeriode(entity.getPeriode().getPeriode());
    	CacheMemory.setFiliere(entity.getClasse().getFiliere());
    	CacheMemory.setClasse(entity.getClasse());
    	CacheMemory.setExamen(entity.getPeriode());
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	List<MatiereNote> datas = new ArrayList<MatiereNote>();
		if(entity.getPeriode()!=null){
			container.addEq("examen.id", entity.getPeriode().getId());
		}//end if(periode!=null)
		if(entity.getClasse()!=null){
			container.addEq("classe.id", entity.getClasse().getId());
		}//end if(classe!=null)
		List<MatiereNote> results = managerNote.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(results==null||results.isEmpty()||results.size()==0){
			// recherche de la liste des matiere de la classe
			container = RestrictionsContainer.newInstance();
			if(entity.getClasse()!=null){
				container.addEq("classe.id", entity.getClasse().getId());
			}//end if(classe!=null)
			List<CoefMatiereDetail> listMatieres = managerMatiere.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			// recherche des etudiants de la classe
			container = RestrictionsContainer.newInstance();
			if(entity.getClasse()!=null){
				container.addEq("classe.id", entity.getClasse().getId());
			}//end if(classe!=null)
			List<Inscription> eleves = managerEleve.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			if(listMatieres!=null&&eleves!=null){
				for(CoefMatiereDetail mt:listMatieres){
	   	   			MatiereNote mtrt = new MatiereNote(mt,entity.getPeriode(),eleves);
	   	   			mtrt.setId(-1);
	   	   			managerNote.save(mtrt);
	   	   		}
			}else{
				throw new KerenExecption("ERROR: Aucun élève dans cette classe!!!!");
			}
			
		}
    	
    	
        return entity; 
    }

	@Override
	public List<CoefMatiereDetail> findprofclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		System.out.println("TraitNoteRSImpl.findprofclasse() je suis ici  id de la classe"+id);
		return managerMatiere.findprofclasse(id);
	}

}
