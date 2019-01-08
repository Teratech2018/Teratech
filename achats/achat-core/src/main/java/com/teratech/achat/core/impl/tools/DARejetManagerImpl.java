
package com.teratech.achat.core.impl.tools;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.tools.DARejetManagerLocal;
import com.teratech.achat.core.ifaces.tools.DARejetManagerRemote;
import com.teratech.achat.dao.ifaces.tools.DARejetDAOLocal;
import com.teratech.achat.model.tools.DARejet;

@TransactionAttribute
@Stateless(mappedName = "DARejetManager")
public class DARejetManagerImpl
    extends AbstractGenericManager<DARejet, Long>
    implements DARejetManagerLocal, DARejetManagerRemote
{

    @EJB(name = "DARejetDAO")
    protected DARejetDAOLocal dao;

    public DARejetManagerImpl() {
    }

    @Override
    public GenericDAO<DARejet, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
