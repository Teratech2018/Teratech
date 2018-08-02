
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CentreFraisDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CentreFraisDAORemote;
import com.teratech.gmao.model.base.CentreFrais;

@Stateless(mappedName = "CentreFraisDAO")
public class CentreFraisDAOImpl
    extends AbstractGenericDAO<CentreFrais, Long>
    implements CentreFraisDAOLocal, CentreFraisDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CentreFraisDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CentreFrais> getManagedEntityClass() {
        return (CentreFrais.class);
    }

}
