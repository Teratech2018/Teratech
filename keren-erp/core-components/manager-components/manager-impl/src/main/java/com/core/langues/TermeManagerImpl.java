
package com.core.langues;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import java.util.Date;

@TransactionAttribute
@Stateless(mappedName = "TermeManager")
public class TermeManagerImpl
    extends AbstractGenericManager<Terme, Long>
    implements TermeManagerLocal, TermeManagerRemote
{

    @EJB(name = "TermeDAO")
    protected TermeDAOLocal dao;
    
    @EJB(name = "LangueDAO")
    protected LangueDAOLocal languedao;

    public TermeManagerImpl() {
    }

    @Override
    public GenericDAO<Terme, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public void processBeforeUpdate(Terme entity) {
        Terme old = dao.findByPrimaryKey("id", entity.getId());
        if(!old.getOrign().equalsIgnoreCase(entity.getOrign())
                ||!old.getTraduc().equalsIgnoreCase(entity.getTraduc())
                ||old.getLangue().compareTo(entity.getLangue())!=0){
            entity.getLangue().setModified(new Date());
            languedao.update(entity.getLangue().getId(), entity.getLangue());
        }//end if(!old.getOrign().equalsIgnoreCase(entity.getOrign())
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Terme entity) {
        entity.getLangue().setModified(new Date());
        languedao.update(entity.getLangue().getId(), entity.getLangue());
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
}
