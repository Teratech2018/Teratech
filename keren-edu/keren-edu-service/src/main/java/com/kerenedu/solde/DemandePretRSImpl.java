
package com.kerenedu.solde;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
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
@Path("/demandepret")
public class DemandePretRSImpl
    extends AbstractGenericService<DemandePret, Long>
    implements DemandePretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "DemandePretManagerImpl", interf = DemandePretManagerRemote.class)
    protected DemandePretManagerRemote manager;
	@Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
	protected AnneScolaireManagerRemote managerAnnee;

    public DemandePretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandePret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                MetaData meta = MetaDataUtil.getMetaData(new DemandePret(), new HashMap<String, MetaData>(),new ArrayList<String>());
                MetaColumn workbtn = new MetaColumn("button", "work1", "G&eacute;n&eacute;rer les reglements", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'echeancier','critical':true,'alert':'&ecirc;tes vous sur de vouloir continuer ?'}");
                workbtn.setStates(new String[]{"confirme"});
                workbtn.setRoles(new String[]{"Administrateur"});
                workbtn.setPattern("btn btn-info");
                meta.getHeader().add(workbtn);
                workbtn = new MetaColumn("button", "work2", "Confirmer", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'confirme','critical':true,'alert':'&ecirc;tes vous sur de vouloir continuer ?'}");
                workbtn.setStates(new String[]{"etabli"});
                workbtn.setRoles(new String[]{"Administrateur"});
                workbtn.setPattern("btn btn-success");
                meta.getHeader().add(workbtn);
                workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'annule','critical':true,'alert':'&ecirc;tes vous sur de vouloir continuer ?'}");
                workbtn.setStates(new String[]{"confirme"});
                workbtn.setRoles(new String[]{"Administrateur"});
                workbtn.setPattern("btn btn-danger");
                meta.getHeader().add(workbtn);	     
                 workbtn = new MetaColumn("button", "work2", "Fiche de Pr&ecirc;t", false, "report", null);
    			workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'pdf'}");
    			workbtn.setStates(new String[] { "confirme", "encours","paye","termine" });
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
    protected void processBeforeSave(DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Pr&ecirc;t est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salari&eacute;  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de d&eacute;but remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicit&eacute;  est obligatoire");
        }
//        }else if(entity.getMontantpro()==null){
//                throw new KerenExecption("Le montant propos&eacute;  est obligatoire");
//        }
        else if(entity.getDuree()==null){
                throw new KerenExecption("La dur&eacute;e du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotit&eacute; cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; confirm&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; confirm&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; termin&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; annul&eacute;e");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure &agrave; la date de remboursement");
        }else if(entity.getDrembour().before(new Date())){
        	  throw new KerenExecption("La date du pret ne peut etre inferieure &agrave; la date du jour");
        }
        // verifier si l'employ&eacute; n'a pas dej&agrave; un autre pret encours
        RestrictionsContainer container = RestrictionsContainer.newInstance();
//        container.addEq("employe.id", entity.getEmploye().getId());
//        container.addNotEq("state", "termine");
//        container.addNotEq("state", "annule");
//        List<DemandePret> listpret = manager.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
//        if(listpret!=null&&!listpret.isEmpty()&&listpret.size()!=0){
//        	 throw new KerenExecption("	OPPERATION IMPOSSIBLE : Cet employe &agrave; dej&agrave; un Pr&ecirc;t encours !!!");
//        }
        
        
        container = RestrictionsContainer.newInstance();
		container.addEq("connected", true);
		List<AnneScolaire> annee = managerAnnee.filter(container.getPredicats(), null, null, 0, -1);
		if (annee == null || annee.size() == 0) {
			throw new KerenExecption("TRAITEMENt IMPOSSIBLE ::: Aucune Ann&eacute;e Scolaire disponible !!!");
		}
        //On set l'etat initial
        entity.setState("confirme");

        if(entity.getDpret()==null){
        	entity.setDpret(new Date());
        }
        if(entity.getMontantpro()==null){
        	entity.setMontantpro(entity.getMontantsol());
        	entity.setSolde(entity.getMontantpro());
        	entity.setMontantRem(entity.getMontantpro()-entity.getSolde());
        }

		entity.setAnneScolaire(annee.get(0).getCode());
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Pr&ecirc;t est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salari&eacute;  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Pr&ecirc;t  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de d&eacute;but remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicit&eacute;  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant propos&eacute;  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La dur&eacute;e du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotit&eacute; cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; confirm&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; confirm&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; termin&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; annul&eacute;e");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure &agrave; la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant propos&eacute;, ne peut etre sup&eacute;rieur au montant sollicit&eacute;");
        }

        super.processBeforeUpdate(entity);
    }

    @Override
    public DemandePret generereglements(HttpHeaders headers, DemandePret entity) {
       
        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Pr&ecirc;t est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salari&eacute;  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Pr&ecirc;t  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de d&eacute;but remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicit&eacute;  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant propos&eacute;  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La dur&eacute;e du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotit&eacute; cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; termin&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; annul&eacute;e");
        }else if(entity.getRemboursements() !=null &&!entity.getRemboursements().isEmpty()){
                throw new KerenExecption("Des ech&eacute;ances sont d&eacute;j&agrave; g&eacute;n&eacute;r&eacute;s pour cette demande");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant propos&eacute;, ne peut etre sup&eacute;rieur au montant sollicit&eacute;");
        }

        return manager.generereglements(entity);
    }

    @Override
    public DemandePret confirme(HttpHeaders headers, DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Pr&ecirc;t est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salari&eacute;  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Pr&ecirc;t  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de d&eacute;but remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicit&eacute;  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant propos&eacute;  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La dur&eacute;e du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotit&eacute; cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("La demande de Pr&ecirc;t est d&eacute;j&agrave; confirm&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; termin&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; annul&eacute;e");
        }else if(entity.getRemboursements()==null||entity.getRemboursements().isEmpty()){
                throw new KerenExecption("Veuillez g&eacute;n&eacute;rer les remboursements");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pr&ecirc;t ne peut &ecirc;tre sup&egrave;rieure &agrave; la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant propos&eacute;, ne peut etre sup&egrave;rieur au montant sollicit&eacute;");
        }

        return manager.confirme(entity);
    }

    @Override
    public DemandePret annule(HttpHeaders headers, DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Pr&ecirc;t est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salari&eacute;  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Pr&ecirc;t  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de d&eacute;but remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicit&eacute;  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant propos&eacute;  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La dur&eacute;e du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotit&eacute; cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; termin&eacute;e");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Pr&ecirc;t d&eacute;j&agrave; annul&eacute;e");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure &agrave; la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant propos&eacute;, ne peut etre sup&egrave;rieur au montant sollicit&eacute;");
        }

        return manager.annule(entity);
    }
    
    @Override
    public DemandePret delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        DemandePret entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est d&eacute;j&agrave; en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
    
    @Override
	public List<DemandePret> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		container.addNotEq("state", "annule");	
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
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
	public Response buildPdfReport(DemandePret entity) {
		try {
			// convertir en lettre
			RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);

			BigDecimal bd = new BigDecimal(entity.getMontantsol());
			bd = bd.setScale(0, BigDecimal.ROUND_UP);
			Double netarond = bd.doubleValue();
			String mntEnlettre = rbnf.format(netarond);
			entity.setMntLettre(mntEnlettre);
		//	System.out.println("DemandePretRSImpl.buildPdfReport() remboursement "+entity.getRemboursements().size());
			String URL = ReportHelper.templatepaieURL + ReportsName.FICHE_PRET.getName();
			List<DemandePret> records = new ArrayList<DemandePret>();
			records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("TRAITEMENt IMPOSIBLE ::: Bien vouloir Selectionn&eacute; un el&egrave;ve !!!");
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

	@Override
	public Response buildPdfReportbi(DemandePret entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}
}
