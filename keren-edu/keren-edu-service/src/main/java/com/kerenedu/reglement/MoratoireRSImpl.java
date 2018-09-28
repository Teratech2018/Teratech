
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.configuration.EtablissementManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 13:51:28 WAT 2018
 * 
 */
@Path("/moratoire")
public class MoratoireRSImpl
    extends AbstractGenericService<Moratoire, Long>
    implements MoratoireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "MoratoireManagerImpl", interf = MoratoireManagerRemote.class)
    protected MoratoireManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "EtablissementManagerImpl", interf =EtablissementManagerRemote.class)
    protected EtablissementManagerRemote manageretbl;
    
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote managerIns;

    public MoratoireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Moratoire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Moratoire(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    
    @Override
	protected void processBeforeSave(Moratoire entity) {
		
		if (entity.getDateDeb().before(entity.getDelai())) {
			throw new KerenExecption("Création impossible, Bien vouloir Verifier les Dates  !!!!");
		}
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("eleve.id", entity.getEleve().getId());
		List<Moratoire> moratoires = manager.filter(container.getPredicats(), null, null, 0, -1);
		Etablissement e = manageretbl.findAll().get(0);
		if(moratoires!=null&&moratoires.size()>0&&moratoires.size()>=e.getQuota()){
			throw new KerenExecption("Création impossible, Vous aviez attients votre quota de moratoire  !!!!");
		}

		super.processBeforeUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}
    

	@Override
	public List<Moratoire> filter(HttpHeaders headers, int firstResult, int maxResult) {
		Gson gson = new Gson();
		Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);

		// UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
		// Type predType = ;
		List contraints = new ArrayList();
		if (headers.getRequestHeader("predicats") != null) {
			contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),
					new TypeToken<List<FilterPredicat>>() {
					}.getType());
		} // end if(headers.getRequestHeader("predicats")!=null){
			// System.out.println(AbstractGenericService.class.toString()+" ===
			// "+headers.getRequestHeader("predicats")+" === "+firstResult+" ===
			// "+maxResult+" == "+contraints);
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (contraints != null && !contraints.isEmpty()) {
			for (Object obj : contraints) {
				FilterPredicat filter = (FilterPredicat) obj;
				if (filter.getFieldName() != null && !filter.getFieldName().trim().isEmpty()
						&& filter.getValue() != null && !filter.getValue().isEmpty()) {
					container = addPredicate(container, filter);
				} // end
					// if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
			} // end for(Object obj : contraints)
		} // end if(contraints!=null&&!contraints.isEmpty())
			// container.addEq("source", user);

		if (headers.getRequestHeader("eleve") != null) {
			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);

			Inscription inscription = null;
			inscription = managerIns.find("id", studenid);
			container.addEq("eleve.id", inscription.getId());
		}

		// if (inscription != null) {
		// container.addEq("eleve.eleve.matricule", inscription.getEleve().());
		// }
		// if (CacheMemory.getCurrentNameStudent() != null &&
		// !CacheMemory.getCurrentNameStudent().isEmpty()
		// && !CacheMemory.getCurrentNameStudent().equals("")) {
		// container.addEq("eleve.eleve.nom",
		// CacheMemory.getCurrentNameStudent());
		// }

		// List result = new ArrayList();
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), firstResult, maxResult);
	}

	@Override
	public RSNumber count(HttpHeaders headers) {
		// To change body of generated methods, choose Tools | Templates.
		// To change body of generated methods, choose Tools | Templates.
		Gson gson = new Gson();
		Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);

		// UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
		// Type predType = ;
		List contraints = new ArrayList();
		if (headers.getRequestHeader("predicats") != null) {
			contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),
					new TypeToken<List<FilterPredicat>>() {
					}.getType());
		} // end if(headers.getRequestHeader("predicats")!=null){
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (contraints != null && !contraints.isEmpty()) {
			for (Object obj : contraints) {
				FilterPredicat filter = (FilterPredicat) obj;
				if (filter.getFieldName() != null && !filter.getFieldName().trim().isEmpty()
						&& filter.getValue() != null && !filter.getValue().isEmpty()) {
					container = addPredicate(container, filter);
				} // end
					// if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
			} // end for(Object obj : contraints)
		} // end if(contraints!=null&&!contraints.isEmpty())
		if (headers.getRequestHeader("eleve") != null) {
			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);

			Inscription inscription = null;
			inscription = managerIns.find("id", studenid);
			container.addEq("eleve.id", inscription.getId());
		}

		// if (inscription != null) {
		// container.addEq("eleve.eleve.matricule", inscription.getEleve().());
		// }
		// if (CacheMemory.getCurrentNameStudent() != null &&
		// !CacheMemory.getCurrentNameStudent().isEmpty()
		// && !CacheMemory.getCurrentNameStudent().equals("")) {
		// container.addEq("eleve.eleve.nom",
		// CacheMemory.getCurrentNameStudent());
		// }

		RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
		// System.out.println(AbstractGenericService.class.toString()+".count
		// === "+" == "+number.getValue());
		return number;
	}

}
