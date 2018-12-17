
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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.MatiereNote;
import com.kerenedu.notes.NoteDetail;
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
		EmargementPeriode mtnote= new EmargementPeriode();
		if(entity.getEmagementdlt()!=null||!entity.getEmagementdlt().isEmpty()){
		for(EmargementDtlPeriode notes: entity.getEmagementdlt()){
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			if (notes.getMatricule() != null) {
				container.addEq("prof.matricule", notes.getMatricule());//+"/"+entity.getAnneScolaire());
			}
			
			List<EnseignantSecondaire> prof = daoprof.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			if(prof!=null&&!prof.isEmpty()){
				notes.setProf(prof.get(0));
				notes.setMatricule(prof.get(0).getMatricule());
				notes.setNom(prof.get(0).getNom());
				notes.setPeriode(entity.getPeriode());
				datas.add(notes);
			}
		}
			//System.out.println("MatiereNoteManagerImpl.importNote() nombre de note"+datas.toString()+" size"+datas.size());
			 mtnote= new EmargementPeriode(entity);
			 mtnote.setEmagementdlt(datas);
			// System.out.println("MatiereNoteManagerImpl.importNote() note taille"+mtnote.getNotelisttr().size());
			this.update(mtnote.getId(), mtnote);
				
			
		}
	}
		
}
