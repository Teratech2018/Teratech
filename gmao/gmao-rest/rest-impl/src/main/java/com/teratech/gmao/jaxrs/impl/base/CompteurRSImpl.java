
package com.teratech.gmao.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.base.CompteurManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.base.CompteurRS;
import com.teratech.gmao.model.base.Compteur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jul 13 17:11:00 GMT+01:00 2018
 * 
 */
@Path("/compteur")
public class CompteurRSImpl
    extends AbstractGenericService<Compteur, Long>
    implements CompteurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "CompteurManagerImpl", interf = CompteurManagerRemote.class)
    protected CompteurManagerRemote manager;

    public CompteurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Compteur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new Compteur(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeUpdate(Compteur entity) {
        if(entity.getEquipement()==null){
            throw new KerenExecption("Le champ Equipement est obligatoire");
        }else if(entity.getUnite()==null){
            throw new KerenExecption("Le champ Unité est obligatoire");
        }else if(entity.getInitial()==null){
            throw new KerenExecption("Le champ Valeur Initial est obligatoire");
        }else if(entity.getDebut()==null){
            throw new KerenExecption("Le champ Date Initialisation est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Compteur entity) {
         if(entity.getEquipement()==null){
            throw new KerenExecption("Le champ Equipement est obligatoire");
        }else if(entity.getUnite()==null){
            throw new KerenExecption("Le champ Unité est obligatoire");
        }else if(entity.getInitial()==null){
            throw new KerenExecption("Le champ Valeur Initial est obligatoire");
        }else if(entity.getDebut()==null){
            throw new KerenExecption("Le champ Date Initialisation est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
