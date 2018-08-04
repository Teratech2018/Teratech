
package com.kerenedu.inscription;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.ServiceManagerRemote;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.notes.Examen;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.tools.KerenEduManagerException;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/changeclasse")
public class ChangeClasseRSImpl extends AbstractGenericService<ChangeClasse, Long> implements ChangeClasseRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote manager;

	@Manager(application = "kereneducation", name = "ServiceManagerImpl", interf = ServiceManagerRemote.class)
	protected ServiceManagerRemote managerService;

	public ChangeClasseRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<ChangeClasse, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}
	
	
	

	
	@Override
	public ChangeClasse save(HttpHeaders headers, ChangeClasse entity) {
		// TODO Auto-generated method stub
		System.out.println("ChangeClasseRSImpl.save() je suis là "+entity.getIdIns());
		if(entity.getIdIns()<=0){
			throw new KerenExecption("selectionner une inscription !!!");
		}
		manager.changerClasse(entity);
		return entity;
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ChangeClasse(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	
}
