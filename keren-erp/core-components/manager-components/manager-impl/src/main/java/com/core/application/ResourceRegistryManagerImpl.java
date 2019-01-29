
package com.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import java.util.List;

@TransactionAttribute
@Stateless(mappedName = "ResourceRegistryManager")
public class ResourceRegistryManagerImpl
    extends AbstractGenericManager<ResourceRegistry, Long>
    implements ResourceRegistryManagerLocal, ResourceRegistryManagerRemote
{

    @EJB(name = "ResourceRegistryDAO")
    protected ResourceRegistryDAOLocal dao;

    public ResourceRegistryManagerImpl() {
    }

    @Override
    public GenericDAO<ResourceRegistry, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public ResourceRegistry getRegistryEntry(String srcnmae, String entity, String modele,long _instance) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("srcname", srcnmae);
        container.addEq("ownerentity", entity);
        container.addEq("_instance", _instance);
        if(modele!=null){
            container.addEq("ownermodele", modele);
        }//end if(modele!=null){
        List<ResourceRegistry> datas = dao.filter(container.getPredicats(), null, null, 0, -1);
        return datas.isEmpty() ? null:datas.get(0);
    }

}
