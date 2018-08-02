
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AbscenceManager")
public class AbscenceManagerImpl
    extends AbstractGenericManager<Abscence, Long>
    implements AbscenceManagerLocal, AbscenceManagerRemote
{

    @EJB(name = "AbscenceDAO")
    protected AbscenceDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;   

    public AbscenceManagerImpl() {
    }

    @Override
    public GenericDAO<Abscence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Abscence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Abscence> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Abscence> result = new ArrayList<Abscence>();
   		for(Abscence elev:datas){
   			result.add(new Abscence(elev));
   		}
   		return result;
   	}

   	@Override
   	public Abscence find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Abscence elev = super.find(propertyName, entityID);
   		Abscence inscrip = new Abscence(elev);
   		for(LigneAbscence eleve: elev.getAbscences()){
   			inscrip.getAbscences().add(new LigneAbscence(eleve));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<Abscence> findAll() {
   		// TODO Auto-generated method stub
   		List<Abscence> datas = super.findAll();
   		List<Abscence> result = new ArrayList<Abscence>();
   		for(Abscence elev:datas){
   			result.add(new Abscence(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Abscence delete(Long id) {
   		// TODO Auto-generated method stub
   		Abscence elev = super.delete(id);
   		return new Abscence(elev);
   	}
   	
   	

	@Override
	public void processBeforeUpdate(Abscence entity) {
		 List<LigneAbscence> ligne = new ArrayList<LigneAbscence>();
		for(LigneAbscence lgn : entity.getAbscences()){
	    	lgn.setHeuretotal(DateHelper.hours(lgn.getHdebut(), lgn.getHfin(),new Date()));
	    	ligne.add(lgn);
	    }
	    entity.setAbscences(ligne);
		super.processBeforeUpdate(entity);
	}

	@Override
	public void processBeforeSave(Abscence entity) {
		// set annescolaire courante
		  //Creation des journaux de saisie
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 List<LigneAbscence> ligne = new ArrayList<LigneAbscence>();
		 container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
	    if(annee==null||annee.size()==0){
	        RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
	        throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
	    }
	    for(LigneAbscence lgn : entity.getAbscences()){
	    	lgn.setId(-1);
	    	if(lgn.getHdebut().equals("00:00")){
	    		throw new KerenExecption("Renseigner l'heure de Début!!!");
	    	}
	    	if(lgn.getHfin().equals("00:00")){
	    		throw new KerenExecption("Renseigner l'heure de Fin !!!");
	    	}
	    	lgn.setHeuretotal(DateHelper.hours(lgn.getHdebut(), lgn.getHfin(),new Date()));
	    	ligne.add(lgn);
	    }
	    entity.setAbscences(ligne);
	    entity.setAnneScolaire(annee.get(0).getCode());
		super.processBeforeSave(entity);
	}

	@Override
	public Abscence valider(Abscence entity) {
		  // TODO Auto-generated method stub
        if(entity.getState().equalsIgnoreCase("etabli")){
                entity.setState("valideé");
                entity = dao.update(entity.getId(), entity);
        }//end if(entity.getState().equalsIgnoreCase("etabli")){

        Abscence result = new Abscence(entity);
        return result;
	}
   	

}
