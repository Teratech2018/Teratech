
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.kerenedu.solde.ParaCoutMatiere;
import com.kerenedu.solde.ParaCoutMatiereDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EmargementPeriodeManager")
public class EmargementPeriodeManagerImpl
    extends AbstractGenericManager<EmargementPeriode, Long>
    implements EmargementPeriodeManagerLocal, EmargementPeriodeManagerRemote
{

    @EJB(name = "EmargementPeriodeDAO")
    protected EmargementPeriodeDAOLocal dao;
    
    @EJB(name = "EnseignantSecondaireDAO")
    protected EnseignantSecondaireDAOLocal daoprof;
    
    @EJB(name = "ProfesseurDAO")
    protected ProfesseurDAOLocal daovac;
    
    @EJB(name = "EmargementDtlPeriodeDAO")
    protected EmargementDtlPeriodeDAOLocal daodtl;
    
    @EJB(name = "ParaCoutMatiereDAO")
    protected ParaCoutMatiereDAOLocal daocout;

    public EmargementPeriodeManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementPeriode, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<EmargementPeriode> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
//    	RestrictionsContainer container = RestrictionsContainer.newInstance();
//    	container.addEq("discriminant","P");   	
//    	predicats.addAll(container.getPredicats());
   		List<EmargementPeriode> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EmargementPeriode> result = new ArrayList<EmargementPeriode>();
   		for(EmargementPeriode elev:datas){
   			result.add(new EmargementPeriode(elev));
   		}
   		return result;
   	}

   	@Override
   	public EmargementPeriode find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EmargementPeriode elev = super.find(propertyName, entityID);
   		EmargementPeriode inscrip = new EmargementPeriode(elev);
   		for (EmargementDtlPeriode serv : elev.getEmagementdlt()) {
			inscrip.getEmagementdlt().add(new EmargementDtlPeriode(serv));
		}
   		return inscrip;
   	}

   	@Override
   	public List<EmargementPeriode> findAll() {
   		// TODO Auto-generated method stub
   		List<EmargementPeriode> datas = super.findAll();
   		List<EmargementPeriode> result = new ArrayList<EmargementPeriode>();
   		for(EmargementPeriode elev:datas){
   			result.add(new EmargementPeriode(elev));
   		}
   		return result;
   	}
   	
 
	@Override
   	public EmargementPeriode delete(Long id) {
   		// TODO Auto-generated method stub
		EmargementPeriode elev = super.delete(id);
   		return new EmargementPeriode(elev);
   	}
	
	@Override
	public void importNote(EmargementPeriode entity) {
		List<EmargementDtlPeriode> datas = new ArrayList<EmargementDtlPeriode>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		EmargementPeriode mtnote= new EmargementPeriode();
		
		if(entity.getEmagementdlt()!=null||!entity.getEmagementdlt().isEmpty()){
			
		for(EmargementDtlPeriode notes: entity.getEmagementdlt()){
			container = RestrictionsContainer.newInstance();
			if (notes.getMatricule() != null) {
				container.addEq("matricule", notes.getMatricule());//+"/"+entity.getAnneScolaire());
			}
			//System.out.println("EmargementPeriodeManagerImpl.importNote() matricule is "+notes.getMatricule());
			//container.addEq("status", "0");
			List<Professeur> prof = daovac.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			if(prof!=null&&!prof.isEmpty()){
				notes.setProf(prof.get(0));
				notes.setMatricule(prof.get(0).getMatricule());
				notes.setNom(prof.get(0).getNom());
				notes.setPeriode(entity.getPeriode());
				notes.setAnneScolaire(entity.getPeriode().getExercice().getCode());
				notes.setDsaisie(entity.getPeriode().getDfin());
			}
			// get cout matiere
//			container = RestrictionsContainer.newInstance();
//			if(notes.getMatiere()!=null){
//				container.addEq("code", notes.getMatiere());
//			}
//			List<ParaCoutMatiere> cout = daocout.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
//			if(cout!=null&&!cout.isEmpty()){
//				notes.setCout(cout.get(0));
//			}
			
			datas.add(notes);
		}
		//System.out.println("EmargementPeriodeManagerImpl.importNote() datas ud size"+datas.size());
		container = RestrictionsContainer.newInstance();
		container.addEq("periode.id", entity.getPeriode().getId());
		List<EmargementPeriode> emargelist= dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		if(emargelist!=null&&!emargelist.isEmpty()&&emargelist.size()!=0){
			for(EmargementPeriode em : emargelist){
				dao.deleteemarge(em);
				}
			}

			 mtnote= new EmargementPeriode(entity);
			 mtnote.setEmagementdlt(datas);
			 mtnote.setPeriode(entity.getPeriode());
			
			// System.out.println("MatiereNoteManagerImpl.importNote() note taille"+mtnote.getNotelisttr().size());
			this.save(mtnote);
				
			
		}
	}
		
}
