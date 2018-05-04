
package com.keren.jaxrs.impl.presences;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.presences.FichePointageManagerRemote;
import com.keren.core.ifaces.presences.PointageJouranlierManagerRemote;
import com.keren.jaxrs.ifaces.presences.PointageJouranlierRS;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.presences.FichePointage;
import com.keren.model.presences.LigneFichePointage;
import com.keren.model.presences.LignePointage;
import com.keren.model.presences.PointageJouranlier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
@Path("/pointagejouranlier")
public class PointageJouranlierRSImpl
    extends AbstractGenericService<PointageJouranlier, Long>
    implements PointageJouranlierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "PointageJouranlierManagerImpl", interf = PointageJouranlierManagerRemote.class)
    protected PointageJouranlierManagerRemote manager;
    
    @Manager(application = "kerenrh", name = "FichePointageManagerImpl", interf = FichePointageManagerRemote.class)
    protected FichePointageManagerRemote fichemanager;
    

    public PointageJouranlierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PointageJouranlier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
   
    
	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		 try {
				MetaData meta = MetaDataUtil.getMetaData(new PointageJouranlier(),new HashMap<String, MetaData>()
						, new ArrayList<String>());
				MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
				workbtn.setStates(new String[]{"etabli"});
				workbtn.setValue("{'model':'kerenrh','entity':'pointagejouranlier','method':'confirme'}");
				meta.getHeader().add(workbtn);
				MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
				meta.getHeader().add(stautsbar);
				return meta;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new WebApplicationException(e);
			}
	}
	
	

	@Override
	protected void processBeforeSave(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("L'intitulé est obligatoire");
		}else if(entity.getDatepointage()==null){
			throw new KerenExecption("La date de la feuille de pointage est obligatoire");
		}else if(entity.getFiche()==null){
			throw new KerenExecption("La fiche de pointage est obligatoire");
		}
		super.processBeforeSave(entity);
	}
	
	

	@Override
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		PointageJouranlier entity = manager.find("id", (Long) id);
		if(entity.getState().equalsIgnoreCase("confirmer")){
			throw new KerenExecption("Le Pointage journalier est deja valide");
		}//end if(entity.getState().equalsIgnoreCase("valide")){
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeUpdate(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("L'intitulé est obligatoire");
		}else if(entity.getDatepointage()==null){
			throw new KerenExecption("La date de la feuille de pointage est obligatoire");
		}else if(entity.getFiche()==null){
			throw new KerenExecption("La fiche de pointage est obligatoire");
		}else if(entity.getState().equalsIgnoreCase("confirmer")){
			throw new KerenExecption("Pointage journalier deéjà confirmé");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public PointageJouranlier confirmer(HttpHeaders headers, PointageJouranlier entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("L'intitulé est obligatoire");
		}else if(entity.getDatepointage()==null){
			throw new KerenExecption("La date de la feuille de pointage est obligatoire");
		}else if(entity.getFiche()==null){
			throw new KerenExecption("La fiche de pointage est obligatoire");
		}else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
			throw new KerenExecption("Veuillez saisir au moins une ligne de pointage");
		}
		return manager.confirmer(entity);
	}

	@Override
	public List<LignePointage> presences(HttpHeaders headers) {
		// TODO Auto-generated method stub
		List<LignePointage> datas = new ArrayList<LignePointage>();
//		System.out.println(PointageJouranlierRSImpl.class.toString()+" ==================== "+headers.getRequestHeader("id")+" ======= "+headers.getRequestHeader("datepointage"));
		Gson gson = new Gson();
		Long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		if(id==null||id<0){
			return datas;
		}//end if(id==null||id<0){
//		Date date = gson.fromJson(headers.getRequestHeader("datepointage").get(0), Date.class);
//		//Construction des pointages
//		if(date==null){
//			throw new KerenExecption("Veuillez saisir la date de la feuille de presence");
//		}//end if(date==null){
		//Chargement de la fiche de pointae
		FichePointage fiche = fichemanager.find("id", id);
		
		//Construction des lignes
		for(LigneFichePointage ligne:fiche.getLignes()){
			datas.add(new LignePointage(ligne));
		}//end for(LigneFichePointage ligne:fiche.getLignes()){
		return datas;
	}

}
