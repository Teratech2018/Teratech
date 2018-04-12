
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.EtablissementManagerLocal;
import com.keren.core.ifaces.structures.EtablissementManagerRemote;
import com.keren.dao.ifaces.structures.EtablissementDAOLocal;
import com.keren.model.structures.Etablissement;

@TransactionAttribute
@Stateless(mappedName = "EtablissementManager")
public class EtablissementManagerImpl
    extends AbstractGenericManager<Etablissement, Long>
    implements EtablissementManagerLocal, EtablissementManagerRemote
{

    @EJB(name = "EtablissementDAO")
    protected EtablissementDAOLocal dao;

    public EtablissementManagerImpl() {
    }

    @Override
    public GenericDAO<Etablissement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
