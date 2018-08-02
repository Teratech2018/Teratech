
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierRManagerLocal;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierRManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierRDAOLocal;
import com.keren.courrier.model.courrier.LigneBorderoCourrierR;

@TransactionAttribute
@Stateless(mappedName = "LigneBorderoCourrierRManager")
public class LigneBorderoCourrierRManagerImpl
    extends AbstractGenericManager<LigneBorderoCourrierR, Long>
    implements LigneBorderoCourrierRManagerLocal, LigneBorderoCourrierRManagerRemote
{

    @EJB(name = "LigneBorderoCourrierRDAO")
    protected LigneBorderoCourrierRDAOLocal dao;

    public LigneBorderoCourrierRManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBorderoCourrierR, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
