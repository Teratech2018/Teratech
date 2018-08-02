
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.IndiceSoldeManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.IndiceSoldeRS;
import com.keren.kerenpaie.model.paie.IndiceSolde;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Mar 30 15:55:03 GMT+01:00 2018
 * 
 */
@Path("/indicesolde")
public class IndiceSoldeRSImpl
    extends AbstractGenericService<IndiceSolde, Long>
    implements IndiceSoldeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "IndiceSoldeManagerImpl", interf = IndiceSoldeManagerRemote.class)
    protected IndiceSoldeManagerRemote manager;

    public IndiceSoldeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<IndiceSolde, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            // TODO Auto-generated method stub
            MetaData meta =null;
            try {
                    meta = MetaDataUtil.getMetaData(new IndiceSolde(), new HashMap<String, MetaData>()
                                    , new ArrayList<String>());
//			MetaColumn workbtn = new MetaColumn("button", "work1", "Générer Les indices", false, "workflow", null);
//	        workbtn.setValue("{'model':'kerenpaie','entity':'indicesolde','method':'genere'}");
//	        workbtn.setStates(new String[]{"etabli"});
//	        workbtn.setPattern("btn btn-primary");
//	        meta.getHeader().add(workbtn);  
            MetaColumn workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'indicesolde','method':'actif'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);   
            workbtn = new MetaColumn("button", "work2", "Désactiver", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'indicesolde','method':'inactif'}");
            workbtn.setStates(new String[]{"active"});
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
        
        // TODO Auto-generated method stub
        IndiceSolde entity = manager.find("id", (Long) id);
        
        if(!entity.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Cette entité a déjà subit un traitement");
        }
        
        super.processBeforeDelete(entity);
    }

    @Override
    protected void processBeforeSave(IndiceSolde entity) {
        
        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getIndicessolde()==null||entity.getIndicessolde().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins une ligne");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de Debut ne peut etre superieure à la date de Fin");
        }
        
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(IndiceSolde entity) {
        
        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getIndicessolde()==null||entity.getIndicessolde().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins une ligne");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de Debut ne peut etre superieure à la date de Fin");
        }
        
        super.processBeforeUpdate(entity);
    }

    @Override
    public IndiceSolde actif(HttpHeaders headers, IndiceSolde entity) {
        
        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getIndicessolde()==null||entity.getIndicessolde().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins une ligne");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de Debut ne peut etre superieure à la date de Fin");
        }

        return manager.actif(entity);
    }

    @Override
    public IndiceSolde inactif(HttpHeaders headers, IndiceSolde entity) {

        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getIndicessolde()==null||entity.getIndicessolde().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins une ligne");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de Debut ne peut etre superieure à la date de Fin");
        }

        return manager.inactif(entity);
    }
    
    @Override
    public IndiceSolde delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        IndiceSolde entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
