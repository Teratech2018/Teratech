
package com.keren.kerenpaie.core.impl.comptabilite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.ExerciceComptableManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.ExerciceComptableManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.ExerciceComptableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.model.comptabilite.ExerciceComptable;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ExerciceComptableManager")
public class ExerciceComptableManagerImpl
    extends AbstractGenericManager<ExerciceComptable, Long>
    implements ExerciceComptableManagerLocal, ExerciceComptableManagerRemote
{

    @EJB(name = "ExerciceComptableDAO")
    protected ExerciceComptableDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodepaiedao;

    public ExerciceComptableManagerImpl() {
    }

    @Override
    public GenericDAO<ExerciceComptable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public ExerciceComptable delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<ExerciceComptable> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ExerciceComptable> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ExerciceComptable> result = new ArrayList<ExerciceComptable>();
		for(ExerciceComptable exo:datas){
			result.add(new ExerciceComptable(exo));
		}
		return result;
	}

	@Override
	public ExerciceComptable find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ExerciceComptable data = super.find(propertyName, entityID);
		ExerciceComptable result = new ExerciceComptable(data);
		for(PeriodePaie perio:data.getPeriodes()){
			result.getPeriodes().add(new PeriodePaie(perio));
		}
		return result;
	}

	@Override
	public List<ExerciceComptable> findAll() {
		// TODO Auto-generated method stub
		List<ExerciceComptable> datas =  super.findAll();
		List<ExerciceComptable> result = new ArrayList<ExerciceComptable>();
		for(ExerciceComptable exo:datas){
			result.add(new ExerciceComptable(exo));
		}
		return result;
	}

	@Override
        public void processAfterUpdate(ExerciceComptable entity) {

             for(PeriodePaie aas:entity.getPeriodes()){

                aas.setExercice(entity);

                if(aas.getId()>0){
                    periodepaiedao.update(aas.getId(), aas);
                }else {
                    periodepaiedao.save(aas);
                }
            }
            super.processAfterUpdate(entity);
        }

        @Override
        public void processAfterSave(ExerciceComptable entity) {
            entity = dao.findByPrimaryKey("code", entity.getCode());

            for(PeriodePaie aas:entity.getPeriodes()){
                aas.setExercice(entity);

                if(aas.getId()>0){
                    periodepaiedao.update(aas.getId(), aas);
                }else {
                    periodepaiedao.save(aas);
                }
            }
            super.processAfterSave(entity);
        }
    
	/**
	 * Construit la liste des periode de paie pour l'exercices
	 * @param exo
	 * @return
	 */
    private List<PeriodePaie> periodeBuilder(ExerciceComptable exo){
    	List<PeriodePaie> result = new ArrayList<PeriodePaie>();
    	Calendar cdebut = Calendar.getInstance();
    	cdebut.setTime(exo.getDebut());
    	Calendar cfin = Calendar.getInstance();
    	cfin.setTime(exo.getFin());    	
    	while(cdebut.getTime().getMonth()<=exo.getFin().getMonth()){
    		
    	}//end while(begin.getMonth()<=exo.getFin().getMonth())
    	return result;
    }

}