
package com.keren.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.comptabilite.CompteManagerRemote;
import com.keren.jaxrs.ifaces.comptabilite.CompteRS;
import com.keren.model.comptabilite.Compte;
import com.keren.model.employes.Categorie;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/compte")
public class CompteRSImpl
    extends AbstractGenericService<Compte, Long>
    implements CompteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CompteManagerImpl", interf = CompteManagerRemote.class)
    protected CompteManagerRemote manager;

    public CompteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Compte, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            // TODO Auto-generated method stub
            try {
                    return MetaDataUtil.getMetaData(new Compte(),new HashMap<String, MetaData>()
                                    , new ArrayList<String>());
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    throw new WebApplicationException(e);
            }
    }
    
    @Override
    protected void processBeforeUpdate(Compte entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le numero de compte est obligatoire");
        }else if(entity.getLibele()==null||entity.getLibele().trim().isEmpty()){
            throw new KerenExecption("Le libellé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le type de compte est obligatoire");
        }else if(entity.getNature()==null||entity.getNature().trim().isEmpty()){
            throw new KerenExecption("La nature est obligatoire");
        }/*else if(entity.getTaxe()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getReportdesanouveau()==null||entity.getReportdesanouveau().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getLettrage()==null||entity.getLettrage().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getAnalytiques()==null||entity.getAnalytiques().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un SectionAnalytique");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(Compte entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le numero de compte est obligatoire");
        }else if(entity.getLibele()==null||entity.getLibele().trim().isEmpty()){
            throw new KerenExecption("Le libellé est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le type de compte est obligatoire");
        }else if(entity.getNature()==null||entity.getNature().trim().isEmpty()){
            throw new KerenExecption("La nature est obligatoire");
        }/*else if(entity.getTaxe()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getReportdesanouveau()==null||entity.getReportdesanouveau().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getLettrage()==null||entity.getLettrage().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getAnalytiques()==null||entity.getAnalytiques().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un SectionAnalytique");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
}