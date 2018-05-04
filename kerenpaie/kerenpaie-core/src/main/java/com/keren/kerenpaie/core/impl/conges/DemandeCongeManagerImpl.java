
package com.keren.kerenpaie.core.impl.conges;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.conges.DemandeCongeManagerLocal;
import com.keren.kerenpaie.core.ifaces.conges.DemandeCongeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.conges.DemandeCongeDAOLocal;
import com.keren.kerenpaie.model.conges.DemandeConge;

@TransactionAttribute
@Stateless(mappedName = "DemandeCongeManager")
public class DemandeCongeManagerImpl
    extends AbstractGenericManager<DemandeConge, Long>
    implements DemandeCongeManagerLocal, DemandeCongeManagerRemote
{

    @EJB(name = "DemandeCongeDAO")
    protected DemandeCongeDAOLocal dao;

    public DemandeCongeManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeConge, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
