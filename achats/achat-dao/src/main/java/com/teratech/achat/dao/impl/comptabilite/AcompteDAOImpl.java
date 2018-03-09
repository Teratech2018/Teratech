
package com.teratech.achat.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.comptabilite.AcompteDAOLocal;
import com.teratech.achat.dao.ifaces.comptabilite.AcompteDAORemote;
import com.teratech.achat.model.comptabilite.Acompte;

@Stateless(mappedName = "AcompteDAO")
public class AcompteDAOImpl
    extends AbstractGenericDAO<Acompte, Long>
    implements AcompteDAOLocal, AcompteDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public AcompteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Acompte> getManagedEntityClass() {
        return (Acompte.class);
    }

}
