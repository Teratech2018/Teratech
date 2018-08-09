
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.RappelCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.RappelCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.RappelCourrierDAOLocal;
import com.keren.courrier.model.referentiel.RappelCourrier;

@TransactionAttribute
@Stateless(mappedName = "RappelCourrierManager")
public class RappelCourrierManagerImpl
    extends AbstractGenericManager<RappelCourrier, Long>
    implements RappelCourrierManagerLocal, RappelCourrierManagerRemote
{

    @EJB(name = "RappelCourrierDAO")
    protected RappelCourrierDAOLocal dao;

    public RappelCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<RappelCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
