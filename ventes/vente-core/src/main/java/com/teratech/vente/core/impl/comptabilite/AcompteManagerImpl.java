
package com.teratech.vente.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.comptabilite.AcompteManagerLocal;
import com.teratech.vente.core.ifaces.comptabilite.AcompteManagerRemote;
import com.teratech.vente.dao.ifaces.comptabilite.AcompteDAOLocal;
import com.teratech.vente.model.comptabilite.Acompte;

@TransactionAttribute
@Stateless(mappedName = "AcompteManager")
public class AcompteManagerImpl
    extends AbstractGenericManager<Acompte, Long>
    implements AcompteManagerLocal, AcompteManagerRemote
{

    @EJB(name = "AcompteDAO")
    protected AcompteDAOLocal dao;

    public AcompteManagerImpl() {
    }

    @Override
    public GenericDAO<Acompte, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
