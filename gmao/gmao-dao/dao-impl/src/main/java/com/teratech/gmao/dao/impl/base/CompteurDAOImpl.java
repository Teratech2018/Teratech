
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CompteurDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CompteurDAORemote;
import com.teratech.gmao.model.base.Compteur;

@Stateless(mappedName = "CompteurDAO")
public class CompteurDAOImpl
    extends AbstractGenericDAO<Compteur, Long>
    implements CompteurDAOLocal, CompteurDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CompteurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Compteur> getManagedEntityClass() {
        return (Compteur.class);
    }

}
