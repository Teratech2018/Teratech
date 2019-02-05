
package com.kerenedu.personnel;

import java.io.File;
import java.io.IOException;
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
import com.kerem.core.FileHelper;
import com.kerenedu.allerte.ViewHelperTrtglobal;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.notes.CoefMatiereDetailDAOLocal;
import com.kerenedu.solde.EltSalaireLigne;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ProfesseurManager")
public class ProfesseurManagerImpl
    extends AbstractGenericManager<Professeur, Long>
    implements ProfesseurManagerLocal, ProfesseurManagerRemote
{

    @EJB(name = "ProfesseurDAO")
    protected ProfesseurDAOLocal dao;
    
    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal daocoefmat;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal daoclasse;
    
    @EJB(name = " AnneScolaireDAO")
    protected AnneScolaireDAOLocal daoanne;

    public ProfesseurManagerImpl() {
    }

    @Override
    public GenericDAO<Professeur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Professeur> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
//    	RestrictionsContainer container = RestrictionsContainer.newInstance();
//    	container.addEq("discriminant","P");   	
//    	predicats.addAll(container.getPredicats());
   		List<Professeur> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Professeur> result = new ArrayList<Professeur>();
   		for(Professeur elev:datas){
   			result.add(new Professeur(elev));
   		}
   		return result;
   	}

   	@Override
   	public Professeur find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Professeur elev = super.find(propertyName, entityID);
   		Professeur inscrip = new Professeur(elev);
		
   		return inscrip;
   	}

   	@Override
   	public List<Professeur> findAll() {
   		// TODO Auto-generated method stub
   		List<Professeur> datas = super.findAll();
   		List<Professeur> result = new ArrayList<Professeur>();
   		for(Professeur elev:datas){
   			result.add(new Professeur(elev));
   		}
   		return result;
   	}
   	
   	
   	
   	

   	@Override
	public void processBeforeSave(Professeur entity) {
		// set defaut valeur
//   		this.salaire= eleve.salaire;
//		this.thoraire=eleve.thoraire;
//		this.numBan=eleve.numBan;
//		this.role=eleve.role;
//		this.zavance=eleve.zavance;
//		this.zprime=eleve.zprime;
//		this.zretenu=eleve.zretenu;
//		this.salaire=eleve.salaire;
   		entity.setSalmax((long) 0);
		super.processBeforeSave(entity);
	}

	@Override
   	public Professeur delete(Long id) {
   		// TODO Auto-generated method stub
   		Professeur elev = super.delete(id);
   		return new Professeur(elev);
   	}

	public List<Professeur> findprofclasse(Long id) {
		List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>() ;
		 List<Professeur> result = new ArrayList<Professeur>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
			if(id>0){
				// recherche l'objet classe
				container = RestrictionsContainer.newInstance();
				container.addEq("id",id);
				Classe classe = daoclasse.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
				
				container = RestrictionsContainer.newInstance();
				 container.addEq("classe.id",id);
				 datas = daocoefmat.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				 if(datas!=null||datas.size()!=0){
					 for(CoefMatiereDetail cmdlt :datas){
						 result.add(new Professeur(cmdlt.getProffesseur()));
					 }
					 // triatement des doublons 
					 Set<Professeur> set = new HashSet<Professeur>();
					 set.addAll(result);
					 List<Professeur> listDistinct = new ArrayList<Professeur>(set);
					 result=listDistinct;
				 }// fin  if(datas!=null||datas.size()!=0)
			}// fin if(id>0)
		return result;
}

	@Override
	public List<EltSalaireLigne> getLigneSalaire(Long id) {
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 List<EltSalaireLigne> result = new ArrayList<EltSalaireLigne>();
			if(id>0){
				// recherche l'objet classe
				container = RestrictionsContainer.newInstance();
				container.addEq("status","0");
				List<Professeur> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				if(datas!=null){
					for(Professeur  p : datas){
						result.add(new EltSalaireLigne(p));
					}
				}
			}
				
		return result;
	}
	
	@Override
	public void processAfterSave(Professeur entity) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("connected", true);
		List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
		// set Matricule 
		entity.setMatricule(ViewHelperTrtglobal.getMatricule(entity, annee.get(0)));
		 if(entity.getImage()!=null){
	    	  // try {
	    	   String imageName = entity.getImage();
	    	   System.out.println("EleveRSImpl.processAfterSave() matricule is "+ entity.getMatricule());
	    	   String newName = entity.getMatricule()+".png";
	    	   File file = new File( FileHelper.getStaticDirectory()+File.separator+imageName);
	    	   file.renameTo(new File(file.getPath()+File.separator+newName));
	    	   File filedest = new File( FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+imageName);
	    	   System.out.println("EleveManagerImpl.processAfterSave() file "+file.getPath());
//	           File filerename = new File(newName);
	        
	       }
		super.processAfterSave(entity);
	}
  	
	
	@Override
	public void processAfterUpdate(Professeur entity) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
				
		 if(entity.getImage()!=null){
	    	  // try {
	    	   String imageName = entity.getImage();
	    	   System.out.println("EleveRSImpl.processAfterSave() matricule is "+ entity.getMatricule());
	    	   String newName = entity.getMatricule()+".png";
	    	   File file = new File( FileHelper.getStaticDirectory()+File.separator+imageName);
	    	   file.renameTo(new File(file.getPath()+File.separator+newName));
	    	   File filedest = new File( FileHelper.getStaticDirectory()+File.separator+"scolarite"+File.separator+imageName);
	    	   filedest.renameTo(new File(file.getPath()+File.separator+newName));
	    	   System.out.println("EleveManagerImpl.processAfterSave() file "+file.getPath());
////	           File filerename = new File(newName);
//	           try {
//				FileHelper.copyFile(new File(file.getPath()), new File(filedest.getPath()));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	       }
		super.processAfterSave(entity);
	}
  	
	
}
