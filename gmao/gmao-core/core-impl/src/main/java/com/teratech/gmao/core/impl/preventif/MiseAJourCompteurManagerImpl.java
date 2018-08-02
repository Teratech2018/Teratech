
package com.teratech.gmao.core.impl.preventif;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.preventif.MiseAJourCompteurManagerLocal;
import com.teratech.gmao.core.ifaces.preventif.MiseAJourCompteurManagerRemote;
import com.teratech.gmao.dao.ifaces.preventif.MiseAJourCompteurDAOLocal;
import com.teratech.gmao.model.preventif.MiseAJourCompteur;

@TransactionAttribute
@Stateless(mappedName = "MiseAJourCompteurManager")
public class MiseAJourCompteurManagerImpl
    extends AbstractGenericManager<MiseAJourCompteur, Long>
    implements MiseAJourCompteurManagerLocal, MiseAJourCompteurManagerRemote
{

    @EJB(name = "MiseAJourCompteurDAO")
    protected MiseAJourCompteurDAOLocal dao;

    public MiseAJourCompteurManagerImpl() {
    }

    @Override
    public GenericDAO<MiseAJourCompteur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
