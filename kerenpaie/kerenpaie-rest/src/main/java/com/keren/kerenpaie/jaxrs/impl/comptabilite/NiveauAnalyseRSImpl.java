
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.NiveauAnalyseManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.NiveauAnalyseRS;
import com.keren.kerenpaie.model.comptabilite.NiveauAnalyse;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
@Path("/niveauanalyse")
public class NiveauAnalyseRSImpl
    extends AbstractGenericService<NiveauAnalyse, Long>
    implements NiveauAnalyseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "NiveauAnalyseManagerImpl", interf = NiveauAnalyseManagerRemote.class)
    protected NiveauAnalyseManagerRemote manager;

    public NiveauAnalyseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<NiveauAnalyse, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new NiveauAnalyse(),new HashMap<String, MetaData>()
                                , new ArrayList<String>());
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }
    
    @Override
    public NiveauAnalyse delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        NiveauAnalyse entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
