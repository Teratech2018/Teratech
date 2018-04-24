
package com.keren.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.comptabilite.CompteAnalytiqueManagerRemote;
import com.keren.jaxrs.ifaces.comptabilite.CompteAnalytiqueRS;
import com.keren.model.comptabilite.CompteAnalytique;
import com.keren.model.employes.Categorie;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/compteanalytique")
public class CompteAnalytiqueRSImpl
    extends AbstractGenericService<CompteAnalytique, Long>
    implements CompteAnalytiqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CompteAnalytiqueManagerImpl", interf = CompteAnalytiqueManagerRemote.class)
    protected CompteAnalytiqueManagerRemote manager;

    public CompteAnalytiqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CompteAnalytique, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
            // TODO Auto-generated method stub
            try {
                    return MetaDataUtil.getMetaData(new CompteAnalytique(),new HashMap<String, MetaData>()
                                    , new ArrayList<String>());
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
            }
    }
    
    @Override
    protected void processBeforeUpdate(CompteAnalytique entity) {
        
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La reference est obligatoire");
        }/*else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
            throw new KerenExecption("Le libelle est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le type de compte est obligatoire");
        }else if(entity.getReportANouveau()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getActive()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getNiveau()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(CompteAnalytique entity) {
        
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("La reference est obligatoire");
        }/*else if(entity.getLabel()==null||entity.getLabel().trim().isEmpty()){
            throw new KerenExecption("Le libelle est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le type de compte est obligatoire");
        }else if(entity.getReportANouveau()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getActive()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getNiveau()==null){
            throw new KerenExecption("La null est obligatoire");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
}