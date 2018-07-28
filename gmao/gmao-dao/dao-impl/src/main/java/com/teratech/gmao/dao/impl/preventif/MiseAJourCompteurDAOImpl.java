
package com.teratech.gmao.dao.impl.preventif;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.preventif.MiseAJourCompteurDAOLocal;
import com.teratech.gmao.dao.ifaces.preventif.MiseAJourCompteurDAORemote;
import com.teratech.gmao.model.preventif.MiseAJourCompteur;

@Stateless(mappedName = "MiseAJourCompteurDAO")
public class MiseAJourCompteurDAOImpl
    extends AbstractGenericDAO<MiseAJourCompteur, Long>
    implements MiseAJourCompteurDAOLocal, MiseAJourCompteurDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public MiseAJourCompteurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MiseAJourCompteur> getManagedEntityClass() {
        return (MiseAJourCompteur.class);
    }

}
