
package com.kerenedu.solde;

import java.util.ArrayList;
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
import com.kerem.core.KerenExecption;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RemboursementAvanceManager")
public class RemboursementAvanceManagerImpl
    extends AbstractGenericManager<RemboursementAvance, Long>
    implements RemboursementAvanceManagerLocal, RemboursementAvanceManagerRemote
{

    @EJB(name = "RemboursementAvanceDAO")
    protected RemboursementAvanceDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    
    @EJB(name = "AvanceSalaireDAO")
    protected AvanceSalaireDAOLocal avancedao;
    
    

    public RemboursementAvanceManagerImpl() {
    }

    @Override
    public GenericDAO<RemboursementAvance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public RemboursementAvance delete(Long id) {

        // TODO Auto-generated method stub
        return super.delete(id);
    }

    @Override
    public List<RemboursementAvance> filter(List<Predicat> predicats, Map<String, OrderType> orders,
                    Set<String> properties, int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<RemboursementAvance> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<RemboursementAvance> result = new ArrayList<RemboursementAvance>();

        for(RemboursementAvance data:datas){
            result.add(new RemboursementAvance(data));
        }

        return result;
    }

    @Override
    public RemboursementAvance find(String propertyName, Long entityID) { 

        // TODO Auto-generated method stub
        RemboursementAvance data= super.find(propertyName, entityID);
        RemboursementAvance result = new RemboursementAvance(data);

        return result;
    }

    @Override
    public List<RemboursementAvance> findAll() {

        // TODO Auto-generated method stub
        List<RemboursementAvance> datas =super.findAll();
        List<RemboursementAvance> result = new ArrayList<RemboursementAvance>();

        for(RemboursementAvance data:datas){
            result.add(new RemboursementAvance(data));
        }

        return result;
    }

    /**
     * 
     * @param entity
     * @param periode
     * @return
     */
    @Override
    public RemboursementAvance valider(RemboursementAvance entity,PeriodePaie periode) {

        // TODO Auto-generated method stub
        //Traitement des Elements Variables de paie
        periode = periodedao.findByPrimaryKey("id", periode.getId());
        ElementVariable element = null ;
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("salarie0", entity.getAvance().getEmploye());
        container.addEq("peiode", periode);
        List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1); 

        if(datas!=null && datas.size()>0){
            element = datas.get(0);
        }//end if(datas!=null && datas.size()>0)

        if(element==null){
            element = new ElementVariable();
            element.setSalarie(entity.getAvance().getEmploye());
            element.setPeriode(periode);		
            variabledao.save(element);
            datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);

            if(datas!=null && datas.size()>0){
                element = datas.get(0);
            }
        }//end if(element==null)

        entity.setEltVariable(element);
        entity.setState("confirme");

        dao.update(entity.getId(), entity);	
        
        // mis à jour de l'avance
        int remvalide =0;
        int remconfirme=0;
        int remrefuse=0;
        AvanceSalaire avance = avancedao.findByPrimaryKey("id",entity.getAvance().getId());
        for(RemboursementAvance rem : avance.getRemboursements()){
        	if(rem.getState().equals("etabli")){
        		remvalide=remvalide+1;
        	}else if(rem.getState().equals("confirme")){
        		remconfirme=remconfirme+1;
        	}else{
        		remrefuse=remrefuse+1;
        	}
        }
        if(remvalide!=0){
        	avance.setState("encours");
        	avancedao.update(avance.getId(), avance);
        }else{
        	avance.setState("termine");
        	avancedao.update(avance.getId(), avance);
        }
        return entity;
    }

    @Override
    public RemboursementAvance refuser(RemboursementAvance entity) {
        
        // TODO Auto-generated method stub
        entity.setState("refuse");
        dao.update(entity.getId(), entity);
        return entity;
    }
    
    @Override
	public void processBeforeDelete(RemboursementAvance entity) {
		 if(!entity.getState().equals("etabli")){
	           throw new KerenExecption("Ce Remboursement ne peut être Supprimer");
	    }
		super.processBeforeDelete(entity);
	}

}
