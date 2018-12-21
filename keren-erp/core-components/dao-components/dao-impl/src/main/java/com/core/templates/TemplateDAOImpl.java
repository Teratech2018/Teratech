
package com.core.templates;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "TemplateDAO")
public class TemplateDAOImpl
    extends AbstractGenericDAO<Template, Long>
    implements TemplateDAOLocal, TemplateDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public TemplateDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Template> getManagedEntityClass() {
        return (Template.class);
    }

}
