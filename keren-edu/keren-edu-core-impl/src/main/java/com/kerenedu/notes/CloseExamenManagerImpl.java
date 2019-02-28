
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "CloseExamenManager")
public class CloseExamenManagerImpl
    extends AbstractGenericManager<CloseExamen, Long>
    implements CloseExamenManagerLocal, CloseExamenManagerRemote
{

    @EJB(name = "CloseExamenDAO")
    protected CloseExamenDAOLocal dao;
    
    @EJB(name = "ExamenDAO")
    protected ExamenDAOLocal daoexamen;

    public CloseExamenManagerImpl() {
    }

    @Override
    public GenericDAO<CloseExamen, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    

   	@Override
   	public CloseExamen save(CloseExamen entity) {
   		// TODO Auto-generated method stub
   		entity.getExamen().setState("ferme");
   		daoexamen.update(entity.getExamen().getId(), entity.getExamen());
   		return entity;
   	}

   	@Override
   	public CloseExamen update(Long id, CloseExamen entity) {
   		// TODO Auto-generated method stub
   		entity.getExamen().setState("ferme");
   		daoexamen.update(entity.getExamen().getId(), entity.getExamen());
   		return super.update(id, entity);
   	}

}
