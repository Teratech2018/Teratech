
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.DiagnosticDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.DiagnosticDAORemote;
import com.teratech.gmao.model.curative.Diagnostic;

@Stateless(mappedName = "DiagnosticDAO")
public class DiagnosticDAOImpl
    extends AbstractGenericDAO<Diagnostic, Long>
    implements DiagnosticDAOLocal, DiagnosticDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public DiagnosticDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Diagnostic> getManagedEntityClass() {
        return (Diagnostic.class);
    }

}
