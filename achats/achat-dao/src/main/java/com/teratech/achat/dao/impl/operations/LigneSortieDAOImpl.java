
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.LigneSortieDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneSortieDAORemote;
import com.teratech.achat.model.operations.LigneSortie;

@Stateless(mappedName = "LigneSortieDAO")
public class LigneSortieDAOImpl
    extends AbstractGenericDAO<LigneSortie, Long>
    implements LigneSortieDAOLocal, LigneSortieDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public LigneSortieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneSortie> getManagedEntityClass() {
        return (LigneSortie.class);
    }

}
