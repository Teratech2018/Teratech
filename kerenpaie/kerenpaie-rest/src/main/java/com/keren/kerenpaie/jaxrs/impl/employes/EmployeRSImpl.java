
package com.keren.kerenpaie.jaxrs.impl.employes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.employes.EmployeManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.employes.EmployeRS;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
@Path("/employe")
public class EmployeRSImpl
    extends AbstractGenericService<Employe, Long>
    implements EmployeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "EmployeManagerImpl", interf = EmployeManagerRemote.class)
    protected EmployeManagerRemote manager;

    public EmployeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Employe, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
            return MetaDataUtil.getMetaData(new Employe(),new HashMap<String, MetaData>()
                            , new ArrayList<String>());
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }

    @Override
    public List<Employe> getSalaries(HttpHeaders headers, ValiderSalaire entity) {
        
        // TODO Auto-generated method stub
        List<Employe> salaries = new ArrayList<Employe>();
        return salaries;
    }

    @Override
    public RSNumber countSalaries(HttpHeaders headers, ValiderSalaire entity) {
        
        // TODO Auto-generated method stub
        RSNumber number = new RSNumber(0);
        return number;
    }
    
    @Override
    public Employe delete(Long id) {

        // TODO Auto-generated method stub
        Employe entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

    @Override
    public List<Employe> filter(HttpHeaders headers, int firstResult, int maxResult) {
//        System.out.println(EmployeRSImpl.class.toString()+".filter(HttpHeaders headers, int firstResult, int maxResult) =========== "+headers.getRequestHeader("userid").get(0));
        Gson gson = new Gson();
        Long userID = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
