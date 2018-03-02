
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.AppelOffreManagerLocal;
import com.teratech.achat.core.ifaces.operations.AppelOffreManagerRemote;
import com.teratech.achat.dao.ifaces.operations.AppelOffreDAOLocal;
import com.teratech.achat.model.operations.AppelOffre;
import com.teratech.achat.model.operations.LigneAppeloffre;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "AppelOffreManager")
public class AppelOffreManagerImpl
    extends AbstractGenericManager<AppelOffre, Long>
    implements AppelOffreManagerLocal, AppelOffreManagerRemote
{

    @EJB(name = "AppelOffreDAO")
    protected AppelOffreDAOLocal dao;

    public AppelOffreManagerImpl() {
    }

    @Override
    public GenericDAO<AppelOffre, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<AppelOffre> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<AppelOffre> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<AppelOffre> result = new ArrayList<AppelOffre>();
        for(AppelOffre of:datas){
            result.add(new AppelOffre(of));
        }
        return result;
    }

    @Override
    public List<AppelOffre> findAll() {
        List<AppelOffre> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<AppelOffre> result = new ArrayList<AppelOffre>();
        for(AppelOffre of:datas){
            result.add(new AppelOffre(of));
        }
        return result;
    }

    @Override
    public AppelOffre find(String propertyName, Long entityID) {
        AppelOffre data= super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        AppelOffre result = new AppelOffre(data);
        for(LigneAppeloffre lign:data.getLignes()){
            result.getLignes().add(new LigneAppeloffre(lign));
        }
        return result;
    }

    @Override
    public AppelOffre delete(Long id) {
        AppelOffre data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new AppelOffre(data);
    }

    
}
