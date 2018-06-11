
package com.keren.kerenpaie.jaxrs.impl.prets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.prets.AcompteManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.prets.AcompteRS;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.prets.Acompte;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
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
    @Manager(application = "kerenpaie", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
    protected AcompteManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote periodemanager;
    

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
        return ("kerenpaie");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {

            MetaData meta = MetaDataUtil.getMetaData(new Acompte(), new HashMap<String, MetaData>(),new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Payer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'paye'}");
            workbtn.setStates(new String[]{"confirme"});
            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
            workbtn.setStates(new String[]{"confirme"});
            workbtn.setPattern("btn btn-danger");
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

        // TODO Auto-generated method stub
        if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié concerné est obligatoire");
        }else if(entity.getEffet()==null){
                throw new KerenExecption("La date de prise d'effet est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant de l'acompte est obligatoire");
        }

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
        }

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
    public Acompte delete(Long id) {

        // TODO Auto-generated method stub
        Acompte entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}