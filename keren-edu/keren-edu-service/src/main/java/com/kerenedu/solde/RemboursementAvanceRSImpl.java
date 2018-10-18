
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
@Path("/remboursementavance")
public class RemboursementAvanceRSImpl
    extends AbstractGenericService<RemboursementAvance, Long>
    implements RemboursementAvanceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "RemboursementAvanceManagerImpl", interf = RemboursementAvanceManagerRemote.class)
    protected RemboursementAvanceManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote periodemanager;

    public RemboursementAvanceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RemboursementAvance, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                MetaData meta = MetaDataUtil.getMetaData(new RemboursementAvance(), new HashMap<String, MetaData>(),new ArrayList<String>());
                MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
                workbtn.setValue("{'model':'kerenpaie','entity':'remboursementavance','method':'valide'}");
                workbtn.setStates(new String[]{"etabli"});
                workbtn.setPattern("btn btn-success");
                meta.getHeader().add(workbtn);   
                workbtn = new MetaColumn("button", "work1", "Refuser", false, "workflow", null);
                workbtn.setValue("{'model':'kerenpaie','entity':'remboursementavance','method':'refuse'}");
                workbtn.setStates(new String[]{"etabli"});
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
    protected void processBeforeDelete(Object id) {

        // TODO Auto-generated method stub
        throw new KerenExecption("Impossible de supprimer une remboursement");
    }

    @Override
    public RemboursementAvance valider(HttpHeaders headers, RemboursementAvance entity) {

        // TODO Auto-generated method stub
        if(entity.getAvance()==null){
                throw new KerenExecption("L'avance de salaire est obligatoire");
        }else if(entity.getDate()==null){
                throw new KerenExecption("La date de remboursement est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant du remboursement est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Ce remboursement est déjà confirmé");
        }else if(entity.getState().equalsIgnoreCase("refuse")){
                throw new KerenExecption("Ce remboursement est déjà refusé");
        }/*else if(entity.getAvance().getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Veuillez valider l'avance liée");
        }*/

        PeriodePaie periode = periodeChecker(entity);
        return manager.valider(entity,periode);
    }

    @Override
    public RemboursementAvance refuser(HttpHeaders headers, RemboursementAvance entity) {

        // TODO Auto-generated method stub
        if(entity.getAvance()==null){
                throw new KerenExecption("L'avance de salaire est obligatoire");
        }else if(entity.getDate()==null){
                throw new KerenExecption("La date de remboursement est obligatoire");
        }else if(entity.getMontant()==null){
                throw new KerenExecption("Le montant du remboursement est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Ce remboursement est déjà confirmé");
        }else if(entity.getState().equalsIgnoreCase("refuse")){
                throw new KerenExecption("Ce remboursement est déjà refusé");
        }/*else if(entity.getAvance().getState().equalsIgnoreCase("etabli")){
                throw new KerenExecption("Veuillez valider l'avance liée");
        }*/

        return manager.refuser(entity);
    }

    /**
     * Permete de verifier que ;
     * il exites une periode ouvert contenant la date
     *  du remboursement en cours
     * @param entity
     */
    private PeriodePaie periodeChecker(RemboursementAvance entity){

      PeriodePaie periode = periodemanager.getPeriodeFromDate(entity.getDate());

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
    public RemboursementAvance delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        RemboursementAvance entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
}
