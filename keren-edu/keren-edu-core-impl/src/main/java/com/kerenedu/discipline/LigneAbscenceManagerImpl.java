
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;

@TransactionAttribute
@Stateless(mappedName = "LigneAbscenceManager")
public class LigneAbscenceManagerImpl
    extends AbstractGenericManager<LigneAbscence, Long>
    implements LigneAbscenceManagerLocal, LigneAbscenceManagerRemote
{

    @EJB(name = "LigneAbscenceDAO")
    protected LigneAbscenceDAOLocal dao;
    

    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal daoClasse;

    public LigneAbscenceManagerImpl() {
    }

    @Override
    public GenericDAO<LigneAbscence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<LigneAbscence> findeleve(long idclasse) {
		List<LigneAbscence> results = new ArrayList<LigneAbscence>();
		if(idclasse>0){
			Classe cls = daoClasse.findByPrimaryKey("id", idclasse);
			RestrictionsContainer container = RestrictionsContainer.newInstance();
	   		 container.addEq("classe", cls.getId());
	   		 List<Inscription>records = daoIns.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
	   		 int index =0;
	   		 for(Inscription ins :records){
	   			 LigneAbscence lgnsbs= new LigneAbscence(ins);
	   			 lgnsbs.setId(-index);
	   			 results.add(lgnsbs);
	   			index ++;
	   		 }
		}
		return results;
	}
    
    

}
