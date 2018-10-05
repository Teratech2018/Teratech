
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.FichierLieTriManagerLocal;
import com.keren.courrier.core.ifaces.courrier.FichierLieTriManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.FichierLieTriDAOLocal;
import com.keren.courrier.model.courrier.FichierLieTri;

@TransactionAttribute
@Stateless(mappedName = "FichierLieTriManager")
public class FichierLieTriManagerImpl
    extends AbstractGenericManager<FichierLieTri, Long>
    implements FichierLieTriManagerLocal, FichierLieTriManagerRemote
{

    @EJB(name = "FichierLieTriDAO")
    protected FichierLieTriDAOLocal dao;

    public FichierLieTriManagerImpl() {
    }

    @Override
    public GenericDAO<FichierLieTri, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
