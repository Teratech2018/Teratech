
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.ExerciceComptableManagerRemote;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.PeriodePaieRS;
import com.keren.kerenpaie.model.comptabilite.ExerciceComptable;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
@Path("/periodepaie")
public class PeriodePaieRSImpl
    extends AbstractGenericService<PeriodePaie, Long>
    implements PeriodePaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote manager;
    
    /**
     * On injecte le manager de l'ExerciceComptable
     * 
     */
    @Manager(application = "kerenpaie", name = "ExerciceComptableManagerImpl", interf = ExerciceComptableManagerRemote.class)
    protected ExerciceComptableManagerRemote exerciceComptableManager;
    
    //Motif erreur
    private String motif;

    public PeriodePaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
             MetaData meta =  MetaDataUtil.getMetaData(new PeriodePaie(), new HashMap<String, MetaData>()
                                    , new ArrayList<String>());           
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
    protected void processBeforeSave(PeriodePaie entity) {
        
        // TODO Auto-generated method stub
        if(entity.getDdebut().after(entity.getDfin())){
           throw new KerenExecption("La date debut est incorrecte");
        }else if(!DateHelper.between(entity.getDdebut(), entity.getExercice().getDebut(), entity.getExercice().getFin())){
            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
        }else if(!DateHelper.between(entity.getDfin(), entity.getExercice().getDebut(), entity.getExercice().getFin())){
            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
        }else if(!ifDatePeriodeCorrecte(entity)){
            throw new KerenExecption("L'intervalle de temps est incorrect, elle chevauche une periode dejà existante .<br>"
                    + "Il s'agit de la periode ayant pour code = <strong>"+motif+"</strong>");
        }else if(entity.getActif() == null){
            entity.setActif(Boolean.FALSE);
        }
        
        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(PeriodePaie entity) {
        
        // TODO Auto-generated method stub
        if(entity.getDdebut().after(entity.getDfin())){
           throw new KerenExecption("La date debut est incorrecte");
        }else if(!DateHelper.between(entity.getDdebut(), entity.getExercice().getDebut(), entity.getExercice().getFin())){
            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
        }else if(!DateHelper.between(entity.getDfin(), entity.getExercice().getDebut(), entity.getExercice().getFin())){
            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
        }else if(!ifDatePeriodeCorrecte(entity)){
            throw new KerenExecption("L'intervalle de temps est incorrect, elle chevauche une periode dejà existante .<br>"
                    + "Il s'agit de la periode ayant pour code = <strong>"+motif+"</strong>");
        }else if(entity.getActif() == null){
            entity.setActif(Boolean.FALSE);
        }

        super.processBeforeUpdate(entity);
    }
    
    @Override
    public PeriodePaie delete(Long id) {

        // TODO Auto-generated method stub
        PeriodePaie entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
    
    /**
     * Permet de veridier si une periode est correcte en terme de date,
     * quelle ne chevauche pas celle d'autres periodes du meme exercice
     * @autor ABEGA ABEGA SERGE
     * @param periode
     * @return 
     */
    private boolean ifDatePeriodeCorrecte(PeriodePaie periode){
        
        //Variables
        boolean etatOperation = true;
        ExerciceComptable exerciceComptable = exerciceComptableManager.find("id", periode.getExercice().getId());
        
        //on parcourt la liste des periode de l'exercice
        for(PeriodePaie periodePaie : exerciceComptable.getPeriodes()){
            
            //On verifie qu'il ne s'agit pas de la periode courante
            if(!periodePaie.getCode().equalsIgnoreCase(periode.getCode())){
                
                //Si la date debut de la perionde courante chevauche une periode appartenant au meme execrcice
                if(DateHelper.between(periode.getDdebut(), periodePaie.getDdebut(), periodePaie.getDfin())){
                    
                    //On recupere le resultat
                    etatOperation = false;
                    
                    //On recupere le code la periode
                    motif = periodePaie.getCode();
                    
                    //on sort
                    break;
                }
                
                //Si la date fin de la perionde courante chevauche une periode appartenant au meme execrcice 
                if(DateHelper.between(periode.getDfin(), periodePaie.getDdebut(), periodePaie.getDfin())){
                   
                    //On recupere le resultat
                    etatOperation = false;
                    
                    //On recupere le code la periode
                    motif = periodePaie.getCode();
                    
                    //on sort
                    break;
                }
            }
        }
        
        return etatOperation;
    }

}
