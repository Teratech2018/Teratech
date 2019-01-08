
package com.teratech.vente.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.comptabilite.ExerciceComptableManagerLocal;
import com.teratech.vente.core.ifaces.comptabilite.ExerciceComptableManagerRemote;
import com.teratech.vente.dao.ifaces.comptabilite.ExerciceComptableDAOLocal;
import com.teratech.vente.model.comptabilite.ExerciceComptable;

@TransactionAttribute
@Stateless(mappedName = "ExerciceComptableManager")
public class ExerciceComptableManagerImpl
    extends AbstractGenericManager<ExerciceComptable, Long>
    implements ExerciceComptableManagerLocal, ExerciceComptableManagerRemote
{

    @EJB(name = "ExerciceComptableDAO")
    protected ExerciceComptableDAOLocal dao;

    public ExerciceComptableManagerImpl() {
    }

    @Override
    public GenericDAO<ExerciceComptable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
