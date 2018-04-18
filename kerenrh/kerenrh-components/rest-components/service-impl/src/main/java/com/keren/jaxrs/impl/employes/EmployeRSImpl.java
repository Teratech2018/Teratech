
package com.keren.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.EmployeManagerRemote;
import com.keren.jaxrs.ifaces.employes.EmployeRS;
import com.keren.model.employes.Employe;
import com.keren.model.employes.Fonction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/employe")
public class EmployeRSImpl
    extends AbstractGenericService<Employe, Long>
    implements EmployeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EmployeManagerImpl", interf = EmployeManagerRemote.class)
    protected EmployeManagerRemote manager;

    public EmployeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Employe, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            // TODO Auto-generated method stub
            try {
                    return MetaDataUtil.getMetaData(new Employe(),new HashMap<String, MetaData>()
                                    , new ArrayList<String>());
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    throw new WebApplicationException(e);
            }
    }

}
/*
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		MetaData meta = null;
   		try {
   			meta = MetaDataUtil.getMetaData(new Employe(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'employe','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'employe','method':'annule'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
   	        meta.getHeader().add(workbtn);   
   	        MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
   	        meta.getHeader().add(stautsbar);
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return meta;
   	}

	@Override
	protected void processBeforeDelete(Object id) {
        Employe entity = manager.find("id", (Long)id);
        if(!entity.getState().trim().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Cette Employe a deja fait l'objet d'un traitement");
        }
        super.processBeforeDelete(id); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected void processBeforeUpdate(Employe entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Employe est obligatoire");
            }else if(entity.getImage;()==null||entity.getImage;().trim().isEmpty()){
                throw new KerenExecption("La Photo est obligatoire");
            }else if(entity.getHandicape()==null){
                throw new KerenExecption("La Handicapé(e)? est obligatoire");
            }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
                throw new KerenExecption("La Nom  est obligatoire");
            }else if(entity.getMatricule()==null||entity.getMatricule().trim().isEmpty()){
                throw new KerenExecption("La Matricule est obligatoire");
            }else if(entity.getGenre()==null||entity.getGenre().trim().isEmpty()){
                throw new KerenExecption("La Genre est obligatoire");
            }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
                throw new KerenExecption("La Statut est obligatoire");
            }else if(entity.getDipe;()==null||entity.getDipe;().trim().isEmpty()){
                throw new KerenExecption("La N. Dipe) est obligatoire");
            }else if(entity.getCategorie()==null){
                throw new KerenExecption("La Catégories  est obligatoire");
            }else if(entity.getEchelon()==null){
                throw new KerenExecption("La Echelon  est obligatoire");
            }else if(entity.getNumsec()==null||entity.getNumsec().trim().isEmpty()){
                throw new KerenExecption("La N. d'assurance social est obligatoire");
            }else if(entity.getNationalite()==null){
                throw new KerenExecption("La Nationalité est obligatoire");
            }else if(entity.getContribuable()==null||entity.getContribuable().trim().isEmpty()){
                throw new KerenExecption("La N. contribuable est obligatoire");
            }else if(entity.getCni()==null||entity.getCni().trim().isEmpty()){
                throw new KerenExecption("La N. CNI est obligatoire");
            }else if(entity.getDatedelivrance()==null){
                throw new KerenExecption("La Date de délivrance est obligatoire");
            }else if(entity.getLieudelivrance()==null||entity.getLieudelivrance().trim().isEmpty()){
                throw new KerenExecption("La Lieu de délivrance est obligatoire");
            }else if(entity.getEtatcivil()==null||entity.getEtatcivil().trim().isEmpty()){
                throw new KerenExecption("La Etat Civil est obligatoire");
            }else if(entity.getPasseport()==null||entity.getPasseport().trim().isEmpty()){
                throw new KerenExecption("La N. de passeport est obligatoire");
            }else if(entity.getNbreenfants()==null){
                throw new KerenExecption("La Nombre d'enfants est obligatoire");
            }else if(entity.getNaissance()==null){
                throw new KerenExecption("La Date de naissance est obligatoire");
            }else if(entity.getLieudenaiss()==null||entity.getLieudenaiss().trim().isEmpty()){
                throw new KerenExecption("La Lieu de naissance est obligatoire");
            }else if(entity.getAdresse1()==null||entity.getAdresse1().trim().isEmpty()){
                throw new KerenExecption("La Adresse 1 est obligatoire");
            }else if(entity.getAdresse2()==null||entity.getAdresse2().trim().isEmpty()){
                throw new KerenExecption("La Adresse 2 est obligatoire");
            }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
                throw new KerenExecption("La Téléphone est obligatoire");
            }else if(entity.getModile()==null||entity.getModile().trim().isEmpty()){
                throw new KerenExecption("La Portable est obligatoire");
            }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
                throw new KerenExecption("La Adresse électronique est obligatoire");
            }else if(entity.getRegion()==null){
                throw new KerenExecption("La Région d'origine est obligatoire");
            }else if(entity.getDepartementsoc()==null){
                throw new KerenExecption("La Département d'origine est obligatoire");
            }else if(entity.getStructure()==null){
                throw new KerenExecption("La Structure est obligatoire");
            }else if(entity.getPoste()==null){
                throw new KerenExecption("La Poste est obligatoire");
            }else if(entity.getDepartement()==null){
                throw new KerenExecption("La Département est obligatoire");
            }else if(entity.getLieuaffectation;()==null||entity.getLieuaffectation;().trim().isEmpty()){
                throw new KerenExecption("La Lieu d'affectation est obligatoire");
            }else if(entity.getLieurecrut;()==null||entity.getLieurecrut;().trim().isEmpty()){
                throw new KerenExecption("La Lieu de recrutement est obligatoire");
            }else if(entity.getFonction;()==null){
                throw new KerenExecption("La Fonction est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte salaire est obligatoire");
            }else if(entity.getNbrejours()==null){
                throw new KerenExecption("La Nombre de jours est obligatoire");
            }else if(entity.getComptesbancaire()==null||entity.getComptesbancaire().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un CompteBancaire");
            }else if(entity.getContrats()==null||entity.getContrats().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un ContratTravail");
            }else if(entity.getFamilles()==null||entity.getFamilles().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un Famille");
            }
            super.processBeforeUpdate(entity);
    }

	@Override
	protected void processBeforeSave(Employe entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Employe est obligatoire");
            }else if(entity.getImage;()==null||entity.getImage;().trim().isEmpty()){
                throw new KerenExecption("La Photo est obligatoire");
            }else if(entity.getHandicape()==null){
                throw new KerenExecption("La Handicapé(e)? est obligatoire");
            }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
                throw new KerenExecption("La Nom  est obligatoire");
            }else if(entity.getMatricule()==null||entity.getMatricule().trim().isEmpty()){
                throw new KerenExecption("La Matricule est obligatoire");
            }else if(entity.getGenre()==null||entity.getGenre().trim().isEmpty()){
                throw new KerenExecption("La Genre est obligatoire");
            }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
                throw new KerenExecption("La Statut est obligatoire");
            }else if(entity.getDipe;()==null||entity.getDipe;().trim().isEmpty()){
                throw new KerenExecption("La N. Dipe) est obligatoire");
            }else if(entity.getCategorie()==null){
                throw new KerenExecption("La Catégories  est obligatoire");
            }else if(entity.getEchelon()==null){
                throw new KerenExecption("La Echelon  est obligatoire");
            }else if(entity.getNumsec()==null||entity.getNumsec().trim().isEmpty()){
                throw new KerenExecption("La N. d'assurance social est obligatoire");
            }else if(entity.getNationalite()==null){
                throw new KerenExecption("La Nationalité est obligatoire");
            }else if(entity.getContribuable()==null||entity.getContribuable().trim().isEmpty()){
                throw new KerenExecption("La N. contribuable est obligatoire");
            }else if(entity.getCni()==null||entity.getCni().trim().isEmpty()){
                throw new KerenExecption("La N. CNI est obligatoire");
            }else if(entity.getDatedelivrance()==null){
                throw new KerenExecption("La Date de délivrance est obligatoire");
            }else if(entity.getLieudelivrance()==null||entity.getLieudelivrance().trim().isEmpty()){
                throw new KerenExecption("La Lieu de délivrance est obligatoire");
            }else if(entity.getEtatcivil()==null||entity.getEtatcivil().trim().isEmpty()){
                throw new KerenExecption("La Etat Civil est obligatoire");
            }else if(entity.getPasseport()==null||entity.getPasseport().trim().isEmpty()){
                throw new KerenExecption("La N. de passeport est obligatoire");
            }else if(entity.getNbreenfants()==null){
                throw new KerenExecption("La Nombre d'enfants est obligatoire");
            }else if(entity.getNaissance()==null){
                throw new KerenExecption("La Date de naissance est obligatoire");
            }else if(entity.getLieudenaiss()==null||entity.getLieudenaiss().trim().isEmpty()){
                throw new KerenExecption("La Lieu de naissance est obligatoire");
            }else if(entity.getAdresse1()==null||entity.getAdresse1().trim().isEmpty()){
                throw new KerenExecption("La Adresse 1 est obligatoire");
            }else if(entity.getAdresse2()==null||entity.getAdresse2().trim().isEmpty()){
                throw new KerenExecption("La Adresse 2 est obligatoire");
            }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
                throw new KerenExecption("La Téléphone est obligatoire");
            }else if(entity.getModile()==null||entity.getModile().trim().isEmpty()){
                throw new KerenExecption("La Portable est obligatoire");
            }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
                throw new KerenExecption("La Adresse électronique est obligatoire");
            }else if(entity.getRegion()==null){
                throw new KerenExecption("La Région d'origine est obligatoire");
            }else if(entity.getDepartementsoc()==null){
                throw new KerenExecption("La Département d'origine est obligatoire");
            }else if(entity.getStructure()==null){
                throw new KerenExecption("La Structure est obligatoire");
            }else if(entity.getPoste()==null){
                throw new KerenExecption("La Poste est obligatoire");
            }else if(entity.getDepartement()==null){
                throw new KerenExecption("La Département est obligatoire");
            }else if(entity.getLieuaffectation;()==null||entity.getLieuaffectation;().trim().isEmpty()){
                throw new KerenExecption("La Lieu d'affectation est obligatoire");
            }else if(entity.getLieurecrut;()==null||entity.getLieurecrut;().trim().isEmpty()){
                throw new KerenExecption("La Lieu de recrutement est obligatoire");
            }else if(entity.getFonction;()==null){
                throw new KerenExecption("La Fonction est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte salaire est obligatoire");
            }else if(entity.getNbrejours()==null){
                throw new KerenExecption("La Nombre de jours est obligatoire");
            }else if(entity.getComptesbancaire()==null||entity.getComptesbancaire().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un CompteBancaire");
            }else if(entity.getContrats()==null||entity.getContrats().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un ContratTravail");
            }else if(entity.getFamilles()==null||entity.getFamilles().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un Famille");
            }
            super.processBeforeSave(entity);
    }

	@Override
	public Employe valide(HttpHeaders headers, Employe entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Employe est obligatoire");
            }else if(entity.getImage;()==null||entity.getImage;().trim().isEmpty()){
                throw new KerenExecption("La Photo est obligatoire");
            }else if(entity.getHandicape()==null){
                throw new KerenExecption("La Handicapé(e)? est obligatoire");
            }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
                throw new KerenExecption("La Nom  est obligatoire");
            }else if(entity.getMatricule()==null||entity.getMatricule().trim().isEmpty()){
                throw new KerenExecption("La Matricule est obligatoire");
            }else if(entity.getGenre()==null||entity.getGenre().trim().isEmpty()){
                throw new KerenExecption("La Genre est obligatoire");
            }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
                throw new KerenExecption("La Statut est obligatoire");
            }else if(entity.getDipe;()==null||entity.getDipe;().trim().isEmpty()){
                throw new KerenExecption("La N. Dipe) est obligatoire");
            }else if(entity.getCategorie()==null){
                throw new KerenExecption("La Catégories  est obligatoire");
            }else if(entity.getEchelon()==null){
                throw new KerenExecption("La Echelon  est obligatoire");
            }else if(entity.getNumsec()==null||entity.getNumsec().trim().isEmpty()){
                throw new KerenExecption("La N. d'assurance social est obligatoire");
            }else if(entity.getNationalite()==null){
                throw new KerenExecption("La Nationalité est obligatoire");
            }else if(entity.getContribuable()==null||entity.getContribuable().trim().isEmpty()){
                throw new KerenExecption("La N. contribuable est obligatoire");
            }else if(entity.getCni()==null||entity.getCni().trim().isEmpty()){
                throw new KerenExecption("La N. CNI est obligatoire");
            }else if(entity.getDatedelivrance()==null){
                throw new KerenExecption("La Date de délivrance est obligatoire");
            }else if(entity.getLieudelivrance()==null||entity.getLieudelivrance().trim().isEmpty()){
                throw new KerenExecption("La Lieu de délivrance est obligatoire");
            }else if(entity.getEtatcivil()==null||entity.getEtatcivil().trim().isEmpty()){
                throw new KerenExecption("La Etat Civil est obligatoire");
            }else if(entity.getPasseport()==null||entity.getPasseport().trim().isEmpty()){
                throw new KerenExecption("La N. de passeport est obligatoire");
            }else if(entity.getNbreenfants()==null){
                throw new KerenExecption("La Nombre d'enfants est obligatoire");
            }else if(entity.getNaissance()==null){
                throw new KerenExecption("La Date de naissance est obligatoire");
            }else if(entity.getLieudenaiss()==null||entity.getLieudenaiss().trim().isEmpty()){
                throw new KerenExecption("La Lieu de naissance est obligatoire");
            }else if(entity.getAdresse1()==null||entity.getAdresse1().trim().isEmpty()){
                throw new KerenExecption("La Adresse 1 est obligatoire");
            }else if(entity.getAdresse2()==null||entity.getAdresse2().trim().isEmpty()){
                throw new KerenExecption("La Adresse 2 est obligatoire");
            }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
                throw new KerenExecption("La Téléphone est obligatoire");
            }else if(entity.getModile()==null||entity.getModile().trim().isEmpty()){
                throw new KerenExecption("La Portable est obligatoire");
            }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
                throw new KerenExecption("La Adresse électronique est obligatoire");
            }else if(entity.getRegion()==null){
                throw new KerenExecption("La Région d'origine est obligatoire");
            }else if(entity.getDepartementsoc()==null){
                throw new KerenExecption("La Département d'origine est obligatoire");
            }else if(entity.getStructure()==null){
                throw new KerenExecption("La Structure est obligatoire");
            }else if(entity.getPoste()==null){
                throw new KerenExecption("La Poste est obligatoire");
            }else if(entity.getDepartement()==null){
                throw new KerenExecption("La Département est obligatoire");
            }else if(entity.getLieuaffectation;()==null||entity.getLieuaffectation;().trim().isEmpty()){
                throw new KerenExecption("La Lieu d'affectation est obligatoire");
            }else if(entity.getLieurecrut;()==null||entity.getLieurecrut;().trim().isEmpty()){
                throw new KerenExecption("La Lieu de recrutement est obligatoire");
            }else if(entity.getFonction;()==null){
                throw new KerenExecption("La Fonction est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte salaire est obligatoire");
            }else if(entity.getNbrejours()==null){
                throw new KerenExecption("La Nombre de jours est obligatoire");
            }else if(entity.getComptesbancaire()==null||entity.getComptesbancaire().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un CompteBancaire");
            }else if(entity.getContrats()==null||entity.getContrats().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un ContratTravail");
            }else if(entity.getFamilles()==null||entity.getFamilles().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un Famille");
            }
            return manager.valide(entity);
	}

	@Override
	public Employe annule(HttpHeaders headers, Employe entity) {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference de la Employe est obligatoire");
            }else if(entity.getImage;()==null||entity.getImage;().trim().isEmpty()){
                throw new KerenExecption("La Photo est obligatoire");
            }else if(entity.getHandicape()==null){
                throw new KerenExecption("La Handicapé(e)? est obligatoire");
            }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
                throw new KerenExecption("La Nom  est obligatoire");
            }else if(entity.getMatricule()==null||entity.getMatricule().trim().isEmpty()){
                throw new KerenExecption("La Matricule est obligatoire");
            }else if(entity.getGenre()==null||entity.getGenre().trim().isEmpty()){
                throw new KerenExecption("La Genre est obligatoire");
            }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
                throw new KerenExecption("La Statut est obligatoire");
            }else if(entity.getDipe;()==null||entity.getDipe;().trim().isEmpty()){
                throw new KerenExecption("La N. Dipe) est obligatoire");
            }else if(entity.getCategorie()==null){
                throw new KerenExecption("La Catégories  est obligatoire");
            }else if(entity.getEchelon()==null){
                throw new KerenExecption("La Echelon  est obligatoire");
            }else if(entity.getNumsec()==null||entity.getNumsec().trim().isEmpty()){
                throw new KerenExecption("La N. d'assurance social est obligatoire");
            }else if(entity.getNationalite()==null){
                throw new KerenExecption("La Nationalité est obligatoire");
            }else if(entity.getContribuable()==null||entity.getContribuable().trim().isEmpty()){
                throw new KerenExecption("La N. contribuable est obligatoire");
            }else if(entity.getCni()==null||entity.getCni().trim().isEmpty()){
                throw new KerenExecption("La N. CNI est obligatoire");
            }else if(entity.getDatedelivrance()==null){
                throw new KerenExecption("La Date de délivrance est obligatoire");
            }else if(entity.getLieudelivrance()==null||entity.getLieudelivrance().trim().isEmpty()){
                throw new KerenExecption("La Lieu de délivrance est obligatoire");
            }else if(entity.getEtatcivil()==null||entity.getEtatcivil().trim().isEmpty()){
                throw new KerenExecption("La Etat Civil est obligatoire");
            }else if(entity.getPasseport()==null||entity.getPasseport().trim().isEmpty()){
                throw new KerenExecption("La N. de passeport est obligatoire");
            }else if(entity.getNbreenfants()==null){
                throw new KerenExecption("La Nombre d'enfants est obligatoire");
            }else if(entity.getNaissance()==null){
                throw new KerenExecption("La Date de naissance est obligatoire");
            }else if(entity.getLieudenaiss()==null||entity.getLieudenaiss().trim().isEmpty()){
                throw new KerenExecption("La Lieu de naissance est obligatoire");
            }else if(entity.getAdresse1()==null||entity.getAdresse1().trim().isEmpty()){
                throw new KerenExecption("La Adresse 1 est obligatoire");
            }else if(entity.getAdresse2()==null||entity.getAdresse2().trim().isEmpty()){
                throw new KerenExecption("La Adresse 2 est obligatoire");
            }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
                throw new KerenExecption("La Téléphone est obligatoire");
            }else if(entity.getModile()==null||entity.getModile().trim().isEmpty()){
                throw new KerenExecption("La Portable est obligatoire");
            }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
                throw new KerenExecption("La Adresse électronique est obligatoire");
            }else if(entity.getRegion()==null){
                throw new KerenExecption("La Région d'origine est obligatoire");
            }else if(entity.getDepartementsoc()==null){
                throw new KerenExecption("La Département d'origine est obligatoire");
            }else if(entity.getStructure()==null){
                throw new KerenExecption("La Structure est obligatoire");
            }else if(entity.getPoste()==null){
                throw new KerenExecption("La Poste est obligatoire");
            }else if(entity.getDepartement()==null){
                throw new KerenExecption("La Département est obligatoire");
            }else if(entity.getLieuaffectation;()==null||entity.getLieuaffectation;().trim().isEmpty()){
                throw new KerenExecption("La Lieu d'affectation est obligatoire");
            }else if(entity.getLieurecrut;()==null||entity.getLieurecrut;().trim().isEmpty()){
                throw new KerenExecption("La Lieu de recrutement est obligatoire");
            }else if(entity.getFonction;()==null){
                throw new KerenExecption("La Fonction est obligatoire");
            }else if(entity.getCompte()==null){
                throw new KerenExecption("La Compte salaire est obligatoire");
            }else if(entity.getNbrejours()==null){
                throw new KerenExecption("La Nombre de jours est obligatoire");
            }else if(entity.getComptesbancaire()==null||entity.getComptesbancaire().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un CompteBancaire");
            }else if(entity.getContrats()==null||entity.getContrats().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un ContratTravail");
            }else if(entity.getFamilles()==null||entity.getFamilles().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un Famille");
            }
            return manager.annule(entity);
	}

*/
