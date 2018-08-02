
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.QualificationManagerLocal;
import com.teratech.gmao.core.ifaces.base.QualificationManagerRemote;
import com.teratech.gmao.dao.ifaces.base.QualificationDAOLocal;
import com.teratech.gmao.model.base.Qualification;

@TransactionAttribute
@Stateless(mappedName = "QualificationManager")
public class QualificationManagerImpl
    extends AbstractGenericManager<Qualification, Long>
    implements QualificationManagerLocal, QualificationManagerRemote
{

    @EJB(name = "QualificationDAO")
    protected QualificationDAOLocal dao;

    public QualificationManagerImpl() {
    }

    @Override
    public GenericDAO<Qualification, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
