
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.invetaire.LArticleEmplacementLotManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.LArticleEmplacementLotManagerRemote;
import com.teratech.stock.dao.ifaces.invetaire.LArticleEmplacementLotDAOLocal;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "LArticleEmplacementLotManager")
public class LArticleEmplacementLotManagerImpl
    extends AbstractGenericManager<LArticleEmplacementLot, Long>
    implements LArticleEmplacementLotManagerLocal, LArticleEmplacementLotManagerRemote
{

    @EJB(name = "LArticleEmplacementLotDAO")
    protected LArticleEmplacementLotDAOLocal dao;

    public LArticleEmplacementLotManagerImpl() {
    }

    @Override
    public GenericDAO<LArticleEmplacementLot, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<LArticleEmplacementLot> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<LArticleEmplacementLot> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<LArticleEmplacementLot> result = new ArrayList<LArticleEmplacementLot>();
        for(LArticleEmplacementLot art:datas){
            result.add(new LArticleEmplacementLot(art));
        }
        return result;
    }

    @Override
    public List<LArticleEmplacementLot> findAll() {
        List<LArticleEmplacementLot> datas = super.findAll();
        List<LArticleEmplacementLot> result = new ArrayList<LArticleEmplacementLot>();
        for(LArticleEmplacementLot art:datas){
            result.add(new LArticleEmplacementLot(art));
        }
        return result;
    }

    @Override
    public LArticleEmplacementLot find(String propertyName, Long entityID) {
        LArticleEmplacementLot data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new LArticleEmplacementLot(data);
    }

    @Override
    public LArticleEmplacementLot delete(Long id) {
        return new LArticleEmplacementLot(super.delete(id)); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
