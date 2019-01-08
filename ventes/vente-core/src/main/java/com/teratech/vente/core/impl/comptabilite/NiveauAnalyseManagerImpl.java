
package com.teratech.vente.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.comptabilite.NiveauAnalyseManagerLocal;
import com.teratech.vente.core.ifaces.comptabilite.NiveauAnalyseManagerRemote;
import com.teratech.vente.dao.ifaces.comptabilite.NiveauAnalyseDAOLocal;
import com.teratech.vente.model.comptabilite.NiveauAnalyse;

@TransactionAttribute
@Stateless(mappedName = "NiveauAnalyseManager")
public class NiveauAnalyseManagerImpl
    extends AbstractGenericManager<NiveauAnalyse, Long>
    implements NiveauAnalyseManagerLocal, NiveauAnalyseManagerRemote
{

    @EJB(name = "NiveauAnalyseDAO")
    protected NiveauAnalyseDAOLocal dao;

    public NiveauAnalyseManagerImpl() {
    }

    @Override
    public GenericDAO<NiveauAnalyse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
