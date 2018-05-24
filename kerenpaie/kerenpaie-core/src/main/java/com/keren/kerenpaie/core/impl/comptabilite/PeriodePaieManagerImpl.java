
package com.keren.kerenpaie.core.impl.comptabilite;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.ExerciceComptableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieManager")
public class PeriodePaieManagerImpl
    extends AbstractGenericManager<PeriodePaie, Long>
    implements PeriodePaieManagerLocal, PeriodePaieManagerRemote
{

    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal dao;
    
    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal bulletinpaiedao;

    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal elementvariabledao;
    
    @EJB(name = "ExerciceComptableDAO")
    protected ExerciceComptableDAOLocal exerciceComptableDao;

    public PeriodePaieManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public PeriodePaie delete(Long id) {
        
        // TODO Auto-generated method stub
        PeriodePaie data = super.delete(id);
        return new PeriodePaie(data);
    }

    @Override
    public List<PeriodePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<PeriodePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<PeriodePaie> result = new ArrayList<PeriodePaie>();

        for(PeriodePaie data:datas){
                result.add(new PeriodePaie(data));
        }

        return result;
    }

    @Override
    public PeriodePaie find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        PeriodePaie data= super.find(propertyName, entityID);
        PeriodePaie result = new PeriodePaie(data);

        for(BulletinPaie bul:data.getSalaires()){
            result.getSalaires().add(new BulletinPaie(bul));
        }

        for(ElementVariable varia:data.getVariables()){
            result.getVariables().add(new ElementVariable(varia));
        }

        return result;
    }

    @Override
    public List<PeriodePaie> findAll() {

        // TODO Auto-generated method stub
        List<PeriodePaie> datas = super.findAll();
        List<PeriodePaie> result = new ArrayList<PeriodePaie>();

        for(PeriodePaie data:datas){
            result.add(new PeriodePaie(data));
        }
        return result;
    }
    
    /**
     * Gere les traiteents apres une mise à jour en bd
     * @author ABEGA ABEGA SERGE
     * @param entity 
     */
    @Override
    public void processAfterUpdate(PeriodePaie entity) {
        
        for(BulletinPaie aas:entity.getSalaires()){

            
            aas.setPeriode(entity);

            if(aas.getId()>0){
                bulletinpaiedao.update(aas.getId(), aas);
            }else {
                bulletinpaiedao.save(aas);
            }
        }

         for(ElementVariable aas:entity.getVariables()){

            aas.setPeiode(entity);

            if(aas.getId()>0){
                elementvariabledao.update(aas.getId(), aas);
            }else {
                elementvariabledao.save(aas);
            }
        }
         
        super.processAfterUpdate(entity);
    }
    
     /**
     * Gere les traiteents avant une persistence en bd
     * @author ABEGA ABEGA SERGE
     * @param entity 
     */
    @Override
    public void processAfterSave(PeriodePaie entity) {
        entity = dao.findByPrimaryKey("code", entity.getCode());
         
        for(BulletinPaie aas:entity.getSalaires()){
            aas.setPeriode(entity);

            if(aas.getId()>0){
                bulletinpaiedao.update(aas.getId(), aas);
            }else {
                bulletinpaiedao.save(aas);
            }
        }

        for(ElementVariable aas:entity.getVariables()){
            aas.setPeiode(entity);

            if(aas.getId()>0){
                elementvariabledao.update(aas.getId(), aas);
            }else {
                elementvariabledao.save(aas);
            }
        }
        
        super.processAfterSave(entity);
    }
        
    @Override
    public PeriodePaie getPeriodeFromDate(Date date) {
        // TODO Auto-generated method stub
//		String requete= "SELECT c FROM PeriodePaie p WHERE p.ddebut <= ?1 AND p.dfin >= ?2";
//		Query query = dao.getEntityManager().createQuery(requete);
//		query.setParameter(1,date, TemporalType.DATE);
//		query.setParameter(2,date, TemporalType.DATE);
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addLe("ddebut", date);
        container.addGe("dfin", date);
        List<PeriodePaie> datas = dao.filter(container.getPredicats(), new HashMap<String, OrderType>(), null, 0, -1);

        if(!datas.isEmpty()){
                return datas.get(0);
        }

        return null;
    }
    
    

}