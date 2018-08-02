
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.SymptomeDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.SymptomeDAORemote;
import com.teratech.gmao.model.curative.Symptome;

@Stateless(mappedName = "SymptomeDAO")
public class SymptomeDAOImpl
    extends AbstractGenericDAO<Symptome, Long>
    implements SymptomeDAOLocal, SymptomeDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public SymptomeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Symptome> getManagedEntityClass() {
        return (Symptome.class);
    }

}
