
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.recrutement.EtapeRecrutementManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.EtapeRecrutementRS;
import com.keren.model.recrutement.Emploi;
import com.keren.model.recrutement.EtapeRecrutement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/etaperecrutement")
public class EtapeRecrutementRSImpl
    extends AbstractGenericService<EtapeRecrutement, Long>
    implements EtapeRecrutementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EtapeRecrutementManagerImpl", interf = EtapeRecrutementManagerRemote.class)
    protected EtapeRecrutementManagerRemote manager;

    public EtapeRecrutementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EtapeRecrutement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        
        // TODO Auto-generated method stub
        MetaData meta = null;
        
        try {
            meta = MetaDataUtil.getMetaData(new EtapeRecrutement(), new HashMap<String, MetaData>()
                , new ArrayList<String>());   			
        } catch (InstantiationException e) {
                
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
                
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return meta;
    }
    
    @Override
    protected void processBeforeUpdate(EtapeRecrutement entity) {
        
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le nom de l'etape  est obligatoire");
        }/*else if(entity.getDernier()==null){
            throw new KerenExecption("La Dernier Etape? est obligatoire");
        }else if(entity.getSequ()==null){
            throw new KerenExecption("La Séquence est obligatoire");
        }else if(entity.getDepartement()==null){
            throw new KerenExecption("La Département Lié est obligatoire");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La . est obligatoire");
        }*/
        
        super.processBeforeUpdate(entity);
    }

    @Override
    protected void processBeforeSave(EtapeRecrutement entity) {
        
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le Nom  est obligatoire");
        }/*else if(entity.getDernier()==null){
            throw new KerenExecption("La Dernier Etape? est obligatoire");
        }else if(entity.getSequ()==null){
            throw new KerenExecption("La Séquence est obligatoire");
        }else if(entity.getDepartement()==null){
            throw new KerenExecption("La Département Lié est obligatoire");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La . est obligatoire");
        }*/
    }
}
