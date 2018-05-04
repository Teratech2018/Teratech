
package com.keren.kerenpaie.core.impl.rapports;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.rapports.ViewDipePaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.rapports.ViewDipePaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewDipePaieDAOLocal;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;

@TransactionAttribute
@Stateless(mappedName = "ViewDipePaieManager")
public class ViewDipePaieManagerImpl
    extends AbstractGenericManager<ViewDipePaie, Long>
    implements ViewDipePaieManagerLocal, ViewDipePaieManagerRemote
{

    @EJB(name = "ViewDipePaieDAO")
    protected ViewDipePaieDAOLocal dao;

    public ViewDipePaieManagerImpl() {
    }

    @Override
    public GenericDAO<ViewDipePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<ViewDipePaie> getCriteres(ViewDipePaie critere) {
		   //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        List<ViewDipePaie> datas = new ArrayList<ViewDipePaie>();
        if(critere!=null){     	
        		  if(critere.getPeriode()!=null){
                      container.addEq("periode.id", critere.getPeriode().getId());
                  }
        		 datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
        		 System.out.println("ViewDipePaieManagerImpl.getCriteres() nombre selection "+datas.size());
        }
        List<ViewDipePaie>  result = new ArrayList<ViewDipePaie>();
        for(ViewDipePaie ecrit:datas){            
        	ViewDipePaie ecriture = new ViewDipePaie(ecrit);
            result.add(ecriture);
        }
        return result;
	}
	  
    
}
