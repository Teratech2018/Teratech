
package com.keren.courrier.jaxrs.impl.courrier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.CourrierTrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.CourrierTrierRS;
import com.keren.courrier.model.courrier.CourrierTrier;
import com.keren.courrier.model.courrier.FichierLieTri;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Aug 28 17:51:17 WAT 2018
 * 
 */
@Path("/courriertrier")
public class CourrierTrierRSImpl
    extends AbstractGenericService<CourrierTrier, Long>
    implements CourrierTrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierTrierManagerImpl", interf = CourrierTrierManagerRemote.class)
    protected CourrierTrierManagerRemote manager;

    public CourrierTrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CourrierTrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new CourrierTrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
    
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
   @Override
   protected void processAfterUpdate(CourrierTrier entity) {
        //To change body of generated methods, choose Tools | Templates.
       for(FichierLieTri elt:entity.getPiecesjointes()){
           File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
           if(file.exists()){
               File destfile = new File(FileHelper.getStaticDirectory().getPath());
               boolean result = true;
               if(!destfile.exists()){
                   result = destfile.mkdir();
               }//end if(!destfile.exists()){
               if(result){
                   try {
                       destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
                       FileHelper.moveFile(file, destfile);
                   } //end if(result){
                   catch (IOException ex) {
                       throw new KerenExecption(ex.getMessage());
                   }
               }
           }//end if(file.exists()){
       }//end for(FichierLie elt:entity.getPiecesjointes()){
       super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   protected void processAfterSave(CourrierTrier entity) {
       //To change body of generated methods, choose Tools | Templates.
       for(FichierLieTri elt:entity.getPiecesjointes()){
           File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
           if(file.exists()){
               File destfile = new File(FileHelper.getStaticDirectory().getPath());
               boolean result = true;
               if(!destfile.exists()){
                   result = destfile.mkdir();
               }//end if(!destfile.exists()){
               if(result){
                   try {
                       destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
                       FileHelper.moveFile(file, destfile);
                   } //end if(result){
                   catch (IOException ex) {
                       throw new KerenExecption(ex.getMessage());
                   }
               }
           }//end if(file.exists()){
       }//end for(FichierLie elt:entity.getPiecesjointes()){
       super.processAfterSave(entity); 
   }

}
