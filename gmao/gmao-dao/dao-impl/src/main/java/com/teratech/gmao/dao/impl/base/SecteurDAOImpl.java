
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.SecteurDAOLocal;
import com.teratech.gmao.dao.ifaces.base.SecteurDAORemote;
import com.teratech.gmao.model.base.Secteur;

@Stateless(mappedName = "SecteurDAO")
public class SecteurDAOImpl
    extends AbstractGenericDAO<Secteur, Long>
    implements SecteurDAOLocal, SecteurDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public SecteurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Secteur> getManagedEntityClass() {
        return (Secteur.class);
    }

}
