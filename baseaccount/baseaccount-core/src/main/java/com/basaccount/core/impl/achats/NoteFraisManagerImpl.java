
package com.basaccount.core.impl.achats;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.basaccount.core.ifaces.achats.NoteFraisManagerLocal;
import com.basaccount.core.ifaces.achats.NoteFraisManagerRemote;
import com.basaccount.dao.ifaces.achats.NoteFraisDAOLocal;
import com.basaccount.model.achats.NoteFrais;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "NoteFraisManager")
public class NoteFraisManagerImpl
    extends AbstractGenericManager<NoteFrais, Long>
    implements NoteFraisManagerLocal, NoteFraisManagerRemote
{

    @EJB(name = "NoteFraisDAO")
    protected NoteFraisDAOLocal dao;

    public NoteFraisManagerImpl() {
    }

    @Override
    public GenericDAO<NoteFrais, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
