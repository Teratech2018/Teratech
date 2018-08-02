
package com.teratech.gmao.jaxrs.impl.budget;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.budget.BudgetDivisionManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.budget.BudgetDivisionRS;
import com.teratech.gmao.model.budget.BudgetDivision;
import com.teratech.gmao.model.budget.LigneBudget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Jul 21 11:07:53 GMT+01:00 2018
 * 
 */
@Path("/budgetdivision")
public class BudgetDivisionRSImpl
    extends AbstractGenericService<BudgetDivision, Long>
    implements BudgetDivisionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "BudgetDivisionManagerImpl", interf = BudgetDivisionManagerRemote.class)
    protected BudgetDivisionManagerRemote manager;

    public BudgetDivisionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BudgetDivision, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            //To change body of generated methods, choose Tools | Templates.
            meta = MetaDataUtil.getMetaData(new BudgetDivision(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Saisie le budget", false, "action", null);
//            workbtn.setValue("{'name':'teratech_gmao_pro_2_1',template:{'division':'object.division','annee':'object.annee'}}");
//            workbtn.setStates(new String[]{"etabli","valide"});
//            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
            MetaColumn workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'convension','method':'actif'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);   
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);	
        } catch (InstantiationException ex) {
            Logger.getLogger(BudgetDivisionRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BudgetDivisionRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    public List<LigneBudget> getDetails(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
//        String annee = gson.fromJson(headers.getHeaderString("annee"), String.class);
        List<LigneBudget> lignes = new ArrayList<LigneBudget>();
        for(int i=1;i<=12;i++){
            LigneBudget ligne = new LigneBudget(""+i, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            lignes.add(ligne);
        }//end for(int i=1;i<=12;i++){
        return lignes ;
    }

    @Override
    protected void processBeforeUpdate(BudgetDivision entity) {
        if(entity.getDivision()==null){
            throw new KerenExecption("Le champ Division est obligatoire");
        }else if(entity.getAnnee()==null || entity.getAnnee().trim().isEmpty()){
            throw new KerenExecption("Le champ Exercice est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BudgetDivision entity) {
        if(entity.getDivision()==null){
            throw new KerenExecption("Le champ Division est obligatoire");
        }else if(entity.getAnnee()==null || entity.getAnnee().trim().isEmpty()){
            throw new KerenExecption("Le champ Exercice est obligatoire");
        }
        entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
