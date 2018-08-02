
package com.teratech.gmao.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.base.EquipementManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.base.EquipementRS;
import com.teratech.gmao.model.base.Article;
import com.teratech.gmao.model.base.Equipement;
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
@Path("/equipement")
public class EquipementRSImpl
    extends AbstractGenericService<Equipement, Long>
    implements EquipementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "EquipementManagerImpl", interf = EquipementManagerRemote.class)
    protected EquipementManagerRemote manager;

    public EquipementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Equipement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new Equipement(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeUpdate(Equipement entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Equipement est obligatoire");
        }else if(entity.getIntitule()==null|| entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le champ ésignation est obligatoire");
        }else if(entity.getFamille()==null){
            throw new KerenExecption("Le champ Famille est obligatoire");
        }else if(entity.getCentre()==null){
            throw new KerenExecption("Le champ Centre de frais est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Equipement entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Equipement est obligatoire");
        }else if(entity.getIntitule()==null|| entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le champ ésignation est obligatoire");
        }else if(entity.getFamille()==null){
            throw new KerenExecption("Le champ Famille est obligatoire");
        }else if(entity.getCentre()==null){
            throw new KerenExecption("Le champ Centre de frais est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
