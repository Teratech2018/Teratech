
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.ConvensionManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ConvensionRS;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.keren.kerenpaie.model.prets.Acompte;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Mar 06 14:40:10 GMT+01:00 2018
 * 
 */
@Path("/convension")
public class ConvensionRSImpl
    extends AbstractGenericService<Convension, Long>
    implements ConvensionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ConvensionManagerImpl", interf = ConvensionManagerRemote.class)
    protected ConvensionManagerRemote manager;

    public ConvensionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Convension, Long> getManager() {
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

        meta = MetaDataUtil.getMetaData(new Convension(), new HashMap<String, MetaData>()
                        , new ArrayList<String>());
        MetaColumn workbtn = new MetaColumn("button", "work1", "Générer La Grille", false, "workflow", null);
        workbtn.setValue("{'model':'kerenpaie','entity':'convension','method':'genere'}");
        workbtn.setStates(new String[]{"etabli","actif"});
        workbtn.setPattern("btn btn-primary");
        meta.getHeader().add(workbtn);  
        workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
        workbtn.setValue("{'model':'kerenpaie','entity':'convension','method':'actif'}");
        workbtn.setStates(new String[]{"etabli"});
        workbtn.setPattern("btn btn-success");
        meta.getHeader().add(workbtn);   
        workbtn = new MetaColumn("button", "work2", "Désactiver", false, "workflow", null);
        workbtn.setValue("{'model':'kerenpaie','entity':'convension','method':'inactif'}");
        workbtn.setStates(new String[]{"actif"});
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
/*
	@Override
	protected void processBeforeDelete(Object key) {
		// TODO Auto-generated method stub
		Convension entity = manager.find("id", (Long) key);
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference est obligatoire");
		}else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
			throw new KerenExecption("L'Intitulé est obligatoire");
		}else if(entity.getRubrique()==null){
			throw new KerenExecption("La Rubrique de Paie est obligatoire");
		}else if(entity.getDebut()==null){
			throw new KerenExecption("La Date de Début  est obligatoire");
		}else if(entity.getFin()==null){
			throw new KerenExecption("La Date de Fin est obligatoire");
		}else if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("La grille a déjà fait l'objet d'une activation ou désativation");
		}
		super.processBeforeDelete(entity);
	}*/

	@Override
	protected void processBeforeSave(Convension entity) {
            
            // TODO Auto-generated method stub
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                    throw new KerenExecption("La Reference est obligatoire");
            }else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
                    throw new KerenExecption("L'Intitulé est obligatoire");
            }else if(entity.getRubrique()==null){
                    throw new KerenExecption("La Rubrique de Paie est obligatoire");
            }else if(entity.getDebut()==null){
                    throw new KerenExecption("La Date de Début  est obligatoire");
            }else if(entity.getFin()==null){
                    throw new KerenExecption("La Date de Fin est obligatoire");
            }else if(entity.getDebut().after(entity.getFin())){
                    throw new KerenExecption("La Date de debut ne peut etre superieure a la date de fin");
            }

            super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Convension entity) {
            
            // TODO Auto-generated method stub
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                    throw new KerenExecption("La Reference est obligatoire");
            }else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
                    throw new KerenExecption("L'Intitulé est obligatoire");
            }else if(entity.getRubrique()==null){
                    throw new KerenExecption("La Rubrique de Paie est obligatoire");
            }else if(entity.getDebut()==null){
                    throw new KerenExecption("La Date de Début  est obligatoire");
            }else if(entity.getFin()==null){
                    throw new KerenExecption("La Date de Fin est obligatoire");
            }else if(entity.getDebut().after(entity.getFin())){
                    throw new KerenExecption("La Date de debut ne peut etre superieure a la date de fin");
            }

            super.processBeforeUpdate(entity);
	}

    @Override
    public Convension actif(HttpHeaders headers, Convension entity) {

        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
            throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
            throw new KerenExecption("La Rubrique de Paie est obligatoire");
        }else if(entity.getDebut()==null){
            throw new KerenExecption("La Date de Début  est obligatoire");
        }else if(entity.getFin()==null){
            throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de debut ne peut etre superieure a la date de fin");
        }

        return manager.actif(entity);
    }

    @Override
    public Convension inactif(HttpHeaders headers, Convension entity) {

        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique de Paie est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début  est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(!entity.getState().equalsIgnoreCase("actif")){
                throw new KerenExecption("La Désactivation n'est possible que <br/> pour la convension active");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de debut ne peut etre superieure a la date de fin");
        }

        return manager.inactif(entity);
    }

    @Override
    public Convension genere(HttpHeaders headers, Convension entity) {

        // TODO Auto-generated method stub
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("La Reference est obligatoire");
        }else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
                throw new KerenExecption("L'Intitulé est obligatoire");
        }else if(entity.getRubrique()==null){
                throw new KerenExecption("La Rubrique de Paie est obligatoire");
        }else if(entity.getDebut()==null){
                throw new KerenExecption("La Date de Début  est obligatoire");
        }else if(entity.getFin()==null){
                throw new KerenExecption("La Date de Fin est obligatoire");
        }else if(entity.getDebut().after(entity.getFin())){
                throw new KerenExecption("La Date de debut ne peut etre superieure a la date de fin");
        }

        return manager.genere(entity);
    }
    
    private void validateGruille(Convension convension){
        
        int i = 0;
        
        for(LigneConvension lign:convension.getLignes()){
            i++;
            
            if(lign.getCategorie()==null){
                throw new KerenExecption("La Catégorie est obligatoire ligne : "+i);
            }else if(lign.getEchelon()==null){
                 throw new KerenExecption("L'Echélon est obligatoire ligne : "+i);
            }else if(lign.getSalbase()==null){
                 throw new KerenExecption("Le Salaire de base est obligatoire ligne : "+i);
            }
        }
    }
    
    @Override
    public Convension delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        Convension entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
