
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.curative.EtatEquipementManagerLocal;
import com.teratech.gmao.core.ifaces.curative.EtatEquipementManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.EtatEquipementDAOLocal;
import com.teratech.gmao.model.curative.EtatEquipement;

@TransactionAttribute
@Stateless(mappedName = "EtatEquipementManager")
public class EtatEquipementManagerImpl
    extends AbstractGenericManager<EtatEquipement, Long>
    implements EtatEquipementManagerLocal, EtatEquipementManagerRemote
{

    @EJB(name = "EtatEquipementDAO")
    protected EtatEquipementDAOLocal dao;

    public EtatEquipementManagerImpl() {
    }

    @Override
    public GenericDAO<EtatEquipement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
