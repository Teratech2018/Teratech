
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.SoumettreSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.SoumettreSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.SoumettreSalaireDAOLocal;
import com.keren.kerenpaie.model.paie.SoumettreSalaire;

@TransactionAttribute
@Stateless(mappedName = "SoumettreSalaireManager")
public class SoumettreSalaireManagerImpl
    extends AbstractGenericManager<SoumettreSalaire, Long>
    implements SoumettreSalaireManagerLocal, SoumettreSalaireManagerRemote
{

    @EJB(name = "SoumettreSalaireDAO")
    protected SoumettreSalaireDAOLocal dao;

    public SoumettreSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<SoumettreSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
