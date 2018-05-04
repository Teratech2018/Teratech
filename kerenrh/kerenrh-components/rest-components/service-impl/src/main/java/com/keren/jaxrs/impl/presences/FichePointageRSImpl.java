
package com.keren.jaxrs.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.EmployeManagerRemote;
import com.keren.core.ifaces.presences.FichePointageManagerRemote;
import com.keren.core.ifaces.structures.DepartementManagerRemote;
import com.keren.jaxrs.ifaces.presences.FichePointageRS;
import com.keren.model.conges.InterruptionConge;
import com.keren.model.employes.Employe;
import com.keren.model.presences.FichePointage;
import com.keren.model.presences.LigneFichePointage;
import com.keren.model.structures.Departement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
@Path("/fichepointage")
public class FichePointageRSImpl
    extends AbstractGenericService<FichePointage, Long>
    implements FichePointageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FichePointageManagerImpl", interf = FichePointageManagerRemote.class)
    protected FichePointageManagerRemote manager;
    
    @Manager(application = "kerenrh", name = "EmployeManagerImpl", interf = EmployeManagerRemote.class)
    protected EmployeManagerRemote employemanager;
    
    @Manager(application = "kerenrh", name = "DepartementManagerImpl", interf = DepartementManagerRemote.class)
    protected DepartementManagerRemote departementmanager;
    

    public FichePointageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FichePointage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            MetaData meta = MetaDataUtil.getMetaData(new FichePointage(),new HashMap<String, MetaData>()
                            , new ArrayList<String>());			
            return meta;
        } catch (Exception e) {

            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }

    }
    
    @Override
    protected void processBeforeSave(FichePointage entity) {
       
        //On controle les champs
        controlreView(entity);
        
        super.processBeforeSave(entity);
    }

    @Override
    public FichePointage delete(Long id) {
        
        //Initialisation
        FichePointage data = null;
        FichePointage result = null;
        
        try{
        
            data = super.delete(id);
            result = new FichePointage(data);
            
        }catch(Exception e){
            
            throw new KerenExecption("Suppression impossible, car cette Fiche de Pointage est dejà en cours d'utilisation par d'autres objets !");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    
    private void controlreView(FichePointage entity){
        
        if(entity.getPorte().equalsIgnoreCase("1") && entity.getDepartement() == null){
            throw new KerenExecption("Veillez selectionner un departement!");
        }/*else if(entity.getDebut().equals(entity.getFin())){
            throw new KerenExecption("Saisie Date erronée !!!");
        }else if(entity.getFin().after(entity.getFin())){
            throw new KerenExecption("Saisie Date erronée !!!");
        }else if(!entity.getState().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Modification impossible, car l'element a deja subit des traitements");
        }*/
    }
    
    @Override
    public List<LigneFichePointage> presences(HttpHeaders headers) {
        // TODO Auto-generated method stub
        Gson gson = new Gson();
        String key = gson.fromJson(headers.getRequestHeader("id").get(0), String.class);
        Long depID = gson.fromJson(headers.getRequestHeader("departement").get(0), Long.class);

        //Employe concernes
        List<Employe> employes = new ArrayList<Employe>();
        if(key.trim().equalsIgnoreCase("0")){
                employes = employemanager.findAll();
        }else if(key.trim().equalsIgnoreCase("1")){
                RestrictionsContainer container = RestrictionsContainer.newInstance();
                if(depID==null){
                        throw new KerenExecption("Veuillez saisir le departement concerné");
                }//end if(depID==null){
                Departement departement = departementmanager.find("id", depID);
                container.addEq("departement", departement);
                employes = employemanager.filter(container.getPredicats(), null, null, 0, -1);
        }//end if(key.trim().equalsIgnoreCase("0")){
        List<LigneFichePointage> datas = new ArrayList<LigneFichePointage>();
        for(Employe employe : employes){
                datas.add(new LigneFichePointage(employe));
        }//end for(Employe employe : employes){
        return datas;
    }
}
