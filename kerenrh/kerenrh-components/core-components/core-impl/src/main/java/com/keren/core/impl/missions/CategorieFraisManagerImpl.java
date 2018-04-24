
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.CategorieFraisManagerLocal;
import com.keren.core.ifaces.missions.CategorieFraisManagerRemote;
import com.keren.dao.ifaces.missions.CategorieFraisDAOLocal;
import com.keren.model.missions.CategorieFrais;
import com.keren.model.missions.GrilleFrais;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CategorieFraisManager")
public class CategorieFraisManagerImpl
    extends AbstractGenericManager<CategorieFrais, Long>
    implements CategorieFraisManagerLocal, CategorieFraisManagerRemote
{

    @EJB(name = "CategorieFraisDAO")
    protected CategorieFraisDAOLocal dao;

    public CategorieFraisManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieFrais, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<CategorieFrais> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CategorieFrais> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<CategorieFrais> results = new ArrayList<CategorieFrais>();
        for(CategorieFrais data:datas){
            results.add(new CategorieFrais(data));
        }
        return results;
    }

    @Override
    public List<CategorieFrais> findAll() {
        List<CategorieFrais> datas = super.findAll();
        List<CategorieFrais> results = new ArrayList<CategorieFrais>();

        for(CategorieFrais data:datas){
            results.add(new CategorieFrais(data));
        }
        return results;
    }

    @Override
    public CategorieFrais find(String propertyName, Long entityID) {
        CategorieFrais data = super.find(propertyName, entityID);
        CategorieFrais result = new CategorieFrais(data);

        for(GrilleFrais aas:data.getGrille()){
            result.getGrille().add(new GrilleFrais(aas));
        }


        return result;
    }

    @Override
    public void processAfterUpdate(CategorieFrais entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(CategorieFrais entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }
    
}