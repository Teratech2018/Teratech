
package com.kerenedu.notes;

import java.math.BigDecimal;
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
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.Appreciation;
import com.kerenedu.configuration.AppreciationDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "MatiereNoteManager")
public class MatiereNoteManagerImpl extends AbstractGenericManager<MatiereNote, Long>
		implements MatiereNoteManagerLocal, MatiereNoteManagerRemote {

	@EJB(name = "MatiereNoteDAO")
	protected MatiereNoteDAOLocal dao;

	@EJB(name = "AppreciationDAO")
	protected AppreciationDAOLocal daoapp;
	
	@EJB(name = "AnneScolaireDAO")
	protected AnneScolaireDAOLocal annedao;
	
	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal elevedao;
	
	@EJB(name = "NoteDetailDAO")
	protected NoteDetailDAOLocal daonote;


	public MatiereNoteManagerImpl() {
	}

	@Override
	public GenericDAO<MatiereNote, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<MatiereNote> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
	
		//predicats.addAll(container.getPredicats());
		List<MatiereNote> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<MatiereNote> result = new ArrayList<MatiereNote>();
		for (MatiereNote elev : datas) {
			result.add(new MatiereNote(elev));
		}
		return result;
	}

	@Override
	public MatiereNote find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		MatiereNote note = super.find(propertyName, entityID);
		MatiereNote data = new MatiereNote(note);

		for (NoteDetail detail : note.getNotelisttr()) {
			data.getNotelisttr().add(new NoteDetail(detail));
		}
//		for (NoteDetailPr detail : note.getNotesprimaire()) {
//			data.getNotesprimaire().add(new NoteDetailPr(detail));
//		}

		return data;
	}

	@Override
	public List<MatiereNote> findAll() {
		// TODO Auto-generated method stub
		List<MatiereNote> datas = super.findAll();

		return datas;
	}

	@Override
	public MatiereNote delete(Long id) {
		// TODO Auto-generated method stub
		MatiereNote elev = super.delete(id);
		return new MatiereNote(elev);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager#
	 * processBeforeSave(java.lang.Object)
	 */
	@Override
	public void processBeforeSave(MatiereNote entity) {
		// appreciation
		List<NoteDetail> notes = new ArrayList<NoteDetail>();
			for (NoteDetail not : entity.getNotelisttr()) {
				if (not.getNote() > 20) {
					throw new KerenExecption("la note ne peut etre supèrieure à 20 !!!");
				}
				if(entity.getClasse().getSection().getTypesection().equals("0")){
					not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelleen());
				}else{
					not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelle());
				}
				
				not.setMatricule(not.getEleve().getEleve().getMatricule());
				not.setNom(not.getEleve().getEleve().getNom()+" "+not.getEleve().getEleve().getPrenon());
				notes.add(not);
			}
			entity.setNotelisttr(notes);
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("connected", true);
			List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0, -1);
			if (annee == null || annee.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/> Aucune Année Scolaire disponible !!!");
			}
			//entity.setAnneScolaire(CacheMemory.getCurrentannee());
			entity.setAnneScolaire(annee.get(0).getCode());

		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(MatiereNote entity) {
		List<NoteDetail> notes = new ArrayList<NoteDetail>();
		if (entity.getExamen().getState().equals("fermé")) {
			throw new KerenExecption(
					"impossible de saisir les notes : les saisies pour cette séquence sont cloturée !!!");
		} else {
			if(entity.getClasse().getFiliere().getCycle().getTypecycle().equals("1")){
				for (NoteDetail not : entity.getNotelisttr()) {
					double snote1=0 ;double snote2=0;double notmoy=0;double snote3=0;
					snote1=not.getNote1()*entity.getExamen().getE1()/entity.getMatiere().getCoef();
					snote2=not.getNote2()*entity.getExamen().getE2()/entity.getMatiere().getCoef();
					snote3=not.getNote3()*entity.getExamen().getE2()/entity.getMatiere().getCoef();
				
					notmoy=(snote1+snote2+snote3)/3;
					 BigDecimal bd = new BigDecimal(notmoy);
					 bd= bd.setScale(2,BigDecimal.ROUND_DOWN);
					 notmoy = bd.doubleValue();

					not.setNote(notmoy);
					not.setSnote1(snote1);
					not.setSnote2(snote2);
					not.setSnote3(snote3);
					
					if (not.getNote() > 20) {
						throw new KerenExecption("la note ne peut etre supèrieure à 20 !!!");
					}
					if (not.getNote()<  0) {
						throw new KerenExecption("Mauvaise note  !!!");
					}
					if(entity.getClasse().getSection().getTypesection().equals("0")){
						not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelleen());
					}else{
						not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelle());
					}
					
					notes.add(not);
				}
				
			}else if(entity.getClasse().getFiliere().getCycle().getTypecycle().equals("2")){
			for (NoteDetail not : entity.getNotelisttr()) {
			
				double note1=0 ;double note2=0;double notmoy=0;double note3=0;
				if(not.getNote1()==0&&not.getNote2()!=0&&not.getNote3()!=0){
					 note1=0;
					 note2=not.getNote2()*entity.getExamen().getE3();
					 note3=not.getNote3()*entity.getExamen().getE3();
				}else if(not.getNote2()==0&&not.getNote1()!=0&&not.getNote3()!=0){
					 note2=0;
					 note1=not.getNote1()*entity.getExamen().getE3();
					 note3=not.getNote3()*entity.getExamen().getE3();
				}else if(not.getNote1()==0&&not.getNote2()==0&&not.getNote3()!=0){
					 note2=0;
					 note1=0;
					 note3=not.getNote3();
				}else if(not.getNote1()!=0&&not.getNote2()==0&&not.getNote3()==0){
					note2=(double) 0;
					note3=(double) 0;
					note1=not.getNote1();
				}else if(not.getNote1()==0&&not.getNote2()!=0&&not.getNote3()==0){
					note1=(double) 0;
					note3=(double) 0;
					note2=not.getNote2();
				}
				else if(not.getNote1()!=0&&not.getNote2()!=0&&not.getNote3()!=0){
					note3=not.getNote3()*entity.getExamen().getE3();
					note2=not.getNote2()*entity.getExamen().getE2();
					note1=not.getNote1()*entity.getExamen().getE1();
				}else if(not.getNote1()!=0&&not.getNote2()!=0&&not.getNote3()==0){
					note1=(double) 0;
					note2=not.getNote2()*entity.getExamen().getE3();
					note3=not.getNote1()*entity.getExamen().getE3();
				}else if(not.getNote1()==0&&not.getNote2()!=0&&not.getNote3()==0){
					note1=(double) 0;
					note2=(double) 0;
					note3=(double) 0;
				}

				 notmoy= note1+note2+note3;
				 BigDecimal bd = new BigDecimal(notmoy);
				 bd= bd.setScale(2,BigDecimal.ROUND_DOWN);
				 notmoy = bd.doubleValue();

				not.setNote(notmoy);
				if (not.getNote() > 20) {
					throw new KerenExecption("la note ne peut etre supèrieure à 20 !!!");
				}
				if (not.getNote()<  0) {
					throw new KerenExecption("Mauvaise note  !!!");
				}
				if(entity.getClasse().getSection().getTypesection().equals("0")){
					not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelleen());
				}else{
					not.setObs(this.getAppreciation(not.getNote().longValue()).getLibelle());
				}
				
				notes.add(not);
			}
			}
			entity.setNotelisttr(notes);
		}

		super.processAfterUpdate(entity);
	}

	private Appreciation getAppreciation(long note) {
		Appreciation app ;
		Appreciation value = daoapp.getAppreciation(note);
		if (value != null) {
			app =value;
		} else {
			Appreciation a = new Appreciation();
			a.setLibelle("RAS");
			a.setLibelleen("nothing");
			app =a;
		}
		return app;
	}

	@Override
	public List<MatiereNote> getCriteres(ViewMatiereClasseModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			
			if (critere.getSection() != null) {
				container.addEq("classe.section.id", critere.getSection().getId());
			}

		}
		List<MatiereNote> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<MatiereNote> result = new ArrayList<MatiereNote>();
		for (MatiereNote ins : datas) {
			MatiereNote note = find("id", ins.getId());
			MatiereNote inscription = new MatiereNote(ins);
			inscription.setNotelisttr(note.getNotelisttr());
			result.add(inscription);
		}
		return result;
	}

	@Override
	public void importNote(MatiereNote entity) {
		List<NoteDetail> datas = new ArrayList<NoteDetail>();
		MatiereNote mtnote= new MatiereNote();
		if(entity.getNotelisttr()!=null||!entity.getNotelisttr().isEmpty()){
		for(NoteDetail notes: entity.getNotelisttr()){
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			if (notes.getMatricule() != null) {
				container.addEq("eleve.matricule", notes.getMatricule());//+"/"+entity.getAnneScolaire());
			}
			container.addEq("classe.id",entity.getClasse().getId());//+"/"+entity.getAnneScolaire());
			
			List<Inscription> eleve = elevedao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		//	System.out.println("MatiereNoteManagerImpl.importNote() je suis ici size is "+eleve.size());
			if(eleve!=null&&!eleve.isEmpty()){
				notes.setEleve(eleve.get(0));
				notes.setMatricule(eleve.get(0).getMatricule());
				notes.setNom(eleve.get(0).getEleve().getNom()+" "+eleve.get(0).getEleve().getPrenon());
				notes.setAnneScolaire(entity.getAnneScolaire());
				notes.setClasse(entity.getClasse());
				notes.setTypeexamen(entity.getExamen().getTypesequence());
				//notes.setMatiere(entity.getMatiere());
				datas.add(notes);
			}
			
		}
			//System.out.println("MatiereNoteManagerImpl.importNote() nombre de note"+datas.toString()+" size"+datas.size());
			 mtnote= new MatiereNote(entity);
			 mtnote.setNotelisttr(datas);
			// System.out.println("MatiereNoteManagerImpl.importNote() note taille"+mtnote.getNotelisttr().size());
			this.update(mtnote.getId(), mtnote);
				
			
		}
		
	}
		
	

}
