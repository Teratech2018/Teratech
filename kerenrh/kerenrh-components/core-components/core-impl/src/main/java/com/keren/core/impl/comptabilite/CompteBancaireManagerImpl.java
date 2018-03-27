
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.CompteBancaireManagerLocal;
import com.keren.core.ifaces.comptabilite.CompteBancaireManagerRemote;
import com.keren.dao.ifaces.comptabilite.CompteBancaireDAOLocal;
import com.keren.model.comptabilite.CompteBancaire;

@TransactionAttribute
@Stateless(mappedName = "CompteBancaireManager")
public class CompteBancaireManagerImpl
    extends AbstractGenericManager<CompteBancaire, Long>
    implements CompteBancaireManagerLocal, CompteBancaireManagerRemote
{

    @EJB(name = "CompteBancaireDAO")
    protected CompteBancaireDAOLocal dao;

    public CompteBancaireManagerImpl() {
    }

    @Override
    public GenericDAO<CompteBancaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
