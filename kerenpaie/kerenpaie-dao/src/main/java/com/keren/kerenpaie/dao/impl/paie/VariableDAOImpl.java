
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAORemote;
import com.keren.kerenpaie.model.paie.Variable;

@Stateless(mappedName = "VariableDAO")
public class VariableDAOImpl
    extends AbstractGenericDAO<Variable, Long>
    implements VariableDAOLocal, VariableDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
