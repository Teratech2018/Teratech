
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.BulletinPaieRS;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.prets.Acompte;
import com.keren.kerenpaie.tools.KerenPaieManagerException;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
@Path("/bulletinpaie")
public class BulletinPaieRSImpl
    extends AbstractGenericService<BulletinPaie, Long>
    implements BulletinPaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
    protected BulletinPaieManagerRemote manager;
    
    
    @Manager(application = "kerenpaie", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
    protected MoteurPaieManagerRemote moteurmanager;
    
    

    public BulletinPaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BulletinPaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			 MetaData meta = MetaDataUtil.getMetaData(new BulletinPaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
			    MetaColumn workbtn = new MetaColumn("button", "work1", "Lancer le Calcul", false, "object", null);
	            workbtn.setValue("{'model':'kerenpaie','entity':'bulletinpaie','method':'calculer','template':{'this':'object'}}");
	            workbtn.setStates(new String[]{"etabli"});
	            workbtn.setPattern("btn btn-success");
	            meta.getHeader().add(workbtn);
	            workbtn = new MetaColumn("button", "work2", "Imprimer le Bulletin de Paie", false, "report", null);
	            workbtn.setValue("{'model':'kerenpaie','entity':'bulletinpaie','method':'printbulletin'}");
	            workbtn.setStates(new String[]{"etabli"});
//	            workbtn.setPattern("btn btn-primary");
	            meta.getHeader().add(workbtn);
//	            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
//	            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
//	            workbtn.setStates(new String[]{"etabli"});
//	            workbtn.setPattern("btn btn-danger");
//	            meta.getHeader().add(workbtn);	           
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
		return null;
	}

	@Override
	public BulletinPaie calculer(HttpHeaders headers, BulletinPaie entity) {
		// TODO Auto-generated method stub
		try{
		  return moteurmanager.eval(entity);
		}catch(KerenPaieManagerException ex){
			throw new KerenExecption(ex.getMessage());
		}
	}

	@Override
	public Response imprimer(HttpHeaders headers, BulletinPaie dmde) {
		// TODO Auto-generated method stub
		throw new KerenExecption("Fonctionnalite non encore implementée");
		
	}

}
