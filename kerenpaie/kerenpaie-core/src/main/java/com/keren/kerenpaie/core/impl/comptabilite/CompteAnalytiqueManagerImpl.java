
package com.keren.kerenpaie.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.CompteAnalytiqueManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.CompteAnalytiqueManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.CompteAnalytiqueDAOLocal;
import com.keren.kerenpaie.model.comptabilite.CompteAnalytique;

@TransactionAttribute
@Stateless(mappedName = "CompteAnalytiqueManager")
public class CompteAnalytiqueManagerImpl
    extends AbstractGenericManager<CompteAnalytique, Long>
    implements CompteAnalytiqueManagerLocal, CompteAnalytiqueManagerRemote
{

    @EJB(name = "CompteAnalytiqueDAO")
    protected CompteAnalytiqueDAOLocal dao;

    public CompteAnalytiqueManagerImpl() {
    }

    @Override
    public GenericDAO<CompteAnalytique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
