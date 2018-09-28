
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EltSalaireLigneDAO")
public class EltSalaireLigneDAOImpl
    extends AbstractGenericDAO<EltSalaireLigne, Long>
    implements EltSalaireLigneDAOLocal, EltSalaireLigneDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EltSalaireLigneDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EltSalaireLigne> getManagedEntityClass() {
        return (EltSalaireLigne.class);
    }

}
