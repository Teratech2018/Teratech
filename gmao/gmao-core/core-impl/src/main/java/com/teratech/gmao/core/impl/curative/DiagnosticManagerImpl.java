
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.curative.DiagnosticManagerLocal;
import com.teratech.gmao.core.ifaces.curative.DiagnosticManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.DiagnosticDAOLocal;
import com.teratech.gmao.model.curative.Diagnostic;

@TransactionAttribute
@Stateless(mappedName = "DiagnosticManager")
public class DiagnosticManagerImpl
    extends AbstractGenericManager<Diagnostic, Long>
    implements DiagnosticManagerLocal, DiagnosticManagerRemote
{

    @EJB(name = "DiagnosticDAO")
    protected DiagnosticDAOLocal dao;

    public DiagnosticManagerImpl() {
    }

    @Override
    public GenericDAO<Diagnostic, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
