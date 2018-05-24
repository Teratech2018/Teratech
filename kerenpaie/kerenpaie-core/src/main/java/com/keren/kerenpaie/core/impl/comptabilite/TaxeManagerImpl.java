
package com.keren.kerenpaie.core.impl.comptabilite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.TaxeManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.TaxeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.TaxeDAOLocal;
import com.keren.kerenpaie.model.comptabilite.Taxe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "TaxeManager")
public class TaxeManagerImpl
    extends AbstractGenericManager<Taxe, Long>
    implements TaxeManagerLocal, TaxeManagerRemote
{

    @EJB(name = "TaxeDAO")
    protected TaxeDAOLocal dao;

    public TaxeManagerImpl() {
    }

    @Override
    public GenericDAO<Taxe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
   
    @Override
    public List<Taxe> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
	public List<Taxe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
    	List<Taxe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Taxe> result = new ArrayList<Taxe>();
        for(Taxe te:datas){
            result.add(new Taxe(te));
        }
        return result;
	}

	@Override
    public Taxe find(String propertyName, Long entityID) {
        Taxe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Taxe result = new Taxe(data);
        
        return result;
    }

    @Override
    public Taxe delete(Long id) {

        // TODO Auto-generated method stub    	
        Taxe data= super.delete(id);

        return new Taxe(data);
    }

    @Override
    public Taxe save(Taxe entity) {
        Taxe data = super.save(entity); //To change body of generated methods, choose Tools | Templates.
        return new Taxe(data);
    }
    

}
/*
    @EJB(name = "CompteDAO")
    protected CompteDAOLocal comptedao;


    @Override
    public List<Taxe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        ////On applique les criteres
        ////RestrictionsContainer container = RestrictionsContainer.newInstance();
        ////container.addEq("state", "valide");
        ////predicats.addAll(container.getPredicats());

        //On initialise les les objets
        List<Taxe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Taxe> results = new ArrayList<Taxe>();

        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public List<Taxe> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<Taxe> datas = super.findAll();
        List<Taxe> results = new ArrayList<Taxe>();

        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public Taxe find(String propertyName, Long entityID) {
        Taxe data = super.find(propertyName, entityID);
        Taxe result = new Taxe(data);

        for(Compte aas:data.getComptes()){
            result.getComptes().add(new Compte(aas));
        }


        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats);
    }

    @Override
    public Taxe delete(Long id) {
        
        Taxe data = super.find("id", id);
        Taxe result = new Taxe(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }

    @Override
    public void processAfterUpdate(Taxe entity) {

         for(Compte aas:entity.getComptes()){

            aas.setTaxe(entity);

            if(aas.getId()>0){
                comptedao.update(aas.getId(), aas);
            }else {
                comptedao.save(aas);
            }
        }
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Taxe entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());


        for(Compte aas:entity.getComptes()){
            aas.setTaxe(entity);

            if(aas.getId()>0){
                comptedao.update(aas.getId(), aas);
            }else {
                comptedao.save(aas);
            }
        }
        super.processAfterSave(entity);
    }

    @Override
    public Taxe valide(Taxe entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        Taxe data = dao.update(entity.getId(), entity);


        for(Compte aas:entity.getComptes()){
            aas.setTaxe(entity);

            if(aas.getId()>0){
                comptedao.update(aas.getId(), aas);
            }else {
                comptedao.save(aas);
            }
        }

        Taxe result = new Taxe(data);

        for(Compte aas:data.getComptes()){
            result.getComptes().add(new Compte(aas));
        }

        return result;
    }

    @Override
    public Taxe annule(Taxe entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Taxe data = dao.update(entity.getId(), entity);
        return new Taxe(data);
    }

*/
