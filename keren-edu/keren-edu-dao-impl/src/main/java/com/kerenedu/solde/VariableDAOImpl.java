
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "VariableDAO")
public class VariableDAOImpl
    extends AbstractGenericDAO<Variable, Long>
    implements VariableDAOLocal, VariableDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public VariableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Variable> getManagedEntityClass() {
        return (Variable.class);
    }

}
