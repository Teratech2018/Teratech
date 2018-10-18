
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ElementVariableDAO")
public class ElementVariableDAOImpl
    extends AbstractGenericDAO<ElementVariable, Long>
    implements ElementVariableDAOLocal, ElementVariableDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ElementVariableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ElementVariable> getManagedEntityClass() {
        return (ElementVariable.class);
    }

}
