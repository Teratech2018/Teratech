
package com.teratech.achat.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.comptabilite.ModeReglementDAOLocal;
import com.teratech.achat.dao.ifaces.comptabilite.ModeReglementDAORemote;
import com.teratech.achat.model.comptabilite.ModeReglement;

@Stateless(mappedName = "ModeReglementDAO")
public class ModeReglementDAOImpl
    extends AbstractGenericDAO<ModeReglement, Long>
    implements ModeReglementDAOLocal, ModeReglementDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public ModeReglementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ModeReglement> getManagedEntityClass() {
        return (ModeReglement.class);
    }

}
