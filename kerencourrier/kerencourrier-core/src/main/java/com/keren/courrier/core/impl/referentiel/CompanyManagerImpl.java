
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.CompanyManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.CompanyManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAOLocal;
import com.keren.courrier.model.referentiel.Company;

@TransactionAttribute
@Stateless(mappedName = "CompanyManager")
public class CompanyManagerImpl
    extends AbstractGenericManager<Company, Long>
    implements CompanyManagerLocal, CompanyManagerRemote
{

    @EJB(name = "CompanyDAO")
    protected CompanyDAOLocal dao;

    public CompanyManagerImpl() {
    }

    @Override
    public GenericDAO<Company, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
