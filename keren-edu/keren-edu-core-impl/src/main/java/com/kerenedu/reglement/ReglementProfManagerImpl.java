
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
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReglementProfProfManager")
public class ReglementProfManagerImpl
    extends AbstractGenericManager<ReglementProf, Long>
    implements ReglementProfManagerLocal, ReglementProfManagerRemote
{

    @EJB(name = "ReglementProfProfDAO")
    protected ReglementProfDAOLocal dao;

    public ReglementProfManagerImpl() {
    }

    @Override
    public GenericDAO<ReglementProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ReglementProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<ReglementProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ReglementProf> result = new ArrayList<ReglementProf>();
   		for(ReglementProf elev:datas){
   			result.add(new ReglementProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public ReglementProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ReglementProf data = super.find(propertyName, entityID);
   		ReglementProf result = new ReglementProf(data);
   			for(FichePaiementProf fiche : data.getFicheProf()){
   				result.getFicheProf().add(new FichePaiementProf(fiche));
   			}
   			
   			for(PaiementProf paie : data.getPaiement()){
   				result.getPaiement().add(new PaiementProf(paie));
   			}
   			
   			for(AvanceProf ech : data.getAvance()){
   				result.getAvance().add(new AvanceProf(ech));
   			}
   			
   			for(PrimeProf prime : data.getPrime()){
   				result.getPrime().add(new PrimeProf(prime));
   			}
   			
   			for(RetenueProf retenue : data.getRetenue()){
   				result.getRetenue().add(new RetenueProf(retenue));
   			}
   			
   			
		
	   	
 	return result;

   	}

   	@Override
   	public List<ReglementProf> findAll() {
   		// TODO Auto-generated method stub
   		List<ReglementProf> datas = super.findAll();
   		List<ReglementProf> result = new ArrayList<ReglementProf>();
   		for(ReglementProf elev:datas){
   			result.add(new ReglementProf(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ReglementProf delete(Long id) {
   		// TODO Auto-generated method stub
   		ReglementProf elev = super.delete(id);
   		return new ReglementProf(elev);
   	}

	@Override
	public void processBeforeSave(ReglementProf entity) {
//		entity=this._afterOperation(entity);
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(ReglementProf entity) {
//		entity=this._afterOperation(entity);
		
		super.processBeforeUpdate(entity);
	}
	
//	private ReglementProf _afterOperation(ReglementProf entity){
//		List<FichePaiement>listFp= new ArrayList<FichePaiement>();
//		Long scolarite = new Long(0);
//		Long payer = new Long(0);
//		Long solde = new Long(0);
//		Long total = new Long(0);
//		Double tva = new Double(0);
//		Double remise = new Double(0);
//		 RestrictionsContainer container = RestrictionsContainer.newInstance();
//		 container.addEq("connected", true);
//		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
//       if(annee==null||annee.size()==0){
//           RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
//           throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
//       }
//       entity.setAnneScolaire(annee.get(0).getCode());
//       
//       
//		for(FichePaiement fp : entity.getService()){
//			total = fp.getzQte()*fp.getzMntHt();
//			System.out.println("ReglementProfManagerImpl.processBeforeUpdate() tva saisie is "+fp.getZtva());
//			if(fp.getZtva()!=null&&fp.getZtva()!=new Long(0)){
//			tva = (fp.getZtva().doubleValue()/100*total); 
//			System.out.println("ReglementProfManagerImpl.processBeforeUpdate() tva saisie pourcent "+fp.getZtva().doubleValue()/100);
//			System.out.println("ReglementProfManagerImpl.processBeforeUpdate() tva is "+tva);
//			}
//			if(fp.getZremise()!=null&&fp.getZremise()!=new Long(0)){
//			remise = (fp.getZremise().doubleValue()/100*total);
//			System.out.println("ReglementProfManagerImpl.processBeforeUpdate() Remise is "+fp.getZremise().doubleValue()/100);
//			}
//			total=(total+tva.longValue())-remise.longValue();
//			fp.setEleve(entity.getEleve());
//			fp.setZtotal(total);
//			scolarite=scolarite+fp.getZtotal();
//			listFp.add(fp);
//		}
//		for(Paiement p : entity.getPaiement()){
//			payer=payer+p.getzMnt();
//		}
//		solde = scolarite-payer;
//		entity.setScolarite(scolarite);
//		entity.setService(listFp);
//		entity.setPayer(payer);
//		entity.setSolde(solde);
//		Inscription ins=daoIns.findByPrimaryKey("id", entity.getEleve().getId());
//		ins.setzMntPaye(new BigDecimal(entity.getPayer()));
//		ins.setzMnt(new BigDecimal(entity.getScolarite()));
//		ins.setzSolde(new BigDecimal(entity.getSolde()));
//		daoIns.update(ins.getId(), ins);
//		return entity;
//		
//	}
	
	

}
