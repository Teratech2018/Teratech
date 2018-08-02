
package com.keren.courrier.core.impl.workflow;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.workflow.ActionCourrierManagerLocal;
import com.keren.courrier.core.ifaces.workflow.ActionCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.workflow.ActionCourrierDAOLocal;
import com.keren.courrier.model.workflow.ActionCourrier;

@TransactionAttribute
@Stateless(mappedName = "ActionCourrierManager")
public class ActionCourrierManagerImpl
    extends AbstractGenericManager<ActionCourrier, Long>
    implements ActionCourrierManagerLocal, ActionCourrierManagerRemote
{

    @EJB(name = "ActionCourrierDAO")
    protected ActionCourrierDAOLocal dao;

    public ActionCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<ActionCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
