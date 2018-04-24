
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.FormateurManagerLocal;
import com.keren.core.ifaces.formations.FormateurManagerRemote;
import com.keren.dao.ifaces.formations.FormateurDAOLocal;
import com.keren.model.formations.Formateur;

@TransactionAttribute
@Stateless(mappedName = "FormateurManager")
public class FormateurManagerImpl
    extends AbstractGenericManager<Formateur, Long>
    implements FormateurManagerLocal, FormateurManagerRemote
{

    @EJB(name = "FormateurDAO")
    protected FormateurDAOLocal dao;

    public FormateurManagerImpl() {
    }

    @Override
    public GenericDAO<Formateur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
