
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneElementVariableDAO")
public class LigneElementVariableDAOImpl
    extends AbstractGenericDAO<LigneElementVariable, Long>
    implements LigneElementVariableDAOLocal, LigneElementVariableDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneElementVariableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneElementVariable> getManagedEntityClass() {
        return (LigneElementVariable.class);
    }

}
