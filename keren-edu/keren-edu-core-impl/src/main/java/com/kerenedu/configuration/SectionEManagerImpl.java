
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "SectionEManager")
public class SectionEManagerImpl
    extends AbstractGenericManager<SectionE, Long>
    implements SectionEManagerLocal, SectionEManagerRemote
{

    @EJB(name = "SectionEDAO")
    protected SectionEDAOLocal dao;

    public SectionEManagerImpl() {
    }

    @Override
    public GenericDAO<SectionE, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
