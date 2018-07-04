
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.commons.DateHelper;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
@Path("/echeancier")
public class EcheancierRSImpl
    extends AbstractGenericService<Echeancier, Long>
    implements EcheancierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EcheancierManagerImpl", interf = EcheancierManagerRemote.class)
    protected EcheancierManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "EcheancierDltManagerImpl", interf = EcheancierDltManagerRemote.class)
    protected EcheancierDltManagerRemote managerdlt;
    
    @Manager(application = "kereneducation", name = "FichePaiementManagerImpl", interf = FichePaiementManagerRemote.class)
    protected FichePaiementManagerRemote managerfiche;

    public EcheancierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Echeancier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Echeancier(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	public List<EcheancierDlt> generateecheance(HttpHeaders headers) {
		Gson gson = new Gson();
		List<EcheancierDlt>echeancedlt= new ArrayList<EcheancierDlt>();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		Long periode =gson.fromJson(headers.getRequestHeader("periode").get(0), Long.class);
		String planif =gson.fromJson(headers.getRequestHeader("typePlanif").get(0), String.class);
		Date datedebut =gson.fromJson(headers.getRequestHeader("dateDeb").get(0), Date.class);
		System.out.println("EcheancierRSImpl.generateecheance() id "+id);
		System.out.println("EcheancierRSImpl.generateecheance() typlanif===="+planif+"Periode===="+periode+"datedébut===="+datedebut);
		Long total =(long) 0;
		if(planif.equals("0")&&id>0){
			System.out.println("EcheancierRSImpl.generateecheance() manager "+managerfiche);
			FichePaiement fiche = managerfiche.find("id", id);
			Long montantEch = (long) (fiche.getZtotal()/periode);
			for(int i=0;i<periode;i++){
				EcheancierDlt echeance = new EcheancierDlt();
				echeance.setId(i);
				echeance.setDateEch(DateHelper.nextMonth(datedebut, i));
				if(i==periode){
					echeance.setMnt((fiche.getZtotal()-total));
				}else{
					echeance.setMnt(montantEch);
					total +=montantEch;
				}//end if(i==periode){
				echeancedlt.add(echeance);
			}
		}
	
		return echeancedlt;
	}

}
