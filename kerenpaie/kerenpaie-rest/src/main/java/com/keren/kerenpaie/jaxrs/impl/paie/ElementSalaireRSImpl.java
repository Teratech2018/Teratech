
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.ElementSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.ElementSalaireRS;
import com.keren.kerenpaie.model.paie.ElementSalaire;
import com.keren.kerenpaie.model.paie.ParametreAvance;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
@Path("/elementsalaire")
public class ElementSalaireRSImpl
    extends AbstractGenericService<ElementSalaire, Long>
    implements ElementSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ElementSalaireManagerImpl", interf = ElementSalaireManagerRemote.class)
    protected ElementSalaireManagerRemote manager;

    public ElementSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ElementSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		MetaData meta = null;
		
		try {
			meta = MetaDataUtil.getMetaData(new ElementSalaire(), new HashMap<String, MetaData>(), new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Activer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'elementsalaire','method':'active'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Désactiver", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'elementsalaire','method':'inactive'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
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
	protected void processBeforeDelete(Object entity) {
		// TODO Auto-generated method stub
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(ElementSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getEmploye()==null){
			throw new KerenExecption("Le Salarié concerné est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type d'Element est Obligatoire");
		}else if(Short.parseShort(entity.getType())>=0 
				&& Short.parseShort(entity.getType())<=5 
				|| Short.parseShort(entity.getType())==8){
			if(entity.getValeur()==null||entity.getValeur()<=0){
				throw new KerenExecption("La Valeur  est Obligatoire");
			}//end if(entity.getValeur()==null||entity.getValeur()<=0)
		}else if(entity.getRubriques()==null||entity.getRubriques().isEmpty()){
			throw new KerenExecption("Veuillez fournir au moins une Rubrique de paie");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ElementSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getEmploye()==null){
			throw new KerenExecption("Le Salarié concerné est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type d'Element est Obligatoire");
		}else if(Short.parseShort(entity.getType())>=0 
				&& Short.parseShort(entity.getType())<=5 
				|| Short.parseShort(entity.getType())==8){
			if(entity.getValeur()==null||entity.getValeur()<=0){
				throw new KerenExecption("La Valeur  est Obligatoire");
			}//end if(entity.getValeur()==null||entity.getValeur()<=0)
		}else if(entity.getRubriques()==null||entity.getRubriques().isEmpty()){
			throw new KerenExecption("Veuillez fournir au moins une Rubrique de paie");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public ElementSalaire actif(HttpHeaders headers, ElementSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getEmploye()==null){
			throw new KerenExecption("Le Salarié concerné est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type d'Element est Obligatoire");
		}else if(Short.parseShort(entity.getType())>=0 
				&& Short.parseShort(entity.getType())<=5 
				|| Short.parseShort(entity.getType())==8){
			if(entity.getValeur()==null||entity.getValeur()<=0){
				throw new KerenExecption("La Valeur  est Obligatoire");
			}//end if(entity.getValeur()==null||entity.getValeur()<=0)
		}else if(entity.getRubriques()==null||entity.getRubriques().isEmpty()){
			throw new KerenExecption("Veuillez fournir au moins une Rubrique de paie");
		}
		return manager.actif(entity);
	}

	@Override
	public ElementSalaire inactif(HttpHeaders headers, ElementSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getEmploye()==null){
			throw new KerenExecption("Le Salarié concerné est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type d'Element est Obligatoire");
		}else if(Short.parseShort(entity.getType())>=0 
				&& Short.parseShort(entity.getType())<=5 
				|| Short.parseShort(entity.getType())==8){
			if(entity.getValeur()==null||entity.getValeur()<=0){
				throw new KerenExecption("La Valeur  est Obligatoire");
			}//end if(entity.getValeur()==null||entity.getValeur()<=0)
		}else if(entity.getRubriques()==null||entity.getRubriques().isEmpty()){
			throw new KerenExecption("Veuillez fournir au moins une Rubrique de paie");
		}
		return manager.inactif(entity);
	}
    
    
}
