
package com.teratech.vente.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.operations.DevisManagerRemote;
import com.teratech.vente.jaxrs.ifaces.operations.DevisRS;
import com.teratech.vente.model.operations.Devis;
import com.teratech.vente.model.operations.LigneDevis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 10:14:00 WAT 2019
 * 
 */
@Path("/devis")
public class DevisRSImpl
    extends AbstractGenericService<Devis, Long>
    implements DevisRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "DevisManagerImpl", interf = DevisManagerRemote.class)
    protected DevisManagerRemote manager;

    public DevisRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Devis, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    protected void processBeforeUpdate(Devis entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ reference est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDatecommande()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }
         compute(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Devis entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ reference est obligatoire");
        }else if(entity.getClient()==null){
            throw new KerenExecption("Veuillez selectionner le client concerné");
        }else if(entity.getDatecommande()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }
        entity.setState("etabli");
        compute(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param entity 
     */
    private void compute(Devis entity){
        for(LigneDevis ligne:entity.getLignes()){
            if(ligne.getId()<=0){
                ligne.setId(-1L);
            }//end if(ligne.getId()<=0){
        }//end for(LigneDevis ligne:entity.getLignes()){
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Devis(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Envoyé le devis par e-mail", false, "action", null);
            workbtn.setValue("{'name':'teratech_vente_ope_1_1',template:{'devis':'object'}}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setRoles(new String[]{"gestionnaire","administrateur"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Imprimer le bon", false, "report", null);
            workbtn.setValue("{'name':'devisvte_report01','model':'teratechvente','entity':'devis','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","transmi","refuse","accepte"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Marqué comme accepté", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'devis','method':'accepte','critical':true,'alert':'Vous allez marquer le devis accepté \nÊtes vous sûr de vouloir continuer?'}");
            workbtn.setStates(new String[]{"transmi"});workbtn.setPattern("btn btn-danger");
            workbtn.setRoles(new String[]{"gestionnaire","administrateur"});            
             meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work2", "Marqué comme refusé", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'devis','method':'refuse','critical':true,'alert':'Vous allez marquer le devis refusé \nÊtes vous sûr de vouloir continuer?'}");
            workbtn.setStates(new String[]{"transmi"});workbtn.setPattern("btn btn-danger");
             workbtn.setRoles(new String[]{"gestionnaire","administrateur"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'devis','method':'annule'}");
            workbtn.setStates(new String[]{"refuse"});//workbtn.setPattern("btn btn-danger");
            workbtn.setRoles(new String[]{"gestionnaire","administrateur"});
             meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Générer les commandes", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_2',template:{'devis':'object','client':'object.client','codeclient':'object.codeclient','lieu':'object.lieu','livraison':'object.livraison'},'header':['devis']}");
            workbtn.setStates(new String[]{"accepte"});//workbtn.setPattern("btn btn-danger");
             workbtn.setRoles(new String[]{"gestionnaire","administrateur"});
            meta.getHeader().add(workbtn);
              workbtn = new MetaColumn("button", "work2", "Générer les livraisons", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_3',template:{'devis':'object','client':'object.client','reference':'object.codeclient','lieu':'object.lieu','entrepot':'object.entrepot','livraison':'object.livraison'},'header':['devis']}");
            workbtn.setStates(new String[]{"accepte"});//workbtn.setPattern("btn btn-danger");
             meta.getHeader().add(workbtn);
              workbtn = new MetaColumn("button", "work2", "Générer les factures", false, "link", null);
            workbtn.setValue("{'name':'teratech_vente_ope_4',template:{'devis':'object','client':'object.client','codeclient':'object.codeclient','lieu':'object.lieu','livraison':'object.livraison'},'header':['devis']}");
            workbtn.setStates(new String[]{"accepte"});//workbtn.setPattern("btn btn-danger");
             meta.getHeader().add(workbtn);
              workbtn = new MetaColumn("button", "work2", "Cloturer le devis", false, "workflow", null);
            workbtn.setValue("{'model':'teratechvente','entity':'devis','method':'termine','critical':true,'alert':'Une fois le devis terminé cette action est irreversible \nVoulez vous continuer?'}");
            workbtn.setStates(new String[]{"accepte"});workbtn.setPattern("btn btn-danger");
            workbtn.setRoles(new String[]{"administrateur"});
             meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
        } catch (InstantiationException ex) {
            Logger.getLogger(DevisRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DevisRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devis> imprimer(HttpHeaders headers, Devis entity) {
        List<Devis> datas = new ArrayList<Devis>();
        datas.add(entity);
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("transmi");
            manager.update(entity.getId(), entity);
        }//end if(entity.getState().equalsIgnoreCase("etabli")){        
        //To change body of generated methods, choose Tools | Templates.
        return datas;
    }

    @Override
    public Devis accepte(HttpHeaders headers, Devis entity) {
         //To change body of generated methods, choose Tools | Templates.
        entity.setState("accepte");
        manager.update(entity.getId(),entity);
        return entity;
    }

    @Override
    public Devis refuse(HttpHeaders headers, Devis entity) {
         //To change body of generated methods, choose Tools | Templates.
        entity.setState("refuse");
        manager.update(entity.getId(),entity);
        return entity;
    }

    @Override
    public Devis annule(HttpHeaders headers, Devis entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("transmi");
        manager.update(entity.getId(),entity);
        return entity;
    }

    @Override
    public Devis termine(HttpHeaders headers, Devis entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
