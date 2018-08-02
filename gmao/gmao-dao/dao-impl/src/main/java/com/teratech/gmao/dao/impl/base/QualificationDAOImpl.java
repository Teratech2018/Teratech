
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.QualificationDAOLocal;
import com.teratech.gmao.dao.ifaces.base.QualificationDAORemote;
import com.teratech.gmao.model.base.Qualification;

@Stateless(mappedName = "QualificationDAO")
public class QualificationDAOImpl
    extends AbstractGenericDAO<Qualification, Long>
    implements QualificationDAOLocal, QualificationDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public QualificationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Qualification> getManagedEntityClass() {
        return (Qualification.class);
    }

}
