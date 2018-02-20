
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
@Stateless(mappedName = "NoteDetailManager")
public class NoteDetailManagerImpl
    extends AbstractGenericManager<NoteDetail, Long>
    implements NoteDetailManagerLocal, NoteDetailManagerRemote
{

    @EJB(name = "NoteDetailDAO")
    protected NoteDetailDAOLocal dao;

    public NoteDetailManagerImpl() {
    }

    @Override
    public GenericDAO<NoteDetail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<NoteDetail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<NoteDetail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<NoteDetail> result = new ArrayList<NoteDetail>();
   		for(NoteDetail elev:datas){
   			result.add(new NoteDetail(elev));
   		}
   		return result;
   	}

   	@Override
   	public NoteDetail find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		NoteDetail elev = super.find(propertyName, entityID);
   		NoteDetail data = new NoteDetail(elev);
   		return data;
   	}

   	@Override
   	public List<NoteDetail> findAll() {
   		// TODO Auto-generated method stub
   		List<NoteDetail> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public NoteDetail delete(Long id) {
   		// TODO Auto-generated method stub
   		NoteDetail elev = super.delete(id);
   		return new NoteDetail(elev);
   	}


}
