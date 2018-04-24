
package com.keren.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.comptabilite.SectionAnalytiqueManagerRemote;
import com.keren.jaxrs.ifaces.comptabilite.SectionAnalytiqueRS;
import com.keren.model.comptabilite.SectionAnalytique;
import com.keren.model.employes.Categorie;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Feb 14 12:53:10 GMT+01:00 2018
 * 
 */
@Path("/sectionanalytique")
public class SectionAnalytiqueRSImpl
    extends AbstractGenericService<SectionAnalytique, Long>
    implements SectionAnalytiqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "SectionAnalytiqueManagerImpl", interf = SectionAnalytiqueManagerRemote.class)
    protected SectionAnalytiqueManagerRemote manager;

    public SectionAnalytiqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SectionAnalytique, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        // TODO Auto-generated method stub
        try {
                return MetaDataUtil.getMetaData(new SectionAnalytique(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new WebApplicationException(e);
        }
    }
    
    @Override
    protected void processBeforeUpdate(SectionAnalytique entity) {
        if(entity.getCompte()==null){
            throw new KerenExecption("Le compte est obligatoire");
        }/*else if(entity.getQuantite()==null){
            throw new KerenExecption("La quantite est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(SectionAnalytique entity) {
        if(entity.getCompte()==null){
            throw new KerenExecption("Le compte est obligatoire");
        }/*else if(entity.getQuantite()==null){
            throw new KerenExecption("La quantite est obligatoire");
        }else if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("La null est obligatoire");
        }*/
        super.processBeforeSave(entity);
    }
}
