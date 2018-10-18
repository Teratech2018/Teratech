
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieManager")
public class PeriodePaieManagerImpl
    extends AbstractGenericManager<PeriodePaie, Long>
    implements PeriodePaieManagerLocal, PeriodePaieManagerRemote
{

    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal dao;
    
    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal bulletinpaiedao;

    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal elementvariabledao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal exerciceComptableDao;

    public PeriodePaieManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<PeriodePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<PeriodePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<PeriodePaie> result = new ArrayList<PeriodePaie>();
   		for(PeriodePaie elev:datas){
   			result.add(new PeriodePaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(PeriodePaie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public PeriodePaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		PeriodePaie elev = super.find(propertyName, entityID);
   		PeriodePaie inscrip = new PeriodePaie(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<PeriodePaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<PeriodePaie> datas = super.findAll();
   		List<PeriodePaie> result = new ArrayList<PeriodePaie>();
   		for(PeriodePaie elev:datas){
   			result.add(new PeriodePaie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public PeriodePaie delete(Long id) {
   		// TODO Auto-generated method stub
   		PeriodePaie elev = super.delete(id);
   		return new PeriodePaie(elev);
   	}
    /**
     * Gere les traiteents apres une mise à jour en bd
     * @author ABEGA ABEGA SERGE
     * @param entity 
     */
    @Override
    public void processAfterUpdate(PeriodePaie entity) {
        
//        for(BulletinPaie aas:entity.getSalaires()){
//
//            
//            aas.setPeriode(entity);
//
//            if(aas.getId()>0){
//                bulletinpaiedao.update(aas.getId(), aas);
//            }else {
//                bulletinpaiedao.save(aas);
//            }
//        }
//
//         for(ElementVariable aas:entity.getVariables()){
//
//            aas.setPeiode(entity);
//
//            if(aas.getId()>0){
//                elementvariabledao.update(aas.getId(), aas);
//            }else {
//                elementvariabledao.save(aas);
//            }
//        }
         
        super.processAfterUpdate(entity);
    }
    
     /**
     * Gere les traiteents avant une persistence en bd
     * @author ABEGA ABEGA SERGE
     * @param entity 
     */
    @Override
    public void processAfterSave(PeriodePaie entity) {
        entity = dao.findByPrimaryKey("code", entity.getCode());
         
//        for(BulletinPaie aas:entity.getSalaires()){
//            aas.setPeriode(entity);
//
//            if(aas.getId()>0){
//                bulletinpaiedao.update(aas.getId(), aas);
//            }else {
//                bulletinpaiedao.save(aas);
//            }
//        }
//
//        for(ElementVariable aas:entity.getVariables()){
//            aas.setPeiode(entity);
//
//            if(aas.getId()>0){
//                elementvariabledao.update(aas.getId(), aas);
//            }else {
//                elementvariabledao.save(aas);
//            }
//        }
        
        super.processAfterSave(entity);
    }
        
    @Override
    public PeriodePaie getPeriodeFromDate(Date date) {
        // TODO Auto-generated method stub
//		String requete= "SELECT c FROM PeriodePaie p WHERE p.ddebut <= ?1 AND p.dfin >= ?2";
//		Query query = dao.getEntityManager().createQuery(requete);
//		query.setParameter(1,date, TemporalType.DATE);
//		query.setParameter(2,date, TemporalType.DATE);
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addLe("ddebut", date);
        container.addGe("dfin", date);
        List<PeriodePaie> datas = dao.filter(container.getPredicats(), new HashMap<String, OrderType>(), null, 0, -1);

        if(!datas.isEmpty()){
                return datas.get(0);
        }

        return null;
    }


}
