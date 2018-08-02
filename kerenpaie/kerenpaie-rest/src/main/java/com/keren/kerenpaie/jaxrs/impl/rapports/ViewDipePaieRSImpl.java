
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.CommonTools;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.rapports.ViewDipePaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.rapports.ViewDipePaieRS;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;
import com.keren.kerenpaie.tools.KerenPaieManagerException;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Thu Apr 19 10:00:59 WAT 2018
 * 
 */
@Path("/viewdipepaie")
public class ViewDipePaieRSImpl extends AbstractGenericService<ViewDipePaie, Long> implements ViewDipePaieRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kerenpaie", name = "ViewDipePaieManagerImpl", interf = ViewDipePaieManagerRemote.class)
	protected ViewDipePaieManagerRemote manager;
	@Manager(application = "kerenpaie", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
	protected PeriodePaieManagerRemote managerperiode;

	public ViewDipePaieRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ViewDipePaie, Long> getManager() {
		return manager;
	}

	public String getModuleName() {
		return ("kerenpaie");
	}

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        return getMetaData(); //To change body of generated methods, choose Tools | Templates.
    }

        
	
	public MetaData getMetaData() {
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewDipePaie(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work2", "Dipe", false, "download", null);
			workbtn.setValue("{'model':'kerenpaie','entity':'viewdipepaie','method':'builddipemagnetique','template':{'this':'object'}}");
			workbtn.setStates(new String[] { "etabli" });
			//// workbtn.setPattern("btn btn-primary");
			// meta.getHeader().add(workbtn);
			//// workbtn = new MetaColumn("button", "work3", "Annuler", false,
			//// "workflow", null);
			//// workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
			//// workbtn.setStates(new String[]{"etabli"});
			//// workbtn.setPattern("btn btn-danger");
			meta.getHeader().add(workbtn);
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(BPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public Response buildDipeMagnetique(HttpHeaders headers) {
	Gson g = new Gson();
	Long periodeId = new Long(0) ;
	String typeDipe =null;
	 periodeId= g.fromJson(headers.getRequestHeader("periode").get(0), Long.class);
	 typeDipe= g.fromJson(headers.getRequestHeader("dipe").get(0), String.class);
	 RestrictionsContainer container = RestrictionsContainer.newInstance();
	 ViewDipePaie critere = new ViewDipePaie();
	 if(periodeId!=null&&periodeId>0&&typeDipe!=null){
		 	container = RestrictionsContainer.newInstance();
			container.addEq("id",periodeId);
			PeriodePaie periode = managerperiode.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			critere.setPeriode(periode);
			critere.setDipe(typeDipe);
		
	 }
	 return this.buildTxtFile(critere);	
	}

	@Override
	public ViewDipePaie save(@Context HttpHeaders headers , ViewDipePaie entity) {
		// generer le dipe
		// TODO Auto-generated method stub
		if (entity.getPeriode() == null) {
			throw new KerenExecption("Bien vouloir renseigner les paramètres  <br/> ");
		} // end if (entity.getPeriode()==null)
		try {
			List<ViewDipePaie> records = manager.getCriteres(entity);
			if (records == null || records.isEmpty()) {
				throw new KerenExecption("Aucunes Données Trouvées <br/> ");
			} // end if (records==null||records.isEmpty())
			DipeGenerator.process(records, entity);
		} catch (KerenPaieManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
		return entity;
	}
	

	    private Response buildTxtFile(ViewDipePaie critere) {
	    	try {
				List<ViewDipePaie> records = manager.getCriteres(critere);
				if (records == null || records.isEmpty()) {
					throw new KerenExecption("Aucunes Données Trouvées <br/> ");
				} // end if (records==null||records.isEmpty())
					return getFile(DipeGenerator.process(records, critere)) ;
			} catch (KerenPaieManagerException ex) {
				throw new KerenExecption(ex.getMessage());
			}
	    }
	    
	   
	    public Response getFile(File file) {
//	    	System.out.println("ViewDipePaieRSImpl.getFile1() je suis iicii !!!!");
	    	  try{
//	                String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
//	                File file = new File(resourceDir);
	                if(file.exists()){
	                    return CommonTools.getText(file,file.getName());
	                }else{
	                    return Response.noContent().build();
	                }//end if(file.exists())
	        }catch(Exception ex){
	            throw new WebApplicationException(ex, Response.serverError().build());
	        }

		}

}
