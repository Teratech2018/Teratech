
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
@Path("/echeancierdlt")
public class EcheancierDltRSImpl
    extends AbstractGenericService<EcheancierDlt, Long>
    implements EcheancierDltRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EcheancierDltManagerImpl", interf = EcheancierDltManagerRemote.class)
    protected EcheancierDltManagerRemote manager;

    public EcheancierDltRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EcheancierDlt, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new EcheancierDlt(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	public List<EcheancierDlt> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		String predicates = arg0.getRequestHeader("predicats").get(0);
		System.out.println(EcheancierDltRSImpl.class.toString()+" =================  "+predicates);
		return super.filter(arg0, arg1, arg2);
	}

	@Override
	public RSNumber count(HttpHeaders arg0) {
		// TODO Auto-generated method stub
		String predicates = arg0.getRequestHeader("predicats").get(0);
		System.out.println(EcheancierDltRSImpl.class.toString()+" =================  "+predicates);
		return super.count(arg0);
	}

	

  


}
