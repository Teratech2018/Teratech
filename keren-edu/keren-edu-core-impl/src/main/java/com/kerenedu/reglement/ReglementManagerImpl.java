
package com.kerenedu.reglement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReglementManager")
public class ReglementManagerImpl
    extends AbstractGenericManager<Reglement, Long>
    implements ReglementManagerLocal, ReglementManagerRemote
{

    @EJB(name = "ReglementDAO")
    protected ReglementDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;  
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;

    public ReglementManagerImpl() {
    }

    @Override
    public GenericDAO<Reglement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Reglement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Reglement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Reglement> result = new ArrayList<Reglement>();
   		for(Reglement elev:datas){
   			result.add(new Reglement(elev));
   		}
   		return result;
   	}

   	@Override
   	public Reglement find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Reglement data = super.find(propertyName, entityID);
   		Reglement result = new Reglement(data);
   			for(FichePaiement fiche : data.getService()){
   				result.getService().add(new FichePaiement(fiche));
   			}
   			
   			for(Paiement paie : data.getPaiement()){
   				result.getPaiement().add(new Paiement(paie));
   			}
   			
   			for(Echeancier ech : data.getEcheance()){
   				result.getEcheance().add(new Echeancier(ech));
   			}
   			
   			for(Retard retard : data.getRetard()){
   				result.getRetard().add(new Retard(retard));
   			}
   			
   			
		
	   	
 	return result;

   	}

   	@Override
   	public List<Reglement> findAll() {
   		// TODO Auto-generated method stub
   		List<Reglement> datas = super.findAll();
   		List<Reglement> result = new ArrayList<Reglement>();
   		for(Reglement elev:datas){
   			result.add(new Reglement(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Reglement delete(Long id) {
   		// TODO Auto-generated method stub
   		Reglement elev = super.delete(id);
   		return new Reglement(elev);
   	}

	@Override
	public void processBeforeSave(Reglement entity) {
		entity=this._afterOperation(entity);
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(Reglement entity) {
		entity=this._afterOperation(entity);
		
		super.processBeforeUpdate(entity);
	}
	
	private Reglement _afterOperation(Reglement entity){
		List<FichePaiement>listFp= new ArrayList<FichePaiement>();
		Long scolarite = new Long(0);
		Long payer = new Long(0);
		Long solde = new Long(0);
		Long total = new Long(0);
		Double tva = new Double(0);
		Double remise = new Double(0);
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
       if(annee==null||annee.size()==0){
           RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
           throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
       }
       entity.setAnneScolaire(annee.get(0).getCode());
       
       
		for(FichePaiement fp : entity.getService()){
			total = fp.getzQte()*fp.getzMntHt();
			System.out.println("ReglementManagerImpl.processBeforeUpdate() tva saisie is "+fp.getZtva());
			if(fp.getZtva()!=null&&fp.getZtva()!=new Long(0)){
			tva = (fp.getZtva().doubleValue()/100*total); 
			System.out.println("ReglementManagerImpl.processBeforeUpdate() tva saisie pourcent "+fp.getZtva().doubleValue()/100);
			System.out.println("ReglementManagerImpl.processBeforeUpdate() tva is "+tva);
			}
			if(fp.getZremise()!=null&&fp.getZremise()!=new Long(0)){
			remise = (fp.getZremise().doubleValue()/100*total);
			System.out.println("ReglementManagerImpl.processBeforeUpdate() Remise is "+fp.getZremise().doubleValue()/100);
			}
			total=(total+tva.longValue())-remise.longValue();
			fp.setEleve(entity.getEleve());
			fp.setZtotal(total);
			scolarite=scolarite+fp.getZtotal();
			listFp.add(fp);
		}
		for(Paiement p : entity.getPaiement()){
			payer=payer+p.getzMnt();
		}
		solde = scolarite-payer;
		entity.setScolarite(scolarite);
		entity.setService(listFp);
		entity.setPayer(payer);
		entity.setSolde(solde);
		Inscription ins=daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		ins.setzMntPaye(new BigDecimal(entity.getPayer()));
		ins.setzMnt(new BigDecimal(entity.getScolarite()));
		ins.setzSolde(new BigDecimal(entity.getSolde()));
		daoIns.update(ins.getId(), ins);
		return entity;
		
	}
	
	
   	

}
