
package com.kerenedu.solde;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.tools.DateHelper;
import com.google.gson.Gson;
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
@Path("/acompte")
public class AcompteRSImpl
    extends AbstractGenericService<Acompte, Long>
    implements AcompteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
    protected AcompteManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote periodemanager;
    
    @Manager(application = "kereneducation", name = "RubriquePaieManagerImpl", interf = RubriquePaieManagerRemote.class)
    protected RubriquePaieManagerRemote managerrubrique;
    

    public AcompteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Acompte, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {

            MetaData meta = MetaDataUtil.getMetaData(new Acompte(), new HashMap<String, MetaData>(),new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'acompte','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            workbtn.setRoles(new String[]{"Administrateur"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Payer", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'acompte','method':'paye'}");
            workbtn.setStates(new String[]{"confirme"});
            workbtn.setRoles(new String[]{"Administrateur"});
            workbtn.setPattern("btn btn-primary");
            //meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'acompte','method':'annule'}");
            workbtn.setStates(new String[]{"confirme"});
            workbtn.setRoles(new String[]{"Administrateur"});
            workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);	        
            workbtn = new MetaColumn("button", "work2", "Fiche Acompte", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'acompte','method':'pdf'}");
			workbtn.setStates(new String[] { "paye","confirme" });
			workbtn.setRoles(new String[]{"Administrateur"});
			meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;

        } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void processBeforeDelete(Object entity) {

        // TODO Auto-generated method stub
        super.processBeforeDelete(entity);
    }

    @Override
    protected void processBeforeSave(Acompte entity) {
    	
    	// set rubrique acompte
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	 PeriodePaie periode = periodeChecker(entity);
		container.addEq("acompte",true);
		List<RubriquePaie> rubrique = managerrubrique.filter(container.getPredicats(), null, null, 0, -1);
		if(rubrique!=null&&!rubrique.isEmpty()){
			entity.setRubrique(rubrique.get(0));
		}
		if(entity.getMontant()<=0){
			  throw new KerenExecption("OPERATION IMPOSSIBLE: Montant erronée ");
		}
		// controle montant acompte 
		if(manager.disponible(entity,periode)==false){
			 throw new KerenExecption("OPERATION IMPOSSIBLE : ce salarié à dépassé sont quota d'acompte du mois ");
		}
		if(periode.getState().equals("ferme")){
			  throw new KerenExecption("Periode concernées plus disponible ");
		}
    	entity.setState("confirme");
        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }if(entity.getState()!=null&&entity.getState().equalsIgnoreCase("paye")){
			throw new KerenExecption("OPERATION IMPOSIBLE: Remboursement déjà pris en compte !!!");
		}
//        else if(entity.getEffet().compareTo(new Date())<0){
//            throw new KerenExecption("La date de l'acompte ne peut etre inferieure &agrave; la date du jour");
//        }
       
        entity.setAnneScolaire(periode.getExercice().getCode());

        super.processBeforeSave(entity);
    }
    
    

    @Override
    protected void processBeforeUpdate(Acompte entity) {

        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }else if(entity.getEffet().before(new Date())){
            throw new KerenExecption("Impossible de modifier");
        }if(entity.getState()!=null&&entity.getState().equalsIgnoreCase("paye")){
			throw new KerenExecption("OPERATION IMPOSIBLE: Remboursement déjà pris en compte !!!");
		}
//        else if(!entity.getState().equalsIgnoreCase("paye")){
//            throw new KerenExecption("Cette Acompte est déjà confirmée , Payée ou Annulée");
//        }

        super.processBeforeUpdate(entity);
    }

    @Override
    public Acompte confirme(HttpHeaders headers, Acompte entity) {

        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }else if(!entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Cette Acompte est déjà confirmée , Payée ou Annulée");
        }
        PeriodePaie periode = periodeChecker(entity);
        return manager.confirme(entity);
    }

    @Override
    public Acompte paye(HttpHeaders headers, Acompte entity) {

        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Veuillez confirmer cette Acompte");
        }else if(!entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Cette Acompte est déjà Payée ou Annulée");
        }

        PeriodePaie periode = periodeChecker(entity);

        return manager.paye(entity, periode);
    }

    @Override
    public Acompte annule(HttpHeaders headers, Acompte entity) {

        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("paye")){
                throw new KerenExecption("Acompte déjà Payée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Acompte déjà Annulée");
        }

        return manager.annule(entity);
    }


    /**
     * Permete de verifier que ;
     * il exites une periode ouvert contenant la date
     *  du remboursement en cours
     * @param entity
     */
    private PeriodePaie periodeChecker(Acompte entity){

          PeriodePaie periode = periodemanager.getPeriodeFromDate(entity.getEffet());

          if(periode==null){
                  throw new KerenExecption("Impossible de trouver une période contenant cette date");
          }else if(periode.getState().equalsIgnoreCase("etabli")){
                  throw new KerenExecption("La periode "+periode.getDesignation()+" n'est pas ouverte <br/> Veuillez ouvrir la periode");
          }else if(periode.getState().equalsIgnoreCase("ferme")){
                  throw new KerenExecption("La période "+periode.getDesignation()+" est déjà fermée");
          }
          return periode;
    }

    @Override
    public Acompte delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        Acompte entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
    
    @Override
   	public Response buildPdfReport(Acompte entity) {
   		try {
   			// convertir en lettre
   			RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);

   			BigDecimal bd = new BigDecimal(entity.getMontant());
   			bd = bd.setScale(0, BigDecimal.ROUND_UP);
   			Double netarond = bd.doubleValue();
   			String mntEnlettre = rbnf.format(netarond);
   			entity.setMntLettre(mntEnlettre);
 
   			String URL = ReportHelper.templatepaieURL + ReportsName.FICHE_ACOMPTE.getName();
   			List<Acompte> records = new ArrayList<Acompte>();
   			records.add(entity);
   			if (records.isEmpty() || records.size() == 0) {
   				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionné un eleve !!!");
   			}
   			Map parameters = this.getReportParameters();
   			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
   		} catch (FileNotFoundException ex) {
   			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
   			Response.serverError().build();
   		} catch (JRException ex) {
   			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
   		}

   		return Response.noContent().build();
   	}
    
	/**
	 * Methode permettant de retourner les parametres pour le reporting
	 *
	 * @return java.util.Map
	 */
	public Map getReportParameters() {
		Map param = ReportHelperTrt.getReportParametersSolde();

		return param;
	}

	@Override
	public Response buildPdfReportbi(Acompte entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

	@Override
	public List<Acompte> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		System.out.println("AcompteRSImpl.filter() je suis ici ==");
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		PeriodePaie periode = (PeriodePaie) CacheMemory.getValue(id, TypeCacheMemory.PERIODE);
		
		if (periode != null) {
			container.addGe("effet",DateHelper.formatDate(periode.getDdebut()));
			container.addLe("effet",DateHelper.formatDate(periode.getDfin()));
		} // end if(classe!=null)
		container.addNotEq("state", "annule");	
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	
	
}
