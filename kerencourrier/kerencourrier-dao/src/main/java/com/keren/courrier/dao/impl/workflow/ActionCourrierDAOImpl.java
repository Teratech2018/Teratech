
package com.keren.courrier.dao.impl.workflow;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.workflow.ActionCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.workflow.ActionCourrierDAORemote;
import com.keren.courrier.model.workflow.ActionCourrier;

@Stateless(mappedName = "ActionCourrierDAO")
public class ActionCourrierDAOImpl
    extends AbstractGenericDAO<ActionCourrier, Long>
    implements ActionCourrierDAOLocal, ActionCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ActionCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ActionCourrier> getManagedEntityClass() {
        return (ActionCourrier.class);
    }

}
