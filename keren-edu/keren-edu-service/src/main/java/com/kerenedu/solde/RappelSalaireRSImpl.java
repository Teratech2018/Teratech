
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.calendar.Rappel;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Oct 15 16:04:46 WAT 2018
 * 
 */
@Path("/rappelsalaire")
public class RappelSalaireRSImpl
    extends AbstractGenericService<RappelSalaire, Long>
    implements RappelSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "RappelSalaireManagerImpl", interf = RappelSalaireManagerRemote.class)
    protected RappelSalaireManagerRemote manager;

    public RappelSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RappelSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        try {
                MetaData meta = MetaDataUtil.getMetaData(new RappelSalaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
                MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'rappelsalaire','method':'engage'}");
                workbtn.setStates(new String[]{"etabli"});
                workbtn.setPattern("btn btn-success");
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
    protected void processBeforeSave(RappelSalaire entity) {
        entity.setState("etabli");
        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié converné est obligatoire");
        }else if(entity.getType()==null||entity.getType().isEmpty()){
                throw new KerenExecption("Le Type de Rappel est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Debut est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("Le Date de Fin est obligatoire");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("Le Date de debut ne peut etre superieur à  la date de fin");
        }
        
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(RappelSalaire entity) {
        
        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié converné est obligatoire");
        }else if(entity.getType()==null||entity.getType().isEmpty()){
                throw new KerenExecption("Le Type de Rappel est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Debut est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("Le Date de Fin est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("engage")){
                throw new KerenExecption("Le Rappel a déjà fait l'objet d'un Engagement");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("Le Date de debut ne peut etre superieur à  la date de fin");
        }
        
        super.processBeforeUpdate(entity);
    }

    @Override
    public RappelSalaire confirme(HttpHeaders headers, RappelSalaire entity) {
        
        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié converné est obligatoire");
        }else if(entity.getType()==null||entity.getType().isEmpty()){
                throw new KerenExecption("Le Type de Rappel est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Debut est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("Le Date de Fin est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("engage")){
                throw new KerenExecption("Le Rappel a déjà fait l'objet d'un Engagement");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("Le Date de debut ne peut etre superieur à  la date de fin");
        }
        
        validateRappel(entity);
        return manager.confirme(entity,null);
    }

    /**
     * 
     * @param entity
     */
    private void validateRappel(RappelSalaire entity){
        
        if(entity.getLignes()==null||entity.getLignes().isEmpty()){
                throw new KerenExecption("Veuillez saisir au moins un Rappel");
        }

        int i=0;

        for(LigneRappel rappel:entity.getLignes()){
            i++;
            if(rappel.getRubrique()==null){
                    throw new KerenExecption("La Rubrique de Paie est obligatoire  Ligne : "+i);
            }else if(rappel.getMontant()==null){
                    throw new KerenExecption("La Montant Réel est obligatoire  Ligne : "+i);
            }else if(rappel.getPercu()==null){
                    throw new KerenExecption("La Montant Perçu est obligatoire  Ligne : "+i);
            }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("Le Date de debut ne peut etre superieur à  la date de fin");
            }
        }
    }
        
    @Override
    public RappelSalaire delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
    	RappelSalaire entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
