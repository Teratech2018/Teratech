
package com.kerenedu.solde;

import java.math.BigDecimal;
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
import com.core.tools.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandePretManager")
public class DemandePretManagerImpl
    extends AbstractGenericManager<DemandePret, Long>
    implements DemandePretManagerLocal, DemandePretManagerRemote
{

    @EJB(name = "DemandePretDAO")
    protected DemandePretDAOLocal dao;
    
    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal remdao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
	@EJB(name = "AnneScolaireDAO")
	protected AnneScolaireDAOLocal annedao;

    public DemandePretManagerImpl() {
    }

    @Override
    public GenericDAO<DemandePret, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public DemandePret delete(Long id) {

        // TODO Auto-generated method stub
        DemandePret  data = super.delete(id);
        return new DemandePret(data);
    }

    @Override
    public List<DemandePret> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<DemandePret> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<DemandePret> result = new ArrayList<DemandePret>();

        for(DemandePret data:datas){
         result.add(new DemandePret(data));
        }

        return result;
    }

    @Override
    public DemandePret find(String propertyName, Long entityID) {
            // TODO Auto-generated method stub
            DemandePret data = super.find(propertyName, entityID);
            DemandePret result = new DemandePret(data);
            for(RemboursementPret pret:data.getRemboursements()){
               result.getRemboursements().add(new RemboursementPret(pret));
            }
            return result;
    }

    @Override
    public List<DemandePret> findAll() {

        // TODO Auto-generated method stub
        List<DemandePret> datas = super.findAll();
        List<DemandePret> result = new ArrayList<DemandePret>();

        for(DemandePret data:datas){
          result.add(new DemandePret(data));
        }

        return result;
    }

    @Override
    public DemandePret generereglements(DemandePret entity) {
    	// System.out.println("DemandePretManagerImpl.generereglements() save begin !!!");
        // TODO Auto-generated method stub
        int duree = entity.getDuree();
        
        if(entity.getTypepret() == null){
           // System.out.println(" ====== >>> TESSS 01");
        }
        
        if(entity.getTypepret().getGelee() == null){
         //   System.out.println(" ====== >>> TESSS 02");
        }
        
        if(entity.getTypepret().getGelee()){
            duree = entity.getDuree();
        }
        
		double val = entity.getMontantsol();
		double val1 = duree;

		Double traite1 = (double) (val / val1);
		BigDecimal bd = new BigDecimal(traite1);
		bd = bd.setScale(0, BigDecimal.ROUND_UP);
		Double netarond = bd.doubleValue();

        Long traite = netarond.longValue();
        Double total = 0.0;
        List<RemboursementPret> remboursements = new ArrayList<RemboursementPret>();

        for(int i=0;i<duree;i++){
 
            RemboursementPret rem = new RemboursementPret();
            rem.setDemande(entity);
            rem.setActif(true);
            rem.setPret(entity.getTypepret());
            rem.setEmplid(entity.getEmploye().getId());
            rem.setAnneScolaire(entity.getAnneScolaire());
          //  rem.setSociete(entity.getEmploye().getStructure());
            rem.setDate(DateHelper.nextMonth(entity.getDrembour(), i));

            if(i==entity.getDuree()){
                    rem.setMontant(entity.getMontantpro()-total);
            }else{
                    rem.setMontant((double)traite);
                    total +=traite;
            }//end if(i==entity.getDuree())
            rem.setState("confirme");
           
            rem= remdao.save(rem);
            RemboursementPret rementity = remdao.findByPrimaryKey("id", rem.getId()); 
            RestrictionsContainer container = RestrictionsContainer.newInstance();
    		container.addEq("elvapid",rementity.getId());
    		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
    		if(datas!=null){
    			ElementVariable elt=datas.get(0);
    			rementity.setEltVariable(elt);
    			remdao.update(rementity.getId(), rementity);
    		}
    		
          //  System.out.println("DemandePretManagerImpl.generereglements() save ok !!!");
//               
          //  this.confirme(rementity, periode);
        }//end for(int i=1;i<entity.getDuree();i++){

        //Chargement de l'entity
        return find("id", entity.getId());
        
    }
    
    /**
	 * Permete de verifier que ;
	 * il exites une periode ouvert contenant la date
	 *  du remboursement en cours
	 * @param entity
	 */
	private PeriodePaie periodeChecker(RemboursementPret entity){
		  PeriodePaie periode = periodedao.getPeriodeFromDate(entity.getDate());
		  if(periode==null){
			  throw new KerenExecption("Impossible de trouver une période contenant cette date");
		  }else if(periode.getState().equalsIgnoreCase("etabli")){
			  throw new KerenExecption("La periode "+periode.getDesignation()+" n'est pas ouverte <br/> Veuillez ouvrir la periode");
		  }else if(periode.getState().equalsIgnoreCase("ferme")){
			  throw new KerenExecption("La période "+periode.getDesignation()+" est déjà fermée");
		  }
		  return periode;
	}
    
    private void confirme(RemboursementPret entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getDemande().getEmploye());
		container.addEq("periode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}//end if(datas!=null && datas.size()>0)
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getDemande().getEmploye());
			element.setPeriode(periode);		
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}
		}//end if(element==null)
		entity.setEltVariable(element);
		entity.setState("confirme");
		remdao.update(entity.getId(), entity);
		
	}

    @Override
    public DemandePret confirme(DemandePret entity) {

        // TODO Auto-generated method stub
        entity.setState("confirme");
        dao.update(entity.getId(), entity);
        return entity;
    }
    
    

    @Override
	public void processAfterSave(DemandePret entity) {
	//
		super.processAfterSave(entity);
	}

	@Override
    public DemandePret annule(DemandePret entity) {
        // TODO Auto-generated method stub
        entity.setState("annule");
        DemandePret pret = dao.findByPrimaryKey("id", entity.getId());
        List<RemboursementPret> remlist = new ArrayList<RemboursementPret>();
        for(RemboursementPret rem: pret.getRemboursements()){
        	rem.setState("annule");
        	ElementVariable elem = rem.getEltVariable();
        	elem.setState("inactif");
        	variabledao.update(elem.getId(), elem);
        	//variabledao.delete(rem.getId());
        }
        entity.setRemboursements(remlist);
        dao.update(entity.getId(), entity);
        return entity;
    }

}
