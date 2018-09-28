
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RetardPaiementModalDAO")
public class RetardPaiementModalDAOImpl
    extends AbstractGenericDAO<RetardPaiementModal, Long>
    implements RetardPaiementModalDAOLocal, RetardPaiementModalDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RetardPaiementModalDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RetardPaiementModal> getManagedEntityClass() {
        return (RetardPaiementModal.class);
    }

}
