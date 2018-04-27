
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ModelBulletinManager")
public class ModelBulletinManagerImpl
    extends AbstractGenericManager<ModelBulletin, Long>
    implements ModelBulletinManagerLocal, ModelBulletinManagerRemote
{

    @EJB(name = "ModelBulletinDAO")
    protected ModelBulletinDAOLocal dao;

    public ModelBulletinManagerImpl() {
    }

    @Override
    public GenericDAO<ModelBulletin, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ModelBulletin> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<ModelBulletin> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ModelBulletin> result = new ArrayList<ModelBulletin>();
   		for(ModelBulletin elev:datas){
   			result.add(new ModelBulletin(elev));
   		}
   		return result;
   	}

   	@Override
   	public ModelBulletin find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ModelBulletin elev = super.find(propertyName, entityID);
   		ModelBulletin data = new ModelBulletin(elev);
   		for(Examen seq:elev.getSequence()){
   			data.getSequence().add(new Examen(seq));
   		}
   		return data;
   	}

   	@Override
   	public List<ModelBulletin> findAll() {
   		// TODO Auto-generated method stub
   		List<ModelBulletin> datas = super.findAll();
   		return datas;
   	}
   	
   	

   	@Override
   	public ModelBulletin delete(Long id) {
   		// TODO Auto-generated method stub
   		ModelBulletin elev = super.delete(id);
   		return new ModelBulletin(elev);
   	}
}
