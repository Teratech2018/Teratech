
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.SectionAnalytiqueManagerLocal;
import com.keren.core.ifaces.comptabilite.SectionAnalytiqueManagerRemote;
import com.keren.dao.ifaces.comptabilite.SectionAnalytiqueDAOLocal;
import com.keren.model.comptabilite.SectionAnalytique;

@TransactionAttribute
@Stateless(mappedName = "SectionAnalytiqueManager")
public class SectionAnalytiqueManagerImpl
    extends AbstractGenericManager<SectionAnalytique, Long>
    implements SectionAnalytiqueManagerLocal, SectionAnalytiqueManagerRemote
{

    @EJB(name = "SectionAnalytiqueDAO")
    protected SectionAnalytiqueDAOLocal dao;

    public SectionAnalytiqueManagerImpl() {
    }

    @Override
    public GenericDAO<SectionAnalytique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
