
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.TraitSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.TraitSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.TraitSalaireDAOLocal;
import com.keren.kerenpaie.model.paie.TraitSalaire;

@TransactionAttribute
@Stateless(mappedName = "TraitSalaireManager")
public class TraitSalaireManagerImpl
    extends AbstractGenericManager<TraitSalaire, Long>
    implements TraitSalaireManagerLocal, TraitSalaireManagerRemote
{

    @EJB(name = "TraitSalaireDAO")
    protected TraitSalaireDAOLocal dao;

    public TraitSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<TraitSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
