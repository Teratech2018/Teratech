
package com.kerenedu.notes;

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
import com.core.dashboard.DashboardField;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.FiliereDAOLocal;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDAOLocal;
import com.kerenedu.configuration.MatiereDlt;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CoefMatiereManager")
public class CoefMatiereManagerImpl extends AbstractGenericManager<CoefMatiere, Long>
		implements CoefMatiereManagerLocal, CoefMatiereManagerRemote {

	@EJB(name = "CoefMatiereDAO")
	protected CoefMatiereDAOLocal dao;

	@EJB(name = "CoefMatiereDetailDAO")
	protected CoefMatiereDetailDAOLocal coefDltdao;

	@EJB(name = "MatiereDAO")
	protected MatiereDAOLocal matieredao;

	@EJB(name = "ClasseDAO")
	protected ClasseDAOLocal classedao;

	@EJB(name = "FiliereDAO")
	protected FiliereDAOLocal filieredao;

	public CoefMatiereManagerImpl() {
	}

	@Override
	public GenericDAO<CoefMatiere, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<CoefMatiere> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<CoefMatiere> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<CoefMatiere> result = new ArrayList<CoefMatiere>();
		for (CoefMatiere elev : datas) {
			result.add(new CoefMatiere(elev));
		}
		return result;
	}

	@Override
	public CoefMatiere find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		CoefMatiere data = super.find(propertyName, entityID);
		CoefMatiere result = new CoefMatiere(data);
		List<CoefMatiereDetail> listcmdlt = new ArrayList<CoefMatiereDetail>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("filiere.code", data.getClasse().getFiliere().getCode());
		List<Matiere> lisyMatiere = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if (data.getMatdetailList() == null || data.getMatdetailList().isEmpty()) {
			List<MatiereDlt> matieres = lisyMatiere.get(0).getMatieres();
			for (MatiereDlt mat : matieres) {
				// listcmdlt = new ArrayList<CoefMatiereDetail>();
				CoefMatiereDetail cmatdlt = new CoefMatiereDetail(mat);
				listcmdlt.add(cmatdlt);
			}
			result.setMatdetailList(listcmdlt);
		} else {
			for (CoefMatiereDetail mdlt : data.getMatdetailList()) {
				// listcmdlt = new ArrayList<CoefMatiereDetail>();
				CoefMatiereDetail cmatdlt = new CoefMatiereDetail(mdlt);
				listcmdlt.add(cmatdlt);
			}
			result.setMatdetailList(listcmdlt);
		}

		return result;
	}

	@Override
	public List<CoefMatiere> findAll() {
		// TODO Auto-generated method stub
		List<CoefMatiere> datas = super.findAll();
		List<CoefMatiere> result = new ArrayList<CoefMatiere>();
		for (CoefMatiere elev : datas) {
			result.add(new CoefMatiere(elev));
		}
		return result;
	}

	@Override
	public CoefMatiere delete(Long id) {
		// TODO Auto-generated method stub
		CoefMatiere elev = super.delete(id);
		return new CoefMatiere(elev);
	}

	public List<CoefMatiereDetail> findMatiereFiliere(Long id) {
		System.out
				.println(CoefMatiereManagerImpl.class.toString() + " ========================================== " + id);
		List<CoefMatiereDetail> datas = new ArrayList<CoefMatiereDetail>();
		List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (id > 0) {
			container = RestrictionsContainer.newInstance();
			container.addEq("id", id);
			Classe classe = classedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);

			container = RestrictionsContainer.newInstance();
			container.addEq("classe.id", id);
			result = coefDltdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);

			if (result == null || result.isEmpty() || result.size() == 0) {
				container = RestrictionsContainer.newInstance();
				System.out.println(
						"CoefMatiereManagerImpl.findMatiereFiliere() filiere id is" + classe.getFiliere().getId());
				container.addEq("filiere.id", classe.getFiliere().getId());
				Matiere mat = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
				List<MatiereDlt> lisyMatiere = mat.getMatieres();
				long index = 1;
				for (MatiereDlt m : lisyMatiere) {
					// listcmdlt = new ArrayList<CoefMatiereDetail>();
					CoefMatiereDetail cmatdlt = new CoefMatiereDetail(m);
					cmatdlt.setId(-index);
					datas.add(cmatdlt);
					index++;
				}
			} else {
				for (CoefMatiereDetail mftl : result) {
					datas.add(new CoefMatiereDetail(mftl));
				}
			} // end if(result==null||result.isEmpty())

		} // end if(id!=-1){
		return datas;
	}

	public void generatecoefmat(CoefMatiereModal entity) {

		if (entity.getFiliere() == null) {
			throw new KerenExecption("Bien vouloir choisir une classe <br/> !!!");
		} // end if (entity.getClasse()==null)
		List<CoefMatiere> coefmatlist = new ArrayList<CoefMatiere>();
		List<Classe> classeList = new ArrayList<Classe>();
		List<Matiere> matieres = new ArrayList<Matiere>();

		Filiere filiere = filieredao.findByPrimaryKey("id", entity.getFiliere().getId());

		// recherche matiere
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("filiere.id", filiere.getId());
		matieres = matieredao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);

		// recherche des classe dejà coefficier

		container = RestrictionsContainer.newInstance();
		container.addEq("classe.filiere.id", filiere.getId());
		coefmatlist = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if (coefmatlist == null || coefmatlist.isEmpty() || coefmatlist.size() == 0) {
			// save coefmat and coefmatdetail
			// recherche des classe d'une filière
			container = RestrictionsContainer.newInstance();
			container.addEq("filiere.id", filiere.getId());
			classeList = classedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			for (Classe cls : classeList) {
				List<CoefMatiereDetail> listdetail = new ArrayList<CoefMatiereDetail>();
				CoefMatiereDetail cmdlt = new CoefMatiereDetail();
				for (MatiereDlt matdlt : matieres.get(0).getMatieres()) {
					cmdlt = new CoefMatiereDetail(matdlt);
					cmdlt.setId(-1);
					cmdlt.setClasse(cls);
					if(filiere.getCycle().getTypecycle().equals("0")||filiere.getCycle().getTypecycle().equals("1")){
						cmdlt.setProffesseur(cls.getProfesseur());
					}
					listdetail.add(cmdlt);
				}
				CoefMatiere cm = new CoefMatiere();
				cm.setClasse(cls);
				cm.setMatdetailList(listdetail);
				dao.save(cm);
			}
		}

	}

}
