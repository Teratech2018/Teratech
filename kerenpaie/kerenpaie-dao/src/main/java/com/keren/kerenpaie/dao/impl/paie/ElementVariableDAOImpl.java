
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAORemote;
import com.keren.kerenpaie.model.paie.ElementVariable;

@Stateless(mappedName = "ElementVariableDAO")
public class ElementVariableDAOImpl
    extends AbstractGenericDAO<ElementVariable, Long>
    implements ElementVariableDAOLocal, ElementVariableDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
