
package com.teratech.achat.jaxrs.impl.tools;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.core.ifaces.operations.ReponseFournisseurManagerRemote;
import com.teratech.achat.core.ifaces.tools.ReponseToCommandeManagerRemote;
import com.teratech.achat.jaxrs.ifaces.tools.ReponseToCommandeRS;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.ReponseFournisseur;
import com.teratech.achat.model.tools.ReponseToCommande;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 22 18:51:44 WAT 2018
 * 
 */
@Path("/reponsetocommande")
public class ReponseToCommandeRSImpl
    extends AbstractGenericService<ReponseToCommande, Long>
    implements ReponseToCommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "ReponseToCommandeManagerImpl", interf = ReponseToCommandeManagerRemote.class)
    protected ReponseToCommandeManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonCommandeManagerImpl", interf = BonCommandeManagerRemote.class)
    protected BonCommandeManagerRemote bcmanager;
    
    @Manager(application = "teratechachat", name = "ReponseFournisseurManagerImpl", interf = ReponseFournisseurManagerRemote.class)
    protected ReponseFournisseurManagerRemote rpmanager;

    public ReponseToCommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ReponseToCommande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ReponseToCommande(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(ReponseToCommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReponseToCommandeRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta ;
         //To return super.getMetaData(headers);change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BonCommande> somethings(ReponseToCommande entity) {
        //To change body of generated methods, choose Tools | Templates.
//        System.out.println(ReponseToCommandeRSImpl.class.toString()+".somethings(ReponseToCommande entity) ============ "+entity.getReponse());
        BonCommande commande = new BonCommande(entity.getReponse());
        commande.setCondreglement(entity.getCondreglement());
        commande.setMethod(entity.getMethod());
        commande.setDate(new Date());
        commande.setDatecommande(entity.getDate());
        commande.setEmplacement(entity.getEntrepot());
        commande.setState("etabli");
        bcmanager.save(commande);
        List<BonCommande> commandes = new ArrayList<BonCommande>();
        commandes.add(commande);
        //Mise a jour etat Reponse
        ReponseFournisseur reponse = entity.getReponse();
        reponse.setState("command");
        rpmanager.update(reponse.getId(), reponse);
        return commandes;
    }
    
    

}
