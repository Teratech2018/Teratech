
package com.kerenedu.solde;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ParaCoutMatiereManager")
public class ParaCoutMatiereManagerImpl
    extends AbstractGenericManager<ParaCoutMatiere, Long>
    implements ParaCoutMatiereManagerLocal, ParaCoutMatiereManagerRemote
{

    @EJB(name = "ParaCoutMatiereDAO")
    protected ParaCoutMatiereDAOLocal dao;

    public ParaCoutMatiereManagerImpl() {
    }

    @Override
    public GenericDAO<ParaCoutMatiere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
