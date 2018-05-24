
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.ExprBesionManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.ExprBesionRS;
import com.teratech.achat.model.operations.ExprBesion;
import com.teratech.achat.model.operations.LigneExprBesion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
@Path("/exprbesion")
public class ExprBesionRSImpl
    extends AbstractGenericService<ExprBesion, Long>
    implements ExprBesionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "ExprBesionManagerImpl", interf = ExprBesionManagerRemote.class)
    protected ExprBesionManagerRemote manager;

    public ExprBesionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ExprBesion, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta = MetaDataUtil.getMetaData(new ExprBesion(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Etape suivante", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'exprbesion','method':'valider'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-primary");
             meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'exprbesion','method':'annule'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     @Override
    public void processBeforeUpdate(ExprBesion entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la référence");
        }else if(entity.getDateExpr()==null){
            throw new KerenExecption("Veuillez saisir la date d'expression");
        }else if(entity.getUtilisateur()==null){
            throw new KerenExecption("Veuillez selectionner l'employé");
        }else if(entity.getBesions()==null || entity.getBesions().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un besion");
        }
         for(int i=0 ;i<entity.getBesions().size();i++){
             if(entity.getBesions().get(i).getId()<=0){
                 entity.getBesions().get(i).setId(-1);
             }//end if(entity.getBesions().get(i).getId()<=0){
        }//end for(int i=0 ;i<entity.getBesions().size();i++){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(ExprBesion entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la référence");
        }else if(entity.getDateExpr()==null){
            throw new KerenExecption("Veuillez saisir la date d'expression");
        }else if(entity.getUtilisateur()==null){
            throw new KerenExecption("Veuillez selectionner l'employé");
        }else if(entity.getBesions()==null || entity.getBesions().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un besion");
        }
        for(int i=0 ;i<entity.getBesions().size();i++){
             entity.getBesions().get(i).setId(-1);
        }//end for(int i=0 ;i<entity.getBesions().size();i++){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExprBesion confirmer(HttpHeaders headers, ExprBesion entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity==null||entity.getId()<0){
            throw new KerenExecption("Aucune expression n'est definie");
        }
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la référence");
        }else if(entity.getDateExpr()==null){
            throw new KerenExecption("Veuillez saisir la date d'expression");
        }else if(entity.getUtilisateur()==null){
            throw new KerenExecption("Veuillez selectionner l'employé");
        }else if(entity.getBesions()==null || entity.getBesions().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un besion");
        }else if(entity.getState().trim().equalsIgnoreCase("annule")){
            throw new KerenExecption("Expression déjà annulée");
        }
        return manager.confirmer(entity);
    }

    @Override
    public ExprBesion annuler(HttpHeaders headers, ExprBesion entity) {
         if(entity==null||entity.getId()<0){
            throw new KerenExecption("Aucune expression n'est definie");
        }
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la référence");
        }else if(entity.getDateExpr()==null){
            throw new KerenExecption("Veuillez saisir la date d'expression");
        }else if(entity.getUtilisateur()==null){
            throw new KerenExecption("Veuillez selectionner l'employé");
        }else if(entity.getBesions()==null || entity.getBesions().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un besion");
        }else if(entity.getState().trim().equalsIgnoreCase("annule")){
            throw new KerenExecption("Expression déjà annulée");
        }
        return manager.annuler(entity);
    }
    
}
