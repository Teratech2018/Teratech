
package com.keren.courrier.core.impl.courrier;

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
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "LigneBorderoCourrierManager")
public class LigneBorderoCourrierManagerImpl
    extends AbstractGenericManager<LigneBorderoCourrier, Long>
    implements LigneBorderoCourrierManagerLocal, LigneBorderoCourrierManagerRemote
{

    @EJB(name = "LigneBorderoCourrierDAO")
    protected LigneBorderoCourrierDAOLocal dao;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;


    public LigneBorderoCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBorderoCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public boolean originalAllReadyaffect(LigneBorderoCourrier ligne , StructureCompany service) {
        //To change body of generated methods, choose Tools | Templates.
        if(ligne.getCourrier().getBordero()==null){
            return false;
        }else if(ligne.getCourrier().getBordero().getCible().compareTo(service)!=0 && ligne.getNature().trim().equalsIgnoreCase("0")){
            return true;
        }
        return false;
    }

	@Override
	public List<LigneBorderoCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<CourrierClone> courriers = courrierdao.filter(predicats, orders, properties, firstResult, maxResult);
		List<LigneBorderoCourrier> results = new ArrayList<LigneBorderoCourrier>();
		for(CourrierClone courrier:courriers){
			results.add(new LigneBorderoCourrier(courrier));
		}//end for(CourrierClone courrier:courriers){
		return results;
	}
    
    

}
