
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.CadreClassementDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.CadreClassementDAORemote;
import com.keren.courrier.model.archivage.CadreClassement;

@Stateless(mappedName = "CadreClassementDAO")
public class CadreClassementDAOImpl
    extends AbstractGenericDAO<CadreClassement, Long>
    implements CadreClassementDAOLocal, CadreClassementDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CadreClassementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CadreClassement> getManagedEntityClass() {
        return (CadreClassement.class);
    }

}
