
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.KerenCoreMDBHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.DemandePrixManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.DemandePrixRS;
import com.teratech.achat.model.base.Tier;
import com.teratech.achat.model.operations.DemandePrix;
import com.teratech.achat.model.operations.LigneDemandePrix;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import com.teratech.achat.model.operations.ReponseFournisseur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
@Path("/demandeprix")
public class DemandePrixRSImpl
    extends AbstractGenericService<DemandePrix, Long>
    implements DemandePrixRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "DemandePrixManagerImpl", interf = DemandePrixManagerRemote.class)
    protected DemandePrixManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "DemandePrixManagerImpl", interf = DemandePrixManagerRemote.class)
    protected DemandePrixManagerRemote dpmanager;
    
    
    @Resource(lookup = "java:/kerencore/coreConnectionFactory")
    ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java:/kerencore/coremdb")
    Destination destination;

    public DemandePrixRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandePrix, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta = MetaDataUtil.getMetaData(new DemandePrix(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Envoyé une demande par e-mail", false, "action", null);
            workbtn.setValue("{'name':'teratech_achat_ope_2_1',template:{'demande':'object'}}");
            workbtn.setStates(new String[]{"etabli","transmi"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Imprimer la demande", false, "report", null);
            workbtn.setValue("{'name':'demandeprix_report01','model':'teratechachat','entity':'demandeprix','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","transmi","cloture"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Reponses fournisseurs", false, "link", null);
            workbtn.setValue("{'name':'teratech_achat_ope_2_2',template:{'demande':'object','lignes':'object.articles'},'header':['demande']}");
            workbtn.setStates(new String[]{"transmi","cloture"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Clôturer la demande", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'demandeprix','method':'engage'}");
            workbtn.setStates(new String[]{"transmi"});
//            workbtn.setPattern("btn btn-primary");
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
    protected void processBeforeUpdate(DemandePrix entity) {
        try {
            if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("Veuillez saisir la reference");
            }else if(entity.getDate()==null){
                throw new KerenExecption("Veuillez saisir la date de la commande");
            }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
                throw new KerenExecption("Veuillez saisir les fournisseurs");
            }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
                throw new KerenExecption("Veuillez saisir les Articles concernés");
            }
            KerenCoreMDBHelper.textMessageProducer("Hello I am the new MDB", connectionFactory, destination);
            super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
        } catch (JMSException ex) {
            Logger.getLogger(DemandePrixRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void processBeforeSave(DemandePrix entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("Veuillez saisir la reference");
            }else if(entity.getDate()==null){
                throw new KerenExecption("Veuillez saisir la date de la commande");
            }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
                throw new KerenExecption("Veuillez saisir les fournisseurs");
            }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
                throw new KerenExecption("Veuillez saisir les Articles concernés");
            }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DemandePrix confirmer(HttpHeaders headers, DemandePrix entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
                throw new KerenExecption("Veuillez saisir la reference");
            }else if(entity.getDate()==null){
                throw new KerenExecption("Veuillez saisir la date de la commande");
            }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
                throw new KerenExecption("Veuillez saisir les fournisseurs");
            }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
                throw new KerenExecption("Veuillez saisir les Articles concernés");
            }
        return manager.confirmer(entity);
    }

    @Override
    public DemandePrix envoyer(HttpHeaders headers, DemandePrix entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
            throw new KerenExecption("Veuillez saisir les fournisseurs");
        }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
            throw new KerenExecption("Veuillez saisir les Articles concernés");
        }
        return manager.envoyer(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DemandePrix engage(HttpHeaders headers, DemandePrix entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
            throw new KerenExecption("Veuillez saisir les fournisseurs");
        }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
            throw new KerenExecption("Veuillez saisir les Articles concernés");
        }
        validateLigneDP(entity);
        //To change body of generated methods, choose Tools | Templates.
        return manager.engage(entity);
    }

    @Override
    public DemandePrix annule(HttpHeaders headers, DemandePrix entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFournisseurs()==null || entity.getFournisseurs().isEmpty()){
            throw new KerenExecption("Veuillez saisir les fournisseurs");
        }else if(entity.getArticles()==null || entity.getArticles().isEmpty()){
            throw new KerenExecption("Veuillez saisir les Articles concernés");
        }
         return manager.annule(entity);
    }

    /**
     * Valide les lignes de la demandes de prix
     * @param entity 
     */
    private void validateLigneDP(DemandePrix entity){
        
    }

    @Override
    public List<ReponseFournisseur> imprimer(HttpHeaders headers, DemandePrix dmde) {
         //To change body of generated methods, choose Tools | Templates.
        List<ReponseFournisseur> datas = new ArrayList<ReponseFournisseur>();
        for(Tier tier : dmde.getFournisseurs()){
            datas.add(new ReponseFournisseur(dmde, tier));
        }//end for(Tier tier : dmde.getFournisseurs()){
        if(dmde.getState().equalsIgnoreCase("etabli")){
            dmde.setState("transmi");
        }//end if(dmde.getState().equalsIgnoreCase("etabli")){
        dpmanager.update(dmde.getId(), dmde);
        return datas;
    }
    

}
