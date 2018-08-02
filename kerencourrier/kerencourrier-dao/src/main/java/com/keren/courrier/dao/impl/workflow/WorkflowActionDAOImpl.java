
package com.keren.courrier.dao.impl.workflow;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.workflow.WorkflowActionDAOLocal;
import com.keren.courrier.dao.ifaces.workflow.WorkflowActionDAORemote;
import com.keren.courrier.model.workflow.WorkflowAction;

@Stateless(mappedName = "WorkflowActionDAO")
public class WorkflowActionDAOImpl
    extends AbstractGenericDAO<WorkflowAction, Long>
    implements WorkflowActionDAOLocal, WorkflowActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public WorkflowActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<WorkflowAction> getManagedEntityClass() {
        return (WorkflowAction.class);
    }

}
