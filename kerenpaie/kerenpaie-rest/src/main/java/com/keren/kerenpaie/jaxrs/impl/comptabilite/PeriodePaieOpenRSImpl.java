
package com.keren.kerenpaie.jaxrs.impl.comptabilite;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieOpenManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.comptabilite.PeriodePaieOpenRS;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 08 15:05:28 GMT+01:00 2018
 * 
 */
@Path("/periodepaieopen")
public class PeriodePaieOpenRSImpl
    extends AbstractGenericService<PeriodePaieOpen, Long>
    implements PeriodePaieOpenRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "PeriodePaieOpenManagerImpl", interf = PeriodePaieOpenManagerRemote.class)
    protected PeriodePaieOpenManagerRemote manager;

    public PeriodePaieOpenRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaieOpen, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                //To change body of generated methods, choose Tools | Templates.
                MetaData meta =  MetaDataUtil.getMetaData(new PeriodePaieOpen(), new HashMap<String, MetaData>()
                                            , new ArrayList<String>());           
    //            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
    //            meta.getHeader().add(stautsbar);
                return meta;
        } catch (InstantiationException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    
    @Override
    public PeriodePaieOpen delete(Long id) {

        // TODO Auto-generated method stub
        PeriodePaieOpen entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
