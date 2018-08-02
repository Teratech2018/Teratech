
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.CandidatureSpontaneManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.CandidatureSpontaneRS;
import com.keren.model.recrutement.BesionRecrutement;
import com.keren.model.recrutement.CandidatureSpontane;
import com.keren.model.recrutement.Emploi;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/candidaturespontane")
public class CandidatureSpontaneRSImpl
    extends AbstractGenericService<CandidatureSpontane, Long>
    implements CandidatureSpontaneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CandidatureSpontaneManagerImpl", interf = CandidatureSpontaneManagerRemote.class)
    protected CandidatureSpontaneManagerRemote manager;

    public CandidatureSpontaneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CandidatureSpontane, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        MetaData meta = null;
        try {
                meta = MetaDataUtil.getMetaData(new CandidatureSpontane(), new HashMap<String, MetaData>()
                , new ArrayList<String>());   			
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
    protected void processBeforeUpdate(CandidatureSpontane entity) {
        if(entity.getObjet()==null||entity.getObjet().trim().isEmpty()){
            throw new KerenExecption("L'Objet est obligatoire");
        }else if(entity.getNationalite()==null){
            throw new KerenExecption("La Nationalité est obligatoire");
        }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
            throw new KerenExecption("Le Nom et Prenom est obligatoire");
        }/*else if(entity.getResidence()==null){
            throw new KerenExecption("Le Lieu de résidence est obligatoire");
        }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
            throw new KerenExecption("L'etat civil est obligatoire");
        }else if(entity.getQuatier()==null||entity.getQuatier().trim().isEmpty()){
            throw new KerenExecption("Le Quatier est obligatoire");
        }else if(entity.getNaissa()==null){
            throw new KerenExecption("La Date de naissance est obligatoire");
        }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
            throw new KerenExecption("Le Téléphone est obligatoire");
        }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
            throw new KerenExecption("La Courriel est obligatoire");
        }else if(entity.getFormations()==null||entity.getFormations().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un FormationCandidat");
        }else if(entity.getExperiences()==null||entity.getExperiences().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un ExperienceCandidat");
        }else if(entity.getLangues()==null||entity.getLangues().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un LangueCandidat");
        }else if(entity.getResume()==null||entity.getResume().trim().isEmpty()){
            throw new KerenExecption("La . est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(CandidatureSpontane entity) {
        if(entity.getObjet()==null||entity.getObjet().trim().isEmpty()){
            throw new KerenExecption("L'Objet est obligatoire");
        }else if(entity.getNationalite()==null){
            throw new KerenExecption("La Nationalité est obligatoire");
        }else if(entity.getNom()==null||entity.getNom().trim().isEmpty()){
            throw new KerenExecption("Le Nom et Prenom est obligatoire");
        }/*else if(entity.getResidence()==null){
            throw new KerenExecption("Le Lieu de résidence est obligatoire");
        }else if(entity.getStatut()==null||entity.getStatut().trim().isEmpty()){
            throw new KerenExecption("L'etat civil est obligatoire");
        }else if(entity.getQuatier()==null||entity.getQuatier().trim().isEmpty()){
            throw new KerenExecption("Le Quatier est obligatoire");
        }else if(entity.getNaissa()==null){
            throw new KerenExecption("La Date de naissance est obligatoire");
        }else if(entity.getTel()==null||entity.getTel().trim().isEmpty()){
            throw new KerenExecption("Le Téléphone est obligatoire");
        }else if(entity.getMail()==null||entity.getMail().trim().isEmpty()){
            throw new KerenExecption("La Courriel est obligatoire");
        }else if(entity.getFormations()==null||entity.getFormations().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un FormationCandidat");
        }else if(entity.getExperiences()==null||entity.getExperiences().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un ExperienceCandidat");
        }else if(entity.getLangues()==null||entity.getLangues().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un LangueCandidat");
        }else if(entity.getResume()==null||entity.getResume().trim().isEmpty()){
            throw new KerenExecption("La . est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
    
    @Override
    public CandidatureSpontane delete(@Context HttpHeaders headers , Long id) {
        
        //Initialsiation
        CandidatureSpontane entity = null;
        
        try{
            
            //On supprime l'entite
            entity = super.delete(headers,id);
            
        }catch(Exception e){
            
            //On lève une exception
            throw new KerenExecption("Cette Candidature a deja fait l'objet d'un traitement ");
        }
        
        return entity; 
    }
}